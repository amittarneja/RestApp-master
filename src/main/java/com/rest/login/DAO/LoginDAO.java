package com.rest.login.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rest.login.model.Login;
/**
 * Created by Amit on 2021/11/7
 * Login data access object.
 */
@Repository
public class LoginDAO {

	private static final Map<String, Login> loginMap = new HashMap<String, Login>();

	static {
		Login login1 = new Login("1", "Amit", "Tarneja");

		loginMap.put(login1.getLoginNo(), login1);
	}

	public List<Login> getAllLogins() {
		Collection<Login> c = loginMap.values();
		List<Login> list = new ArrayList<Login>();
		list.addAll(c);
		return list;
	}

}