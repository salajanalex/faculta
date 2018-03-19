package repository;

import connection.DBConfig;
import model.Inscriere;

import java.sql.*;
import java.util.ArrayList;

public class InscriereRepo {


    /**
     * Getters Setter ADD for repo.
     */

    private ArrayList<Inscriere> inscrieriRepo = new ArrayList<Inscriere>();


    public InscriereRepo(ArrayList<Inscriere> inscrieri) {
        this.inscrieriRepo = inscrieri;
    }

    public ArrayList<Inscriere> getInscrieriRepo() {
        return this.inscrieriRepo;
    }

    public void setInscrieriRepo(ArrayList<Inscriere> inscrieriRepo) {
        this.inscrieriRepo = inscrieriRepo;
    }

    public void addInscriere(Inscriere inscriere) {
        inscrieriRepo.add(inscriere);
    }

    public void deleteInscriere(Inscriere inscriere) {
        inscrieriRepo.remove(inscriere);
    }



}
