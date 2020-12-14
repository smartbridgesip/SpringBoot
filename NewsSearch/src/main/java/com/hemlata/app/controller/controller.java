package com.hemlata.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class controller {
	ApiCalls ap=new ApiCalls(); //create object of the ApiCall.java class to access methods inside it
	@Autowired
	Repo repo;
	@RequestMapping(value="/", method=RequestMethod.GET) //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView home(ModelAndView modelAndView)
	{
		modelAndView.setViewName("index");
		return modelAndView;
	}
	@RequestMapping(value="/ng", method=RequestMethod.GET) //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView nghome(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.newsGlance();
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> data=(ArrayList<String>)RecMap.get("value");
	   // System.out.println("data is: "+data);
	    Iterator it=data.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	   
	    modelAndView.addObject("newsList",iterable);
		modelAndView.setViewName("news");
		return modelAndView;
	}
	@RequestMapping(value="/news", method=RequestMethod.GET) //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView nhome(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.news();
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> data=(ArrayList<String>)RecMap.get("value");
	   // System.out.println("data is: "+data);
	    Iterator it=data.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	  
	    modelAndView.addObject("newsList",iterable);
		modelAndView.setViewName("news2");
		return modelAndView;
	}
	@RequestMapping(value="/srch", method=RequestMethod.GET) //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView srgethome(ModelAndView modelAndView,Input input) throws IOException, InterruptedException
	{
		
	    modelAndView.addObject("input",input);
		modelAndView.setViewName("search");
		return modelAndView;
	}	
	@RequestMapping(value="/srch", method=RequestMethod.POST) //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView srhome(ModelAndView modelAndView,Input input) throws IOException, InterruptedException
	{
		String map=ap.srch(input.getWord());
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> data=(ArrayList<String>)RecMap.get("value");
	    System.out.println("data is: "+data);
	    Iterator it=data.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("input",input);
	    modelAndView.addObject("news",iterable);
		modelAndView.setViewName("search");
		return modelAndView;
	}	
}
