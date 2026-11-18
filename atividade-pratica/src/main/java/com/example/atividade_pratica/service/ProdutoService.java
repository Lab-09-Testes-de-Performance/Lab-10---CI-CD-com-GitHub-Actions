<<<<<<< HEAD
package com.example.atividade_pratica.service;

import com.example.atividade_pratica.dto.ProdutoRequestDTO;
import com.example.atividade_pratica.dto.ProdutoResponseDTO;
import com.example.atividade_pratica.entity.Produto;
import com.example.atividade_pratica.exception.GlobalException;
import com.example.atividade_pratica.exception.ResourceNotFoundException;
import com.example.atividade_pratica.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    // 🔹 Listar todos
    public List<ProdutoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    // 🔹 Buscar por ID
    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        return converterParaResponseDTO(produto);
    }

    // 🔹 Salvar
    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {

        // (opcional) validação simples
        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new GlobalException("Nome do produto é obrigatório");
        }

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        Produto salvo = repository.save(produto);

        return converterParaResponseDTO(salvo);
    }

    // 🔹 Atualizar
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {

        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        Produto atualizado = repository.save(produto);

        return converterParaResponseDTO(atualizado);
    }

    // 🔹 Deletar
    public void deletar(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        repository.delete(produto);
    }

    // 🔹 Converter Entity → ResponseDTO
    private ProdutoResponseDTO converterParaResponseDTO(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco()
        );
    }
=======
package com.example.atividade_pratica.service;

import com.example.atividade_pratica.dto.ProdutoRequestDTO;
import com.example.atividade_pratica.dto.ProdutoResponseDTO;
import com.example.atividade_pratica.entity.Produto;
import com.example.atividade_pratica.exception.GlobalException;
import com.example.atividade_pratica.exception.ResourceNotFoundException;
import com.example.atividade_pratica.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    // 🔹 Listar todos
    public List<ProdutoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    // 🔹 Buscar por ID
    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        return converterParaResponseDTO(produto);
    }

    // 🔹 Salvar
    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {

        // (opcional) validação simples
        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new GlobalException("Nome do produto é obrigatório");
        }

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        Produto salvo = repository.save(produto);

        return converterParaResponseDTO(salvo);
    }

    // 🔹 Atualizar
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {

        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        Produto atualizado = repository.save(produto);

        return converterParaResponseDTO(atualizado);
    }

    // 🔹 Deletar
    public void deletar(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        repository.delete(produto);
    }

    // 🔹 Converter Entity → ResponseDTO
    private ProdutoResponseDTO converterParaResponseDTO(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco()
        );
    }
>>>>>>> 844bd8c (Atualiza configuracao CI-CD)
}