package semiproject;

/**
 * 인사시스템 값 오브젝트 (VO)
 */

public class EmployeeVO {//VO클래스 구현 이하는 변수들. private 필수.
    private String empno;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String hdat;
    private String jobid;
    private int sal;
    private double comm;
    private int mgrid;
    private int deptid;


    public EmployeeVO() {
    }// 기본생성자. 필수조건

    public EmployeeVO(String empno, String fname, String lname, String email, String phone,
                      String hdat, String jobid, int sal, double comm, int mgrid, int deptid) {
        this.empno = empno;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.hdat = hdat;
        this.jobid = jobid;
        this.sal = sal;
        this.comm = comm;
        this.mgrid = mgrid;
        this.deptid = deptid;
    }//생성자. 필수조건

    public void setEmpno(String empno) {
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

    public void setHdat(String hdat) {
        this.hdat = hdat;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public void setMgrid(int mgrid) {
        this.mgrid = mgrid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    //privated 변수를 열기위한 setter들


    public String getEmpno() {
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

    public String getHdat() {
        return hdat;
    }

    public String getJobid() {
        return jobid;
    }

    public int getSal() {
        return sal;
    }

    public double getComm() {
        return comm;
    }

    public int getMgrid() {
        return mgrid;
    }

    public int getDeptid() {
        return deptid;
    }

}//privated 변수를 열기위한 getter들
