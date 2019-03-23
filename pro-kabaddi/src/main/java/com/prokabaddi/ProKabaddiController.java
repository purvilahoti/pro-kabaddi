package com.prokabaddi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prokabaddi.domain.common.Match;
import com.prokabaddi.facade.MatchSchedule;


/**
 * @author purvi.manohar.lahoti
 * This is a controller class for prokabaddi schedule
 */
@Controller
@RequestMapping("/schedule")
public class ProKabaddiController {
	
	@Autowired
	private MatchSchedule matchSchedule;
	
	/**
	 * @param startDate
	 * @return
	 */
	@GetMapping(path = "/match", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Match> generateSchedule(@RequestParam("startDate") Date startDate) {
		return matchSchedule.generateMatchSchedule(startDate);
	}

}
