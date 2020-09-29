package vp.spring.rcs.web.dto;

import java.util.List;

import vp.spring.rcs.model.Brand;

public class BrandDTO {

	private Long id;
	private String name;
	private List<PcComponentDTO> components;

	public BrandDTO(String name, List<PcComponentDTO> components) {
		super();
		this.name = name;
		this.components = components;
	}
	
	

	public BrandDTO(String name) {
		super();
		this.name = name;
	}



	public BrandDTO() {
		super();
	}

	public BrandDTO(Brand brand) {
		this.id=brand.getId();
		this.name=brand.getName();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PcComponentDTO> getComponents() {
		return components;
	}

	public void setComponents(List<PcComponentDTO> components) {
		this.components = components;
	}

}
