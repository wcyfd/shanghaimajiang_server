package com.randioo.shanghaimajiang_server.core.majiang.qiaoma;

import com.randioo.randioo_server_base.entity.RoleInterface;
import com.randioo.shanghaimajiang_server.core.majiang.MajiangGame;
import com.randioo.shanghaimajiang_server.entity.bo.Role;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameType;

public class QiaoMaGame extends MajiangGame {

	@Override
	public int getGameType() {
		return GameType.GAME_TYPE_QIAOMA.getNumber();
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
