package br.com.portotech.portotech.modules.usuario.services;

import br.com.portotech.portotech.dao.usuario.TbUsuarioObj;
import br.com.portotech.portotech.dao.usuario.repository.TbUsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TbUsuarioService implements UserDetailsService {
    private TbUsuarioRepository tbUsuarioRepository;

    TbUsuarioService(TbUsuarioRepository tbUsuarioRepository) {
        this.tbUsuarioRepository = tbUsuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<TbUsuarioObj> tbUsuarioObj = tbUsuarioRepository.findByTxEmail(username);

        if (tbUsuarioObj.isPresent()) {
            return tbUsuarioObj.get();
        } else {
            throw new UsernameNotFoundException("Usuário não foi encontrado!");
        }
    }
}
