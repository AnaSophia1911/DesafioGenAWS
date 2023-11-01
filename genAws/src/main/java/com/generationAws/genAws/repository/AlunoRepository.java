package com.generationAws.genAws.repository;

	
	import java.util.List;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Repository;
	import com.generationAws.genAws.model.Aluno;
	@Repository
	public interface AlunoRepository extends JpaRepository<Aluno, Long> {
		
		public List <Aluno> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	}
	
	

