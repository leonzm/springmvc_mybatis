package service;

import java.util.List;

import model.UserInfo;

public interface UserService {

	UserInfo getUserById(int id);
	
	List<UserInfo> getUsers();
	
	int insert(UserInfo userInfo);
	
	int inserts(List<UserInfo> userInfos);
}
