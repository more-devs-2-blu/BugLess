package com.BugLess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BugLess.entity.Bairro;
import com.BugLess.entity.Localizacao;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
	
	@Query("SELECT new com.BugLess.entity.Bairro(l.bairro, count(l.bairro))"
			+ "FROM Localizacao AS l GROUP BY l.bairro")
	public List<Bairro> countTotalLocalizacaosByBairroClass();
	
}
