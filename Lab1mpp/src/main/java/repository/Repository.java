package repository;

import model.Inscriere;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Inscriere> inscrieriRepo = new ArrayList<Inscriere>();

    public Repository(ArrayList<Inscriere> inscrieri){
        this.inscrieriRepo = inscrieri;
    }

    public ArrayList<Inscriere> getInscrieriRepo() {
        return this.inscrieriRepo;
    }

    public void setInscrieriRepo(ArrayList<Inscriere> inscrieriRepo) {
        this.inscrieriRepo = inscrieriRepo;
    }

    public void addInscriere(Inscriere inscriere){
        inscrieriRepo.add(inscriere);
    }


}
