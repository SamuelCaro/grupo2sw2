package com.example.laboratorio4.repository;

<<<<<<< HEAD
import com.example.laboratorio4.dto.recursosHumanosDto;
=======
import com.example.laboratorio4.dto.EmpleadoPorSalarioDto;
>>>>>>> 3d81d388a7b5dabf37e45eda628a5a6900c7cb65
import com.example.laboratorio4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {

    @Query(value="SELECT e.first_name, e.last_name, jh.start_date, jh.end_date, j.job_title, e.salary\n" +
            "            FROM hr.employees e \n" +
            "            INNER JOIN jobs j  on e.job_id = j.job_id \n" +
            "            INNER JOIN job_history jh on e.employee_id = jh.employee_id\n" +
            "             where e.salary > 8000 and e.salary= ?1", nativeQuery = true)
    List<EmpleadoPorSalarioDto> listaEmpleadosPorSalario2(int salario);

<<<<<<< HEAD
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
=======
    @Query(value="SELECT e.first_name, e.last_name, jh.start_date, jh.end_date, j.job_title, e.salary\n" +
            "            FROM hr.employees e \n" +
            "            INNER JOIN jobs j  on e.job_id = j.job_id \n" +
            "            INNER JOIN job_history jh on e.employee_id = jh.employee_id\n" +
            "             where e.salary > 8000", nativeQuery = true)
    List<EmpleadoPorSalarioDto> listaEmpleadosPorSalario();
>>>>>>> 3d81d388a7b5dabf37e45eda628a5a6900c7cb65


}
