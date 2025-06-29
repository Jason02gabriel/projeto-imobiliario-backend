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
    @Column(nullable = false, unique = true, length = 50)
    private String codigo_imovel;

    @ManyToOne
    @JoinColumn(name = "id_proprietario", nullable = false)
    private Cliente proprietario;

    @ManyToOne
    @JoinColumn(name = "id_captador") // Captador é um usuário do sistema
    private Usuario captador;

    @Column(length = 100)
    private String tipo_imovel; // Ex: Apartamento, Casa, Terreno

    @Column(length = 20)
    private String finalidade; // LOCACAO ou VENDA

    @Column(length = 20)
    private String status; // DISPONIVEL, ALUGADO, VENDIDO, etc.

    private LocalDate data_captacao;
    private LocalDate data_exclusividade;
    private String local_chaves;

    // --- Endereço ---
    private String endereco_cep;
    private String endereco_logradouro;
    private String endereco_numero;
    private String endereco_complemento;
    private String endereco_bairro;
    private String endereco_cidade;
    @Column(length = 2)
    private String endereco_uf;
    private String ponto_referencia;

    // --- Valores ---
    @Column(precision = 12, scale = 2)
    private BigDecimal valor_venda;

    @Column(precision = 12, scale = 2)
    private BigDecimal valor_aluguel;

    @Column(precision = 10, scale = 2)
    private BigDecimal valor_condominio;

    @Column(precision = 10, scale = 2)
    private BigDecimal valor_iptu;

    // --- Detalhes Físicos ---
    private int dormitorios;
    private int suites;
    private int banheiros;
    private int vagas_garagem;
    private double area_util;
    private double area_total;

    // --- Descrições ---
    @Lob // Para textos longos
    private String descricao;

    @Lob
    private String caracteristicas_imovel; // Solução simples para as checkboxes

    @Lob
    private String caracteristicas_condominio; // Solução simples para as checkboxes
}