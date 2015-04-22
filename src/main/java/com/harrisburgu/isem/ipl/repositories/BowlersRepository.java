package com.harrisburgu.isem.ipl.repositories;

import com.harrisburgu.isem.ipl.entity.Bowlers;
import com.harrisburgu.isem.ipl.entity.Teams;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by bharatkosti on 4/21/15.
 */
public interface BowlersRepository extends CrudRepository<Bowlers,Integer> {

  @Query("select b from Bowlers b where b.team = (select t from Teams t where t.Id = :#{#teamsId})")
  public Set<Bowlers> findByTeam(@Param("teamsId")int Id);

}
