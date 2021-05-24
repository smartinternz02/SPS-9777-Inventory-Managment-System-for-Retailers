package com.futuretech.inventorymanagementapp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class InventoryController {
	public String email;
	@Autowired 
	private JavaMailSender sender;
	@Autowired
	UserRepository userRepo;
	@Autowired
    private ProductServices service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/process_register")
	public String processing(User user) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
		try {
			sendEmail(user.getEmail());
		}
		catch(Exception e) {
			
		}
	 
		return "dashboard";
	}
	@GetMapping("/dashboard")
		public String dashboard(Model model) throws IOException, URISyntaxException {
		List<Product> listProducts = service.listAll();
		
		if(listProducts.isEmpty()) 
			
	    model.addAttribute("listProducts", listProducts);
	    
			return "dashboard";
		}
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Product product = new Product();
	    model.addAttribute("product", product);
	     
	    return "new_product";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
	    service.save(product);
	     
	    return "redirect:/dashboard";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_product");
	    Product product = service.get(id);
	    mav.addObject("product", product);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/dashboard";       
	}
	private void sendEmail(String email)throws Exception{
		System.out.println("Sending Mail");
		System.out.println(email);
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("inventory.management00@gmail.com");
		helper.setTo(email);
		helper.setText("You have an empty inventory!!!!");
		helper.setSubject("Inventory storage is empty");
		
		sender.send(message);
		System.out.println("Mail sent");
	}
	
	
	
}
