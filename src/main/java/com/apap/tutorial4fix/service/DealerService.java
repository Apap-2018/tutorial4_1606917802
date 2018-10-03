package com.apap.tutorial4fix.service;
import java.util.Optional;

import com.apap.tutorial4fix.model.DealerModel;

public interface DealerService {
	Optional<DealerModel> getDealerDetailById(Long id);
	
	void addDealer(DealerModel dealer);
	
	void deleteDealer(DealerModel dealer);
}
