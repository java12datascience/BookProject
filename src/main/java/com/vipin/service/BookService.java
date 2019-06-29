package com.vipin.service;

import java.util.List;

import com.vipin.model.BookModel;
/**
 * 
 * @author vipinsingh
 *
 */
public interface BookService {
	
	public Integer inserBookData(BookModel model);
	public List<BookModel> findAllBookDetails();
	public String deleteBookDetail(Integer id);
	public  BookModel findById(int id);
	
	

}
