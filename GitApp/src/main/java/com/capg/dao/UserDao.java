package com.capg.dao;

import java.util.HashMap;

public class UserDao {

	private static HashMap<String, String> users;

	public UserDao() {
		if (users == null) {
			users = new HashMap<>();
			users.put("kiran", "kiran123");
			users.put("arun", "arun123");
		}
	}
	
	public HashMap<String,String> getUsers(){
		return users;
	}

}
