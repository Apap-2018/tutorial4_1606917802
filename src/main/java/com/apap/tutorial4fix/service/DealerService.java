package com.apap.tutorial4fix.service;
import java.util.List;
import java.util.Optional;

import com.apap.tutorial4fix.model.DealerModel;

public interface DealerService {
	Optional<DealerModel> getDealerDetailById(Long id);
	
	void addDealer(DealerModel dealer);
	
	void deleteDealer(DealerModel dealer);
	
	List<DealerModel> getAllDealer();
	
	void updateDealer(long id, Optional<DealerModel> dealer);

}
