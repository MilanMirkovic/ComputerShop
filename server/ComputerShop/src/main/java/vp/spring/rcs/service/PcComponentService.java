package vp.spring.rcs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javassist.bytecode.LineNumberAttribute.Pc;
import vp.spring.rcs.data.PcComponentRepository;
import vp.spring.rcs.model.Brand;
import vp.spring.rcs.model.Category;
import vp.spring.rcs.model.PcComponent;

@Component
public class PcComponentService {

	@Autowired
	PcComponentRepository PcComponetRepo;
	
	@Autowired
	BrandService brandService;
	@Autowired
	CategoryService categoryService;
	
	public List<PcComponent> findAll(){
		return PcComponetRepo.findAllCom();
	}
	
	public Page<PcComponent> pagePcComponents(Pageable page){
		return PcComponetRepo.findAll(page);
	}
	
	public PcComponent getOne(Long id) {
		return PcComponetRepo.getOne(id);
	}
	
	public Page<PcComponent> getByCategory(Long id,Pageable page){
		Category category=categoryService.getOne(id);
		
		List<PcComponent> components=category.getComponents();
		//Page<PcComponent> pages=new PageImpl<PcComponent>(components, new PageRequest(0, 10, null), components.size());
		Page<PcComponent> pages=new PageImpl<>(components,page,2);
		return pages;
	}
	
	public List<PcComponent> getByBrand(Long id){
		Brand brand=brandService.getOne(id);
		
		List<PcComponent> components=brand.getComponents();
		//Page<PcComponent> pages=new PageImpl<PcComponent>(components, new PageRequest(0, 10, null), components.size());
	
		return components;
	}
	
//	public Page<PcComponent> getByName(Pageable page, String name){
//		return PcComponetRepo.findByNameContaining(page, name);
//	}
	public Page<PcComponent> getByNameAndCategoryId(Pageable page, String name,Long id){
		Category category=categoryService.getOne(id);

		List<PcComponent> comp=category.getComponents().stream().filter(c->c.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
		Page<PcComponent> pages=new PageImpl<>(comp,page,comp.size());
		return pages;
	}
}
