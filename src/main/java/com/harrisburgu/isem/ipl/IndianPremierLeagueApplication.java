package com.harrisburgu.isem.ipl;

import com.harrisburgu.isem.ipl.entity.Teams;
import com.harrisburgu.isem.ipl.repositories.TeamsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IndianPremierLeagueApplication implements CommandLineRunner {

    @Autowired
    private TeamsRepository teamsRepository;

    public static void main(String[] args) {
        SpringApplication.run(IndianPremierLeagueApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Teams team = new Teams();
       // team.setId(1);
        team.setName("Sunrisers Hyderabad");
        team.setWins(10);
        team.setLosses(2);
        team.setMatches(12);
        teamsRepository.save(team);
        final Iterable<Teams> teams = teamsRepository.findAll();
        for(Teams team1:teams)
        {
            System.out.println(team1.getName());
        }
    }
}
