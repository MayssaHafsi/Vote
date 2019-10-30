package tn.vote.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class LoginController {

	//private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

//	@Autowired
//	private UserService userService;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/adminIndex");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/access-denied" }, method = RequestMethod.GET)
	public ModelAndView accessDenied() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("access-denied");
		return modelAndView;
	}

	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public ModelAndView about() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("about");
		return modelAndView;
	}

	@RequestMapping(value = { "/404" }, method = RequestMethod.GET)
	public ModelAndView notfound(HttpSession session, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("404");
		return modelAndView;
	}

	@RequestMapping(value = { "/500" }, method = RequestMethod.GET)
	public ModelAndView siteproblem() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("500");
		modelAndView.addObject("messageToShow", "Erreur technique");
		return modelAndView;
	}

	@RequestMapping(value = { "/403" }, method = RequestMethod.GET)
	public ModelAndView inaccessible() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("403");
		return modelAndView;
	}

	@RequestMapping(value = { "/down" }, method = RequestMethod.GET)
	public ModelAndView maintenance() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("maintenance");
		return modelAndView;
	}

}
