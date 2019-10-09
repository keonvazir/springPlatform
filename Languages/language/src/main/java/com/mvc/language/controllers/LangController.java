package com.mvc.language.controllers;

//import java.awt.print.Book;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.language.models.Lang;
import com.mvc.language.services.LangService;




@Controller
public class LangController {
  private final LangService langService;
  
  public LangController(LangService langService) {
      this.langService = langService;
  }
  
  @GetMapping("/")
  public String index(Model model) {
	  List<Lang> users = langService.allLangs();
      model.addAttribute("users", users);
      model.addAttribute("user", new Lang());
      return "/languages/index.jsp";
  }
  @PostMapping(value="/")
  public String create(@Valid @ModelAttribute("user") Lang user, BindingResult result) {
	  if (result.hasErrors()) {
		  return "/languages/index.jsp";
	  }
	  else {
		  langService.createOrUpdateLang(user);
		  return "redirect:/books";
	  }
  }
  
}