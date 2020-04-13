package com.hams.manager.erp.common.base;

import com.hams.manager.erp.common.entity.User;
import com.hams.manager.erp.common.realm.AuthRealm;
import com.hams.manager.erp.common.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
	
	public User getCurrentUser() {
		AuthRealm.ShiroUser shiroUser = (AuthRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
		if(shiroUser == null) {
			return null;
		}
		User loginUser = userService.selectById(shiroUser.getId());
		return loginUser;
	}

	@Autowired
	protected UserService userService;

}
