package br.com.portotech.portotech.dao.clima.repository;

import br.com.portotech.portotech.dao.clima.TbClimaObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TbClimaRepository extends JpaRepository<TbClimaObj, Integer> {
    TbClimaObj findFirstByDtConsultaBetweenOrderByDtConsultaDesc(Date dtInicial, Date dtFinal);
}
