package br.com.veneza.imoveis.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contratos")
@Getter
@Setter
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_contrato", nullable = false, unique = true)
    private String codigoContrato;

    @ManyToOne @JoinColumn(name = "id_imovel", nullable = false)
    private Imovel imovel;

    @ManyToOne @JoinColumn(name = "id_locatario", nullable = false)
    private Cliente locatario;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "contrato_fiadores",
            joinColumns = @JoinColumn(name = "contrato_id"),
            inverseJoinColumns = @JoinColumn(name = "fiador_id")
    )
    private Set<Cliente> fiadores = new HashSet<>();

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_final")
    private LocalDate dataFinal;

    @Column(name = "duracao_meses")
    private int duracaoMeses;

    @Column(name = "dia_vencimento")
    private int diaVencimento;

    @Column(name = "valor_aluguel", precision = 12, scale = 2)
    private BigDecimal valorAluguel;

    @Column(name = "taxa_administracao_percentual", precision = 5, scale = 2)
    private BigDecimal taxaAdministracaoPercentual;

    @Column(name = "repassa_iptu")
    private boolean repassaIptu = false;

    @Column(name = "repassa_condominio")
    private boolean repassaCondominio = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_garantia")
    private TipoGarantia tipoGarantia;

    @Column(name = "caucao_valor", precision = 12, scale = 2)
    private BigDecimal caucaoValor;

    @Lob @Column(name = "caucao_descricao")
    private String caucaoDescricao;

    @ManyToOne @JoinColumn(name = "id_seguradora")
    private Seguradora seguradora;

    @Column(name = "seguro_fianca_apolice")
    private String seguroFiancaApolice;

    @Column(name = "seguro_fianca_valor", precision = 12, scale = 2)
    private BigDecimal seguroFiancaValor;

    @Column(name = "credpago_codigo_contrato")
    private String credpagoCodigoContrato;

    @Column(name = "status_contrato", length = 20)
    private String statusContrato;

    @Lob
    private String observacao;

    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Recibo> recibos = new HashSet<>();
}