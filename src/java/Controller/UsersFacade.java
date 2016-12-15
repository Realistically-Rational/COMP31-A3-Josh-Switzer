/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jswitzer09
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "COMP31_A3_Josh_SwitzerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    public Users findByUserName(String userName) {
        Users user = new Users();
        try{
            user = (Users) em.createNamedQuery("Users.findByUserName").setParameter("userName", userName).getSingleResult();
        }
        catch (Exception e){
           e.printStackTrace();
        }
        return user;
    }
}
