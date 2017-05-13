package com.randioo.shanghaimajiang_server.module.login.action;

import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_server_base.annotation.PTAnnotation;
import com.randioo.randioo_server_base.net.IActionSupport;
import com.randioo.shanghaimajiang_server.module.login.service.LoginService;
import com.randioo.shanghaimajiang_server.protocol.Login.LoginCheckAccountRequest;
import com.randioo.shanghaimajiang_server.util.SessionUtils;

@Controller
@PTAnnotation(LoginCheckAccountRequest.class)
public class LoginCheckAction implements IActionSupport {

	@Autowired
	private LoginService loginService;

	@Override
	public void execute(Object data, IoSession session) {
		LoginCheckAccountRequest request = (LoginCheckAccountRequest) data;
		GeneratedMessage sc = loginService.login(request.getAccount());
		SessionUtils.sc(session, sc);
	}

}
