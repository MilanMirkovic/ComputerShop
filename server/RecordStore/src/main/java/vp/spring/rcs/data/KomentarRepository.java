package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.rcs.model.Komentar;

public interface KomentarRepository extends JpaRepository <Komentar, Long> {

}
