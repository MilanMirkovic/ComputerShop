package vp.spring.rcs.data;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import vp.spring.rcs.model.PcComponent;

@Component
public interface PcComponentRepository extends JpaRepository<PcComponent, Long> {

	public Page<PcComponent> findByNameContaining(Pageable page, String name);
	
	@Query("SELECT c FROM PcComponent c")
	public List<PcComponent> findAllCom();
}
