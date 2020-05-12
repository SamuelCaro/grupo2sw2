package com.example.laboratorio4.repository;

import com.example.laboratorio4.dto.recursosHumanosDto;
import com.example.laboratorio4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {


    @Query(value = "select e.first_name, e.last_name, e.hire_date, j.end_date, \n" +
            "(Select FLOOR(DATEDIFF(j.end_date,e.hire_date)/365)), \n" +
            "(Select FLOOR(DATEDIFF(j.end_date,e.hire_date)/31))\n" +
            "from job_history j left join employees e on e.employee_id = j.employee_id \n" +
            "order by (Select FLOOR(DATEDIFF(j.end_date,e.hire_date)/365));",nativeQuery = true)
    List<recursosHumanosDto> obtenerRecursosHumanos();

    @Query(value = "select e.first_name, e.last_name, e.hire_date, j.end_date, \n" +
            "(Select FLOOR(DATEDIFF(CURRENT_DATE(),e.hire_date)/365)), \n" +
            "(Select FLOOR(DATEDIFF(CURRENT_DATE(),e.hire_date)/31))\n" +
            "from job_history j right join employees e on e.employee_id = j.employee_id \n" +
            "order by (Select FLOOR(DATEDIFF(j.end_date,e.hire_date)/365));",nativeQuery = true)
    List<recursosHumanosDto> obtenerRecursosHumanosActivos();


}
