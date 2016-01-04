/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import utility.ConnectionManager;

/**
 *
 * @author Chong Cher
 */
public class EmployeeDAO {

    private HashMap<String, Employee> employees;

    /*public EmployeeDAO(){
     employees = readFromDatabase();
        
     }
    
     private HashMap<String,Employee> readFromDatabase(){
     employees = new HashMap<String,Employee>();
     try(Connection connection = ConnectionManager.getConnection();
     PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM employee");
     ResultSet rs = pstmt.executeQuery();) {
     while (rs.next()) {
     String nric = rs.getString("nric");
     String name = rs.getString("name");
     String citizenship = rs.getString("citizenship");
     String nickname = rs.getString("nickname");
     DateTime birthday = DateTime.parse(rs.getString("birthday"),DateTimeFormat.forPattern("dd mm YYYY"));
     String email = rs.getString("email");
     String contactNumber = rs.getString("contact_number");
     boolean registeredWithMOE = rs.getBoolean("registered_with_moe");
     boolean fulltime = rs.getBoolean("fulltime");
     employees.put(nric,new Employee(nric,name,birthday));
     }
     } catch (Exception ex) {
     System.out.println("Unable to connect to database" + ex);
     }
     return employees;
     }
    
     public boolean addEmployee(String nric, String name, DateTime birthday){
     if(employees.containsKey(nric)){
     return false;
     }
     else{
     employees.put(nric,new Employee(nric,name,birthday));
     return true;
     }
     }*/
    
    public static ArrayList<ArrayList<String>> getAllEmployees() {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM employee");
                ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                System.out.println("Debugging EmployeeDAO - Reading database!");
                ArrayList<String> thisRow = new ArrayList<String>();
                thisRow.add(rs.getString("nric"));
                thisRow.add(rs.getString("name"));
                thisRow.add(rs.getString("citizenship"));
                thisRow.add(rs.getString("nickname"));
                thisRow.add(rs.getString("birthday"));
                thisRow.add(rs.getString("email"));
                thisRow.add(rs.getString("contact_number"));
                thisRow.add(rs.getString("registered_with_moe"));
                thisRow.add(rs.getString("fulltime"));
                result.add(thisRow);
            }
        } catch (Exception ex) {
            System.out.println("Unable to connect to database" + ex);
        }
        return result;
    }
    
    public static ArrayList<String> getEmployee(String nric) {
        ArrayList<String> result = new ArrayList<>();
        ResultSet rs = null;
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM employee WHERE nric = ?");) {
            pstmt.setString(1, nric);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result.add(rs.getString("nric"));
                result.add(rs.getString("name"));
                result.add(rs.getString("citizenship"));
                result.add(rs.getString("nickname"));
                result.add(rs.getString("birthday"));
                result.add(rs.getString("email"));
                result.add(rs.getString("contact_number"));
                result.add(rs.getString("registered_with_moe"));
                result.add(rs.getString("fulltime"));
                return result;
            }
            else return null;
        } catch (Exception ex) {
            System.out.println("Unable to connect to database" + ex);
            if(rs != null) try {
                rs.close();
            } catch (SQLException ex1) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return result;
    }

    public static boolean updateEmployee(String nric, String fieldName, String newField) {
        boolean fieldUpdated = true;
        ResultSet rs = null;
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement pstmt = connection.prepareStatement("SELECT * from employee WHERE nric = ?");) {
            pstmt.setString(1, nric);
            rs = pstmt.executeQuery();
            rs.updateString(fieldName, newField);
        } catch (SQLFeatureNotSupportedException e) {
            System.out.println("Feature not supported" + e);
            fieldUpdated = false;
        } catch (SQLException e) {
            System.out.println("SQL exception" + e);
            fieldUpdated = false;
        } catch (Exception ex) {
            System.out.println("Unable to connect to database" + ex);
            fieldUpdated = false;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error closing resultset wtf" + e);
                }
            }
        }
        return fieldUpdated;
    }

    public static boolean addEmployee(String nric, String name, String citizenship, String nickname,
            String birthday, String email, String contactNumber, String registeredWithMOE, String fulltime) {
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?)");) {
            pstmt.setString(1, nric);
            pstmt.setString(2, name);
            pstmt.setString(3, citizenship);
            pstmt.setString(4, nickname);
            pstmt.setString(5, birthday);
            pstmt.setString(6, email);
            pstmt.setString(7, contactNumber);
            pstmt.setString(8, registeredWithMOE);
            pstmt.setString(9, fulltime);
            pstmt.executeQuery();
            return true;
        } catch (SQLFeatureNotSupportedException e) {
            System.out.println("Feature not supported" + e);
            return false;
        } catch (SQLException e) {
            System.out.println("SQL exception" + e);
            return false;
        } catch (Exception ex) {
            System.out.println("Unable to connect to database" + ex);
            return false;
        }
    }

    public static boolean deleteEmployee(String nric) {
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM employee WHERE nric = ?");) {
            pstmt.setString(1, nric);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                rs.deleteRow();
                rs.close();
                return true;
            } else {
                rs.close();
                return false;
            }
        } catch (SQLFeatureNotSupportedException e) {
            System.out.println("Feature not supported" + e);
            return false;
        } catch (SQLException e) {
            System.out.println("SQL exception" + e);
            return false;
        } catch (Exception ex) {
            System.out.println("Unable to connect to database" + ex);
            return false;
        }
    }

}
