package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.rcs.model.Faq;

public interface FaqRepository extends JpaRepository <Faq, Long> {
	
	

}
