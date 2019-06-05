package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.VestRepository;
import vp.spring.rcs.model.Vest;

@Service
public class VestService {
	
	@Autowired
	VestRepository vestRepository;
	
	private List<Vest> getAll(){
		return vestRepository.findAll();
	}

}
