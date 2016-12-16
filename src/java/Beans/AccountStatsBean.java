/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.UsersFacade;
import Model.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Josh
 */
@Named(value = "accountStatsBean")
@SessionScoped
public class AccountStatsBean implements Serializable {

    /**
     * Creates a new instance of AccountStatsBean
     */
    public AccountStatsBean() {
    }
    @EJB
    private UsersFacade usersFacade;
    
    public void setUsersFacade(UsersFacade usersFacade){
        this.usersFacade = usersFacade;
    }
    
    
    private Users user;
    public Users getUser(){
        return user;
    }
    public void setUser(Users user){
        this.user = user;
    }
    
    
        private String userType;

    
    private int userId;

    public int getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    private String passWord;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public Users getUsers(){
        try{
            this.user = usersFacade.findByUserName(userName);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }
}
