package vp.spring.rcs.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "computershop")
public class PcComponent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	private String name;

	private double price;

	@ManyToOne
	private Category category;
	@ManyToOne
	private Brand brand;

	public PcComponent() {
		super();
	}

	

	public PcComponent(Long id, String name, double price, Category category, Brand brand ) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.brand = brand;
	
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}
