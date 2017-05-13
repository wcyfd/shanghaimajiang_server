package com.randioo.shanghaimajiang_server.module.match.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.randioo.randioo_server_base.utils.ReflectUtils;
import com.randioo.randioo_server_base.utils.game.IdClassCreator;
import com.randioo.randioo_server_base.utils.service.ObserveBaseService;
import com.randioo.shanghaimajiang_server.cache.file.GameRoundConfigCache;
import com.randioo.shanghaimajiang_server.cache.local.GameCache;
import com.randioo.shanghaimajiang_server.core.AbstractGame;
import com.randioo.shanghaimajiang_server.core.majiang.qiaoma.QiaoMaRule;
import com.randioo.shanghaimajiang_server.core.majiang.qinghunpeng.QingHunPengRule;
import com.randioo.shanghaimajiang_server.entity.bo.Role;
import com.randioo.shanghaimajiang_server.entity.file.GameRoundConfig;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameType;
import com.randioo.shanghaimajiang_server.protocol.Entity.NewGameConfigData;
import com.randioo.shanghaimajiang_server.protocol.Match.MatchNewGameResponse;
import com.randioo.shanghaimajiang_server.protocol.ServerMessage.SC;

@Service("matchService")
public class MatchServiceImpl extends ObserveBaseService implements MatchService {

	@Autowired
	private IdClassCreator idClassCreator;

	@Override
	public void init() {
		GameCache.getGameRuleMap().put(GameType.GAME_TYPE_QIAOMA, new QiaoMaRule());
		GameCache.getGameRuleMap().put(GameType.GAME_TYPE_QINGHUNPENG, new QingHunPengRule());
		
	
	}

	@Override
	public Object newGame(Role role, NewGameConfigData gameConfig) {
		int round = gameConfig.getRound();
		GameRoundConfig config = GameRoundConfigCache.roundMap().get(round);
		if (config == null) {
			return null;
		}

		if (role.getMoney() < config.needMoney) {
			return null;
		}

		AbstractGame abstractGame = this.createGame(gameConfig);

		return SC.newBuilder().setMatchNewGameResponse(MatchNewGameResponse.newBuilder()).build();
	}

	private AbstractGame createGame(NewGameConfigData config) {
		int gameId = idClassCreator.getId(AbstractGame.class);
		
		GameType gameType = config.getGameType();
		
		Class<? extends AbstractGame> abstractGameClass = GameCache.getGameClassMap().get(gameType);
		AbstractGame game = ReflectUtils.newInstance(abstractGameClass);
		
		
		

		GameCache.getGameMap().put(gameId, game);
		return game;
	}

}
