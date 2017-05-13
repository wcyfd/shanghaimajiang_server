package com.randioo.shanghaimajiang_server.core.majiang.qinghunpeng;

import com.randioo.shanghaimajiang_server.core.AbstractGame;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameType;

public class QingHunPengGame extends AbstractGame {

	@Override
	public int getGameType() {
		return GameType.GAME_TYPE_QINGHUNPENG.getNumber();
	}

	@Override
	public void initGame(Object gameConfigInterface) {
		// TODO Auto-generated method stub
		
	}

}
