package com.generationAws.genAws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_aluno")

public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório")
	@Size(min = 3, max = 60, message = "O nome deve conter entre 3 a 60 caracteres")
	private String nome;
	
	@NotNull(message = "A idade é obrigatória")
	private int idade;
	
	@NotNull(message = "A nota do primeiro semestre é obrigatória")
	private double primeiraNota;
	
	@NotNull(message = "A nota do segundo semestre é obrigatória")
	private double segundaNota;
	
	@NotBlank(message = "O nome do professor é obrigatório")
	@Size(min = 3, max = 60, message = "O nome deve conter entre 3 a 60 caracteres")
	private String nomeProfessor;
	
	@NotNull(message = "O número da sala é obrigatório")
	private int sala;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPrimeiraNota() {
		return primeiraNota;
	}

	public void setPrimeiraNota(double primeiraNota) {
		this.primeiraNota = primeiraNota;
	}

	public double getSegundaNota() {
		return segundaNota;
	}

	public void setSegundaNota(double segundaNota) {
		this.segundaNota = segundaNota;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	
}

