package ro.salajan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.salajan.model.Cursa;
import ro.salajan.model.Participant;
import ro.salajan.service.CursaService;
import ro.salajan.model.Cursa;
import ro.salajan.service.ParticipantService;
import ro.salajan.service.impl.CursaServiceImplementation;
import ro.salajan.service.impl.ParticipantServiceImplementation;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CursaController {

    //de ce cursaService si nu impl-ul?
    @Autowired
    private CursaServiceImplementation cursaService;

    @Autowired
    private ParticipantService participantService;

    @RequestMapping(value = "/curse", method = RequestMethod.GET)
    public String getAllCurse(Model model) {
        List<Cursa> cursaList = cursaService.getAllCurse();
        model.addAttribute("curseList",cursaList);   //numim sub ce nume sa se trimita cusaList
        return "curse";  //jsp -ul
    }
//
//    @RequestMapping(value = "/curse", method = RequestMethod.GET)
//    public String getAllCurse(Model model) {
//        List<Cursa> cursaList = cursaService.getAllCurse();
//        List<Integer> sizeList = new ArrayList<Integer>();
//        for (Cursa cursa : cursaList){
//            sizeList.add(cursa.getListaParticipant().size());
//        }
//        model.addAttribute("curseList",cursaList);   //numim sub ce nume sa se trimita cusaList
//        model.addAttribute("CurseList",sizeList);
//        return "curse";  //jsp -ul
//    }

}
