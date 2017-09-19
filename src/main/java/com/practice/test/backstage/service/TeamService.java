package com.practice.test.backstage.service;

import com.practice.test.backstage.beans.Team;
import com.practice.test.backstage.currency.PagerList;

public interface TeamService {

	public PagerList<Team> getTeamForPage(Team Team,Integer skip,Integer size,String prefixUrl);
	
	public Integer insert(Team t) ;
	
	public Integer update(Team t) ;

	public Integer delete(Long id) ;
	
	public Integer deleteBatch(Long[] ids) ;

	public Team get(Long id) ;
}
