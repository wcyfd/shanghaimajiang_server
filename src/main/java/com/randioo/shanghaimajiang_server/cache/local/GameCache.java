package com.randioo.shanghaimajiang_server.cache.local;

import java.util.HashMap;
import java.util.Map;

import com.randioo.shanghaimajiang_server.core.majiang.MajiangGame;
import com.randioo.shanghaimajiang_server.core.majiang.MajiangRule;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameType;

public class GameCache {
	private static Map<Integer, MajiangGame> gameMap = new HashMap<>();

	public static Map<Integer, MajiangGame> getGameMap() {
		return gameMap;
	}

	private static Map<GameType, MajiangRule> ruleMap = new HashMap<>();

	public static Map<GameType, MajiangRule> getGameRuleMap() {
		return ruleMap;
	}

	private static Map<GameType, Class<? extends MajiangGame>> gameClassMap = new HashMap<>();

	public static Map<GameType, Class<? extends MajiangGame>> getGameClassMap() {
		return gameClassMap;
	}

}
