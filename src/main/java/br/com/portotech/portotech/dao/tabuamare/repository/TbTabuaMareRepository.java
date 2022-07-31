package br.com.portotech.portotech.dao.tabuamare.repository;

import br.com.portotech.portotech.dao.tabuamare.TbTabuaMareObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TbTabuaMareRepository extends JpaRepository<TbTabuaMareObj, Integer> {
    List<TbTabuaMareObj> findByDtPicoMareBetween(Date dtInicioPico, Date dtFimPico);
}
