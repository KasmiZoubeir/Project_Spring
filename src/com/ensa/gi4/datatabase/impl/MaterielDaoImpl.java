package com.ensa.gi4.datatabase.impl;

import com.ensa.gi4.datatabase.api.MaterielDao;
import com.ensa.gi4.modele.Materiel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaterielDaoImpl extends GenericDAO<Materiel> implements MaterielDao {
    @Override
    public List<Materiel> findAll() {
        return super.findAll("SELECT * FROM MATERIEL;");
    }

    @Override
    public Materiel findone(Long id) {
        return super.findone("SELECT * FROM MATERIEL WHERE ID=?;", id);
    }

    @Override
    protected MaterielRowMapper getRowMapper() { // template method design pattern
        return new MaterielRowMapper();
    }

	@Override
	public void create(Materiel t) {
		String sql="INSERT INTO materiel(name, code) VALUES(?,?) ";
		super.createExe(sql,t.getName(),t.getCode());
		
	}

	@Override
	public void update(Materiel t, Long id) {
		String sql="UPDATE materiel set name=?,code=? where ID=? ; ";
		super.updateExe(sql,t.getName(),t.getCode());
		
	}

	@Override
	public void delete(Long id) {
		
		String sql="delete from materiel where ID=? ";
		super.deletExe(sql, id);

	}

	

	
}
