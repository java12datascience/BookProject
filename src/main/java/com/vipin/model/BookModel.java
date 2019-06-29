package com.vipin.model;

import java.io.Serializable;

import lombok.Data;
/**
 * 
 * @author vipinsingh
 *
 */
@Data
public class BookModel implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2275291388413849385L;



	private Integer bookid;
	
	private String bname;

	private String bauthor;

	private Double bprice;

}
