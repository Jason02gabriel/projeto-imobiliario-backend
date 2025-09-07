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
    @Column(nullable = false, length = 10, name = "tipo_pessoa")
    private String tipoPessoa; // 'FISICA' ou 'JURIDICA'

    @Column(nullable = false, name = "nome_razao_social")
    private String nomeRazaoSocial;

    @Column(nullable = false, unique = true, length = 18, name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "status")
    private boolean status = true; // Ativo ou Inativo

    // --- Dados de Pessoa Física ---
    @Column(name = "rg")
    private String rg;

    @Column(name = "rg_orgao_expedidor")
    private String rgOrgaoExpedidor;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "estado_civil")
    private String estadoCivil;

    @Column(name = "profissao")
    private String profissao;

    // --- Dados de Pessoa Jurídica ---
    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;

    // --- Contato ---
    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "fone1")
    private String fone1;

    @Column(name = "fone2")
    private String fone2;

    @Column(name = "celular1")
    private String celular1;

    @Column(name = "celular2")
    private String celular2;

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

    // --- Dados Bancários ---
    @Column(name = "banco")
    private String banco;

    @Column(name = "agencia")
    private String agencia;

    @Column(name = "conta")
    private String conta;

    @Column(name = "tipo_conta")
    private String tipoConta;

    // --- Dados do Cônjuge (se aplicável) ---
    @Column(name = "conjuge_nome")
    private String conjugeNome;

    @Column(name = "conjuge_cpf")
    private String conjugeCpf;

    @Column(name = "conjuge_rg")
    private String conjugeRg;

    @Column(name = "conjuge_profissao")
    private String conjugeProfissao;

    // --- Outros ---
    @Lob
    @Column(name = "observacao")
    private String observacao;

    // --- Acesso ao Portal do Cliente ---
    @Column(name = "login_portal")
    private String loginPortal;

    @Column(name = "senha_portal")
    private String senhaPortal;
}