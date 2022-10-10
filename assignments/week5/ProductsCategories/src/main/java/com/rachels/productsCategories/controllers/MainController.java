package com.rachels.productsCategories.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rachels.productsCategories.models.Category;
import com.rachels.productsCategories.models.LoginUser;
import com.rachels.productsCategories.models.Product;
import com.rachels.productsCategories.models.User;
import com.rachels.productsCategories.services.CategoryService;
import com.rachels.productsCategories.services.ProductService;
import com.rachels.productsCategories.services.UserService;

@Controller
public class MainController {
	@Autowired
	private CategoryService cService;
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private UserService uService;
	
	@GetMapping("/")
	public String loginRegistration(@ModelAttribute("loginUser") LoginUser loginUser, @ModelAttribute("registerUser") User registerUser, Model model) {
		return "index.jsp";
	}
	
	
//	create a new user through registration
	@PostMapping("/register")
	public String registration(@Valid @ModelAttribute("registerUser") User registerUser, Model model, HttpSession session,BindingResult result) {
		boolean validEmail = registerUser.isValidEmail(registerUser);
		
		if (result.hasErrors()) {
			return "index.jsp";
		}
		User u = uService.register(registerUser, result);
		session.setAttribute("user_id", u.getId());
		session.setAttribute("user_name", registerUser.getName());
		return "redirect:/dashboard";
		
	}
	
	
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, HttpSession session, Model model,  @ModelAttribute("user") User user,BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		model.addAttribute("newUser", uService.userEmail(newLogin, result));
		session.setAttribute("user_id", uService.userEmail(newLogin, result));
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("product") Product product , @ModelAttribute("category") Category category, @RequestParam(required = false, name = "id") Long category_id, Model model) {
		model.addAttribute("categories",cService.find());
		model.addAttribute("products",pService.find());
		if (category.getId() != null) {
			model.addAttribute("oneCategory", cService.findById(category_id));
		}
		if (product.getId()!= null) {
		model.addAttribute("oneProduct", pService.getOne(product.getId()));
		}
		return "dashboard.jsp";
	}
	
	@GetMapping("/create/product")
	public String createProduct(@ModelAttribute("newProduct") Product newProduct) {
		return "product.jsp";
	}
	
	@PostMapping("/new/product")
	public String newProduct(@Valid @ModelAttribute("newProduct") Product newProduct,@ModelAttribute("category") Category category, BindingResult result) {
		
		if (result.hasErrors()) {
			return "redirect:/";
		}
		
		pService.create(newProduct);

		return "redirect:/one/product/" + newProduct.getId();
	}
	
	@GetMapping("/create/category")
	public String createCategory(@ModelAttribute("category") Category category, @ModelAttribute("products") Product products) {
		return "category.jsp";
	}
//	create a category post route
	@PostMapping("/new/category")
	public String newCategory(@Valid @ModelAttribute("category") Category category, @ModelAttribute("products") Product products, BindingResult result) {
		
		if (result.hasErrors()) {
			return "redirect:/";
		}
		cService.create(category);
		return "redirect:/one/category/" + category.getId();
	}
	
//	non inclusive list of categories
	
	@GetMapping("/one/category/{id}")
	public String showCategoriesforProduct(@PathVariable("id") Long category_id, @ModelAttribute("products") Product products, Model model) {
		model.addAttribute("oneProduct",pService.getOne(products.getId()));
		model.addAttribute("oneCategory",cService.findById(category_id));
		model.addAttribute("categories", cService.findByProduct(products));
		model.addAttribute("allCategories", cService.findAllBy(products));
		
		return "showProduct.jsp";
	}
	
	@PostMapping("/add/category/{id}")
	public String addToCategories(@RequestParam("categories") Long category_id, @PathVariable("id") Long product_id, @ModelAttribute("products") Product products, Model model, BindingResult result) {
		Category category = cService.findById(category_id);
		Product product = pService.getOne(product_id);
		cService.addCategory(product, category);
		return "redirect:/one/category/" + product_id;
	}
	
	@GetMapping("/one/product/{id}")
	public String showProductsforCategory(@ModelAttribute("category") Category category, @PathVariable("id") Long product_id, @ModelAttribute("product") Product product, Model model) {
		model.addAttribute("oneProduct",pService.getOne(product_id));
		Long category_id = category.getId();
		Category oneCat = cService.findById(category_id);
		model.addAttribute("oneCategory", oneCat);
		model.addAttribute("products", pService.findByCategory(oneCat));
		model.addAttribute("allProducts", pService.findAllBy(oneCat));


		return "show.jsp";
	}
	
//	many to many relationship route
	@PostMapping("/add/product/{id}")
	public String addToProducts(@ModelAttribute("categories") Category categories, @PathVariable("id") Long product_id) {
		Long category_id = categories.getId();
		Product product = pService.getOne(product_id);
		Category category = cService.findById(category_id);
		pService.addProduct(product, category);
		return "redirect:/one/product/" + product_id;
	}


	
//	update product entry by pulling in one product object
	
	@GetMapping("/update/{productId}")
	public String updateProduct(@ModelAttribute("newProduct") Product newProduct, @PathVariable("productId") Long productId, Model model) {
			model.addAttribute("oneProduct",pService.getOne(productId));
			return "edit.jsp";
	}
	
//	process the updated data 
	@PutMapping("/update/product/{id}")
	public String update(@Valid @ModelAttribute("newProduct") Product newProduct, @PathVariable("id") Long productId,  Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/update/" + newProduct.getId();
		}
		else {
			pService.updateOne(newProduct);
			return "redirect:/dashboard";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		pService.destroy(id);
		return "redirect:/dashboard";
	}
	
	

}
