package cn.et.food.entity;

import java.util.Date;

public class Emp {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.empno
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    private Integer empno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.ename
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    private String ename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.job
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    private String job;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.mgr
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    private Integer mgr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.hiredate
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    private Date hiredate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.sal
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    private Integer sal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.deptno
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    private Integer deptno;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.empno
     *
     * @return the value of emp.empno
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public Integer getEmpno() {
        return empno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.empno
     *
     * @param empno the value for emp.empno
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.ename
     *
     * @return the value of emp.ename
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public String getEname() {
        return ename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.ename
     *
     * @param ename the value for emp.ename
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.job
     *
     * @return the value of emp.job
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public String getJob() {
        return job;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.job
     *
     * @param job the value for emp.job
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.mgr
     *
     * @return the value of emp.mgr
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public Integer getMgr() {
        return mgr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.mgr
     *
     * @param mgr the value for emp.mgr
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.hiredate
     *
     * @return the value of emp.hiredate
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public Date getHiredate() {
        return hiredate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.hiredate
     *
     * @param hiredate the value for emp.hiredate
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.sal
     *
     * @return the value of emp.sal
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public Integer getSal() {
        return sal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.sal
     *
     * @param sal the value for emp.sal
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public void setSal(Integer sal) {
        this.sal = sal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.deptno
     *
     * @return the value of emp.deptno
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public Integer getDeptno() {
        return deptno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.deptno
     *
     * @param deptno the value for emp.deptno
     *
     * @mbg.generated Wed Nov 29 20:49:52 CST 2017
     */
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }
}