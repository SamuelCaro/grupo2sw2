package com.example.laboratorio4.entity;

import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.util.Date;


@Entity
@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeid;
    @Column(name = "first_name")
    @NotBlank
    private String firstname;
    @NotBlank
    @Column(name = "Last_name",  nullable = false)
    private String lastname;
    @Column( nullable = false)
    private String email;
    @NotBlank
    @Size(min = 8, message = "debe tener un minimo de 8 caracteres")
    private String password;
    @Column(name = "phone_numbe")
    private String phonenumber;
    @Column(name = "hire_date",  nullable = false)
    private Date hiredate;

    @Column(name = "job_id", nullable = false )
    private Jobs jobid;

    @Digits(integer = 8, fraction = 2)
    @Positive
    private BigDecimal salary;
    @Column(name = "commission_pct")
    private BigDecimal commissionpct;

    @Column(name = "manager_id")
    private Jobs managerid;

    @Column(name = "department_ id")
    private Departments departmentid;
    private int enabled;






}
