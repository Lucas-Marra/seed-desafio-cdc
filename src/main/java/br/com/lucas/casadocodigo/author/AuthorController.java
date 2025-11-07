package br.com.lucas.casadocodigo.author;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorRequest authorRequest) {
        Author author = authorRepository.save(authorRequest.toModel());

        return ResponseEntity
                .created(URI.create("/author/" + author.getId()))
                .body(Map.of("id", author.getId()));
    }
}
