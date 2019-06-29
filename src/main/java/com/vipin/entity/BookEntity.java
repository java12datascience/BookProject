package com.vipin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * 
 * @author vipinsingh
 *
 */
@Data
@Entity
@Table(name="BOOKS_DETAILS")
public class BookEntity {
	
	@Id
	@GeneratedValue
	@Column(name="BOOK_ID",length=10)
	private Integer bookid;
	
	@Column(name="B_NAME",length=15)
	private String bname;
	
	@Column(name="B_AUTHOR",length=15)
	
	private String bauthor;
	
	@Column(name="B_PRICE",length=15)
	//@Transient
	private Double bprice;

}
