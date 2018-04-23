package ro.salajan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.salajan.model.Cursa;
import ro.salajan.repository.CursaRepo;
import ro.salajan.service.CursaService;

import java.util.List;

@Service
public class CursaServiceImplementation implements CursaService{

    @Autowired
    private CursaRepo cursaRepo;

    @Override
    public List<Cursa> getAllCurse() {
        return cursaRepo.findAll();
    }

    @Override
    public Cursa getCursaById(int id) {
        return cursaRepo.findById(id);
    }

    @Override
    public Cursa addCursa(Cursa cursa) {
         return cursaRepo.save(cursa);
    }
}
