package com.randioo.shanghaimajiang_server.core.majiang.qiaoma;

import com.randioo.shanghaimajiang_server.core.AbstractGame;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameType;

public class QiaoMaGame extends AbstractGame {

	@Override
	public int getGameType() {
		return GameType.GAME_TYPE_QIAOMA.getNumber();
	}

	@Override
	public void initGame(Object gameConfigInterface) {
		// TODO Auto-generated method stub

	}

}
