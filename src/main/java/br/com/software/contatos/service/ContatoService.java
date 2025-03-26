package br.com.software.contatos.service;

import br.com.software.contatos.model.Contato;
import br.com.software.contatos.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }

    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    public Contato buscarPorId(Long id) {
        Optional<Contato> optContato = contatoRepository.findById(id);
        return optContato.orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    public Contato atualizar(Long id, Contato contato) {
        Contato existente = buscarPorId(id);
        existente.setContato_nome(contato.getContato_nome());
        existente.setContato_email(contato.getContato_email());
        existente.setContatoCelular(contato.getContatoCelular());
        existente.setContato_telefone(contato.getContato_telefone());
        existente.setContato_sn_favorito(contato.getContato_sn_favorito());
        existente.setContato_sn_ativo(contato.getContato_sn_ativo());
        // Mantém contato_dh_cad sem alteração
        return contatoRepository.save(existente);
    }

    public Contato inativar(Long id) {
        Contato existente = buscarPorId(id);
        existente.setContato_sn_ativo('N');
        return contatoRepository.save(existente);
    }

    public void deletar(Long id) {
        contatoRepository.deleteById(id);
    }
}
