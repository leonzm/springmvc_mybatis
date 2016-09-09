package service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.UserInfo;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import dao.UserInfoMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class UserServiceTest {

	private static final Logger LOGGER = Logger.getLogger(UserServiceTest.class);

	@Autowired
	private UserInfoMapper userMapper;
	@Autowired
	private UserService userService;

	@Test
	public void testQueryById1() {
		UserInfo userInfo = userService.getUserById(1);
		LOGGER.info(JSON.toJSON(userInfo));
	}

	@Test
	public void testQueryAll() {
		List<UserInfo> userInfos = userService.getUsers();
		LOGGER.info(JSON.toJSON(userInfos));
	}

	@Test
	public void testInsert() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUname("xiaoming-" + new Random().nextInt(100));
		userInfo.setUnumber(5);
		int result = userService.insert(userInfo);
		System.out.println(result);
	}
	
	@Test
	public void testInserts() {
		int userId1 = 111;
		int userId2 = 112;
		int userId3 = 114;
		//userMapper.deleteByPrimaryKey(userId1);
		//userMapper.deleteByPrimaryKey(userId2);
		//userMapper.deleteByPrimaryKey(userId3);
		
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(userId1);
		userInfo1.setUname("xiaoming-" + new Random().nextInt(100));
		userInfo1.setUnumber(11);
		
		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(userId2);
		userInfo2.setUname("xiaoming-" + new Random().nextInt(100));
		userInfo2.setUnumber(12);
		
		UserInfo userInfo3 = new UserInfo();
		userInfo3.setId(userId3);
		userInfo3.setUname("xiaoming-" + new Random().nextInt(100));
		userInfo3.setUnumber(13);
		
		int result = userService.inserts(Arrays.asList(userInfo1, userInfo2, userInfo3));
		System.out.println(result);
	}
	
}
