package com.vipin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vipin.cmd.Book;
import com.vipin.model.BookModel;
import com.vipin.service.BookService;

/**
 * 
 * @author vipinsingh
 *
 */
@Controller
public class BookController {
   /**
    * 
    */
	@Autowired
	private BookService service;

	/**
	 * this is use for displaying home page
	 * 
	 * @return
	 */
	@RequestMapping("/home")
	public String showHome() {
		return "home";
	}

	/**
	 * this method use to initial lunching form
	 * 
	 * @param map
	 * @param book
	 * @return
	 */

	//@RequestMapping(name = "/register1", method = RequestMethod.GET)
	@GetMapping("/register")
	public String showRegisterPage(Map<String, Object> map, @ModelAttribute("bookCmd") Book book) {
		return "register";
	}

	/**
	 * process the form
	 * 
	 * @param map
	 * @param book
	 * @param errors
	 * @param req
	 * @return
	 */

	//@RequestMapping(name = "/register", method = RequestMethod.POST)
	@PostMapping("/register")
	public String processRegisterPage(Map<String, Object> map, @ModelAttribute("bookCmd") Book book) {
		Integer id = null;

		String msg, msg1 = null;
		List<BookModel> listModel = null;

		BookModel model = null;
		// create model class object
		model = new BookModel();
		id = book.getBookid();
		// copy property command class to model class
		BeanUtils.copyProperties(book, model);

		// user service
		service.inserBookData(model);

		if (id == null) {
			msg = "Register success";
			map.put("msg", msg);

		} else {
			msg1 = "update record";
			map.put("msg", msg1);

		}
		// use service
		listModel = service.findAllBookDetails();

		// put the all record into map

		map.put("listmodel", listModel);

		map.put("bookCmd", new Book());

		return "register";
	}

	/**
	 * this method use to update the user details
	 * 
	 * @param map
	 * @param book
	 * @param req
	 * @return
	 */

	//@RequestMapping(value = "/update", method = RequestMethod.GET)
	@GetMapping("/update")
	public String updateBook(Map<String, Object> map, @ModelAttribute("bookCmd") Book book, HttpServletRequest req) {

		List<BookModel> listmodel = null;
		BookModel model = null;

		// create model class object
		model = new BookModel();
		// use service
		model = service.findById(Integer.parseInt(req.getParameter("bookid")));

		// copy model class to command class
		BeanUtils.copyProperties(model, book);

		// use service
		listmodel = service.findAllBookDetails();
		
		//map 
		map.put("listmodel", listmodel);
		map.put("book", book);
		System.out.println(book);
		return "register";

	}

	/**
	 * this method use to delete record
	 * 
	 * @param map
	 * @param book
	 * @param res
	 * @param attribute
	 * @return
	 */
	//@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@GetMapping("/delete")
	public String removeBookById(Map<String, Object> map, @ModelAttribute("bookCmd") Book book, HttpServletRequest res,
			RedirectAttributes attribute) {
		String msg = null;
		List<BookModel> listmodel = null;
		msg = service.deleteBookDetail(Integer.parseInt(res.getParameter("bookid")));
		listmodel = service.findAllBookDetails();
		attribute.addFlashAttribute("listmodel", listmodel);
		attribute.addFlashAttribute("msg", msg);
		return "redirect:/register";

	}
	/*@GetMapping
	public String doublePost(HttpServletRequest req) {
		return "dbl_post";
	}
	*/

}
