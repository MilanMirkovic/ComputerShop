package vp.spring.rcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.FaqRepository;

@Service
public class FaqService {
	
	@Autowired
	FaqRepository faqRepository;

}
