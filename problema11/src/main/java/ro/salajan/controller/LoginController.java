package ro.salajan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.salajan.model.User;
import ro.salajan.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView logIn(){
        //view name append with .jsp
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/loginfail", method = RequestMethod.GET)
    public ModelAndView logInFail(){
        //view name append with .jsp
        return new ModelAndView("loginfail");
    }


}
