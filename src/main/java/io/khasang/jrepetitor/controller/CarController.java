package io.khasang.jrepetitor.controller;

import io.khasang.jrepetitor.entity.Car;
import io.khasang.jrepetitor.entity.Employee;
import io.khasang.jrepetitor.service.CarService;
import io.khasang.jrepetitor.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

}
