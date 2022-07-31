package br.com.portotech.portotech.dao.portosantos.repository;

import br.com.portotech.portotech.dao.portosantos.TbProgramadosPortoSantosObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbProgramadosPortoSantosRepository extends JpaRepository<TbProgramadosPortoSantosObj, Integer> {
}
