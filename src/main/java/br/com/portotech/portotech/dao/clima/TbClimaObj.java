package br.com.portotech.portotech.dao.clima;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_clima", schema = "portotech")
public class TbClimaObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_clima")
    private Integer cdClima;

    @Column(name = "tx_cidade")
    private String txCidade;

    @Column(name = "tx_uf")
    private String txUf;

    @Column(name = "tx_pais")
    private String txPais;

    @Column(name = "vl_temperatura")
    private Double vlTemperatura;

    @Column(name = "tx_direcao_vento")
    private String txDirecaoVento;

    @Column(name = "vl_velocidade_vento")
    private Double vlVelocidadeVento;

    @Column(name = "tx_condicao")
    private String txCondicao;

    @Column(name = "dt_consulta")
    private Date dtConsulta;
}
