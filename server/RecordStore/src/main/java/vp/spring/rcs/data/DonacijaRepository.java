package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.rcs.model.Donacija;

public interface DonacijaRepository extends JpaRepository <Donacija, Long> {

}
