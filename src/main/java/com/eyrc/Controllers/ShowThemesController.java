package com.eyrc.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eyrc.Repository.*;

@Controller
public class ShowThemesController {
	
	@RequestMapping("listThemes")
	public ModelAndView listThemes(HttpServletRequest request,HttpServletResponse response)
	{    
		Configuration config = new Configuration().configure().addAnnotatedClass(Theme.class).addAnnotatedClass(Stage.class).addAnnotatedClass(Task.class);    
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(registry);   
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        Query q = session.createQuery("from Theme");
          
        List<Theme> themeList = q.list();
        
        ModelAndView mv = new ModelAndView();
	
		int i =0;
		for(Theme t : themeList)
		{
			mv.addObject("theme"+i,t.toString());
			i++;
		}
		mv.addObject("counter",i);
		mv.setViewName("listThemes.jsp");
		
		return mv;
	}
}
