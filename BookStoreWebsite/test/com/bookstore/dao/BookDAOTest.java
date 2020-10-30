package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class BookDAOTest  {

	private static BookDAO bookDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookDao = new BookDAO();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bookDao.close();
	}
	
	
	@Test
	public void testUpdateBook() throws ParseException, IOException {
		
		Book existBook = new Book();
		existBook.setBookId(1);
		Category category = new Category("Java Core");
		category.setCategoryId(1);
		existBook.setCategory(category );
		
		existBook.setTitle("Effective Java (3rd Edition)");
		existBook.setAuthor("Joshua Bloch");
		existBook.setDescription("Highlights include: New coverage of generics, enums, annotations, autoboxing, the for-each loop, varargs, concurrency utilities, and much more Updated techniques and best practices on classic topics, including objects, classes, libraries, methods, and serialization How to avoid the traps and pitfalls of commonly misunderstood subtleties of the language Focus on the language and its most fundamental libraries: java.lang, java.util, and, to a lesser extent, java.util.concurrent and java.io Simply put, Effective Java™, Second Edition, presents the most practical, authoritative guidelines available for writing efficient, well-designed programs.");
		existBook.setPrice(40f);
		existBook.setIsbn("03125668479");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");
		Date publishDate = dateFormat.parse("05/28/2008");
		existBook.setPublishDate(publishDate);
		String imagePath = "D:\\Vero\\JAVA\\Learn Java Servlet, JSP and Hibernate framework to build an eCommerce Website (with PayPal and credit card payment)\\images\\Effective_Java.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		existBook.setImage(imageBytes);
		
		Book updatedBook = bookDao.update(existBook);
		
		assertEquals(updatedBook.getTitle(), "Effective Java (3rd Edition)");	
		
	}


	@Test
	public void testCreateBook() throws ParseException, IOException {
		
		Book newBook = new Book();
		Category category = new Category("Java Advanced");
		category.setCategoryId(3);
		newBook.setCategory(category );
		
		newBook.setTitle("Effective Java (2nd Edition)");
		newBook.setAuthor("Joshua Bloch");
		newBook.setDescription("Highlights include: New coverage of generics, enums, annotations, autoboxing, the for-each loop, varargs, concurrency utilities, and much more Updated techniques and best practices on classic topics, including objects, classes, libraries, methods, and serialization How to avoid the traps and pitfalls of commonly misunderstood subtleties of the language Focus on the language and its most fundamental libraries: java.lang, java.util, and, to a lesser extent, java.util.concurrent and java.io Simply put, Effective Java™, Second Edition, presents the most practical, authoritative guidelines available for writing efficient, well-designed programs.");
		newBook.setPrice(38.87f);
		newBook.setIsbn("3125668479");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");
		Date publishDate = dateFormat.parse("05/28/2008");
		newBook.setPublishDate(publishDate);
		String imagePath = "D:\\Vero\\JAVA\\Learn Java Servlet, JSP and Hibernate framework to build an eCommerce Website (with PayPal and credit card payment)\\images\\Effective_Java.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		Book createdBook = bookDao.create(newBook);
		
		assertTrue(createdBook.getBookId() > 0);	
		
	}
	@Test
	public void testCreate2ndBook() throws ParseException, IOException {
		
		Book newBook = new Book();
		Category category = new Category("Java Core");
		category.setCategoryId(1);
		newBook.setCategory(category );
		
		newBook.setTitle("Java 8 in action");
		newBook.setAuthor("Alan Mycroft");
		newBook.setDescription("Every new version of Java is important, but Java 8 was a game changer. Java 8 in Action is a clearly written guide to the new features of Java 8. It begins with a practical introduction to lambdas, using real-world Java code. Next, it covers the new Streams API and shows how you can use it to make collection-based code radically easier to understand and maintain. It also explains other major Java 8 features including default methods, Optional, CompletableFuture, and the new Date and Time API. With Java 8's functional features you can write more concise code in less time and also automatically benefit from multicore architectures. It's time to dig in!");
		newBook.setPrice(36.72f);
		newBook.setIsbn("16172951423");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");
		Date publishDate = dateFormat.parse("08/28/2014");
		newBook.setPublishDate(publishDate);
		String imagePath = "D:\\Vero\\JAVA\\Learn Java Servlet, JSP and Hibernate framework to build an eCommerce Website (with PayPal and credit card payment)\\images\\Java_8_in_action.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		Book createdBook = bookDao.create(newBook);
		
		assertTrue(createdBook.getBookId() > 0);	
		
	}


	@Test(expected = EntityNotFoundException.class )
	public void testDeleteBookFail() throws ParseException, IOException {
		
		Integer bookId = 100;
		bookDao.delete(bookId);
		
		assertTrue(true);
		
	}
	
	@Test
	public void testGetBookFail() throws ParseException, IOException {
		
		Integer bookId = 99;
		Book book = bookDao.get(bookId);
		assertNull(book);
		
	}
	
	@Test
	public void testListAll() {
		List<Book> listBooks =  bookDao.listAll();
		
		for (Book aBook : listBooks ) {
			System.out.println(aBook.getTitle() + " - " + aBook.getAuthor());
		}
		
		assertFalse(listBooks.isEmpty());
		
	}
	
	@Test
	public void testFindByTitleNotExist() {
		String title = "Thinking in Java";
		Book book = bookDao.findByTitle(title);
				
		assertNull(book);
		
	}
	
	@Test
	public void testFindByTitleExist() {
		String title = "Java 8 in action";
		Book book = bookDao.findByTitle(title);
		System.out.println(book.getAuthor());	
		System.out.println(book.getPrice());	
		assertNotNull(book);
		
	}
	
	@Test
	public void testCount() {
		long totalBooks = bookDao.count();
		assertEquals(2, totalBooks);
	}
	
	@Test
	public void testDeleteBookSuccess() throws ParseException, IOException {
		
		Integer bookId = 5;
		bookDao.delete(bookId);
		
		assertTrue(true);
		
	}
	
	@Test
	public void testGetBookSuccess() throws ParseException, IOException {
		
		Integer bookId = 5;
		Book book = bookDao.get(bookId);
		
		assertTrue(true);
		
	}
	
	@Test
	public void testListByCategory() {
		int categoryId = 1;
		List<Book> listBooks = bookDao.listByCategory(categoryId);
		
		assertTrue(listBooks.size() > 0);
		
	}
	
	@Test
	public void testListNewBooks() {
		List<Book> listNewBooks = bookDao.listNewBooks();
		
		for (Book aBook : listNewBooks) {
			System.out.println(aBook.getTitle() + " - " + aBook.getPublishDate());
		}
		assertEquals(4, listNewBooks.size());
	}
	
	@Test
	public void testSearchBookInTitle () {
		String keyword = "Java";
		List<Book> result = bookDao.search(keyword);
		for (Book aBook : result) {
			System.out.println(aBook.getTitle() );
		}
		assertEquals(7, result.size());
	}
	
	@Test
	public void testSearchBookInAuthor () {
		String keyword = "Ferriss";
		List<Book> result = bookDao.search(keyword);
		for (Book aBook : result) {
			System.out.println(aBook.getAuthor() );
		}
		assertEquals(1, result.size());
	}
	
	@Test
	public void testSearchBookInDescription () {
		String keyword = "Grails in a hurry";
		List<Book> result = bookDao.search(keyword);
		for (Book aBook : result) {
			System.out.println(aBook.getDescription() );
		}
		assertEquals(1, result.size());
	}
}
