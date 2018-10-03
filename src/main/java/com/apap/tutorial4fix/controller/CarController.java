package com.apap.tutorial4fix.controller;
import com.apap.tutorial4fix.model.*;
import com.apap.tutorial4fix.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@Autowired
	private DealerService dealerService;
	
	@RequestMapping(value = "/car/add/{dealerId}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "dealerId") Long dealerId, Model model) {
		CarModel car = new CarModel();
		DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
		car.setDealer(dealer);
		model.addAttribute("car", car);
		return "addCar";
	}
	
	@RequestMapping(value = "/car/add", method = RequestMethod.POST)
	private String addCarSubmit(@ModelAttribute CarModel car) {
		carService.addCar(car);
		return "add";
	}
	
	@RequestMapping(value="/car/delete/{id}", method=RequestMethod.GET)
	private String deleteCar(@PathVariable(value = "id") Long id, Model model) {
			//String delete = carService.getDealerDetailByType(type);
		
		carService.deleteById(id);
		//carService.deleteById(id);
		//carService.deleteById(id);
			return "delete-car";
	}
}
