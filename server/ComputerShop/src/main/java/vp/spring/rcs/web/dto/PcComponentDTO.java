package vp.spring.rcs.web.dto;

import vp.spring.rcs.model.PcComponent;

public class PcComponentDTO {
	private Long id;
	private String name;
	private double price;
	private CategoryDTO categoryDTO;
	private BrandDTO brandDTO;

	public PcComponentDTO(PcComponent component) {
		super();
		this.id=component.getId();
		this.name = component.getName();
		this.price= component.getPrice();
		this.categoryDTO = new CategoryDTO(component.getCategory());
		this.brandDTO = new BrandDTO(component.getBrand());
	}

	public PcComponentDTO() {
		super();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	public BrandDTO getBrandDTO() {
		return brandDTO;
	}

	public void setBrandDTO(BrandDTO brandDTO) {
		this.brandDTO = brandDTO;
	}

	
	
}
