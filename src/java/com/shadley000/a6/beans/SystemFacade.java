/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.a6.beans;

import com.shadley000.a6.entities.System;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shadl
 */
@Stateless
public class SystemFacade extends AbstractFacade<System> {

    @PersistenceContext(unitName = "A6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SystemFacade() {
        super(System.class);
    }
    
}
