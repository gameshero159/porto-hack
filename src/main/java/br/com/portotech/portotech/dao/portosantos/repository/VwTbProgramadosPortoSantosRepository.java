package br.com.portotech.portotech.dao.portosantos.repository;

import br.com.portotech.portotech.dao.portosantos.VwTbProgramadosPortoSantosObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VwTbProgramadosPortoSantosRepository extends JpaRepository<VwTbProgramadosPortoSantosObj, Integer> {

    @Query("select x from VwTbProgramadosPortoSantosObj x where x.dtPrevInicio >= ?1")
    List<VwTbProgramadosPortoSantosObj> findByDtPrevInicioMore(Date dtInicio);
}
