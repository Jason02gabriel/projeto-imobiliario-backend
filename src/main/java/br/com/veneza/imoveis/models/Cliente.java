package br.com.veneza.imoveis.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Dados Gerais ---
    @Column(nullable = false, length = 10)
    private String tipo_pessoa; // 'FISICA' ou 'JURIDICA'

    @Column(nullable = false)
    private String nome_razao_social;

    @Column(nullable = false, unique = true, length = 18)
    private String cpf_cnpj;

    private boolean status = true; // Ativo ou Inativo

    // --- Dados de Pessoa Física ---
    private String rg;
    private String rg_orgao_expedidor;
    private String nacionalidade;
    private LocalDate data_nascimento;
    private String sexo;
    private String estado_civil;
    private String profissao;

    // --- Dados de Pessoa Jurídica ---
    private String nome_fantasia;
    private String inscricao_estadual;

    // --- Contato ---
    @Column(unique = true)
    private String email;
    private String fone1;
    private String fone2;
    private String celular1;
    private String celular2;

    // --- Endereço ---
    private String endereco_cep;
    private String endereco_logradouro;
    private String endereco_numero;
    private String endereco_complemento;
    private String endereco_bairro;
    private String endereco_cidade;
    @Column(length = 2)
    private String endereco_uf;

    // --- Dados Bancários ---
    private String banco;
    private String agencia;
    private String conta;
    private String tipo_conta;

    // --- Dados do Cônjuge (se aplicável) ---
    private String conjuge_nome;
    private String conjuge_cpf;
    private String conjuge_rg;
    private String conjuge_profissao;

    // --- Outros ---
    @Lob // @Lob indica que o campo pode armazenar um grande volume de texto
    private String observacao;

    // --- Acesso ao Portal do Cliente ---
    private String login_portal;
    private String senha_portal;

}