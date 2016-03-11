package com.template.system.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.commons.dao.BaseDaoI;
import com.template.commons.utils.security.Digests;
import com.template.system.entity.User;
import com.template.system.service.LoginServiceI;

/**
 * @ClassName: LoginServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Peter Jia
 * @date 2016年3月9日 下午12:48:08
 * 
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginServiceI {

	@Autowired
	private BaseDaoI<User> loginDao;

	public User Login(User user) {
		user.setPassword(Digests.e(user.getPassword()));
		String hql = "from User u where u.username = ? and u.password = ?";
		User u = loginDao.get(hql, new Object[] { user.getUsername(), user.getPassword() });
		return u;
	}

	public User LoginOut() {
		return null;
	}

	public User IsExist(User user) {
		String hql = "from User u where u.username = ?";
		User u = loginDao.get(hql, new Object[] {user.getUsername()});
		return u;
	}

}
