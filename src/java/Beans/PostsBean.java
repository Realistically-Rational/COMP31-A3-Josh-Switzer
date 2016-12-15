/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.PostsFacade;
import Model.Posts;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jswitzer09
 */
//@Named("postsBean")
@ManagedBean
@SessionScoped
public class PostsBean implements Serializable{

    public PostsBean(){
        
    }
    
    @EJB
    private PostsFacade postsFacade;

    public void setPostsFacade(PostsFacade postsFacade) {
        this.postsFacade = postsFacade;
    }
    
    private List<Posts> postList;
    
    public List getPostList() {
        return postList;
    }

    public void setPostList(List postList) {
        this.postList = postList;
    }
    
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private Posts post;

    public Posts getPosts() {
        return post;
    }

    public void setPosts(Posts post) {
        this.post = post;
    }
    public List<Posts> listOfPosts(){
        
       //return this.postList = postsFacade.findAllPosts();
       return this.postList = postsFacade.findAll();
    }
}
