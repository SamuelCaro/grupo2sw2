package com.example.laboratorio4.controller;


import com.example.laboratorio4.dto.EmpleadoPorSalarioDto;
import com.example.laboratorio4.entity.Employees;
import com.example.laboratorio4.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Search")
public class SearchController {
    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }






    @GetMapping(value = {"/Salario"})
    public String listaEmpleadosMayorSalrio (
                                             Model model){



        List<EmpleadoPorSalarioDto> listaEmpleados = employeesRepository.listaEmpleadosPorSalario();
        model.addAttribute("listaEmpleados", listaEmpleados);

        return "Search/lista2";
    }





    @PostMapping("/busqueda")
    public String buscar (@RequestParam("searchField") String searchField,
                          Model model){

        List<EmpleadoPorSalarioDto> listaEmpleados = employeesRepository.listaEmpleadosPorSalario2(Integer.valueOf(searchField));
        model.addAttribute("listaEmpleados", listaEmpleados);
        return "Search/lista2";
    }

    @GetMapping(value = "/Filtro2")
    public String cantidadEmpleadosPorPais (){

        //COMPLETAR
        return "/Search/salario";
    }

    @GetMapping("/listar")
    public String listarEmpleadoDep() {
        //COMPLETAR
        return "/Search/lista3";

    }


}
