package br.com.portotech.portotech.modules.usuario.services;

import br.com.portotech.portotech.dao.usuario.TbUsuarioObj;
import br.com.portotech.portotech.dao.usuario.repository.TbUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TbUsuarioService implements UserDetailsService {
    private final TbUsuarioRepository tbUsuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public TbUsuarioObj createUser(TbUsuarioObj tbUsuarioObj) {
        if (tbUsuarioObj.getCdUsuario() == null) {
            Optional<TbUsuarioObj> optionalTbUsuarioObj = tbUsuarioRepository.findByTxEmail(tbUsuarioObj.getTxEmail());

            if (optionalTbUsuarioObj.isPresent()) {
                return null;
            }

            tbUsuarioObj.setCkAtivo(2);
            tbUsuarioObj.setDtCriacao(new Date());
        }

        if (tbUsuarioObj.getTxSenha() != null && !tbUsuarioObj.getTxSenha().startsWith("$2a$")) {
            tbUsuarioObj.setTxSenha(passwordEncoder.encode(tbUsuarioObj.getTxSenha()));
        }

        return tbUsuarioRepository.save(tbUsuarioObj);
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
