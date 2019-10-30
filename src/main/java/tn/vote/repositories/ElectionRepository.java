package tn.vote.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.vote.entities.ElectionEntity;

@Repository("electionRepository")
public interface ElectionRepository extends JpaRepository<ElectionEntity, Long> {
	
}
