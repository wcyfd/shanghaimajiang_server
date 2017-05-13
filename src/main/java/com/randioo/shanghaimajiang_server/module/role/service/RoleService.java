package com.randioo.shanghaimajiang_server.module.role.service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_server_base.utils.service.ObserveBaseServiceInterface;
import com.randioo.shanghaimajiang_server.entity.bo.Role;

public interface RoleService extends ObserveBaseServiceInterface {

	void newRoleInit(Role role);

	public void roleInit(Role role);

	GeneratedMessage rename(Role role, String name);

}
