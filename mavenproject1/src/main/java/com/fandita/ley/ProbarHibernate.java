/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fandita.ley;

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
        
        //Paso 2: Hacer una operación.
        sesion.save(new Prueba(23, "Fandita pandita", 23565f));
        //No pela el numero 23 porque en la tabla le pusimos "auto_increment" 
        
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

