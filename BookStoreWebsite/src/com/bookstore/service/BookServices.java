package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookServices {

	private EntityManager entityManager;
	private BookDAO bookDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	
	
	public BookServices(EntityManager entityManager,  HttpServletRequest request,
			HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		
		bookDAO = new BookDAO(entityManager);
	}

//	public void listBooks(String message) throws ServletException, IOException {
//		
//		List<Book> listBook = bookDAO.listAll();
//		request.setAttribute("listBook", listBook);
//		
//		if (message != null) {
//			request.setAttribute("message", message);
//		}
//		
//		String listPage = "book_list.jsp";
//		RequestDispatcher requestDispatcher =  request.getRequestDispatcher(listPage);	
//				
//		requestDispatcher.forward(request, response);
//	}
	
	public void listBooks () throws ServletException, IOException {
		List<Book> listBooks = bookDAO.listAll();
		request.setAttribute("listBooks", listBooks);
		
		String listPage = "book_list.jsp";
		RequestDispatcher requestDispatcher =  request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
}
