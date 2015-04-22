package com.harrisburgu.isem.ipl;

import com.harrisburgu.isem.ipl.entity.Batsmen;
import com.harrisburgu.isem.ipl.entity.Bowlers;
import com.harrisburgu.isem.ipl.entity.Teams;
import com.harrisburgu.isem.ipl.repositories.BatsmenRepository;
import com.harrisburgu.isem.ipl.repositories.BowlersRepository;
import com.harrisburgu.isem.ipl.repositories.TeamsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class IndianPremierLeagueApplication implements CommandLineRunner {

    @Autowired
    private TeamsRepository teamsRepository;

    @Autowired
    private BowlersRepository bowlersRepository;

    @Autowired
    private BatsmenRepository batsmenRepository;

    public static void main(String[] args) {
        SpringApplication.run(IndianPremierLeagueApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        /*Set<Batsmen> batsmenSet = new HashSet<>(0);
        Batsmen batsmen = new Batsmen();
        batsmen.setName("Bharat");
        Teams team = new Teams();
        team.setId(1);
        team.setName("Sunrisers Hyderabad");
        team.setWins(10);
        team.setLosses(2);
        team.setMatches(12);
        batsmenSet.add(batsmen);
        team.setBatsmenSet(batsmenSet);
        batsmen.setTeam(team);
        teamsRepository.save(team);*/
        final Iterable<Teams> teams = teamsRepository.findAll();
        for(Teams team1:teams)
        {
            final Set<Batsmen> batsmenSet = batsmenRepository.findByTeam(team1.getId());
            for(Batsmen batsmen : batsmenSet) {
                System.out.println("BATSMEN NAME : "+batsmen.getName());
            }

            /*for(Bowlers bowler : team1.getBowlersSet()){
                System.out.println("BOWLERS NAME : "+ bowler.getName());
            }*/

            final Set<Bowlers> bowlersSet = bowlersRepository.findByTeam(team1.getId());

            for(Bowlers bowler : bowlersSet)
            {
                System.out.println("Bowler from bowler repo : "+bowler.getName());
            }

        }





    }
}
