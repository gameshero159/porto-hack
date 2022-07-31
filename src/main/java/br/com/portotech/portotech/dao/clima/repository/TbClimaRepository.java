package br.com.portotech.portotech.dao.clima.repository;

import br.com.portotech.portotech.dao.clima.TbClimaObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TbClimaRepository extends JpaRepository<TbClimaObj, Integer> {
    @Query(value="select t.* from tb_clima as t order by cd_clima desc limit 1", nativeQuery = true)
    TbClimaObj findFirstByCdClimaOrderByCdClimaDesc();
}
