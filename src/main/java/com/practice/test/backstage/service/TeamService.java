package com.practice.test.backstage.service;

import com.practice.test.backstage.beans.Team;
import com.practice.test.backstage.currency.BaseService;
import com.practice.test.backstage.currency.PagerList;

public interface TeamService extends BaseService<Team>{

	public PagerList<Team> getTeamForPage(Team Team,Integer skip,Integer size,String prefixUrl);
	
	public Integer deleteBatch(Long[] ids);
}
