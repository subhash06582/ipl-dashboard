package io.javabrains.data;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import io.javabrains.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

	private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

	@Override
	public Match process(final MatchInput input) throws Exception {
		Match match = new Match();
		match.setId(Long.parseLong(input.getId()));
		match.setCity(input.getCity());

		match.setDate(LocalDate.parse(input.getDate()));
		match.setPlayerOfMatch(input.getPlayer_of_match());
		match.setVenue(input.getVenue());

		// Set team1 and team2 depending on innings order
		String firstInningTeam, secondInningTeam;

		if ("bat".equalsIgnoreCase(input.getToss_decision())) {
			firstInningTeam = input.getToss_winner();
			secondInningTeam = input.getToss_winner().equals(input.getTeam1()) ? input.getTeam2() : input.getTeam1();
		} else {
			secondInningTeam = input.getToss_winner();
			firstInningTeam = input.getToss_winner().equals(input.getTeam1()) ? input.getTeam2() : input.getTeam1();
		}

		match.setTeam1(firstInningTeam);
		match.setTeam2(secondInningTeam);
		
		match.setTossDecision(input.getToss_decision());
		match.setTossWinner(input.getToss_winner());
		match.setMatchWinner(input.getWinner());
		match.setResult(input.getResult());
		match.setResultMargin(input.getResult_margin());
		match.setUmpire1(input.getUmpire1());
		match.setUmpire2(input.getUmpire2());
		
		//log.info("Converting (" + input + ") into (" + match + ")");
		
		return match;
	}

}
