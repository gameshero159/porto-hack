package br.com.portotech.portotech.dao.portosantos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_programados_porto_santos", schema = "portotech")
public class TbProgramadosPortoSantosObj {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cd_programados_porto_santos", nullable = false)
    private int cdProgramadosPortoSantos;

    @Column(name = "dt_prev_inicio")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dtPrevInicio;

    @Column(name = "dt_prev_fim", nullable = true)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dtPrevFim;

    @Column(name = "tx_berco", nullable = true, length = 45)
    private String txBerco;

    @Column(name = "tx_navio", nullable = true, length = 45)
    private String txNavio;

    @Column(name = "tx_tipo_carga", nullable = true, length = 45)
    private String txTipoCarga;

    @Column(name = "tx_evento", nullable = true, length = 45)
    private String txEvento;

    @Column(name = "tx_ref_viagem", nullable = true, length = 45)
    private String txRefViagem;

    @Column(name = "cd_duv", nullable = true)
    private Integer cdDuv;

    @Column(name = "ck_certificado")
    private Integer ckCertificado;

    @Column(name = "cd_pratico")
    private Integer cdPratico;

    @Column(name = "ck_anuencia")
    private Integer ckAnuencia;

    @Transient
    private String txPratico;

    @Transient
    private String txStatus;

    @Transient
    private String txStatusClass;

    @PostLoad
    public void postLoad() {

        //region Verificação do prático
        if (cdPratico != null) {
            switch (cdPratico) {
                case 1:
                    txPratico = "Manobra Confirmada";
                    break;
                case 2:
                    txPratico = "Manobra em Andamento";
                    break;
                case 3:
                    txPratico = "Manobra Encerrada";
                    break;
                default:
                    txPratico = "Praticagem não comunicada";
                    break;
            }
        } else {
            txPratico = "Praticagem não comunicada";
        }
        //endregion

        //region Verificação do Status do Navio
        if (ckAnuencia == null
                || ckCertificado == null
                || ckAnuencia.equals(2)
                || ckCertificado.equals(2)) { // Não Liberado

            txStatus = "NÃO LIBERADO";
            txStatusClass = "status-1";

        } else if (ckAnuencia.equals(1)
                && ckCertificado.equals(1)
                && cdPratico == null) { // Liberado

            txStatus = "LIBERADO";
            txStatusClass = "status-2";

        } else if (cdPratico.equals(1)) { // Prático Confirmado

            txStatus = "PRÁTICO CONFIRMADO";
            txStatusClass = "status-3";

        } else if (cdPratico.equals(2)) { // Atracação

            txStatus = "ATRACAÇÃO";
            txStatusClass = "status-4";

        } else if (cdPratico.equals(3)) { // Atracado

            txStatus = "ATRACADO";
            txStatusClass = "status-5";

        }
        //endregion

    }

}
