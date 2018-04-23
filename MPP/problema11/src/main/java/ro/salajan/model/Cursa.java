package ro.salajan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cursa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCursa")
    private int id;

    @Column(name = "Name")
    private String nume;

    @Column(name = "Capacity")
    private int capacitate;

    @JoinTable(name="cursa_participant",
            joinColumns = { @JoinColumn(name = "idCursa") },
            inverseJoinColumns = { @JoinColumn(name = "idParticipant") })

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Participant> listaParticipant;

    public Cursa(){

    }


    public List<Participant> getListaParticipant() {
        return listaParticipant;
    }

    public void setListaParticipant(List<Participant> listaParticipant) {
        this.listaParticipant = listaParticipant;
    }

    public Cursa(String nume, int capacitate) {
        this.nume = nume;

        this.capacitate = capacitate;
    }

    public Cursa(String nume, int capacitate, List<Participant> listaParticipant) {
        this.nume = nume;

        this.capacitate = capacitate;
        this.listaParticipant = listaParticipant;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }




    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", capacitate=" + capacitate +
                ", listaParticipant=" + listaParticipant +
                '}';
    }


    public void addParticipant(Participant participant) {
        if (listaParticipant == null) {
            listaParticipant = new ArrayList<>();
        }
        listaParticipant.add(participant);
    }


}
