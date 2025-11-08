package br.com.lucas.casadocodigo.author;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping("/new")
    public ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorRequest authorRequest) {
        entityManager.persist(authorRequest.toModel());

        return ResponseEntity.ok().build();
    }
}
