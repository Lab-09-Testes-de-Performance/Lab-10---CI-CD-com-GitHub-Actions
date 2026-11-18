<<<<<<< HEAD
package com.example.atividade_pratica.controller;

import com.example.atividade_pratica.dto.ProdutoRequestDTO;
import com.example.atividade_pratica.dto.ProdutoResponseDTO;
import com.example.atividade_pratica.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // 🔹 POST -> 201 Created
    @Operation(summary = "Cadastrar Produto", description = "Cadastra um novo produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Produto já cadastrado")
    })
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrar(
            @Valid @RequestBody ProdutoRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoService.salvar(dto));
    }

    // 🔹 GET -> 200 OK
    @Operation(summary = "Listar Produtos", description = "Lista todos os produtos")
    @ApiResponse(responseCode = "200", description = "Retornado com sucesso")
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    // 🔹 GET por ID -> 200 OK
    @Operation(summary = "Buscar Produto por ID", description = "Retorna um produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    // 🔹 PUT -> 200 OK
    @Operation(summary = "Atualizar Produto", description = "Atualiza um produto existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProdutoRequestDTO dto) {

        return ResponseEntity.ok(produtoService.atualizar(id, dto));
    }

    // 🔹 DELETE -> 204 NO CONTENT
    @Operation(summary = "Deletar Produto", description = "Remove um produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
=======
package com.example.atividade_pratica.controller;

import com.example.atividade_pratica.dto.ProdutoRequestDTO;
import com.example.atividade_pratica.dto.ProdutoResponseDTO;
import com.example.atividade_pratica.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // 🔹 POST -> 201 Created
    @Operation(summary = "Cadastrar Produto", description = "Cadastra um novo produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Produto já cadastrado")
    })
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrar(
            @Valid @RequestBody ProdutoRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoService.salvar(dto));
    }

    // 🔹 GET -> 200 OK
    @Operation(summary = "Listar Produtos", description = "Lista todos os produtos")
    @ApiResponse(responseCode = "200", description = "Retornado com sucesso")
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    // 🔹 GET por ID -> 200 OK
    @Operation(summary = "Buscar Produto por ID", description = "Retorna um produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    // 🔹 PUT -> 200 OK
    @Operation(summary = "Atualizar Produto", description = "Atualiza um produto existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProdutoRequestDTO dto) {

        return ResponseEntity.ok(produtoService.atualizar(id, dto));
    }

    // 🔹 DELETE -> 204 NO CONTENT
    @Operation(summary = "Deletar Produto", description = "Remove um produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
>>>>>>> 844bd8c (Atualiza configuracao CI-CD)
}