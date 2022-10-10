package com.rachels.productsCategories.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.rachels.productsCategories.models.LoginUser;
import com.rachels.productsCategories.models.User;
import com.rachels.productsCategories.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	public Iterable<User> allUsers() {
		return userRepository.findAll();
	}
	
	public User userEmail(LoginUser logUser, BindingResult result){
		User userInDB = userRepository.findByEmail(logUser.getEmail()).orElse(null);
		if (userInDB ==null) {
			result.rejectValue("email", "unique", "Invalid login information");
			return null;
		}
		if (!BCrypt.checkpw(logUser.getPassword(), userInDB.getPassword())) {
			result.rejectValue("password", "authentication", "Invalid login attempt");
		}
		if (result.hasErrors()) {
			return null;
		}
		return userInDB; 
	}
	
	public User find(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		  if(optionalUser.isPresent()) {
		       return optionalUser.get();
		  } else {
		       return null;
		  }
	}
	
	
	public User register(User registerUser, BindingResult result) {
//		does email exist
		User findEmail = userRepository.findByEmail(registerUser.getEmail()).orElse(null);
		if (findEmail != null) {
			result.rejectValue("email", "uniqueEmail", "Email does not exist");
		} if (!registerUser.getPassword().equals(registerUser.getConfirm())) {
				result.rejectValue("confirmPass", "confirmed", "Invalid password combination");
		} if (result.hasErrors()) {
			return null;
		}
		String passwordHash = BCrypt.hashpw(registerUser.getPassword(), BCrypt.gensalt());
		registerUser.setPassword(passwordHash);
		return userRepository.save(registerUser);
	}
	
	public String findName(User user) {
		return userRepository.findByName(user.getName());
	}
	
	

	
}
