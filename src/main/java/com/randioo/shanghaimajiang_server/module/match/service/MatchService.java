package com.randioo.shanghaimajiang_server.module.match.service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_server_base.utils.service.ObserveBaseServiceInterface;
import com.randioo.shanghaimajiang_server.entity.bo.Role;
import com.randioo.shanghaimajiang_server.protocol.Entity.NewGameConfigData;

public interface MatchService extends ObserveBaseServiceInterface {

	GeneratedMessage newGame(Role role, NewGameConfigData gameConfig);

	GeneratedMessage joinGame(Role role, int gameId);
}
