package com.date.dateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;




@Controller
public class HomeController {
	
@RequestMapping("/")
 public String index(Model model) {
	new java.util.Date();
       return "index.jsp";
  }
@RequestMapping("/date") 
	public Date date(Model model) {
		model.addAttribute("datetemp");
		Date datetemp;
		datetemp = new java.util.Date();
		return datetemp;
	}
}


