/*
 * Copyright(C) 2021, DINH PHUONG THAO
 * J3.L.P0004(Digital news):
 * Digital news
 *
 * Record of change:
 * DATE            Version             AUTHOR                  DESCRIPTION
 * 2021-05-28       1.0                DINH PHUONG THAO        First Implement
 * 2021-05-28       2.0                DINH PHUONG THAO        Second Implement
 * 2021-05-31       3.0                DINH PHUONG THAO        Third Implement
 * 2021-05-31       4.0                DINH PHUONG THAO        Four Implement
 * 2021-06-02       5.0                DINH PHUONG THAO        Five Implement
 * 2021-06-02       6.0                DINH PHUONG THAO        Six Implement
 */
package entity;

import java.util.Date;


/**
 * This class describes the properties of Digital. Including data attributes
 * such as: id, title, description, image, author, date, shortDes. 
 * And methods like: constructor, getter, setter of Digital object 
 * 
 * <p>
 * Bugs None
 * @author DINH PHUONG THAO
 */
public class Digital {

    private int id;
    private String title;
    private String description;
    private String image;
    private String author;
    private Date date;
    private String shortDes;

    /**
     * Parameterless constructor used to initialize a digital object
     */
    public Digital() {
    }

    /**
     * This is a Constructor with parameters, initialize values to provide data
     * for Digital objects It passed into the attribute as: id, title,
     * description, image, author, date, shortDes
     *
     * @param id is the id attribute of the news.It is an int number
     * @param title the title attribute of the news. It is a
     * <code>java.lang.String</code> object
     * @param description the description attribute of the news. It is a
     * <code>java.lang.String</code> object
     * @param image the link image of the news. It is a
     * <code>java.lang.String</code> object
     * @param author the author attribute of the news. It is a
     * <code>java.lang.String</code> object
     * @param date the time post attribute of the news. It is a
     * <code>java.sql.Date</code> object
     * @param shortDes the short description attribute of the news. It is a
     * <code>java.lang.String</code> object
     */
    public Digital(int id, String title, String description, String image, String author, Date date, String shortDes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.date = date;
        this.shortDes = shortDes;
    }

    /**
     * Only allowed to read the value id from id attribute to from the outer
     * class
     *
     * @return id It is an int number
     */
    public int getId() {
        return id;
    }

    /**
     * Only allowed to write the value id from id attribute to from the outer
     * class
     *
     * @param id id attribute of the news.It is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Only allowed to read the value title from title attribute to from the
     * outer class
     *
     * @return title data type String.It is a <code>java.lang.String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * Only allowed to write the value title from title attribute to from the
     * outer class
     *
     * @param title attribute of the news. It is data type String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Only allowed to read the value description from description attribute to
     * from the outer class
     *
     * @return description data type String.It is a
     * <code>java.lang.String</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * Only allowed to write the value description from description attribute to
     * from the outer class
     *
     * @param description attribute of the news. It is data type String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Only allowed to read the value image from image attribute to from the
     * outer class
     *
     * @return image data type String.It is a <code>java.lang.String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Only allowed to write the value name of image from image attribute to
     * from the outer class
     *
     * @param image attribute of the news. It is data type String
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Only allowed to read the value author from author attribute to from the
     * outer class
     *
     * @return author data type String.It is a <code>java.lang.String</code>
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Only allowed to write the value author from author attribute to from the
     * outer class
     *
     * @param author attribute of the news. It is data type String
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Only allowed to read the value date from date attribute to from the outer
     * class
     *
     * @return date data type Date.It is a <code>java.sql.Date</code> object
     */
    public Date getDate() {
        return date;
    }

    /**
     * Only allowed to write the value date from date attribute to from the
     * outer class
     *
     * @param date attribute of the news. It is data type Date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Only allowed to read the value shortDes from shortDes attribute to from
     * the outer class
     *
     * @return shortDes data type String.It is a <code>java.lang.String</code>
     */
    public String getShortDes() {
        return shortDes;
    }

    /**
     * Only allowed to write the value shortDes from shortDes attribute to from
     * the outer class
     *
     * @param shortDes attribute of the news. It is data type String
     */
    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

}
