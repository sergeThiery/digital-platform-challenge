package com.challenge.tournament.api;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.challenge.common.api.AbstractController;
import com.challenge.tournament.core.service.DivisionCoreService;
import com.challenge.tournament.domain.Division;
import com.challenge.tournament.request.DivisionRequest;

public class DivisionsController extends AbstractController {

	/**
	 * Logger to log messages
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Core Service to retrieve Division related data
	 */
	@Inject
	private DivisionCoreService divisionCoreService;

	/**
	 * Retrieves a division.
	 */
	@RequestMapping(value = "/v1/divisions/{leagueName}/{leagueYear}/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Division> getDivisions(@PathVariable String leagueName,@PathVariable int leagueYear) {
		if (logger.isInfoEnabled()) {
			logger.info("retrieving the list of division for the following league " + leagueName + " in year : " + leagueYear);
		}
		return divisionCoreService.retrieveDivisions(leagueName, leagueYear);
	}

	/**
	 * Deletes a division.
	 */
	@RequestMapping(value = "/v1/divisions/{leagueName}/{leagueYear}/{divisionName}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Void> deleteDivision(@PathVariable String leagueName, @PathVariable int leagueYear, @PathVariable String divisionName ) {
		if (logger.isInfoEnabled()) {
			logger.info("deleting the division with the following name: " + divisionName);
		}

		divisionCoreService.deleteDivision(leagueName, leagueYear, divisionName);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	/**
	 * Updates a division.
	 */
	@RequestMapping(value = "/v1/divisions/{leagueName}/{leagueYear}/{divisionName}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Void> updateDivision(@PathVariable String leagueName,@PathVariable int leagueYear, @PathVariable String divisionName 
			, @RequestBody DivisionRequest divisionRequest) {
		if (logger.isInfoEnabled()) {
			logger.info("updating the division with the following name: " + divisionName);

		}

		this.divisionCoreService.updateDivision(leagueName, leagueYear, divisionName, divisionRequest);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	/**
	 * add a division.
	 */
	@RequestMapping(value = "/v1/divisions", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> addLeague(@RequestBody DivisionRequest divisionRequest) {
		if (logger.isInfoEnabled()) {
			logger.info("adding a new division");
		}
		
		divisionCoreService.addDivision(divisionRequest);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public void setMessageSource(AbstractMessageSource messageSource) {
		// TODO Auto-generated method stub
		
	}



}
