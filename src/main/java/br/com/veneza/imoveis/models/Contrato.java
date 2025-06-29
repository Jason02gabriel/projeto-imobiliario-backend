package br.com.veneza.imoveis.models;

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

    @Column(nullable = false, unique = true)
    private String codigo_contrato;

    // --- Relacionamentos Principais ---
    @ManyToOne
    @JoinColumn(name = "id_imovel", nullable = false)
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(name = "id_locatario", nullable = false)
    private Cliente locatario;

    // --- Dados do Contrato ---
    @Column(nullable = false)
    private LocalDate data_inicio;
    private LocalDate data_final;
    private int duracao_meses;
    private int dia_vencimento;

    // --- Valores e Taxas ---
    @Column(precision = 12, scale = 2)
    private BigDecimal valor_aluguel;
    @Column(precision = 5, scale = 2)
    private BigDecimal taxa_administracao_percentual;
    private boolean repassa_iptu = false;
    private boolean repassa_condominio = false;

    // --- SEÇÃO DE GARANTIAS ---
    @Enumerated(EnumType.STRING) // Diz ao JPA para salvar o nome do enum como texto (ex: "CAUCAO")
    private TipoGarantia tipo_garantia;

    // Garantia do tipo Fiador
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "contrato_fiadores",
            joinColumns = @JoinColumn(name = "contrato_id"),
            inverseJoinColumns = @JoinColumn(name = "fiador_id")
    )
    private Set<Cliente> fiadores = new HashSet<>();

    // Garantia do tipo Caução
    @Column(precision = 12, scale = 2)
    private BigDecimal caucao_valor;
    @Lob
    private String caucao_descricao; // Ex: "3x o valor do aluguel", "Cheque caução", etc.

    // Garantia do tipo Seguro Fiança
    @ManyToOne
    @JoinColumn(name = "id_seguradora")
    private Seguradora seguradora;
    private String seguro_fianca_apolice;
    @Column(precision = 12, scale = 2)
    private BigDecimal seguro_fianca_valor;

    // Garantia do tipo CredPago
    private String credpago_codigo_contrato;

    // --- Outros ---
    @Column(length = 20)
    private String status_contrato;

    @Lob
    private String observacao;
}