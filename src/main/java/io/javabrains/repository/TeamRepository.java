package io.javabrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javabrains.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
	
	Team findByTeamName(String teamName);

}
