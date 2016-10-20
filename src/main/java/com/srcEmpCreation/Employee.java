package com.srcEmpCreation;

import java.io.Serializable;

/**
 * @author M1019048
 *Employee Class with setters and getters
 */
public class Employee implements Serializable{
 
    private static final long serialVersionUID = 1L;
    private String empName;
    private String empId;
    private String empCompt;
    private String empPrac;
    private String empVert;
    private String empIdSearch;
    
    /**
     * @return
     */
    public String getName() {
        return empName;
    }
    /**
     * @param empName
     */
    public void setName(String empName) {
        this.empName = empName;
    }
    /**
     * @return
     */
    public String getId() {
        return empId;
    }
    /**
     * @param empId
     */
    public void setId(String empId) {
        this.empId = empId;
    }
    /**
     * @return
     */
    public String getCompt() {
        return empCompt;
    }
    /**
     * @param empCompt
     */
    public void setCompt(String empCompt) {
        this.empCompt = empCompt;
    }
    /**
     * @return
     */
    public String getPrac() {
        return empPrac;
    }
    /**
     * @param empPrac
     */
    public void setPrac(String empPrac) {
        this.empPrac = empPrac;
    }
    /**
     * @return
     */
    public String getVert() {
        return empVert;
    }
    /**
     * @param empVert
     */
    public void setVert(String empVert) {
        this.empVert = empVert;
    }
    
    
    /**
     * @return
     */
    public String getempIdSearch() {
        return empIdSearch;
    }
    /**
     * @param empIdSearch
     */
    public void setempIdSearch(String empIdSearch) {
        this.empIdSearch = empIdSearch;
    }
    
    
    
     
}
