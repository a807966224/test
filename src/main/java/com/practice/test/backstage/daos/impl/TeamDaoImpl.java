package com.practice.test.backstage.daos.impl;

import java.util.List;

import com.practice.test.backstage.beans.Team;
import com.practice.test.backstage.currency.AbstractBaseDao;
import com.practice.test.backstage.daos.TeamDao;

public class TeamDaoImpl extends AbstractBaseDao<Team> implements TeamDao {

	@Override
	public List<Team> selectAll(Team t) {
		return super.selectAll(t);
	}

	@Override
	public Integer selectCount() {
		return super.selectCount();
	}

	@Override
	public Integer insert(Team t) {
		return super.insert(t);
	}

	@Override
	public Integer update(Team t) {
		return super.update(t);
	}

	@Override
	public Integer delete(Long id) {
		return super.delete(id);
	}

	@Override
	public Team get(Long id) {
		return super.get(id);
	}

	
}
