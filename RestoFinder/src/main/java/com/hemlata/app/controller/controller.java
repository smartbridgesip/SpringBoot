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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemlata.app.ApiCalls;
import com.hemlata.app.Repository.InputRepo;
import com.hemlata.app.model.Input;

@Controller
public class controller {
	@Autowired
	InputRepo repo;

	ApiCalls ap=new ApiCalls();
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home(ModelAndView modelAndView)
	{
		modelAndView.setViewName("index");
		return modelAndView;
	}
	

	
	@RequestMapping(value="/byZ", method=RequestMethod.GET)
	public ModelAndView byzip(ModelAndView modelAndView, Input input) throws IOException, InterruptedException
	{
		modelAndView.setViewName("byZip");
		return modelAndView;
	}
	@RequestMapping(value="/byZ", method=RequestMethod.POST)
	public ModelAndView nbdpost(ModelAndView modelAndView, Input input) throws IOException, InterruptedException
	{
		
		/*String str=ap.byzip(input.getZip()).toString();
		ObjectMapper mapper = new ObjectMapper();
	     Map<String, Object> restMap=mapper.readValue(str, Map.class);
	     ArrayList<String> data=(ArrayList) restMap;
		    //int alen=a.l 
		    Iterator it=data.iterator();
		    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
		    modelAndView.addObject("list",iterable);
		modelAndView.setViewName("byZ");
		return modelAndView;*/
		String map=ap.byzip(input.getZip());
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    System.out.println("recMap is: "+RecMap);
	    Map<String, Object> resultmap=(Map<String, Object>) RecMap.get("result");
	    ArrayList<String> data=(ArrayList<String>) resultmap.get("data");
	    System.out.println("data is: "+data);
	    Iterator it=data.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    System.out.println("iterator value");
	    modelAndView.addObject("list",iterable);
		modelAndView.setViewName("byZip");
		return modelAndView;
	}
	@RequestMapping(value="/byS", method=RequestMethod.GET)
	public ModelAndView byS(ModelAndView modelAndView, Input input) throws IOException, InterruptedException
	{
		modelAndView.setViewName("bystate");
		return modelAndView;
	}
	@RequestMapping(value="/byS", method=RequestMethod.POST)
	public ModelAndView byst(ModelAndView modelAndView, Input input) throws IOException, InterruptedException
	{
		
		/*String str=ap.byzip(input.getZip()).toString();
		ObjectMapper mapper = new ObjectMapper();
	     Map<String, Object> restMap=mapper.readValue(str, Map.class);
	     ArrayList<String> data=(ArrayList) restMap;
		    //int alen=a.l 
		    Iterator it=data.iterator();
		    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
		    modelAndView.addObject("list",iterable);
		modelAndView.setViewName("byZ");
		return modelAndView;*/
		String map=ap.bystate(input.getState());
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    System.out.println("recMap is: "+RecMap);
	    Map<String, Object> resultmap=(Map<String, Object>) RecMap.get("result");
	    ArrayList<String> data=(ArrayList<String>) resultmap.get("data");
	    System.out.println("data is: "+data);
	    Iterator it=data.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    System.out.println("iterator value");
	    modelAndView.addObject("list",iterable);
		modelAndView.setViewName("byState");
		return modelAndView;
	}
	@RequestMapping("/menu/{id}")
	public ModelAndView menu(@PathVariable Integer id,ModelAndView modelAndView, Input input) throws IOException, InterruptedException{
	    String map=ap.munus(id);
	    ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    System.out.println("recMap is: "+RecMap);
	    Map<String, Object> resultmap=(Map<String, Object>) RecMap.get("result");
	    ArrayList<String> data=(ArrayList<String>) resultmap.get("data");
	    System.out.println("data is: "+data);
	    Iterator it=data.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    System.out.println("iterator value");
	    modelAndView.addObject("list",iterable);
		modelAndView.setViewName("Menus");
		return modelAndView;
	}
}
