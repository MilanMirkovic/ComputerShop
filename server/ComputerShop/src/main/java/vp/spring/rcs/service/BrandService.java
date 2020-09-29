package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.BrandRepository;
import vp.spring.rcs.model.Brand;

@Component
public class BrandService {

	@Autowired
	private BrandRepository brandRepo;

	public List<Brand> getAll() {
		return brandRepo.findAll();
	}

	public Page<Brand> pageBrand(Pageable page) {
		return brandRepo.findAll(page);
	}
	
	public Brand getOne(Long id) {
		return brandRepo.getOne(id);
	}
	
	
}
