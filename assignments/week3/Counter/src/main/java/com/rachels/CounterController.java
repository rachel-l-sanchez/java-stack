package com.rachels;

import javax.servlet.http.HttpSession;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class CounterController {
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		// Use getAttribute to initialize test to see if it exists in session or else set the values

		if (session.getAttribute("number") == null) {
			session.setAttribute("number", 0);
		}
		if(session.getAttribute("server") == null) {
			session.setAttribute("server", "http://your_server");
		}
		else {
			Integer currCount = (Integer) session.getAttribute("number");
			currCount ++ ;
			session.setAttribute("currCount", currCount);
			model.addAttribute("currCount", currCount);
	
			String serverName = (String) session.getAttribute("server");
			model.addAttribute("server", serverName);
		}

	
		return "index.jsp";	
	}

	@GetMapping("/count")
	public String increaseCount(Model model, HttpSession session) {
		
		return "counter.jsp";
	}
	
	@GetMapping("/reset")
	public String resetCount(Model model, HttpSession session) {
		session.setAttribute("currCount", 0);
		Integer newCount = (Integer) session.getAttribute("currCount");
		model.addAttribute("currCount", newCount);
		return "counter.jsp";
	}
	
	@GetMapping("/plus/Two")
	public String plusTwo(Model model, HttpSession session) {
		Integer plusTwoCount = (Integer) session.getAttribute("currCount");
		Integer newCount = (Integer) plusTwoCount+2;
		model.addAttribute("currCount", newCount);
		return "counter.jsp";
	}
		
}
