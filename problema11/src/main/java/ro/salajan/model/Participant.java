package ro.salajan.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Participant implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParticipant")
    private int id;

    @Column(name = "Name")
    private String nume;

    @Column(name = "Team")
    private String echipa;

    @Column(name = "Capacity")
    private int capacitate;






    public Participant(){

   }

    public Participant(String nume, String echipa, int capacitate) {
        this.nume = nume;
        this.echipa = echipa;
        this.capacitate = capacitate;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }


    public String getEchipa() {
        return echipa;
    }

    public void setEchipa(String echipa) {
        this.echipa = echipa;
    }


    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }



    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", echipa='" + echipa + '\'' +
                ", capacitate=" + capacitate +
                '}';
    }

}
