package bree.test.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import bree.stage.entity.User;
import bree.stage.repository.UserDAO;

public class UserDAOTest extends BaseConfigurtionTest {
	@Autowired
	private UserDAO userDao;

	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("nana");
		userDao.addUser(user);
		System.out.println("成功往数据库中插入一条数据");
	}

	@Test
	public void testFindAllUsers() {
		List<User> list = userDao.findAllUsers();
		User user = null;
		if (list != null && !list.isEmpty()) {
			System.out.println("所有用户数目" + list.size());
			user = list.get(0);
		}
		if (user != null) {
			System.out.println("user name:" + user.getName());
		}

	}

	@Test
	public void testFindAllUsersWithPagination() {
		RowBounds rowBounds = new RowBounds(4, 1);
		List<User> list = userDao.findAllUsersWithPagination(rowBounds);
		User user = null;
		if (list != null && !list.isEmpty()) {
			System.out.println("所有用户数目" + list.size());
			user = list.get(0);
		}
		if (user != null) {
			System.out.println("user name:" + user.getName());
		}

	}
}
