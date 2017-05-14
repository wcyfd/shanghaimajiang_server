package com.randioo.shanghaimajiang_server.core.majiang.qinghunpeng;

import com.randioo.randioo_server_base.entity.RoleInterface;
import com.randioo.shanghaimajiang_server.core.majiang.MajiangGame;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameType;

public class QingHunPengGame extends MajiangGame {

	@Override
	public int getGameType() {
		return GameType.GAME_TYPE_QINGHUNPENG.getNumber();
	}

	@Override
	public void initGame(Object gameConfigInterface) {
		// TODO Auto-generated method stub

	}

	@Override
	public void joinGame(RoleInterface role) {
		// TODO Auto-generated method stub

	}

}
