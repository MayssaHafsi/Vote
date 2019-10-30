package tn.vote.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.vote.entities.ElectionEntity;

import tn.vote.service.ElectionService;

@RestController
@RequestMapping("/admin/")
public class ElectionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ElectionController.class);
	@Autowired
	private ElectionService electionService;

	@RequestMapping(value = { "/elections" }, method = RequestMethod.GET)
	public ModelAndView listElections() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("elections", electionService.electionList());

		modelAndView.setViewName("admin/elections");
		return modelAndView;
	}

	@RequestMapping(value = "/new_election", method = RequestMethod.POST)
	@ResponseBody
	public long newElection(@RequestParam(value = "date", required = true) Date date,
			@RequestParam(value = "heure_deb", required = true) String heure_deb ,@RequestParam(value = "heure_fin", required = true) String heure_fin , @RequestParam(value = "type", required = true) String type) {

		ElectionEntity election = new ElectionEntity(date, heure_deb , heure_fin ,"desactiver" , type);
		electionService.save(election);
		LOGGER.info("Create new election with id : {}, date : {} heure de debut: {} ,heure fin: {}  ", election.getDate(), election.getHeuredeb(),election.getHeurefin() , election.getType());
				
		return election.getId();
	}
	
	@RequestMapping(value="/update_election", method = RequestMethod.POST)
	public void updateElection(@RequestParam(value = "id_election", required = true) long id_election, @RequestParam(value = "date", required = true) Date date,
			@RequestParam(value = "heure_deb", required = true) String heure_deb , @RequestParam(value = "heure_fin", required = true) String heure_fin , @RequestParam(value = "etat", required = true) String etat , @RequestParam(value = "type", required = true) String type ) {
		ElectionEntity election = electionService.findElection(id_election);
		election.setDate(date);
		election.setHeuredeb(heure_deb);
		election.setHeurefin(heure_fin);
		election.setType(type);
		election.setEtat(etat);
		
		
		electionService.update(election);
		LOGGER.info("Create new election with id : {}, date : {} heure de debut: {} ,heure fin: {}  ", election.getDate(), election.getHeuredeb(),election.getHeurefin() , election.getType());
		
	}
	
	@RequestMapping(value = "/delete_election", method = RequestMethod.POST)
	public void deleteelection(@RequestParam(value = "id_election", required = true) long id_election ) {
		LOGGER.info("Delete election with Id: {}", id_election);
		electionService.delete(id_election);
	}
	
	

}
