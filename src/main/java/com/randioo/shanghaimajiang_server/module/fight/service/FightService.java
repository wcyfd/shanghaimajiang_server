package com.randioo.shanghaimajiang_server.module.fight.service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_server_base.utils.service.ObserveBaseServiceInterface;
import com.randioo.shanghaimajiang_server.entity.bo.Role;
import com.randioo.shanghaimajiang_server.protocol.Entity.GameActionData;

public interface FightService extends ObserveBaseServiceInterface {

	GeneratedMessage action(Role role, GameActionData gameActionData);

}
