package vp.spring.rcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.KomentarRepository;

@Service
public class KomentarService {
	
	@Autowired
	KomentarRepository komentarRepository;

}
