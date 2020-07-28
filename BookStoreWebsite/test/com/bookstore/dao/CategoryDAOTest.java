package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryDAOTest extends BaseDAOTest {
	
	private static CategoryDAO categoryDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		categoryDao = new CategoryDAO(entityManager);
	}

	@Test
	public void testCreateCategory() {
		Category newCat = new Category("Geography");
		Category category = categoryDao.create(newCat);
		assertTrue(category != null && category.getCategoryId() > 0);

	}

	@Test
	public void testUpdateCategory() {
		Category cat = new Category("Java Core");
		cat.setCategoryId(1);
		
		Category category = categoryDao.update(cat);
		assertEquals(cat.getName(), category.getName());
	}

	@Test
	public void testGet() {
		
		Integer categoryId = 41;
		Category category =  categoryDao.get(categoryId);
		if (category != null) {
		System.out.println(category.getName());}
		assertNotNull(category);
	}

	@Test
	public void testDeleteCategory() {
		Integer catId = 22;
		categoryDao.delete(catId);
		Category cat = categoryDao.get(catId);
		assertNull(cat);
	}

	@Test
	public void testListAll() {
		List<Category> listCategory = categoryDao.listAll();
//		for (Category cat:listCategory) {
//			System.out.println(cat.getName());
//		}
		listCategory.forEach( c -> System.out.println(c.getName() + ", "));
		assertTrue(listCategory.size() > 0);
	}

	@Test
	public void testCount() {
		long totalCategories = categoryDao.count();
		assertEquals(6, totalCategories);
	}
	
	@Test
	public void testFindByName() {
		String name = "Java Core";
		Category category = categoryDao.findByName(name);
		assertNotNull(category);
	}
	
	@Test
	public void testFindByNameNotFound() {
		String name = "Java Core1";
		Category category = categoryDao.findByName(name);
		assertNull(category);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

}
