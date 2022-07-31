package br.com.portotech.portotech.dao.usuario.repository;

import br.com.portotech.portotech.dao.usuario.TbUsuarioObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TbUsuarioRepository extends JpaRepository<TbUsuarioObj, Integer> {
    Optional<TbUsuarioObj> findByTxEmail(String TxEmail);
}
