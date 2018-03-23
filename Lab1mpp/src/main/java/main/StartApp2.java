package main;

import repository.InscriereRepo;

import java.util.ArrayList;

public class StartApp2 {

    public static void main(String[] args) {
        InscriereRepo inscriereRepo = new InscriereRepo();
        ArrayList<Inscriere> inscrieriList = new ArrayList<Inscriere>();

        Inscriere inscriere = new Inscriere(1000,"Tupac","Merc");

        /**
         * printing all inscrieri from DB (DB -> repo -> View)
         */
        inscriereRepo.setInscrieriRepo();
        inscrieriList = inscriereRepo.getInscrieriRepo();
        for (Inscriere inscr:inscrieriList) {
            System.out.println(inscr.toString());
        }

        /**
         * add new inscriere to DB & Update Repo
         */
       // inscriereRepo.addInscriere(inscriere);

        /**
         * delete inscriere from DB & update Repo
         */
        inscriereRepo.deleteInscriere(inscriere);

        inscrieriList = inscriereRepo.getInscrieriRepo();
        for (Inscriere inscr:inscrieriList) {
            System.out.println(inscr.toString());
        }
    }

}
