package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.CategoryRepository;
import vp.spring.rcs.model.Category;

@Component
public class CategoryService {

	
	@Autowired
	CategoryRepository categoryRepo;

	
	public Category getOne(long id) {
		return categoryRepo.findOne(id);
	}
	
	public List<Category> getAll(){
		return categoryRepo.findAll();
	}
}
