package br.com.software.contatos.repository;

import br.com.software.contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    // Verifica duplicidade ao cadastrar (já existente)
    boolean existsByContatoCelular(String contatoCelular);
    
    // Verifica duplicidade na atualização: procura por algum contato com o mesmo celular, exceto o de id informado
    boolean existsByContatoCelularAndContatoIdNot(String contatoCelular, Long contatoId);
}
