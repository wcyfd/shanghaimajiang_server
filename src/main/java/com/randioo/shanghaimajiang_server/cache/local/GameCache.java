package com.randioo.shanghaimajiang_server.cache.local;

import java.util.HashMap;
import java.util.Map;

import com.randioo.shanghaimajiang_server.core.AbstractGame;
import com.randioo.shanghaimajiang_server.core.GameRuleInterface;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameType;

public class GameCache {
	private static Map<Integer, AbstractGame> gameMap = new HashMap<>();

	public static Map<Integer, AbstractGame> getGameMap() {
		return gameMap;
	}

	private static Map<GameType, GameRuleInterface> ruleMap = new HashMap<>();

	public static Map<GameType, GameRuleInterface> getGameRuleMap() {
		return ruleMap;
	}

	private static Map<GameType, Class<? extends AbstractGame>> gameClassMap = new HashMap<>();

	public static Map<GameType, Class<? extends AbstractGame>> getGameClassMap() {
		return gameClassMap;
	}
}
