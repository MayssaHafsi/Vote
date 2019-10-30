package tn.vote.service;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import tn.vote.entities.ElectionEntity;
import tn.vote.repositories.ElectionRepository;

@Service("ElectionService")
public class ElectionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private ElectionRepository electionRepository;

	
	public List<ElectionEntity> electionList() {
		return electionRepository.findAll();
	}

	
	
	public  Long save(ElectionEntity election) {

		
		 electionRepository.saveAndFlush(election);
		
		return election.getId();

	}
	
	public Long update(ElectionEntity election) {
		
		 electionRepository.saveAndFlush(election);
		return election.getId();
	}
	
	public ElectionEntity findElection(long id) {
		return electionRepository.findOne(id);
	}
	
	public void delete(long id) {
		
		electionRepository.delete(id);
	}


}


