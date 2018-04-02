package ro.salajan.service;

import ro.salajan.model.Cursa;

import java.util.List;

public interface CursaService {
    List<Cursa> getAllCurse();
    Cursa getCursaById(int id);
    void addCursa(Cursa cursa);
}
