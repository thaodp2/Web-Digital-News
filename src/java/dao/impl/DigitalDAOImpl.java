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
package dao.impl;

import context.DBContext;
import dao.DigitalDAO;
import entity.Digital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * This class is extended from the DBContext class and implemented from the
 * DigitalDAO interface including commands to search the value of news, count
 * the number of news, get all the news searched. 
 * The data is read from the database in sql sever when there is any error 
 * querying the data will come to
 * <code> java.lang.Exception</code>
 *
 * Bug: None
 */
public class DigitalDAOImpl extends DBContext implements DigitalDAO {

    /**
     * This function is used to get the list of news. The amount of news
     * retrieved is transmitted by the user.
     * @param number represents the number of news the user wants to receive. It is an int number
     * 
     * @return a list of <code>Digital</code> objects. It is a
     * <code>java.util.ArrayList</code> object
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<Digital> getAllTopNews(int number) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT TOP (?) [id]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[image]\n"
                + "      ,[author]\n"
                + "      ,[timePost]\n"
                + "      ,[shortDes]\n"
                + "  FROM [DIGITAL_NEWS].[dbo].[digital_News]";
        ArrayList<Digital> digitals = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, number);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Digital digital = new Digital();
                digital.setId(resultSet.getInt("id"));
                digital.setTitle(resultSet.getString("title"));
                digital.setDescription(resultSet.getString("description"));
                digital.setImage(resultSet.getString("image"));
                digital.setAuthor(resultSet.getString("author"));
                digital.setDate(resultSet.getDate("timePost"));
                digital.setShortDes(resultSet.getString("shortDes"));
                digitals.add(digital);
            }
            return digitals;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(resultSet);
            closePs(preparedStatement);
            closeCon(connection);
        }
    }

    /**
     * This function is used to get New specifically by id. The user will
     * enter the id of new to get the corresponding new properties attributes
     *
     * @param id represents the id number of new that the user wants to receive.
     * It is an int number. 
     * Return a <code>Digital</code> objects
     * @throws java.lang.Exception
     */
    @Override
    public Digital getNewById(int id) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT [id]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[image]\n"
                + "      ,[author]\n"
                + "      ,[timePost]\n"
                + "      ,[shortDes]\n"
                + "  FROM [dbo].[digital_News]\n"
                + "  WHERE id = ?";
        Digital digital = new Digital();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                digital.setId(resultSet.getInt("id"));
                digital.setTitle(resultSet.getString("title"));
                digital.setDescription(resultSet.getString("description"));
                digital.setImage(resultSet.getString("image"));
                digital.setAuthor(resultSet.getString("author"));
                digital.setDate(resultSet.getDate("timePost"));
                digital.setShortDes(resultSet.getString("shortDes"));
            }
            return digital;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(resultSet);
            closePs(preparedStatement);
            closeCon(connection);
        }
    }

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
    @Override
    public ArrayList<Digital> getAllSearchDigital(String txtSearch, int index, int pageSize) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT  [id]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[image]\n"
                + "      ,[author]\n"
                + "      ,[timePost]"
                + "      ,[shortDes]\n"
                + "  FROM [DIGITAL_NEWS].[dbo].[digital_News]\n"
                + "  where title like ?\n"
                + "  order by id\n"
                + "  offset ? rows fetch next ? rows only";
        index = pageSize * (index - 1);
        ArrayList<Digital> digitals = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + txtSearch + "%");
            preparedStatement.setInt(2, index);
            preparedStatement.setInt(3, pageSize);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Digital digital = new Digital();
                digital.setId(resultSet.getInt("id"));
                digital.setTitle(resultSet.getString("title"));
                digital.setDescription(resultSet.getString("description"));
                digital.setImage(resultSet.getString("image"));
                digital.setAuthor(resultSet.getString("author"));
                digital.setDate(resultSet.getDate("timePost"));
                digital.setShortDes(resultSet.getString("shortDes"));
                digitals.add(digital);
            }
            return digitals;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(resultSet);
            closePs(preparedStatement);
            closeCon(connection);
        }
    }

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
    @Override
    public int countMaxNews(String txtSearch) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT COUNT(*)\n"
                + "  FROM [DIGITAL_NEWS].[dbo].[digital_News]\n"
                + "  where title like ?";
        int count = 0;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + txtSearch + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        } catch (Exception ex) {
            throw ex;
        }finally {
            closeRs(resultSet);
            closePs(preparedStatement);
            closeCon(connection);
        }
    }
}
