/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fandita.ley;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author T107
 */
public class ProbarHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
        Session sesion=HibernateUtilidades.getSessionFactory().openSession();
        
        //Paso 1: Empezar la sesion.
        sesion.getTransaction().begin();
        
        //Paso 2: Hacer una operaci�n.
        sesion.save(new Prueba(23, "Fandita pandita", 23565f));
        //No pela el numero 23 porque en la tabla le pusimos "auto_increment" 
        
        //sesion.update(new Usuario(1, "pedro", 4000f));
        
        Query q= sesion.createQuery("from Prueba");
        //El Usuario no es el nombre de la tabla es el nombre de LA CLASE
        ArrayList<Prueba> usuario=(ArrayList<Prueba>) q.list();
        for(Prueba usu:usuario){
            System.out.println(usu);
            q.list();
        }
       
        Criteria c=sesion.createCriteria(Prueba.class);
        ArrayList<Prueba> usuario1=(ArrayList<Prueba>) c.list();
        for(Prueba usu:usuario1){
            System.out.println(usu);
            c.list();
        }
        
        
     
             
                        
                
        //Paso3: Hacer el commit.
        sesion.getTransaction().commit();
        
        //CERRAR LA SESION, QUE NUNCA SE NOS OLVIDE.
        //No olvidar el sesion.flush para transacciones masivas (o pago de nomina).
        //sesion.flush();
        
        System.out.println("Se ha guardado con exito este registro");
    }   catch(Exception e){
    
            System.out.print(e.getMessage());
        
    }
    }
}

