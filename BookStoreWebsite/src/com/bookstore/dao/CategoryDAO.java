package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;


import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Category create(Category category) {
		return super.create(category);
	}

	@Override
	public Category update(Category category) {
		return super.update(category);
	}

	@Override
	public Category get(Object categoryId) {
		return super.find(Category.class, categoryId);
	
	}

	@Override
	public void delete(Object categoryId) {
		super.delete(Category.class, categoryId);
		
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Category.countAll");
	}

	public Category findByName(String categoryName) {
		List<Category> listCategory = super.findWithNamedQuery("Category.findByName", "name", categoryName);
		if (listCategory !=null && listCategory.size()> 0) {
		return listCategory.get(0);
		}
		return null;
	}

}
