package com.randioo.shanghaimajiang_server.entity.bo;

public class Role extends RoleInterfaceImpl {

	private int money;
	private int gameId;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		setChange(true);
		this.money = money;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getGameId() {
		return gameId;
	}

}
