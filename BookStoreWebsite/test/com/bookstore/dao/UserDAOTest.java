package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {

	
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setUpClass() throws Exception {

		userDAO = new UserDAO();
	}
	
	@Test
	public void testCreateUsers() {
		
		Users user1 = new Users();
		user1.setEmail("test123@gmail.com");
		user1.setFullName("Alexander Test123");
		user1.setPassword("a2132");
		
		user1 = userDAO.create(user1);
		assertTrue(user1.getUserId() > 0);	
	}
	
	@Test(expected = PersistenceException.class )
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();
		
		user1 = userDAO.create(user1);	
	}
	
	@Test
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUserId(1);
		user.setEmail("veronica.mereacre26@gmail.com");
		user.setFullName("Veronica Eu");
		user.setPassword("24674ab1ad41298ef20c23b7bbd4184f");
		userDAO.update(user);
		
		String expected = "secret26";
		String actual = user.getPassword();
		
		
		
		assertEquals (expected, actual);
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		if (user != null) {
		System.out.println(user.getEmail());}
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 99;
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		Integer userId = 20;
		userDAO.delete(userId);
		Users user = userDAO.get(userId);
		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUsers() {
		Integer userId = 50;
		userDAO.delete(userId);
		
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		for (Users user:listUsers) {
			System.out.println(user.getEmail());
		}
		
		assertTrue(listUsers.size()>0);
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		assertEquals(15, totalUsers);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "veronica.mereacre26@gmail.com";
		String password = "secret26";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertTrue(loginResult);
	}
	
	@Test
	public void testCheckLoginFail() {
		String email = "veronica26@gmail.com";
		String password = "secret6";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertFalse(loginResult);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "sophia@yahoo.com";
		Users user = userDAO.findByEmail(email);
		
		assertNotNull(user);
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDAO.close();
		
	}


}
