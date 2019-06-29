package com.vipin.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipin.entity.BookEntity;
import com.vipin.model.BookModel;
import com.vipin.repository.BookRepository;

/**
 * 
 * @author vipinsingh
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	/**
	 * this method use to insert book data
	 * 
	 * @return Integer
	 * @param model
	 */
	@Override
	public Integer inserBookData(BookModel model) {

		BookEntity entity = null;
		// create entity class object
		entity = new BookEntity();

		// copy model class property to entity class
		BeanUtils.copyProperties(model, entity);

		// use book repository
		entity = bookRepo.save(entity);

		return entity.getBookid();
	}

	/**
	 * method use to retrieve all book data
	 * 
	 * @return Object
	 */
	@Override
	public List<BookModel> findAllBookDetails() {
		List<BookEntity> listEntity = null;

		List<BookModel> listModel = new ArrayList<>();
		listEntity = bookRepo.findAll();
		listEntity.forEach(list -> {
			BookModel model = new BookModel();
			//copy entity to model class
			BeanUtils.copyProperties(list, model);
			listModel.add(model);
		});
		return listModel;
	}

	/**
	 * method use to delete book record by id
	 * 
	 * @param id
	 * @return string
	 */
	@Override
	public String deleteBookDetail(Integer id) {

		if (id == 0) {
			return "Record not found for Deletion";
		} else {
			bookRepo.deleteById(id);
			return "Record  found and Deleted";
		}

	}

	/**
	 * method use to retrieve book record by id
	 * 
	 * @param id 
	 * @return object
	 */
	@Override
	public BookModel findById(int id) {
		BookEntity entity = null;
		BookModel model = null;
		model = new BookModel();
		// use book repository class
		entity = bookRepo.getOne(id);
		// copy entity to model class
		BeanUtils.copyProperties(entity, model);

		return model;

	}

}
