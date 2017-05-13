package com.randioo.shanghaimajiang_server.entity.bo;

public class Role extends RoleInterfaceImpl {

	private int money;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		setChange(true);
		this.money = money;
	}

}
