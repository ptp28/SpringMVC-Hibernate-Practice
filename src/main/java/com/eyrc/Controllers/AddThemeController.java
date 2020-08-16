package com.eyrc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eyrc.Repository.Stage;
import com.eyrc.Repository.Task;
import com.eyrc.Repository.Theme;

@Controller
public class AddThemeController 
{
	private String themeName;
	@SuppressWarnings("unused")
	private int numStages;
	private int numTasks;
	
	
	@RequestMapping("addData1")
	public ModelAndView addData1(@RequestParam("themeName")String themeName,@RequestParam("numStages")int numStages,@RequestParam("numTasks")int numTasks)
	{     
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("themeName",themeName);
		mv.addObject("numStages",numStages);
		mv.addObject("numTasks",numTasks);
		mv.setViewName("addTasks.jsp");
		
		
		this.themeName = themeName;
		this.numStages = numStages;
		this.numTasks = numTasks;
		return mv;
	}
	
	@RequestMapping("addData2")
	public ModelAndView addData2(HttpServletRequest request,HttpServletResponse response)
	{     
		
        Configuration conf = new Configuration().configure().addAnnotatedClass(Theme.class).addAnnotatedClass(Stage.class).addAnnotatedClass(Task.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(reg);
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
		
		int flagExist = 0;
		Task t;
		Stage s;
		Theme th = new Theme();
		th.setName(this.themeName);
		for(int i=0;i<this.numTasks;i++)
		{
			t = new Task();
			t.setDescription(request.getParameter("taskDesc"+i));
			
			session.save(t);
			 
			s = new Stage();
			s.setNumber(Integer.parseInt(request.getParameter("inputStage"+i)));
			
			for(Stage stage: th.getStageList())
			{
				if(stage.getNumber() == s.getNumber())
				{
					stage.getTaskList().add(t);
					flagExist = 1;
				}
			}
			
			if(flagExist == 0)
			{
				s.getTaskList().add(t);
				th.getStageList().add(s);
				session.save(s);
			}
			
			System.out.println("Added !!!!!!");
			System.out.println(th);
		}
		session.save(th);
        tx.commit();

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("result",th);
		mv.setViewName("result.jsp");
		
		return mv;
	}
}
