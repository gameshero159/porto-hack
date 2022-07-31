package br.com.portotech.portotech.dao.portosantos.repository;

import br.com.portotech.portotech.dao.portosantos.VwTbProgramadosPortoSantosObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VwTbProgramadosPortoSantosRepository extends JpaRepository<VwTbProgramadosPortoSantosObj, Integer> {
}
