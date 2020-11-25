package com.hemlata.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class controller {
	

	ApiCalls ap=new ApiCalls();
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home(ModelAndView modelAndView)
	{
		modelAndView.setViewName("index");
		return modelAndView;
	}
	@RequestMapping(value="/lgByGame", method=RequestMethod.GET)
	public ModelAndView lbgget(ModelAndView modelAndView)
	{
		modelAndView.setViewName("LBG");
		return modelAndView;
	}
	@RequestMapping(value="/news", method=RequestMethod.GET)
	public ModelAndView newsget(ModelAndView modelAndView)
	{
		modelAndView.setViewName("news");
		return modelAndView;
	}
	@RequestMapping(value="/cktN", method=RequestMethod.GET)
	public ModelAndView crtnpost(ModelAndView modelAndView) throws IOException, InterruptedException
	{
	String map=ap.news("cricket");
	ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
    ArrayList<String> data=(ArrayList<String>)RecMap.get("arts");
    System.out.println("data is: "+data);
    Iterator it=data.iterator();
    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
    modelAndView.addObject("msg","Cricket News");
    modelAndView.addObject("newsList",iterable);
    modelAndView.setViewName("news");
	return modelAndView;
	}
	@RequestMapping(value="/scrN", method=RequestMethod.GET)
	public ModelAndView scrnpost(ModelAndView modelAndView) throws IOException, InterruptedException
	{
	String map=ap.news("soccer");
	ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
    ArrayList<String> data=(ArrayList<String>)RecMap.get("arts");
    System.out.println("data is: "+data);
    Iterator it=data.iterator();
    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
    modelAndView.addObject("msg","Soccer News");
    modelAndView.addObject("newsList",iterable);
    modelAndView.setViewName("news");
	return modelAndView;
	}
	@RequestMapping(value="/tnsN", method=RequestMethod.GET)
	public ModelAndView tnsnpost(ModelAndView modelAndView) throws IOException, InterruptedException
	{
	String map=ap.news("tennis");
	ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
    ArrayList<String> data=(ArrayList<String>)RecMap.get("arts");
    System.out.println("data is: "+data);
    Iterator it=data.iterator();
    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
    modelAndView.addObject("msg","Tennis News");
    modelAndView.addObject("newsList",iterable);
    modelAndView.setViewName("news");
	return modelAndView;
	}
	@RequestMapping(value="/ftblN", method=RequestMethod.GET)
	public ModelAndView basketpost(ModelAndView modelAndView) throws IOException, InterruptedException
	{
	String map=ap.news("basketball");
	ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
    ArrayList<String> data=(ArrayList<String>)RecMap.get("arts");
    System.out.println("data is: "+data);
    Iterator it=data.iterator();
    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
    modelAndView.addObject("msg","BasketBall News");
    modelAndView.addObject("newsList",iterable);
    modelAndView.setViewName("news");
	return modelAndView;
	}
	@RequestMapping(value="/hkyN", method=RequestMethod.GET)
	public ModelAndView khynpost(ModelAndView modelAndView) throws IOException, InterruptedException
	{
	String map=ap.news("hockey");
	ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
    ArrayList<String> data=(ArrayList<String>)RecMap.get("arts");
    System.out.println("data is: "+data);
    Iterator it=data.iterator();
    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
    modelAndView.addObject("msg","Hockey");
    modelAndView.addObject("newsList",iterable);
    modelAndView.setViewName("news");
	return modelAndView;
	}
	
	
	
	@RequestMapping(value="/lgbygm", method=RequestMethod.GET)
	public ModelAndView lgget(ModelAndView modelAndView)
	{
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/ckt", method=RequestMethod.GET)
	public ModelAndView csrget(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.lgsByGame("cricket");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Ccg");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("msg","Leagues in Cricket");
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/scr", method=RequestMethod.GET)
	public ModelAndView scrget(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.lgsByGame("soccer");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Ccg");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("msg","Leagues in Soccer");
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/ftbl", method=RequestMethod.GET)
	public ModelAndView ftblget(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.lgsByGame("basketball");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Ccg");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("msg","Leagues in BasketBall");
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/hky", method=RequestMethod.GET)
	public ModelAndView hkyget(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.lgsByGame("hockey");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Ccg");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("msg","Leagues in Hockey");
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/tns", method=RequestMethod.GET)
	public ModelAndView tnsget(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.lgsByGame("tennis");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Ccg");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("msg","Leagues in Tennis");
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/live", method=RequestMethod.GET)
	public ModelAndView live(ModelAndView modelAndView)
	{
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
	@RequestMapping(value="/liveC", method=RequestMethod.GET)
	public ModelAndView lcget(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.live("cricket");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Stages");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("msg","cricket Live Matches");
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
	@RequestMapping(value="/liveB", method=RequestMethod.GET)
	public ModelAndView lbget(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.live("basketball");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Stages");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("msg","BasketBall Live Matches");
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
	@RequestMapping(value="/liveS", method=RequestMethod.GET)
	public ModelAndView lsget(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.live("soccer");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Stages");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("msg","Soccer Live Matches");
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
	@RequestMapping(value="/liveT", method=RequestMethod.GET)
	public ModelAndView ltget(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.live("tennis");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Stages");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("msg","Tennis Live Matches");
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
	@RequestMapping(value="/liveH", method=RequestMethod.GET)
	public ModelAndView lhget(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		String map=ap.live("hockey");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Stages");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("msg","Hockey Live Matches");
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
}
