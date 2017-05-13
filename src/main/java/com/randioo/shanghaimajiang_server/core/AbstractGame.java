package com.randioo.shanghaimajiang_server.core;

public abstract class AbstractGame {
	private int gameId;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public abstract int getGameType();

	public abstract void initGame(Object gameConfigInterface);

}
