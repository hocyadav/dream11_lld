package io.hari.dream11;

import io.hari.dream11.config.AppConfig;
import io.hari.dream11.dao.PlayerDao;
import io.hari.dream11.dao.TeamDao;
import io.hari.dream11.dao.TournamentDao;
import io.hari.dream11.dao.UserDao;
import io.hari.dream11.entity.Player;
import io.hari.dream11.entity.Team;
import io.hari.dream11.entity.Tournament;
import io.hari.dream11.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 5/24/2021
 */
@Component
@RequiredArgsConstructor
public class TestDream11 implements CommandLineRunner {
    private final AppConfig config;
    private final UserDao userDao;
    private final PlayerDao playerDao;
    private final TournamentDao tournamentDao;
    private final TeamDao teamDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("config = " + config);
        //todo : create user
        final User hariom = User.builder().name("hariom").build();
        final User chandan = User.builder().name("chandan").build();
        userDao.saveMultiple(hariom, chandan);
        final List<User> users = userDao.findAll();
        System.out.println("users = " + users);

        //todo : create players
        final Player player1 = Player.builder().name("player1").creditScore(10).build();
        final Player player2 = Player.builder().name("player2").creditScore(8).build();
        final Player player3 = Player.builder().name("player3").creditScore(7).build();
        final Player player4 = Player.builder().name("player4").creditScore(5).build();
        final Player player5 = Player.builder().name("player5").creditScore(10).build();
        final Player player6 = Player.builder().name("player6").creditScore(7).build();
        final Player player7 = Player.builder().name("player7").creditScore(9).build();
        final Player player8 = Player.builder().name("player8").creditScore(11).build();
        final Player player9 = Player.builder().name("player9").creditScore(4).build();
        final Player player10 = Player.builder().name("player10").creditScore(8).build();
        playerDao.saveMultiple(player1, player2, player3, player4, player5, player6, player7, player8, player9, player10);
        final List<Player> players = playerDao.findAll();
        System.out.println("players = " + players);

        //todo : create tournament
        final Tournament tournament = Tournament.builder().build();
        tournamentDao.saveOrUpdate(tournament);
        tournament.getPlayers().addAll(Arrays.asList(player1, player2, player3, player4, player5));
        System.out.println("tournament = " + tournament);

        final Tournament tournament2 = Tournament.builder().build();
        tournamentDao.saveOrUpdate(tournament2);
        tournament2.getPlayers().addAll(Arrays.asList(player2, player10, player6));
        System.out.println("tournament2 = " + tournament2);

        //todo : create team
        final Team team = Team.builder().build();
        teamDao.saveOrUpdate(team);
        team.getPlayers().addAll(Arrays.asList(player1, player2, player3));
        team.setCaptain(player1);
        team.setViceCaptain(player3);
        System.out.println("team = " + team);

        //todo assign team to user
        hariom.getTeams().add(team);
        System.out.println("hariom team= " + hariom.getTeams());

        //todo : update user team players


        //todo : set new score to player


        //todo : fetch user team status


    }
}
