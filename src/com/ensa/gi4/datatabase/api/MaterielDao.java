package com.ensa.gi4.datatabase.api;

import com.ensa.gi4.modele.Materiel;

import java.util.List;

public interface MaterielDao {
    List<Materiel> findAll();

    Materiel findone(Long i);
    void create(Materiel t);
    void update(Materiel t,Long id);
    void delete(Long id);
   

}
