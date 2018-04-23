package model;

import java.util.Objects;

public class Cursa {
    private int id;
    private String name;
    private int capacity;

    public Cursa(int id, String name, int capacity){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public Cursa(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getcapacity() {
        return capacity;
    }

    public void setcapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cursa cursa = (Cursa) o;
        return id == cursa.id &&
                capacity == cursa.capacity &&
                Objects.equals(name, cursa.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, capacity);
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
