/**
 *
 */
package com.bean.cn;

import java.util.Date;

/**
 * @author renjianyong
 *
 */
public class Employee {

    private int id;
    private String ename;
    private String job;
    private int mgrId;
    private Date hiredate;
    private double salary;
    private double bonus;
    private int dId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgrId() {
        return mgrId;
    }

    public void setMgrId(int mgrId) {
        this.mgrId = mgrId;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", ename=" + ename + ", job=" + job + ", mgrId=" + mgrId
                + ", hiredate=" + hiredate + ", salary=" + salary + ", bonus=" + bonus + ", dId="
                + dId + "]";
    }

}
