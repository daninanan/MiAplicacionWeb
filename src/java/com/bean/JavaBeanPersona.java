/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entidades.Persona;
import com.jpa.controlador.PersonaJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Nanan
 */
public class JavaBeanPersona {
    
    private EntityManagerFactory emf;
    private PersonaJpaController personaControl;
    
    public JavaBeanPersona()
    {
        emf= Persistence.createEntityManagerFactory("MiAplicacionWebPU");
        personaControl=new PersonaJpaController(emf);
    }
    
    public void guardar(Persona persona)
    {
        personaControl.create(persona);
    }
    
    public List<Persona> buscarTodos()
    {
        return personaControl.findPersonaEntities();
    }
    

    
}
