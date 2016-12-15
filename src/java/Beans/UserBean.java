package Beans;

import Controller.UsersFacade;
import Model.Users;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

//@Named("UserBean")
@ManagedBean
@SessionScoped
public class UserBean implements Serializable{
    
    
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
    
    public String login(){
        try{
            this.user = usersFacade.findByUserName(userName);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (user != null && userName.equals(user.getUserName()) && passWord.equals(user.getPassWord()))
        {
            /*FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
            session.setAttribute("userName", userName);
            session.setAttribute("passWord", passWord);*/
            return "index";
        }
        return "Login";
    }
    
    
    public String startSession(){
        /*FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
        String userName = (String) session.getAttribute("userName");*/
        if (userName == null || userName.equals("")){
            return "Login";
        }
        return "index";
    }
    
    
    public List<Users> getUsers(){
        return usersFacade.findAll();
    }
    public UserBean(){
        System.out.println("Created a Bean2134123412341234123412512352345234523452345234523451234523452345234235234523412354234");
                
    }
}
