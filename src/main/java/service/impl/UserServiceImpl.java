package service.impl;

import java.util.List;

import model.UserInfo;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.UserService;
import dao.UserInfoMapper;

@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private SqlSessionFactoryBean sqlSession;

	@Override
	public UserInfo getUserById(int id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserInfo> getUsers() {
		return userInfoMapper.selectAll();
	}

	@Override
	public int insert(UserInfo userInfo) {
		
		int result = userInfoMapper.insert(userInfo);
		
		System.out.println(result);
		return result;
	}

	// Spring+Mybatis整合事务不起作用之解决方案汇总
	// http://blog.csdn.net/walkerjong/article/details/7839002
	@Override
	public int inserts(List<UserInfo> userInfos) { // 通过SqlSession手动控制事务
		int result = 0;
		
		SqlSession session = null;
		try {
			session = sqlSession.getObject().openSession();
			result = userInfoMapper.inserts(userInfos);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			LOG.warn("数据库操作异常，已经回滚", e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return result;
	}
	
	/*public int inserts(List<UserInfo> userInfos) { // 通过抛异常控制事务
		return userInfoMapper.inserts(userInfos);
	}*/

}