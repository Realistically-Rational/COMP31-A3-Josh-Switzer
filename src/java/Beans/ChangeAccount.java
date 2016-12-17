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
import java.util.ArrayList;
import javax.ejb.EJB;

/**
 *
 * @author Josh
 */
@Named(value = "changeAccount")
@SessionScoped
public class ChangeAccount implements Serializable {
    @EJB
    private UsersFacade usersFacade;
    /**
     * Creates a new instance of ChangeAccount
     */
    public ChangeAccount() {
        this.accountTypes = new ArrayList<>();
        accountTypes.add("Admin");
        accountTypes.add("Moderator");
        accountTypes.add("General");
        accountTypes.add("Guest");
        accountList = accountTypes.get(0);
    }
    
    
        private ArrayList<String> accountTypes;

    public ArrayList<String> getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(ArrayList<String> accountTypes) {
        this.accountTypes = accountTypes;
    }
    
    private String accountList;

    public String getAccountList() {
        return accountList;
    }

    public void setAccountList(String accountList) {
        this.accountList = accountList;
    }
    
    private Users user;
    public Users getUser(){
        return user;
    }
    public void setUser(Users user){
        this.user = user;
    }
    
    
        private String userType;

    
    private Users userId;

    public Users getUserId() {
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
    
    private String accountChange;

    public String getAccountChange() {
        return accountChange;
    }

    public void setAccountChange(String accountChange) {
        this.accountChange = accountChange;
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
    public void updateAccountType(){
        Users user = new Users();
        //int userid = usersFacade.find(userId);
        //user.setUserId(usersFacade.find(userId));
        user.setUserType(accountList);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setPassWord(passWord);
        
        usersFacade.edit(user);
    }
}
