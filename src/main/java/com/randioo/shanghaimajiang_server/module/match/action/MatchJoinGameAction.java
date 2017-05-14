package com.randioo.shanghaimajiang_server.module.match.action;

import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_server_base.annotation.PTAnnotation;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.IActionSupport;
import com.randioo.shanghaimajiang_server.entity.bo.Role;
import com.randioo.shanghaimajiang_server.module.match.service.MatchService;
import com.randioo.shanghaimajiang_server.protocol.Match.MatchJoinGameRequest;
import com.randioo.shanghaimajiang_server.util.SessionUtils;

@PTAnnotation(MatchJoinGameRequest.class)
public class MatchJoinGameAction implements IActionSupport {

	@Autowired
	private MatchService matchService;

	@Override
	public void execute(Object data, IoSession session) {
		MatchJoinGameRequest request = (MatchJoinGameRequest) data;
		Role role = (Role) RoleCache.getRoleBySession(session);
		GeneratedMessage message = matchService.joinGame(role, request.getGameId());

		SessionUtils.sc(session, message);
	}

}
