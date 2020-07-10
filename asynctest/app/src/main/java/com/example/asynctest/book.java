package com.example.asynctest;

public class book {
    private String title,authers,imagelink;
     public book(String title, String aythers,String imageLink){
         this.title=title;
         this.authers=authers;
         this.imagelink=imagelink;
     }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthers() {
        return authers;
    }

    public void setAuthers(String authers) {
        this.authers = authers;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }
}
