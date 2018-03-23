package ro.salajan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.salajan.model.Cursa;
import ro.salajan.model.Participant;
import ro.salajan.service.ParticipantService;

import java.util.List;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @RequestMapping(value = "/participanti", method = RequestMethod.GET)
    public String getAllParticipanti(Model model) {
        List<Participant> participantList = participantService.getAllParticipanti();
        model.addAttribute("participantList",participantList);
        return "participanti";
    }



}
