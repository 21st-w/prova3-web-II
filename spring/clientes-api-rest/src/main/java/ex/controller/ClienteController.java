package ex.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ex.model.Cliente;
import ex.model.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    // Salvar cliente

    @PostMapping
    public ResponseEntity<ClienteFormRequest> salvar(
            @RequestBody ClienteFormRequest request) {

        Cliente cliente = request.toModel();

        repository.save(cliente);

        System.out.println(cliente);

        return ResponseEntity.ok(
                ClienteFormRequest.fromModel(cliente));
    }

    // Listar todos os clientes

    @GetMapping
    public List<ClienteFormRequest> getLista() {

        return repository.findAll()
                .stream()
                .map(ClienteFormRequest::fromModel)
                .collect(Collectors.toList());
    }

    // Pesquisar por nome e fazer a paginacao paginar

    @GetMapping("/pagina")
    public Page<ClienteFormRequest> getPagina(

            @RequestParam(defaultValue = "") String nome,

            @RequestParam(defaultValue = "0") int page) {

        Pageable pageable = PageRequest.of(
                page,
                5); //5 pot paginas

        return repository
                .findByNomeContainingIgnoreCase(
                        nome,
                        pageable)
                .map(
                        ClienteFormRequest::fromModel);
    }

    // Pesquisar cliente pelo ID

    @GetMapping("/{id}")
    public ResponseEntity<ClienteFormRequest> getById(
            @PathVariable Long id) {

        return repository.findById(id)

                .map(
                        ClienteFormRequest::fromModel)

                .map(
                        clienteFR -> ResponseEntity.ok(clienteFR))

                .orElseGet(
                        () -> ResponseEntity.notFound().build());
    }

    // Atualizar cliente

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(

            @PathVariable Long id,

            @RequestBody ClienteFormRequest request) {

        Optional<Cliente> clienteExistente = repository.findById(id);

        if (clienteExistente.isEmpty()) {

            return ResponseEntity
                    .notFound()
                    .build();

        }

        Cliente cliente = request.toModel();

        cliente.setId(id);

        repository.save(cliente);

        return ResponseEntity
                .noContent()
                .build();
    }

    // Excluir cliente

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable Long id) {

        return repository.findById(id)

                .map(cliente -> {

                    repository.delete(cliente);

                    return ResponseEntity
                            .noContent()
                            .build();

                })

                .orElseGet(
                        () -> ResponseEntity
                                .notFound()
                                .build());
    }

}
