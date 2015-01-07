package com.controllers;



import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.db.MyBatisConnectionFactory;
import com.domain.Invite;

import com.persistence.InviteDAO;


@Controller
@RequestMapping(value="/registration")
public class RegistrationController {
	
	
	private InviteDAO inviteDAO = new InviteDAO();
	private MyBatisConnectionFactory connFactory;
	
	private static final Logger log = Logger.getLogger(RegistrationController.class.getName());


	@RequestMapping(method=RequestMethod.GET)
	public String showForm(ModelMap model){
		List<Invite> invites = inviteDAO.selectAll();
		model.addAttribute("invites", invites);
		Invite invite= new Invite();
		//invite.setId(UUID.randomUUID().toString());
		model.addAttribute("invite", invite);
		model.addAttribute("invitesel", new Invite());
		log.info("Test repo");
		return "registration";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute(value="invite") Invite invite,BindingResult result){
		
		ModelAndView mv = new ModelAndView("registration");
		if(!result.hasErrors()){
			inviteDAO.insert(invite);
			invite= new Invite();
			//invite.setId(UUID.randomUUID().toString());
			mv.addObject("invite", invite);
			mv.addObject("invitesel", new Invite());
		}
		mv.addObject("invites", inviteDAO.selectAll());
		return mv;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute(value="invite") Invite invite,BindingResult result){
		
		ModelAndView mv = new ModelAndView("registration");
		if(!result.hasErrors()){
			inviteDAO.update(invite);
			invite= new Invite();
			//invite.setId(UUID.randomUUID().toString());
			mv.addObject("invite", invite);
			mv.addObject("invitesel", new Invite());
		}
		mv.addObject("invites", inviteDAO.selectAll());
		return mv;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(value="invite") Invite invite,BindingResult result){
		//validator.validate(invite, result);
		ModelAndView mv = new ModelAndView("registration");
		if(!result.hasErrors()){
			inviteDAO.delete(invite.getEvent_id());
			invite= new Invite();
			//invite.setId(UUID.randomUUID().toString());
			mv.addObject("invite", invite);
			mv.addObject("invites", inviteDAO.selectAll());
			mv.addObject("invitesel", new Invite());
		}
		return mv;	}
	
	@RequestMapping(value="/select", method=RequestMethod.POST)
	public ModelAndView select(@ModelAttribute(value="invitesel") Invite invite,BindingResult result){
		//validator.validate(invite, result);
		ModelAndView mv = new ModelAndView("registration");
		if(!result.hasErrors()){
			invite = inviteDAO.selectSpById(invite.getEvent_id());
			
			//invite.setId(UUID.randomUUID().toString());
			mv.addObject("invitesel", invite);
			mv.addObject("invite", new Invite());
			mv.addObject("invites", inviteDAO.selectAll());
			mv.addObject("invitesel", new Invite());
			
		}
		return mv;	}

	public MyBatisConnectionFactory getConnFactory() {
		return connFactory;
	}

	public void setConnFactory(MyBatisConnectionFactory connFactory) {
		this.connFactory = connFactory;
		inviteDAO.setSqlSessionFactory(connFactory.getSqlSessionFactory());
	}
}
