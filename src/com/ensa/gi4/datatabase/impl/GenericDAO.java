package com.ensa.gi4.datatabase.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ensa.gi4.modele.Materiel;

import javax.sql.DataSource;
import java.util.List;

public abstract class GenericDAO<T> implements InitializingBean {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterPropertiesSet() { // from InitializingBean
        jdbcTemplate = new JdbcTemplate(dataSource);
    } 

    protected List<T> findAll(String query) {
        return jdbcTemplate.query(query, getRowMapper());
    }

    protected T findone(String query, Long id) {
       Materiel t=null;
        		try {
        			t = (Materiel) jdbcTemplate.queryForObject(query, getRowMapper(), id);
        		}catch(DataAccessException ex){
        			System.out.println("Materiel Not Found") ;
        			
        		}
        		return (T) t;
        		
    }

    protected abstract RowMapper<T> getRowMapper();
    public void createExe(String query,String name,String Code){
        int insert =	jdbcTemplate.update(query,name,Code);
        if(insert == 1) {
       	 System.out.println("New Materiel Created Succesfly" + name);
        }
       }
    public void updateExe(String query,String name,String Code){
        int update =	jdbcTemplate.update(query,name,Code);
        if(update == 1) {
       	 System.out.println("Materiel Updated Succesfly" + name);
        }
       }
    public void deletExe(String query, Long id) {
    	jdbcTemplate.update(query,id);
    }

	

	

}
