package com.example.laboratorio4.repository;

import com.example.laboratorio4.dto.EmpleadoPorSalarioDto;
import com.example.laboratorio4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
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

    @Query(value="SELECT e.first_name, e.last_name, jh.start_date, jh.end_date, j.job_title, e.salary\n" +
            "            FROM hr.employees e \n" +
            "            INNER JOIN jobs j  on e.job_id = j.job_id \n" +
            "            INNER JOIN job_history jh on e.employee_id = jh.employee_id\n" +
            "             where e.salary > 8000", nativeQuery = true)
    List<EmpleadoPorSalarioDto> listaEmpleadosPorSalario();


}
