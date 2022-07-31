package br.com.portotech.portotech.dao.portosantos.repository;

import br.com.portotech.portotech.dao.portosantos.TbProgramadosPortoSantosObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TbProgramadosPortoSantosRepository extends JpaRepository<TbProgramadosPortoSantosObj, Integer> {

    @Query("select x from TbProgramadosPortoSantosObj x where x.dtPrevInicio >= ?1 order by x.dtPrevInicio desc")
    List<TbProgramadosPortoSantosObj> findByDtPrevInicioMore(Date dtInicio);

}
