package br.com.portotech.portotech.dao.clima.repository;

import br.com.portotech.portotech.dao.clima.TbClimaObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TbClimaRepository extends JpaRepository<TbClimaObj, Integer> {
    @Query(value="select t.* from tb_clima as t where t.dt_consulta between ?1 and ?2 order by cd_clima desc limit 1", nativeQuery = true)
    TbClimaObj findFirstByCdClimaOrderByCdClimaDesc(Date dtAtual, Date dtProximoDia);
}
