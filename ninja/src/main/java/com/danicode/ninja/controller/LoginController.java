package com.danicode.ninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.danicode.ninja.constant.ViewConstant;
import com.danicode.ninja.model.UserCredential;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping("/") // Cuando vaya a la raiz (http://localhost:8080) redireccionar a login
	public String redirectToLogin() {
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("METHOD: showLoginForm() -- PARAMS: err = " + error + ", logout:" + logout);
		model.addAttribute("userCredential", new UserCredential()); // Pasar el objeto userCredential
		model.addAttribute("logout", logout); // "Cierre de sesión"
		model.addAttribute("error", error); // Pasar los errores
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}

	// Post
	@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute(name = "userCredential") UserCredential userCredential) {
		LOG.info("METHOD: loginCheck() -- PARAMS: err = " + userCredential.toString());
		if ((userCredential.getUsername().equals("user")) && (userCredential.getPassword().equals("user"))) {
			LOG.info("Returning to contacts view");
			return "redirect:/contacts/showcontacts";
		}
		LOG.info("Returning to login?error");
		return "redirect:/login?error";
	}

}
