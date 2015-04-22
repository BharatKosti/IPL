package com.harrisburgu.isem.ipl.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by bharatkosti on 4/21/15.
 */
@Entity
@Table(name = "BOWLERS")
public class Bowlers implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int Id;
  private String name;
  private Double bowlingAvg;
  private String bestFigures;
  private int wickets;
  private int matches;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "teamsId", nullable = false)
  private Teams team;

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getBowlingAvg() {
    return bowlingAvg;
  }

  public void setBowlingAvg(Double bowlingAvg) {
    this.bowlingAvg = bowlingAvg;
  }

  public String getBestFigures() {
    return bestFigures;
  }

  public void setBestFigures(String bestFigures) {
    this.bestFigures = bestFigures;
  }

  public int getWickets() {
    return wickets;
  }

  public void setWickets(int wickets) {
    this.wickets = wickets;
  }

  public int getMatches() {
    return matches;
  }

  public void setMatches(int matches) {
    this.matches = matches;
  }

  public Teams getTeam() {
    return team;
  }

  public void setTeam(Teams team) {
    this.team = team;
  }
}
