package ro.salajan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.salajan.model.Cursa;
import ro.salajan.service.ParticipantService;
import ro.salajan.service.UserService;
import ro.salajan.service.impl.CursaServiceImplementation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class CursaController {

    //de ce cursaService si nu impl-ul?
    @Autowired
    private CursaServiceImplementation cursaService;

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/curse", method = RequestMethod.GET)
    public String getAllCurse(Model model) {
        List<Cursa> cursaList = cursaService.getAllCurse();
        model.addAttribute("curseList",cursaList);   //numim sub ce nume sa se trimita cusaList
        return "curse";  //jsp -ul
    }



//    @RequestMapping(value = "/curse", method=RequestMethod.GET)
//    public String getCurseAfterLogIn(Model model, @RequestParam("uname") String uname,
//                                     @RequestParam("psw") String psw){
//
//        User user = userService.findUserByUsername(uname);
//        List<Cursa> cursaList = cursaService.getAllCurse();
//        model.addAttribute("uname", uname);
//        model.addAttribute("psw", psw);
//        model.addAttribute("curseList",cursaList);
////        MBeanServerConnection session;
////        session.setAttribute("session",uname);
//        if(user==null){
//            return "loginfail";
//        }
//        else if (user.getPassword().equals(psw)) {
//            return "curse";
//
//        } else {
//            return "loginfail";
//        }
//    }
}
