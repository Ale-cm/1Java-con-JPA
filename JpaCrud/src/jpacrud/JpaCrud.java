/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacrud;

import Entidades.Articulos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Alejandro
 */
public class JpaCrud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaCrudPU");
EntityManager em = emf.createEntityManager();
EntityTransaction et = em.getTransaction();
et.begin();
// insertamos un Articulo a la base de dato usando JPA
 Articulos art1= new Articulos();
 
 
art1.setNombre("cambalache");

art1.setPrecio(2000.);
em.persist(art1);
 
// update a la tabla Articulos usando JPA

art1 = em.find(Articulos.class, 1);
art1.setNombre("mouse");
em.merge(art1);
// eliminar un articulo usando JPA

art1 = em.find(Articulos.class, 4);
em.remove(art1);        
et.commit();  

    }
    
}
