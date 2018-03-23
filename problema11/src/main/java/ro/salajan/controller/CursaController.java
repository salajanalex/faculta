package ro.salajan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.salajan.model.Cursa;
import ro.salajan.service.CursaService;
import ro.salajan.service.impl.CursaServiceImplementation;

import java.util.List;


@Controller
public class CursaController {

    //de ce cursaService si nu impl-ul?
    @Autowired
    private CursaServiceImplementation cursaService;

    @RequestMapping(value = "/curse", method = RequestMethod.GET)
    public String getAllCurse(Model model) {
        List<Cursa> cursaList = cursaService.getAllCurse();
        model.addAttribute("ion",cursaList);   //numim sub ce nume sa se trimita cusaList
        return "curse";  //jsp -ul
    }
}
