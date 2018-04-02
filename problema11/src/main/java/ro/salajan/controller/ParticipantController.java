package ro.salajan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.salajan.model.Cursa;
import ro.salajan.model.Participant;
import ro.salajan.service.CursaService;
import ro.salajan.service.ParticipantService;

import java.util.List;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private CursaService cursaService;

    @RequestMapping(value = "/participanti", method = RequestMethod.GET)
    public String getAllParticipanti(Model model) {
        List<Cursa> cursaList = cursaService.getAllCurse();
        List<Participant> participantList = participantService.getAllParticipanti();
        model.addAttribute("participantList",participantList);
        model.addAttribute("cursaList",cursaList);
        return "participanti";
    }


    @RequestMapping(value = "/partbyechipa", method=RequestMethod.GET)
    public String getParticipantiByEchipa(Model model, @RequestParam("echipa") String echipa){
        List<Participant> participantList = participantService.findParticipantByEchipa(echipa);
        model.addAttribute("participantList",participantList);
        model.addAttribute("echipa",echipa);
        return "partbyechipa";
    }

    /**
     * Adaugam nou participant + adaugam participantul la cursa selectata
     * Cautam cursa cu id=idcursa, cream participant nou si il adaugam la cursa gasita
     * @param model
     * @param nume
     * @param echipa
     * @param capacitate
     * @param idcursa
     * @return
     */
    @RequestMapping(value = "/participanti/add", method=RequestMethod.POST)
    public String addNewParticipantToCursa(Model model, @RequestParam("nume") String nume,
                           @RequestParam("echipa") String echipa,
                           @RequestParam("capacitate") int capacitate,
                           @RequestParam("idcursa") int idcursa) {
        Cursa cursa = cursaService.getCursaById(idcursa);
        Participant participant = new Participant(nume, echipa, capacitate);
        participantService.addParticipant(participant);   //adauga participant nou
        cursa.addParticipant(participant);
        cursaService.addCursa(cursa);  //aici face save, ca sa observe hibernate ca am adaugat
        List<Cursa> cursaList = cursaService.getAllCurse();
        List<Participant> participantList = participantService.getAllParticipanti();
        model.addAttribute("participantList",participantList);
        model.addAttribute("cursaList",cursaList);
        return "participanti";
    }

}
