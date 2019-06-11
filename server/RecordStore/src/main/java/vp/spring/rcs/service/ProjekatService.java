package vp.spring.rcs.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.ProjekatRepository;
import vp.spring.rcs.model.Faq;
import vp.spring.rcs.model.Projekat;

@Component
public class ProjekatService {

	@Autowired
	ProjekatRepository projekatRepo;
	
	@Autowired
	FaqService faqService;
	
	public Page<Projekat> getAll(Pageable page){
		return projekatRepo.findAll(page);
	}
	public List<Projekat> findAll(){
		return projekatRepo.findAll();
	}
	
	public Projekat save(Projekat projekat) {
		return projekatRepo.save(projekat);
	}
	
	public Projekat findOne(Long id) {
		return projekatRepo.findOne(id);
	}
	
	public List<Faq> findAllForOneProject(Long id){
		Projekat projekat=findOne(id);
		List<Faq> faqs= faqService.getAll();
		List<Faq> filterFaq=new ArrayList<>();
		for(Faq f : faqs) {
			if(f.getProjekat().getId() == projekat.getId()) {
				filterFaq.add(f);
			}
		}
		return filterFaq;
	}
	
	public List<Projekat> randomProjects(List<Projekat> list){
		List<Projekat> projekti= projekatRepo.findAll();
		
		
		
		Random rand= new Random();
		
		List<Projekat> retVal=new ArrayList<>();
		
		for(int i=0;i<8;i++) {
			
			int randIndex=rand.nextInt(list.size());
			
			retVal.add(list.get(randIndex));
			
			list.remove(randIndex);
		}
		return retVal;
	}
	
//	public class GFG { 
//		  
//	    // Drive Function 
//	    public static void main(String[] args) 
//	    { 
//	  
//	        // create a list of Integer type 
//	        List<Integer> list = new ArrayList<>(); 
//	        // add 5 element in ArrayList 
//	        list.add(10); 
//	        list.add(20); 
//	        list.add(30); 
//	        list.add(40); 
//	        list.add(50); 
//	  
//	        GFG obj = new GFG(); 
//	  
//	        // boundIndex for select in sub list 
//	        int numberOfElements = 3; 
//	  
//	        // take a random element from list and print them 
//	        System.out.println(obj.getRandomElement(list, 
//	                                     numberOfElements)); 
//	    } 
//	  
//	    // Function select an element base on index and return 
//	    // an element 
//	    public List<Integer> getRandomElement(List<Integer> list, 
//	                                          int totalItems) 
//	    { 
//	        Random rand = new Random(); 
//	  
//	        // create a temporary list for storing 
//	        // selected element 
//	        List<Integer> newList = new ArrayList<>(); 
//	        for (int i = 0; i < totalItems; i++) { 
//	  
//	            // take a raundom index between 0 to size  
//	            // of given List 
//	            int randomIndex = rand.nextInt(list.size()); 
//	  
//	            // add element in temporary list 
//	            newList.add(list.get(randomIndex)); 
//	  
//	            // Remove selected element from orginal list 
//	            list.remove(randomIndex); 
//	        } 
//	        return newList; 
//	    } 
//	} 
}
