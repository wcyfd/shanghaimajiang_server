package com.randioo.shanghaimajiang_server.cache.file;

import java.util.HashMap;
import java.util.Map;

import com.randioo.shanghaimajiang_server.entity.file.GameRoundConfig;

public class GameRoundConfigCache {

	private static Map<Integer, GameRoundConfig> map = new HashMap<>();
	private static Map<Integer, GameRoundConfig> roundMap = new HashMap<>();

	public static void putConfig(GameRoundConfig config) {
		map.put(config.id, config);
		roundMap.put(config.round, config);
	}

	public static Map<Integer, GameRoundConfig> map() {
		return map;
	}

	public static Map<Integer, GameRoundConfig> roundMap() {
		return roundMap;
	}

}
