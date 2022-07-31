package br.com.portotech.portotech.modules.usuario.services;

import br.com.portotech.portotech.dao.usuario.TbUsuarioObj;
import br.com.portotech.portotech.dao.usuario.repository.TbUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TbUsuarioService implements UserDetailsService {
    private final TbUsuarioRepository tbUsuarioRepository;

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
