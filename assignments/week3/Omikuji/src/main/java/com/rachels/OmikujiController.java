package com.rachels;


import javax.servlet.http.HttpSession;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@SpringBootApplication
@Controller
public class OmikujiController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping(value="/omikuji/form")
	public String processForm(@RequestParam(value="number") String number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="compliment") String compliment,HttpSession session) {
		// Use getAttribute to initialize test to see if it exists in session or else set the values

			if (session.getAttribute("number") == null || session.getAttribute("city") == null) {
				session.setAttribute("number", number);
				session.setAttribute("city", city);
			}
			else if (session.getAttribute("person") == null || session.getAttribute("hobby") == null) {
				session.setAttribute("hobby", hobby);
				session.setAttribute("person", person);
			}
			else if (session.getAttribute("thing") == null || session.getAttribute("compliment") == null) {
				session.setAttribute("thing", thing);
				session.setAttribute("compliment", compliment);
			}
			else {
				System.out.println("values are null");
			}
			
			return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String omikuji(Model model, HttpSession session) {
		String sessionNumber = (String) session.getAttribute("number");
		String randomNumber = sessionNumber;

		String sessionCity = (String) session.getAttribute("city");
		String randomCity= sessionCity;

		String sessionHobby = (String) session.getAttribute("hobby");
		String hobby = sessionHobby;

		String sessionThing = (String) session.getAttribute("thing");
		String randomItem = sessionThing;

		String sessionPerson = (String) session.getAttribute("person");
		String randomPerson  = sessionPerson;

		String sessionCompliment = (String) session.getAttribute("compliment");
		String compliment = sessionCompliment;
		
		String message = "In " + randomNumber + " years, you will living in  " + randomCity + " with  " + randomPerson
				+ "  as your roommate, " + hobby + " for a living. the next time you see a  " + 
				randomItem + "  you will have good luck. Also,  " + compliment;
		
		model.addAttribute("message",message);
		return "omikuji.jsp";
	}
	
}
