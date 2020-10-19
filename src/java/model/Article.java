/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ThangCoi
 */
public class Article {

    private int id;
    private String image;
    private String title;
    private String type;
    private String content;
    private Date date;
    private int like;
    private int comment;
    private String icon;
    private String monthAndYear;

    public String getMonthAndYear() {
        return monthAndYear;
    }

    public void setMonthAndYear(String monthAndYear) {
        this.monthAndYear = monthAndYear;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public int getLike() {
        return like;
    }

    public int getComment() {
        return comment;
    }

    public String getIcon() {
        return icon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDateFormat() {
        return new SimpleDateFormat("dd-MM-YYYY").format(this.date);
    }

    public Article(int id, String image, String title, String type, String content, Date date, int like, int comment, String icon, String monthAndYear) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.type = type;
        this.content = content;
        this.date = date;
        this.like = like;
        this.comment = comment;
        this.icon = icon;
        this.monthAndYear = monthAndYear;
    }

    public Article() {
    }

    public String FormatDate() throws Exception {
        Date convertDate;
        convertDate = new SimpleDateFormat("MM yyyy").parse(this.monthAndYear);
        return new SimpleDateFormat("MMMM-yyyy").format(convertDate);
    }
}
