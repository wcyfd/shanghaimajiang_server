package com.randioo.shanghaimajiang_server.module.fight.service;

import org.springframework.stereotype.Service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_server_base.utils.service.ObserveBaseService;
import com.randioo.shanghaimajiang_server.cache.local.GameCache;
import com.randioo.shanghaimajiang_server.core.majiang.MajiangGame;
import com.randioo.shanghaimajiang_server.entity.bo.Role;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameActionData;

@Service("fightService")
public class FightServiceImpl extends ObserveBaseService implements FightService {

	@Override
	public GeneratedMessage action(Role role, GameActionData gameActionData) {
		int gameId = role.getGameId();
		MajiangGame majiangGame = GameCache.getGameMap().get(gameId);
		
		return null;
	}

}
