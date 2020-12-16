package semiproject;

public class EmployeeVO2 {
    private int empno;
    private String fname,lname,email,phone,hrdate;
    private int mngid,dptid;

    public EmployeeVO2() {
    }

    public EmployeeVO2 (String fname, String lname, String email,
                        String phone, int mngid, int dptid) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.mngid = mngid;
        this.dptid = dptid;
    }

    public EmployeeVO2(int empno, String fname, String lname, String email,
                       String phone, String hrdate, int mngid, int dptid) {
        this.empno = empno;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.hrdate = hrdate;
        this.mngid = mngid;
        this.dptid = dptid;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHrdate(String hrdate) {
        this.hrdate = hrdate;
    }

    public void setMngid(int mngid) {
        this.mngid = mngid;
    }

    public void setDptid(int dptid) {
        this.dptid = dptid;
    }

    public int getEmpno() {
        return empno;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getHrdate() {
        return hrdate;
    }

    public int getMngid() {
        return mngid;
    }

    public int getDptid() {
        return dptid;
    }
}
