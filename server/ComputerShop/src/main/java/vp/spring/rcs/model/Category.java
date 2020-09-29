package vp.spring.rcs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="category")
	List<PcComponent> components=new ArrayList<>();

	public Category(Long id, String name, List<PcComponent> components) {
		super();
		this.id = id;
		this.name = name;
		this.components = components;
	}

	
	public Category() {
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

	public List<PcComponent> getComponents() {
		return components;
	}

	public void setComponents(List<PcComponent> components) {
		this.components = components;
	}
	
	
	
}
