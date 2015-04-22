package com.harrisburgu.isem.ipl.web;

import com.harrisburgu.isem.ipl.entity.Batsmen;
import com.harrisburgu.isem.ipl.entity.Bowlers;
import com.harrisburgu.isem.ipl.entity.Teams;
import com.harrisburgu.isem.ipl.repositories.BatsmenRepository;
import com.harrisburgu.isem.ipl.repositories.BowlersRepository;
import com.harrisburgu.isem.ipl.repositories.TeamsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.harrisburgu.isem.ipl.entity.Teams;

import java.util.Set;

/**
 * Created by bharatkosti on 4/21/15.
 */
@Controller
public class IPLController {

    @Autowired
    private TeamsRepository teamsRepository;
    @Autowired
    private BowlersRepository bowlersRepository;
    @Autowired
    private BatsmenRepository batsmenRepository;

  @RequestMapping(value="/",  method=RequestMethod.GET)
  public ModelAndView findIndex()
  {
    ModelAndView model = new ModelAndView();
    model.setViewName("index");
    return model;
  }

    @RequestMapping(value = "/teams",method = RequestMethod.GET)
    public ModelAndView findAllTeams(){
      final Iterable<Teams> teams = teamsRepository.findAll();

      ModelAndView modelAndView = new ModelAndView("teams","teams",teams);

      return modelAndView;
    }

    @RequestMapping(value = "/teams/teamDetails/{teamId:.+}",method = RequestMethod.GET)
    public ModelAndView findTeamDetailsForTeam(@PathVariable("teamId")int teamId){
      final Set<Bowlers> bowlersSet = bowlersRepository.findByTeam(teamId);
      final Set<Batsmen> batsmenSet = batsmenRepository.findByTeam(teamId);
      ModelAndView modelAndView = new ModelAndView("teamDetails","bowlers",bowlersSet);
      modelAndView.addObject("batsmen",batsmenSet);
      return modelAndView;
    }

    @RequestMapping(value = "/teams/bowlers/{teamId:.+}",method = RequestMethod.GET)
    public ModelAndView findBowlersForTeam(@PathVariable("teamId")int teamId)
    {
      final Set<Bowlers> bowlersSet = bowlersRepository.findByTeam(teamId);
      ModelAndView modelAndView = new ModelAndView("teamsDetails","bowlers",bowlersSet);
      return modelAndView;
    }


    @RequestMapping(value = "/teams/batsmen/{teamId:.+}", method = RequestMethod.GET)
    public ModelAndView findBatsmenForTeam(@PathVariable("teamId")int teamId)
    {
      final Set<Batsmen> batsmenSet = batsmenRepository.findByTeam(teamId);
      ModelAndView modelAndView = new ModelAndView("teamsDetails","batsmen",batsmenSet);
      return modelAndView;
    }

}
