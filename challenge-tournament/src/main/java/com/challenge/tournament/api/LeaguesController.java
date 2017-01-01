package com.challenge.tournament.api;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.challenge.common.api.JsonResponse;
import com.challenge.common.api.JsonResult;
import com.challenge.tournament.composite.service.LeaguesCompositeService;
import com.challenge.tournament.core.service.LeagueCoreService;
import com.challenge.tournament.dto.LeagueDTO;
import com.challenge.tournament.dto.LeagueDataDTO;
import com.challenge.tournament.request.LeagueRequest;
import com.challenge.tournament.request.LeagueToDeleteRequest;

/**
 * Exposes different APIs to retrieve leagues related data such as teams,
 * standings or location.
 * 
 * @author serge.akoa.owona
 *
 */
@Controller
public class LeaguesController  {

	/**
	 * Logger to log messages
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Composite Service that retrieves composite data related to a league
	 */
	@Inject
	private LeaguesCompositeService leaguesCompositeService;

	/**
	 * Core Service that retrieves league related data.
	 */
	@Inject
	private LeagueCoreService leagueCoreService;

	/**
	 * Retrieves a league.
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/v1/leagues/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<JsonResponse> getLeague(  @Valid @NotEmpty  @PathVariable int id) {
		if (logger.isInfoEnabled()) {
			logger.info("retrieving a league");
		}
		
		LeagueDTO leagueDTO =  leagueCoreService.retrieveLeague(id);
		JsonResult jsonResult = new JsonResult();
		jsonResult.addItem(leagueDTO);
		
		JsonResponse jsonResponse = new JsonResponse(jsonResult);
		ResponseEntity<JsonResponse> responseEntity = new ResponseEntity<JsonResponse>(HttpStatus.OK);
		responseEntity.status(HttpStatus.OK).body(jsonResponse);
		
		return responseEntity;
	}

	/**
	 * Deletes a league.
	 */
	@RequestMapping(value = "/v1/leagues", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<JsonResponse> deleteLeague(@Valid @RequestBody List<LeagueToDeleteRequest> requestList) {
		if (logger.isInfoEnabled()) {
			logger.info("delete a list of league with the size : " + requestList.size());
		}

		leagueCoreService.deleteLeagues(requestList);

		return new ResponseEntity<JsonResponse>(HttpStatus.OK);
	}

	/**
	 * Updates a league.
	 */
	@RequestMapping(value = "/v1/leagues/{name}/{year}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<JsonResponse> updateLeague(@PathVariable String name, @PathVariable int year,
			@Valid @RequestBody LeagueRequest leagueRequest) {
		if (logger.isInfoEnabled()) {
			logger.info("updating the league with the following id: year " + year + " name : " + name);

		}

		this.leagueCoreService.updateLeague(name, year, leagueRequest);

		return new ResponseEntity<JsonResponse>(HttpStatus.OK);
	}

	/**
	 * add a league.
	 */
	@RequestMapping(value = "/v1/leagues", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> addLeague(@Valid @RequestBody LeagueRequest leagueRequest) {
		if (logger.isInfoEnabled()) {
			logger.info("adding a new league");
		}
		
		leagueCoreService.addLeague(leagueRequest);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Retrieves composite data given a league Id
	 * 
	 * @param id
	 *            ID of a league
	 * @return League Related Data.
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/v1/leagueData/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<JsonResponse> getALeagueData(@PathVariable int id) {
		if (logger.isInfoEnabled()) {
			this.logger.info("Retrieving composite league data");
		}

		LeagueDataDTO leagueDataDTO = leaguesCompositeService.retrieveCompositeDataLeague(id);
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.addItem(leagueDataDTO);
		JsonResponse jsonResponse = new JsonResponse(jsonResult);
		ResponseEntity<JsonResponse> responseEntity = new ResponseEntity<JsonResponse>(HttpStatus.OK);
		responseEntity.status(HttpStatus.OK).body(jsonResponse);
		
		return responseEntity;

	}

}
