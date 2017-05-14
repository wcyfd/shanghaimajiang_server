package com.randioo.shanghaimajiang_server.core.majiang;

import com.randioo.shanghaimajiang_server.core.AbstractGame;
import com.randioo.shanghaimajiang_server.entity.bo.Role;

public abstract class MajiangGame extends AbstractGame {
	public abstract int getGameType();

	private MajiangRuleInterface majiangRuleInterface;

	public MajiangRuleInterface getMajiangRuleInterface() {
		return majiangRuleInterface;
	}

	public void setMajiangRuleInterface(MajiangRuleInterface majiangRuleInterface) {
		this.majiangRuleInterface = majiangRuleInterface;
	}

}
