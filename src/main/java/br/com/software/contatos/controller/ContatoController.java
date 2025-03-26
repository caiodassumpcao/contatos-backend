package br.com.software.contatos.controller;

import br.com.software.contatos.model.Contato;
import br.com.software.contatos.service.ContatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    // POST: Cadastrar
    @PostMapping
    public ResponseEntity<Contato> criarContato(@RequestBody Contato contato) {
        Contato novoContato = contatoService.salvar(contato);
        return ResponseEntity.ok(novoContato);
    }

    // GET: Listar todos
    @GetMapping
    public ResponseEntity<List<Contato>> listarTodos() {
        List<Contato> contatos = contatoService.listarTodos();
        return ResponseEntity.ok(contatos);
    }

    // GET: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarPorId(@PathVariable Long id) {
        Contato contato = contatoService.buscarPorId(id);
        return ResponseEntity.ok(contato);
    }

    // PUT: Atualizar (Editar)
    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizar(@PathVariable Long id, @RequestBody Contato contato) {
        Contato atualizado = contatoService.atualizar(id, contato);
        return ResponseEntity.ok(atualizado);
    }

    // PATCH: Inativar
    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Contato> inativar(@PathVariable Long id) {
        Contato inativado = contatoService.inativar(id);
        return ResponseEntity.ok(inativado);
    }
    
    // DELETE: Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        contatoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
