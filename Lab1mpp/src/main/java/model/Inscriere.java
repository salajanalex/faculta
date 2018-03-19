package model;

public class Inscriere {
    private int id;
    private int capacitate;
    private String nume;
    private String echipa;

    public Inscriere(int capacitate, String nume, String echipa){
        this.capacitate = capacitate;
        this.nume = nume;
        this.echipa = echipa;
    }
    public Inscriere(int id, int capacitate, String nume, String echipa ){
        this.id = id;
        this.capacitate = capacitate;
        this.nume = nume;
        this.echipa = echipa;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getCapacitate(){
        return this.capacitate;
    }

    public void setCapacitate(int capacitate){
        this.capacitate = capacitate;
    }

    public String getNume() {
        return this.nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEchipa() {
        return this.echipa;
    }

    public void setEchipa(String echipa) {
        this.echipa = echipa;
    }

    @Override
    public String toString() {
        String s = this.getId() + " "+ this.getCapacitate()+ " " +this.getNume()+ " " + this.getEchipa();
        return s;
    }

//    public void printInscriere(Inscriere inscriere){
//        System.out.printf("");
//    }
}
