package com.hemlata.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemlata.app.APICall;
import com.hemlata.app.model.Input;
import com.hemlata.app.model.Recs;
import com.hemlata.app.repository.InputRepo;

@Controller
public class controller {
	@Autowired
	InputRepo irepo;

	APICall ap=new APICall();
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home(ModelAndView modelAndView)
	{
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value="/quickanswer", method=RequestMethod.GET)
	public ModelAndView getquery(ModelAndView modelAndView,Input input) throws InterruptedException, IOException
	{
		modelAndView.setViewName("quickAnswer");
		return modelAndView;
	}
	
	@RequestMapping(value="/quickanswer", method=RequestMethod.POST)
	public ModelAndView dispform(ModelAndView modelAndView, Input input) throws InterruptedException, IOException
	{
		String ques;
		ques=input.getQues();
		String str=ap.data(ques);
		ObjectMapper mapper = new ObjectMapper();
	     Map<String, Object> restMap=mapper.readValue(str, Map.class);
	     String Answer=restMap.get("answer").toString();
	     String URL=restMap.get("image").toString();
	     System.out.println("String is:"+(restMap.toString()));
	     System.out.println("String is:"+str);
	     modelAndView.addObject("answer",Answer);
	     modelAndView.addObject("URL",URL);
		modelAndView.setViewName("quickAnswer");
		return modelAndView;
	}

	@RequestMapping(value="/chillax", method=RequestMethod.GET)
	public ModelAndView chillaxhome(ModelAndView modelAndView)
	{
		modelAndView.setViewName("chillaxHome");
		return modelAndView;
	}
	@RequestMapping(value="/GetJoke", method=RequestMethod.POST)
	public ModelAndView GetJoke(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String joke=ap.Joke();
		ObjectMapper mapper = new ObjectMapper();
	     Map<String, Object> jokeMap=mapper.readValue(joke, Map.class);
	     String fjoke=jokeMap.get("text").toString();
	     modelAndView.addObject("joke",fjoke);
		modelAndView.setViewName("chillaxHome");
		return modelAndView;
	}
	@RequestMapping(value="/GetTrivia", method=RequestMethod.POST)
	public ModelAndView GetTrivia(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String triviaRes=ap.trivia();
		ObjectMapper mapper = new ObjectMapper();
	     Map<String, Object> jokeMap=mapper.readValue(triviaRes, Map.class);
	     String trivia=jokeMap.get("text").toString();
	     modelAndView.addObject("trivia",trivia);
		modelAndView.setViewName("chillaxHome");
		return modelAndView;
	}
	@RequestMapping(value="/quickbrowse", method=RequestMethod.GET)
	public ModelAndView QBHome(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		modelAndView.setViewName("quichBrowse");
		return modelAndView;
	}
	@RequestMapping(value="/resbycal", method=RequestMethod.GET)
	public ModelAndView resbycalget(ModelAndView modelAndView, Input input) throws IOException, InterruptedException
	{
		modelAndView.setViewName("GetByCal");
		return modelAndView;
	}
	@RequestMapping(value="/resbycal", method=RequestMethod.POST)
	public ModelAndView resbycalpost(ModelAndView modelAndView,Input input) throws IOException, InterruptedException
	{
		String map=ap.recipeByCal(input.getCal());
		ObjectMapper mapper = new ObjectMapper();
	     Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    System.out.println(RecMap);
	   // Map<String, Object> mealsmap=(Map<String, Object>) RecMap.get("meals");
	    
	    ArrayList<String> meals=(ArrayList) RecMap.get("meals");
	    //int alen=a.l 
	    Iterator it=meals.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    System.out.println("iterator value");
	    modelAndView.addObject("list",iterable);
		modelAndView.setViewName("GetByCal");
		return modelAndView;
	}

	@RequestMapping(value="/convertamount", method=RequestMethod.GET)
	public ModelAndView CAget(ModelAndView modelAndView, Input input) throws IOException, InterruptedException
	{
		modelAndView.setViewName("convertAmount");
		return modelAndView;
	}
	@RequestMapping(value="/convertamount", method=RequestMethod.POST)
	public ModelAndView CApost(ModelAndView modelAndView, Input input) throws IOException, InterruptedException
	{
		String iname,wunit,sunit;
		float samount;
		iname=input.getIname();
		wunit=input.getWeightUnit();
		sunit=input.getSunit();
		samount=input.getSamount();
		String str=ap.convertAmount(iname, wunit, sunit, samount);
		ObjectMapper mapper = new ObjectMapper();
	     Map<String, Object> restMap=mapper.readValue(str, Map.class);
	     String Answer=restMap.get("answer").toString();
	     modelAndView.addObject("answer",Answer);
		modelAndView.setViewName("convertAmount");
		return modelAndView;
	}
	@RequestMapping(value="/nutbydish", method=RequestMethod.GET)
	public ModelAndView nbdget(ModelAndView modelAndView, Input input) throws IOException, InterruptedException
	{
		modelAndView.setViewName("NutByDish");
		return modelAndView;
	}
	@RequestMapping(value="/nutbydish", method=RequestMethod.POST)
	public ModelAndView nbdpost(ModelAndView modelAndView, Input input) throws IOException, InterruptedException
	{
		String dname;
		dname=input.getDishname();
		String str=ap.nutByDish(dname);
		ObjectMapper mapper = new ObjectMapper();
	     Map<String, Object> restMap=mapper.readValue(str, Map.class);
	     String cals=restMap.get("calories").toString();
	     String prots=restMap.get("protein").toString();
	     String fat=restMap.get("fat").toString();
	     String carbs=restMap.get("carbs").toString();
	     modelAndView.addObject("cals",cals);
	     modelAndView.addObject("prots",prots);
	     modelAndView.addObject("fat",fat);
	     modelAndView.addObject("carbs",carbs);
		modelAndView.setViewName("NutByDish");
		return modelAndView;
	}
	
	@RequestMapping(value="/smartsearch", method=RequestMethod.GET)
	public ModelAndView ssget(ModelAndView modelAndView, Input input) throws IOException, InterruptedException
	{
		modelAndView.setViewName("search");
		return modelAndView;
	}
}
