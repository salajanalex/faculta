package ro.salajan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.salajan.model.Cursa;
import ro.salajan.model.User;
import ro.salajan.service.CursaService;
import ro.salajan.service.UserService;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private CursaService cursaService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView logIn(){
        //view name append with .jsp
        return new ModelAndView("login");
    }

//    @RequestMapping(value = "/login",params = "success", method = RequestMethod.GET)
//    public ModelAndView logIn(Model model, @RequestParam("success") String success){
//        //view name append with .jsp
//        model.addAttribute("success", success);
//        return new ModelAndView("login");
//    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logOut(){
        //view name append with .jsp
        return new ModelAndView("logout");
    }

    @RequestMapping(value = "/loginfail", method = RequestMethod.GET)
    public ModelAndView logInFail(){
        //view name append with .jsp
        return new ModelAndView("loginfail");
    }

    @RequestMapping(value = "/auth", method=RequestMethod.GET)
    public String getCurseAfterLogIn(Model model, @RequestParam("uname") String uname,
                                     @RequestParam("psw") String psw){


        User user = userService.findUserByUsername(uname);
        List<Cursa> cursaList = cursaService.getAllCurse();
        model.addAttribute("curseList",cursaList);
        model.addAttribute("user", user);
        model.addAttribute("uname", uname);
        if(user==null){
            return "loginfail";
        }
        else if (user.getPassword().equals(psw)) {
            return "auth";

        } else {
            return "loginfail";
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView init(){
        //view name append with .jsp
        return new ModelAndView("login");
    }


}
