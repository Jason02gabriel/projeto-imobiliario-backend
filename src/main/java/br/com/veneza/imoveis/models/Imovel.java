package br.com.veneza.imoveis.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "imoveis")
@Getter
@Setter
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Dados Principais e de Captação ---
    @Column(nullable = false, unique = true, length = 50, name = "codigo_imovel")
    private String codigoImovel;

    @ManyToOne
    @JoinColumn(name = "id_proprietario", nullable = false)
    private Cliente proprietario;

    @ManyToOne
    @JoinColumn(name = "id_captador") // Captador é um usuário do sistema
    private Usuario captador;

    @Column(length = 100, name = "tipo_imovel")
    private String tipoImovel; // Ex: Apartamento, Casa, Terreno

    @Column(length = 20, name = "finalidade")
    private String finalidade; // LOCACAO ou VENDA

    @Column(length = 20, name = "status")
    private String status; // DISPONIVEL, ALUGADO, VENDIDO, etc.

    @Column(name = "data_captacao")
    private LocalDate dataCaptacao;

    @Column(name = "data_exclusividade")
    private LocalDate dataExclusividade;

    @Column(name = "local_chaves")
    private String localChaves;

    // --- Endereço ---
    @Column(name = "endereco_cep")
    private String enderecoCep;

    @Column(name = "endereco_logradouro")
    private String enderecoLogradouro;

    @Column(name = "endereco_numero")
    private String enderecoNumero;

    @Column(name = "endereco_complemento")
    private String enderecoComplemento;

    @Column(name = "endereco_bairro")
    private String enderecoBairro;

    @Column(name = "endereco_cidade")
    private String enderecoCidade;

    @Column(length = 2, name = "endereco_uf")
    private String enderecoUf;

    @Column(name = "ponto_referencia")
    private String pontoReferencia;

    // --- Valores ---
    @Column(precision = 12, scale = 2, name = "valor_venda")
    private BigDecimal valorVenda;

    @Column(precision = 12, scale = 2, name = "valor_aluguel")
    private BigDecimal valorAluguel;

    @Column(precision = 10, scale = 2, name = "valor_condominio")
    private BigDecimal valorCondominio;

    @Column(precision = 10, scale = 2, name = "valor_iptu")
    private BigDecimal valorIptu;

    // --- Detalhes Físicos ---
    @Column(name = "dormitorios")
    private int dormitorios;

    @Column(name = "suites")
    private int suites;

    @Column(name = "banheiros")
    private int banheiros;

    @Column(name = "vagas_garagem")
    private int vagasGaragem;

    @Column(name = "area_util")
    private double areaUtil;

    @Column(name = "area_total")
    private double areaTotal;

    // --- Descrições ---
    @Lob
    @Column(name = "descricao")
    private String descricao; // Para textos longos

    @Lob
    @Column(name = "caracteristicas_imovel")
    private String caracteristicasImovel; // Solução simples para as checkboxes

    @Lob
    @Column(name = "caracteristicas_condominio")
    private String caracteristicasCondominio; // Solução simples para as checkboxes
}