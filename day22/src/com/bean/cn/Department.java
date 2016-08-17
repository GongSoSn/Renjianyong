/**
 *
 */
package com.bean.cn;

/**
 * @author renjianyong
 *
 */
public class Department {

    private int dId;
    private String dname;
    private String location;

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department [dId=" + dId + ", dname=" + dname + ", location=" + location + "]";
    }


}
