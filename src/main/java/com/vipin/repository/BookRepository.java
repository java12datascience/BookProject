package com.vipin.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vipin.entity.BookEntity;
/**
 * 
 * @author vipinsingh
 *
 */
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Serializable> {
       /**
        * 
        * @param id
        * @return
        */
	@Query("from BookEntity where bookid=:id")
	public Integer searchById(Integer id);
}
