package vp.spring.rcs.web.dto;

import vp.spring.rcs.model.Faq;

public class FaqDTO {

	private Long id;
	
	
	private ProjekatDTO projekat;
	
	private String pitanje;
	private String odgovor;
	
	public FaqDTO(Faq faq) {
		this.pitanje=faq.getPitanje();
		this.odgovor=faq.getOdgovor();
		this.projekat=new ProjekatDTO(faq.getProjekat());
	}
	public FaqDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProjekatDTO getProjekat() {
		return projekat;
	}

	public void setProjekat(ProjekatDTO projekat) {
		this.projekat = projekat;
	}

	public String getPitanje() {
		return pitanje;
	}

	public void setPitanje(String pitanje) {
		this.pitanje = pitanje;
	}

	public String getOdgovor() {
		return odgovor;
	}

	public void setOdgovor(String odgovor) {
		this.odgovor = odgovor;
	}
	
	
}
