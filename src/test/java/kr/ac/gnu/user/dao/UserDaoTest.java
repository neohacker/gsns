package kr.ac.gnu.user.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import kr.ac.gnu.user.domain.User;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;



public class UserDaoTest {
	
	UserDao dao;
	
	private User user1;
	private User user2;
	private User user3;
	
	@Before
	public void setUp() {

		this.user1 = new User("gyumee", "박성철", "springno1","gyumee@mail.com");
		this.user2 = new User("leegw700","이길원", "springno2","leegw700@mail.com");
		this.user3 = new User("bumjin", "박범진", "springno3","bumjin@mail.com");
		
		dao = new UserDao();
		
		DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://aws.miraesoft.kr/gsns", "gsns", "ahffk", true);
		dao.setDataSource(dataSource);
	}
	
	@Test
	public void addAndGet() throws SQLException {
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		
		User userget1 = dao.get(user1.getId());
		assertThat(userget1.getName(), is(user1.getName()));
		assertThat(userget1.getPassword(), is(user1.getPassword()));
		
		User userget2 = dao.get(user2.getId());
		assertThat(userget2.getName(), is(user2.getName()));
		assertThat(userget2.getPassword(), is(user2.getPassword()));
		
	}
	
	@Test
	public void count() throws SQLException {
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		assertThat(dao.getCount(), is(1));
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		dao.add(user3);
		assertThat(dao.getCount(), is(3));
		
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException {
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.get("unknown_id");
	}
}