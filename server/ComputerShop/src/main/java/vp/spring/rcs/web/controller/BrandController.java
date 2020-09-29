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
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Brand;
import vp.spring.rcs.model.PcComponent;
import vp.spring.rcs.service.BrandService;
import vp.spring.rcs.service.CartItemService;
import vp.spring.rcs.service.PcComponentService;
import vp.spring.rcs.service.ShoppingCartService;
import vp.spring.rcs.web.dto.BrandDTO;
import vp.spring.rcs.web.dto.PcComponentDTO;

@RestController
public class BrandController {

	@Autowired
	PcComponentService componentService;

	@Autowired
	BrandService brandService;

	
	
	@GetMapping(value = "api/brands/{id}")
	public ResponseEntity<Page<PcComponentDTO>> componentsOfBrand(@PathVariable Long id, Pageable page) {

		Page<PcComponent> components = componentService.getByCategory(id, page);
		List<PcComponentDTO> dto = components.getContent().stream().map(c -> new PcComponentDTO(c))
				.collect(Collectors.toList());

		Page<PcComponentDTO> retVal = new PageImpl<>(dto, page, components.getTotalElements());
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "api/brands")
	public ResponseEntity<List<BrandDTO>> brands() {

		// Page<PcComponent> components=componentService.pagePcComponents(page);

		List<Brand> brands = brandService.getAll();
		List<BrandDTO> dto = brands.stream().map(c -> new BrandDTO(c)).collect(Collectors.toList());

		// Page<PcComponentDTO> retVal=new
		// PageImpl<>(dto,page,components.getTotalElements());

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}
