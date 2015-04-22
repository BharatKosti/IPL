package com.harrisburgu.isem.ipl.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import com.harrisburgu.isem.ipl.entity.Batsmen;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by bharatkosti on 4/20/15.
 */
@Entity
@Table(name = "TEAMS")
public class Teams implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int Id;
  private String name;
  private int wins;
  private int losses;
  private int matches;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
  private Set<Batsmen> batsmenSet = new HashSet<>(0);

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
  private Set<Bowlers> bowlersSet = new HashSet<>(0);

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

  public int getWins() {
    return wins;
  }

  public void setWins(int wins) {
    this.wins = wins;
  }

  public int getLosses() {
    return losses;
  }

  public void setLosses(int losses) {
    this.losses = losses;
  }

  public int getMatches() {
    return matches;
  }

  public void setMatches(int matches) {
    this.matches = matches;
  }

  public Set<Batsmen> getBatsmenSet() {
    return batsmenSet;
  }

  public void setBatsmenSet(Set<Batsmen> batsmenSet) {
    this.batsmenSet = batsmenSet;
  }

  public Set<Bowlers> getBowlersSet() {
    return bowlersSet;
  }

  public void setBowlersSet(Set<Bowlers> bowlersSet) {
    this.bowlersSet = bowlersSet;
  }
}
