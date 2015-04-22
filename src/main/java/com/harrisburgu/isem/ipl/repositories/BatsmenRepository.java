package com.harrisburgu.isem.ipl.repositories;

import com.harrisburgu.isem.ipl.entity.Batsmen;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 * Created by bharatkosti on 4/21/15.
 */
public interface BatsmenRepository extends CrudRepository<Batsmen,Integer> {

  @Query("select b from Batsmen b where b.team = (select t from Teams t where t.Id = :#{#teamsId})")
  public Set<Batsmen> findByTeam(@Param("teamsId")int Id);

}
