package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.rcs.model.Kategorija;

@Component
public interface KategorijaRepository extends JpaRepository<Kategorija, Long> {

}
