package br.com.portotech.portotech.dao.tabuamare.repository;

import br.com.portotech.portotech.dao.tabuamare.TbTabuaMareObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TbTabuaMareRepository extends JpaRepository<TbTabuaMareObj, Integer> {

    @Query("select x from TbTabuaMareObj x where x.dtPicoMare >= ?1")
    List<TbTabuaMareObj> findByDtPicoMareMore(Date dtPico);

    List<TbTabuaMareObj> findByDtPicoMareBetween(Date dtInicioPico, Date dtFimPico);
}
