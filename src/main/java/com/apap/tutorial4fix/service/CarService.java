package com.apap.tutorial4fix.service;
import java.util.List;
import java.util.Optional;

import com.apap.tutorial4fix.model.CarModel;
import com.apap.tutorial4fix.model.DealerModel;

public interface CarService {
	void addCar(CarModel car);
	public void deleteById(Long id);
}
