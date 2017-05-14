package com.randioo.shanghaimajiang_server.module.match.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_server_base.utils.ReflectUtils;
import com.randioo.randioo_server_base.utils.service.ObserveBaseService;
import com.randioo.shanghaimajiang_server.cache.file.GameRoundConfigCache;
import com.randioo.shanghaimajiang_server.cache.local.GameCache;
import com.randioo.shanghaimajiang_server.core.majiang.MajiangGame;
import com.randioo.shanghaimajiang_server.core.majiang.MajiangRule;
import com.randioo.shanghaimajiang_server.core.majiang.MajiangRuleInterface;
import com.randioo.shanghaimajiang_server.core.majiang.qiaoma.QiaoMaGame;
import com.randioo.shanghaimajiang_server.core.majiang.qiaoma.QiaoMaRule;
import com.randioo.shanghaimajiang_server.core.majiang.qinghunpeng.QingHunPengGame;
import com.randioo.shanghaimajiang_server.core.majiang.qinghunpeng.QingHunPengRule;
import com.randioo.shanghaimajiang_server.entity.bo.Role;
import com.randioo.shanghaimajiang_server.entity.file.GameRoundConfig;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameData;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameRoleData;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameType;
import com.randioo.shanghaimajiang_server.protocol.Entity.NewGameConfigData;
import com.randioo.shanghaimajiang_server.protocol.Error.ErrorCode;
import com.randioo.shanghaimajiang_server.protocol.Match.MatchJoinGameResponse;
import com.randioo.shanghaimajiang_server.protocol.Match.MatchNewGameResponse;
import com.randioo.shanghaimajiang_server.protocol.ServerMessage.SC;

@Service("matchService")
public class MatchServiceImpl extends ObserveBaseService implements MatchService {

	@Override
	public void init() {
		GameCache.getGameRuleMap().put(GameType.GAME_TYPE_QIAOMA, new QiaoMaRule());
		GameCache.getGameRuleMap().put(GameType.GAME_TYPE_QINGHUNPENG, new QingHunPengRule());

		GameCache.getGameClassMap().put(GameType.GAME_TYPE_QIAOMA, QiaoMaGame.class);
		GameCache.getGameClassMap().put(GameType.GAME_TYPE_QINGHUNPENG, QingHunPengGame.class);
	}

	@Override
	public GeneratedMessage newGame(Role role, NewGameConfigData gameConfig) {
		int round = gameConfig.getRound();
		GameRoundConfig config = GameRoundConfigCache.roundMap().get(round);
		if (config == null) {
			return SC.newBuilder()
					.setMatchNewGameResponse(
							MatchNewGameResponse.newBuilder().setErrorCode(ErrorCode.GAME_CREATE_ERROR.getNumber()))
					.build();
		}

		if (role.getMoney() < config.needMoney) {
			return SC.newBuilder().setMatchNewGameResponse(
					MatchNewGameResponse.newBuilder().setErrorCode(ErrorCode.NO_MONEY.getNumber())).build();
		}

		MajiangGame game = this.createGame(gameConfig);
		role.setGameId(game.getGameId());

		game.joinGame(role);

		GameData gameData = this.getGameData(role, game);

		return SC.newBuilder().setMatchNewGameResponse(
				MatchNewGameResponse.newBuilder().setGameId(game.getGameId()).setGameData(gameData)).build();
	}

	private MajiangGame createGame(NewGameConfigData config) {

		GameType gameType = config.getGameType();

		Class<? extends MajiangGame> abstractGameClass = GameCache.getGameClassMap().get(gameType);
		MajiangGame game = ReflectUtils.newInstance(abstractGameClass);
		MajiangRuleInterface gameRule = GameCache.getGameRuleMap().get(gameType);
		game.setMajiangRuleInterface(gameRule);

		game.initGame(config);

		synchronized (GameCache.getGameMap()) {
			int gameId = getGameId();
			game.setGameId(gameId);

			GameCache.getGameMap().put(gameId, game);
		}

		return game;
	}

	private int getGameId() {
		Set<Integer> gameIdSet = GameCache.getGameMap().keySet();
		int gameId = 0;
		do {
			gameId = (int) (Math.random() * 100000);
			gameId += 100000;
		} while (gameIdSet.contains(gameId));

		return gameId;
	}

	@Override
	public GeneratedMessage joinGame(Role role, int gameId) {
		MajiangGame game = GameCache.getGameMap().get(gameId);
		if (game == null) {
			return SC.newBuilder()
					.setMatchJoinGameResponse(
							MatchJoinGameResponse.newBuilder().setErrorCode(ErrorCode.GAME_JOIN_ERROR.getNumber()))
					.build();
		}

		game.joinGame(role);
		GameRoleData gameRoleData = this.getGameRoleData(role, game);
		GameData gameData = this.getGameData(role, game);

		return SC.newBuilder().setMatchJoinGameResponse(
				MatchJoinGameResponse.newBuilder().setGameRoleData(gameRoleData).setGameData(gameData)).build();
	}

	private GameRoleData getGameRoleData(Role role, MajiangGame game) {
		return null;
	}

	private GameData getGameData(Role role, MajiangGame game) {
		return null;
	}

}
