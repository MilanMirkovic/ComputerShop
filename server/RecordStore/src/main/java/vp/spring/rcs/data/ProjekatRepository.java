package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.rcs.model.Projekat;

@Component
public interface ProjekatRepository extends JpaRepository<Projekat, Long> {

}
