package vp.spring.rcs.web.dto;

import java.util.List;

import vp.spring.rcs.model.Category;

public class CategoryDTO {

	private Long id;
	private String name;
	
	private List<PcComponentDTO> components;
	

	public CategoryDTO(String name) {
		super();
		this.name = name;
	}


	public CategoryDTO() {
		super();
	}

	public CategoryDTO(Category category) {
		this.id=category.getId();
		this.name=category.getName();
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
