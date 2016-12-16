/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.PostsFacade;
import Controller.UsersFacade;
import Model.Posts;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author Josh
 */
@Named(value = "createBean")
@SessionScoped
public class CreateBean implements Serializable {

    /**
     * Creates a new instance of CreateBean
     */
    public CreateBean() {
    }
    @EJB
    private PostsFacade postsFacade;
    private UsersFacade usersFacade;
    
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String postName;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
    
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String postContent;

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    
    public void createPost()
    {
        Posts post = new Posts();
        
        post.setUserId(usersFacade.find(userId));
        post.setPostName(postName);
        post.setPostContent(postContent);
        post.setPostCreator(userName);
        post.setPostDate(new Date());
        
        postsFacade.persistPost(post);
    }
}
