package model;

import java.util.Objects;

public class Participant {
    private int id;
    private String name;
    private String team;
    private int capacity;

    public Participant(int id, String name, String team, int capacity) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.capacity = capacity;
    }

    public Participant(String name, String team, int capacity) {
        this.name = name;
        this.team = team;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return id == that.id &&
                capacity == that.capacity &&
                Objects.equals(name, that.name) &&
                Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, team, capacity);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
