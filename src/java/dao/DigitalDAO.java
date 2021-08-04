/*
 *Copyright(C) 2021, DINH PHUONG THAO
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
package dao;

import entity.Digital;
import java.util.ArrayList;

/**
 * The interfaces class contains methods for retrieving data from numeric
 * tables in the database.
 *
 * Bug: none
 */
public interface DigitalDAO {

    /**
     * This function is used to get the list of news. The amount of news
     * retrieved is transmitted by the user.
     * @param number represents the number of news the user wants to receive. It is an int number
     * 
     * @return a list of <code>Digital</code> objects. It is a
     * <code>java.util.ArrayList</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<Digital> getAllTopNews(int number) throws Exception;

     /**
     * This function is used to get New specifically by id. The user will
     * enter the id of new to get the corresponding new properties attributes
     *
     * @param id represents the id number of new that the user wants to receive.
     * It is an int number. 
     * Return a <code>Digital</code> objects
     * @throws java.lang.Exception
     */
    public Digital getNewById(int id) throws Exception;

     /**
     * This function is used for a specific new list by title. The user will
     * enter a title string of new to get a list of new corresponding titles by
     * title.
     *
     * @param txtSearch represents the string entered by the user. It is a
     * <code>java.lang.String</code> object.
     * @param index represents the current index of the page. It is an int number
     * @param pageSize represents the number of new in a page that the user
     * wants. It is an int number 
     * 
     * @return a list of <code>Digital</code> objects. It is a
     * <code>java.util.ArrayList</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<Digital> getAllSearchDigital(String txtSearch, int index, int pageSize) throws Exception;

    /**
     * This function returns the number of new that the user input. Count the
     * number of new that the user input in the title
     *
     * @param txtSearch represents the string entered by the user. It is a
     * <code>java.lang.String</code> object. 
     * 
     * Return the number of new from searching in strings. It is an int number
     * @throws java.lang.Exception
     */
    public int countMaxNews(String txtSearch) throws Exception;
}
