package br.com.software.contatos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "coontato", schema = "desafio")
@EntityListeners(AuditingEntityListener.class)
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contato_id")
    private Long contatoId;

    @Column(name = "contato_nome", length = 100, nullable = false)
    private String contato_nome;

    @Column(name = "contato_email", length = 255)
    private String contato_email;

    @Column(name = "contato_celular", length = 11)
    private String contatoCelular;

    @Column(name = "contato_telefone", length = 10)
    private String contato_telefone;

    @Column(name = "contato_sn_favorito", columnDefinition = "char(1)")
    private char contato_sn_favorito;

    @Column(name = "contato_sn_ativo", columnDefinition = "char(1)")
    private char contato_sn_ativo;

    @CreatedDate
    @Column(name = "contato_dh_cad", nullable = false, updatable = false)
    private Timestamp contato_dh_cad;

    // Construtor padrão
    public Contato() {
    }

    // Getters e Setters

    public Long getContato_id() {
        return contatoId;
    }

    public void setContato_id(Long contato_id) {
        this.contatoId = contato_id;
    }

    public String getContato_nome() {
        return contato_nome;
    }

    public void setContato_nome(String contato_nome) {
        this.contato_nome = contato_nome;
    }

    public String getContato_email() {
        return contato_email;
    }

    public void setContato_email(String contato_email) {
        this.contato_email = contato_email;
    }

    public String getContatoCelular() {
        return contatoCelular;
    }

    public void setContatoCelular(String contatoCelular) {
        this.contatoCelular = contatoCelular;
    }

    public String getContato_telefone() {
        return contato_telefone;
    }

    public void setContato_telefone(String contato_telefone) {
        this.contato_telefone = contato_telefone;
    }

    public char getContato_sn_favorito() {
        return contato_sn_favorito;
    }

    public void setContato_sn_favorito(char contato_sn_favorito) {
        this.contato_sn_favorito = contato_sn_favorito;
    }

    public char getContato_sn_ativo() {
        return contato_sn_ativo;
    }

    public void setContato_sn_ativo(char contato_sn_ativo) {
        this.contato_sn_ativo = contato_sn_ativo;
    }

    public Timestamp getContato_dh_cad() {
        return contato_dh_cad;
    }

    public void setContato_dh_cad(Timestamp contato_dh_cad) {
        this.contato_dh_cad = contato_dh_cad;
    }
}
