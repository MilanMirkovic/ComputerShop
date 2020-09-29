package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.rcs.model.Brand;

@Component
public interface BrandRepository extends JpaRepository<Brand, Long > {

}
