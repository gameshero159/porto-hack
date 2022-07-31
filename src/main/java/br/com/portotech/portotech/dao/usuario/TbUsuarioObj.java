package br.com.portotech.portotech.dao.usuario;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario", schema = "portotech")
public class TbUsuarioObj implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_usuario")
    private Integer cdUsuario;

    @Column(name = "tx_usuario")
    private String txUsuario;

    @Column(name = "tx_email")
    private String txEmail;

    @Column(name = "tx_senha")
    private String txSenha;

    @Column(name = "ck_ativo")
    private Integer ckAtivo;

    @Column(name = "dt_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dtCriacao;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return txSenha;
    }

    @Override
    public String getUsername() {
        return txEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (ckAtivo != null) {
            return ckAtivo == 1;
        }

        return false;
    }
}
