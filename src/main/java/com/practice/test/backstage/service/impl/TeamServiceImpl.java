package com.practice.test.backstage.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.test.backstage.beans.Team;
import com.practice.test.backstage.currency.PagerList;
import com.practice.test.backstage.daos.TeamDao;
import com.practice.test.backstage.service.TeamService;

@Transactional
@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamDao teamDao;

	@Override
	public PagerList<Team> getTeamForPage(Team team, Integer skip, Integer size, String prefixUrl) {
		
		
		PagerList<Team> pagers = new PagerList<Team>(skip, size, prefixUrl, teamDao.selectAll(team), teamDao.selectCount());
		
		return pagers;
	}

	@Override
	public Integer insert(Team t) {
		return teamDao.insert(t);
	}

	@Override
	public Integer update(Team t) {
		return teamDao.update(t);
	}

	@Override
	public Integer delete(Long id) {
		return teamDao.delete(id);
	}

	@Override
	public Team get(Long id) {
		return teamDao.get(id);
	}

	@Override
	public Integer deleteBatch(Long[] ids) {
		Map pars = new HashMap();
		pars.put("ids", ids);
		return teamDao.deleteBatch(pars);
	}
}
