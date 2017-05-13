package com.randioo.shanghaimajiang_server.module.match.action;

import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.randioo.randioo_server_base.annotation.PTAnnotation;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.IActionSupport;
import com.randioo.shanghaimajiang_server.entity.bo.Role;
import com.randioo.shanghaimajiang_server.module.match.service.MatchService;
import com.randioo.shanghaimajiang_server.protocol.Match.MatchNewGameRequest;
import com.randioo.shanghaimajiang_server.util.SessionUtils;

@PTAnnotation(MatchNewGameRequest.class)
public class MatchNewGameAction implements IActionSupport {

	@Autowired
	private MatchService matchService;

	@Override
	public void execute(Object data, IoSession session) {
		MatchNewGameRequest request = (MatchNewGameRequest) data;
		Role role = (Role) RoleCache.getRoleBySession(session);
		Object message = matchService.newGame(role, request.getNewGameConfigData());
		
		SessionUtils.sc(session, message);
	}

}
