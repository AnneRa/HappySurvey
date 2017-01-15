package com.htw.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.htw.test.model.AdminUsers;
import com.htw.test.model.Umfrage;
import com.htw.test.repositories.AdminUsersRepository;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
@Autowired
private AdminUsersRepository adminUsersRepository;
	
	@RequestMapping(value = "/api/login", method= RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> myController(@RequestParam String name, @RequestParam String hash) {
		
		// Löschen wenn Datenbank nicht mehr gelöscht wird
		AdminUsers admin = new AdminUsers();
		admin.setUserName("admin@happysurvey.de");
		admin.setHash("21232f297a57a5a743894a0e4a801fc3");
		AdminUsers saved = adminUsersRepository.save(admin);
		
		// Eigentliche Methode
		AdminUsers adminUsers = adminUsersRepository.findOne(name);
		if (adminUsers != null && adminUsers.getHash().equals(hash)) {
			return ResponseEntity.status(HttpStatus.OK).body("");
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("");
	}

}
