package com.harrisburgu.isem.ipl.entity;

import org.hibernate.annotations.GeneratorType;

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
@Table(name = "BATSMEN")
public class Batsmen implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int Id;
  private String name;
  private Double battingAvg;
  private int bestScore;
  private int runs;
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

  public Double getBattingAvg() {
    return battingAvg;
  }

  public void setBattingAvg(Double battingAvg) {
    this.battingAvg = battingAvg;
  }

  public int getBestScore() {
    return bestScore;
  }

  public void setBestScore(int bestScore) {
    this.bestScore = bestScore;
  }

  public int getRuns() {
    return runs;
  }

  public void setRuns(int runs) {
    this.runs = runs;
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
