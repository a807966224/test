package com.practice.test.backstage.actions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.test.backstage.beans.Team;
import com.practice.test.backstage.beans.Team;
import com.practice.test.backstage.service.TeamService;
import com.practice.test.backstage.utils.StringUtils;

@Controller
@RequestMapping("/team")
public class TeamAction {
	
	@Resource
	TeamService teamService;
	
	@RequestMapping("/teamList")
	public String toTeam(Model model, Team team,HttpServletRequest request) {
		
		
		//获取查询数据数量
		model.addAttribute("pagers", teamService.getTeamForPage(team, team.getSkip(), team.getSize(), request.getRequestURI()));
		
		model.addAttribute("team", team);
		
		return "backstage/team/teamList";
	}

	@RequestMapping("/edit")
	public String edit(Team team,Model model,@RequestParam(required=false) boolean readOnly) {
		
		Integer tmpSkip = team.getSkip();
		
		//获取唯一数据
		if(team.getId() != null) {
			team = teamService.get(team.getId());
		}
		
		team.setSkip(tmpSkip);
		//存放至封装类中去
		model.addAttribute("bean", team);
		
		model.addAttribute("readOnly", readOnly);
		
		return "backstage/team/teamEdit";
	}
	
	@RequestMapping("/save")
	public String save(Team team,Model model) {
		
		Integer tmpSkip = team.getSkip();
		
		if(team.getId() == null) {
			teamService.insert(team);
		}else {
			teamService.update(team);
		}
		
		return "redirect:/team/teamList?skip="+tmpSkip;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Long[] ids,@RequestParam(name = "skip",required=false,defaultValue="0") Integer skip) {
		
		teamService.deleteBatch(ids);
		
		return "redirect:/team/teamList?skip="+skip;
	}
	
}
