/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.PostsFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jswitzer09
 */
@ManagedBean
@SessionScoped
public class CreateBean implements Serializable{
    public CreateBean(){
        
    }
    @EJB
    private PostsFacade postsFacade;
    
    
    
}
