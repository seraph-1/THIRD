package com.example.myapplication;

/**
 * Created by 宇宙真理天下第一 on 2020/1/14.
 */

public class Message {
    private String name;
    private String message;
    private String title;
    void SetName(String str){this.name=str;}
    void SetMessage(String str){this.message=str;}
    void SetTitle(String str){this.title=str;}
    String GetName(){return this.name;}
    String GetMessage(){return  this.message;}
    Message(String str1,String str2){this.name=str1;this.message=str2;this.title="Message";}
}
