package chapter04;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {
	private static final int THREE_GAMES_WON = 3;
	private static final int ANY_NUMBER = 123;
	
	@SuppressWarnings("deprecation")
	public Object[] nbOfGamesWon() {
		return $(0, 1, 2);
	}
	
	@SuppressWarnings("deprecation")
	public Object[] illegalNbOfGamesWon() {
		return $(-10, -1);
	}

	@Test
	public void constructorShouldSetGamesWon() {
		FootballTeam team = new FootballTeam(THREE_GAMES_WON);
		assertEquals(THREE_GAMES_WON + " games passed to constructor, but " + team.getGamesWon() + " were returned", THREE_GAMES_WON,  team.getGamesWon());
	}
	
	@Test
	@Parameters(method="nbOfGamesWon")
	public void constructorShouldSetGamesWon(int nbOfGamesWon) {
		FootballTeam team = new FootballTeam(nbOfGamesWon);
		assertEquals(nbOfGamesWon + " games passed to constructor, but " + team.getGamesWon() + " were returned", nbOfGamesWon,  team.getGamesWon());
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="illegalNbOfGamesWon")
	public void constructorShouldThrowExceptionForIllegalGamesNb(int illegalNbOfGamesWon) {
		FootballTeam team = new FootballTeam(illegalNbOfGamesWon);
	}
	
	@Test
	public void shouldBePossibleToCompareTeams() {
		FootballTeam team = new FootballTeam(ANY_NUMBER);
		assertTrue("Footballteam should implement Comparable", team instanceof Comparable);
	}
	
	@Test
	public void teamsWithMoreMatchesWonShouldBeGreater() {
		FootballTeam team_2 = new FootballTeam(2);
		FootballTeam team_3 = new FootballTeam(3);
		
		assertTrue("team with " + team_3.getGamesWon() + " games won should be ranked before the team with " + team_2.getGamesWon() + " games won", team_3.compareTo(team_2) > 0);
	}
	
	@Test
	public void teamsWithLessMatchesWonShouldBeLesser() {
		FootballTeam team_2 = new FootballTeam(2);
		FootballTeam team_3 = new FootballTeam(3);
		
		assertTrue("team with " + team_2.getGamesWon() + " games won should be ranked after the team with " + team_3.getGamesWon() + " games won", team_2.compareTo(team_3) < 0);
	}
	
	@Test
	public void teamsWithSameNumberOfMatchesWonShouldBeEqual() {
		FootballTeam teamA = new FootballTeam(2);
		FootballTeam teamB = new FootballTeam(2);
		
		assertTrue("both teams have won the same number of games: " + teamA.getGamesWon() + " vs. " + teamB.getGamesWon() + " and should be ranked equal",  + teamA.compareTo(teamB) == 0);
	}
	
}
