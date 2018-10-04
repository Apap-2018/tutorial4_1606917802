package com.apap.tutorial4fix.service;
import java.util.List;
import java.util.Optional;

import com.apap.tutorial4fix.model.CarModel;
import com.apap.tutorial4fix.model.DealerModel;
import com.apap.tutorial4fix.repository.CarDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
	@Autowired
	 private CarDb carDb;
	 
	 @Override
	 public void addCar(CarModel car) {
		 carDb.save(car);
	 }	

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		carDb.deleteById(id);
	}
	
	@Override
	public void updateCar(long id, CarModel newCar) {
		CarModel temp = carDb.getOne(id);
		temp.setBrand(newCar.getBrand());
		temp.setType(newCar.getType());
		temp.setPrice(newCar.getPrice());
		temp.setAmount(newCar.getAmount());
		carDb.save(temp);
	}
	
	public CarModel getCar(Long id) {
		return carDb.findById(id).get();
	}
}
	
