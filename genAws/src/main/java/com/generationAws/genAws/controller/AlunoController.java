package com.generationAws.genAws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generationAws.genAws.model.Aluno;
import com.generationAws.genAws.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> getAll(){
		return ResponseEntity.ok(alunoRepository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getById(@PathVariable Long id){
		return alunoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Aluno>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(alunoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Aluno> Post (@Valid @RequestBody Aluno aluno){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(alunoRepository.save(aluno));
	}
	
	@PutMapping
	public ResponseEntity<Aluno> Put (@Valid @RequestBody Aluno aluno){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(alunoRepository.save(aluno));
	}
	
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable Long id) {
		alunoRepository.deleteById(id);
	}
}
