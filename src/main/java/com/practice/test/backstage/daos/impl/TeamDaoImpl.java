package com.practice.test.backstage.daos.impl;

import org.springframework.stereotype.Repository;

import com.practice.test.backstage.beans.Team;
import com.practice.test.backstage.currency.AbstractBaseDao;
import com.practice.test.backstage.daos.TeamDao;

public class TeamDaoImpl extends AbstractBaseDao<Team> implements TeamDao {

	public TeamDaoImpl(){
		super(Team.class);
	}
	
}
