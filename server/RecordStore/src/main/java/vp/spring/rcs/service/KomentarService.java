package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.KomentarRepository;
import vp.spring.rcs.model.Komentar;

@Service
public class KomentarService {
	
	@Autowired
	KomentarRepository komentarRepository;
	
	private List<Komentar> getAll(){
		return komentarRepository.findAll();
	}
	
	private Komentar getOne(String username) {
		return komentarRepository.findByUsername(username);
	}

}
