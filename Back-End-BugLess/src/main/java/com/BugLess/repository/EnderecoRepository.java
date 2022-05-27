package com.BugLess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BugLess.entity.Bairro;
import com.BugLess.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	@Query("SELECT new com.BugLess.entity.Bairro(e.bairro, count(e.bairro)) "
			+ "FROM Endereco AS e, "
			+ "Paciente AS p "
			+ "WHERE p.dataCadastro "
			+ "BETWEEN curdate() - 7 AND curdate() AND p.id = e.id "
			+ "GROUP BY e.bairro")
	public List<Bairro> countTotalLocalizacaosByBairroClass();
	
}
