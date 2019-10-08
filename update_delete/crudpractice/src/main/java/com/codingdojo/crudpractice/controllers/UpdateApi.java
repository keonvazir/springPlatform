package com.codingdojo.crudpractice.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.crudpractice.models.Update;
import com.codingdojo.crudpractice.services.UpdateService;






@RestController
public class UpdateApi {
	@Autowired
	public UpdateService crudService;
	
	@GetMapping("/")
	public String root(Model model) {
		List<Update> allBooks = crudService.getAllBooks();
		model.addAttribute("updates", allBooks);
		return "Hello World!";
	}
	
	@GetMapping("/api/updates")
    public List<Update> index() {
        return crudService.getAllBooks();
    }
	@RequestMapping(value="/api/updates", method=RequestMethod.POST)
    public Update create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Update crud = new Update(title, desc, lang, numOfPages);
        return crudService.createBook(crud);
    }
    
	@RequestMapping(value="/api/updates/{id}", method=RequestMethod.PUT)
    public Update update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Update crud = crudService.update(id, title, desc, lang, numOfPages);
        return crud;
    }
    
    @RequestMapping(value="/api/updates/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        crudService.deleteUpdate(id);
    }
	
}


