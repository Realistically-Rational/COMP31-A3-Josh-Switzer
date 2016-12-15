/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Posts;
import Model.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jswitzer09
 */
@Stateless
public class PostsFacade extends AbstractFacade<Posts> {

    @PersistenceContext(unitName = "COMP31_A3_Josh_SwitzerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostsFacade() {
        super(Posts.class);
    }
    /* Changed Posts.findAll*/
    public List<Posts> findAllPosts() {
        return em.createNamedQuery("Posts.findAll").getResultList();
        //return PostsFacade.findAll();
    }
    
    
}
