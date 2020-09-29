package vp.spring.rcs.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.PcComponent;
import vp.spring.rcs.service.BrandService;
import vp.spring.rcs.service.CartItemService;
import vp.spring.rcs.service.CategoryService;
import vp.spring.rcs.service.PcComponentService;
import vp.spring.rcs.service.ShoppingCartService;
import vp.spring.rcs.web.dto.CategoryDTO;
import vp.spring.rcs.web.dto.PcComponentDTO;

@RestController
public class PcComponentController {

	
	@Autowired
	PcComponentService componentService;
	
	@Autowired
	 BrandService brandService;
	
	@Autowired
	CartItemService cartItemService;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(value="api/components")
	public ResponseEntity<Page<PcComponentDTO>> pcComponents(Pageable page){
	
		Page<PcComponent> components=componentService.pagePcComponents(page);
		
		List<PcComponentDTO> dtos=components.getContent().stream().map(c->new PcComponentDTO(c)).collect(Collectors.toList());
		
		Page<PcComponentDTO> retVal=new PageImpl<>(dtos,page,components.getTotalElements());
		
		return new ResponseEntity<>(retVal,HttpStatus.OK);
		
	}
	
	@GetMapping(value="api/components/filter/{id}")
	public ResponseEntity<Page<PcComponentDTO>> filterByNameAndCategory(Pageable page,@RequestParam String name,@PathVariable Long id){
		
		Page<PcComponent> components=componentService.getByNameAndCategoryId(page, name,id);
		
		List<PcComponentDTO> dtos=components.getContent().stream().map(c-> new PcComponentDTO(c)).collect(Collectors.toList());
	
		Page<PcComponentDTO> retVal=new PageImpl<>(dtos,page,components.getTotalElements());
		
		
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}

	
	@GetMapping(value="api/components/{id}")
	public ResponseEntity<PcComponentDTO> findById(@PathVariable Long id){
		PcComponentDTO dto=new PcComponentDTO(componentService.getOne(id));
			
	
			return new ResponseEntity<>(dto, HttpStatus.OK);

		
	}
	
	@GetMapping(value="api/components/category/{id}")
	public ResponseEntity<Page<PcComponentDTO>> filterByCategory(@PathVariable Long id, Pageable page){
	
		Page<PcComponent> components=componentService.getByCategory(id, page);
		
		List<PcComponentDTO> dtos=components.getContent().stream().map(c-> new PcComponentDTO(c)).collect(Collectors.toList());
		
		Page<PcComponentDTO> retVal=new PageImpl<>(dtos,page,components.getTotalElements());
		
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
	@GetMapping(value="api/categories/{id}")
	public ResponseEntity<CategoryDTO> getOne(@PathVariable Long id){
		
		CategoryDTO dto= new CategoryDTO(categoryService.getOne(id));
		return new ResponseEntity<>(dto , HttpStatus.OK);
		
	}

}
