package com.example.laboratorio4.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="employees")
public class Employees {

    @Id
    @Column(name="employee_id")
    private int id;


    @Column(name="first_name")
    private String firstname;
    @Column(name="last_name")
    private String lastname;
    @Column
    private String email;
    @Column
    private String password;
    @Column(name="phone_number")
    private String phonenumber;
    @Column(name="hire_date")
    private Date hiredate;
    @Column(name="job_id")
    private String jobid;
    @Column
    private int salary;
    @Column(name="commission_pct")
    private float commissionpct;
    @OneToOne
    @JoinColumn(name="manager_id")
    private Employees manager;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Departments department;
    @Column
    private boolean enabled;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public float getCommissionpct() {
        return commissionpct;
    }

    public void setCommissionpct(float commissionpct) {
        this.commissionpct = commissionpct;
    }

    public Employees getManager() {
        return manager;
    }

    public void setManager(Employees manager) {
        this.manager = manager;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



}
