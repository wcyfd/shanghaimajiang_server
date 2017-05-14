package com.randioo.shanghaimajiang_server.core;

import com.randioo.randioo_server_base.entity.RoleInterface;

public abstract class AbstractGame {
	private int gameId;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public abstract void initGame(Object config);

	public abstract void joinGame(RoleInterface role);

}
