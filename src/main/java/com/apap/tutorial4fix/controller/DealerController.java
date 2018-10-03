package com.apap.tutorial4fix.controller;
import java.util.List;

import com.apap.tutorial4fix.model.CarModel;
import com.apap.tutorial4fix.model.*;
import com.apap.tutorial4fix.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DealerController {
	@Autowired
	private DealerService dealerService;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("dealer", new DealerModel());
		return "addDealer";
	}
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.POST)
	private String addDealerSubmit(@ModelAttribute DealerModel dealer) {
		dealerService.addDealer(dealer);
		return "add";
	}
	
	@RequestMapping(value="/dealer/view", method = RequestMethod.GET)
	private String viewDealer(String dealerId, Model model) {
		DealerModel temp = dealerService.getDealerDetailById(Long.parseLong(dealerId)).get();
		List<CarModel> archieve =temp.getListCar();
		model.addAttribute("dealer", temp);
		model.addAttribute("car", archieve);
		return "view-dealer";
	}
	
	@RequestMapping(value="/dealer/delete/{id}", method=RequestMethod.GET)
	private String deleteDealer(@PathVariable(value = "id") Long dealerId, Model model) {
		if(dealerService.getDealerDetailById(dealerId).isPresent()) {
			DealerModel temp = dealerService.getDealerDetailById(dealerId).get();
			dealerService.deleteDealer(temp);
			return "delete-dealer";
			}
		return "error";
	}
}
