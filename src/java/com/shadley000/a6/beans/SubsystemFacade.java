/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.a6.beans;

import com.shadley000.a6.entities.Subsystem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shadl
 */
@Stateless
public class SubsystemFacade extends AbstractFacade<Subsystem> {

    @PersistenceContext(unitName = "A6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubsystemFacade() {
        super(Subsystem.class);
    }
    
}
