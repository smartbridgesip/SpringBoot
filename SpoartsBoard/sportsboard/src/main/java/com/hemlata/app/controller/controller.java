package com.hemlata.app.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemlata.app.model.data;
import com.hemlata.app.reposity.InputRepo;

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
	@RequestMapping(value="/lgByGame", method=RequestMethod.GET)
	public ModelAndView lbgget(ModelAndView modelAndView, data dt)
	{
		modelAndView.setViewName("LBG");
		return modelAndView;
	}
	@RequestMapping(value="/lgByGame", method=RequestMethod.POST)
	public ModelAndView lbgpost(ModelAndView modelAndView, data dt) throws IOException, InterruptedException
	{
		ArrayList<String> data;
		 Map<String, Object> tempMap;
		String map=ap.lgsByGame(dt.getGame());
		JSONObject jsonresultString = new JSONObject(map.toString());
		JSONArray dataArray = jsonresultString.getJSONArray("Ccg");
		JSONObject obj;
		JSONArray array;
		String lgs[] = null;
		for(int i=0;i<dataArray.length();i++)
		{	
		obj=dataArray.getJSONObject(i);
		array=obj.getJSONArray("Stages");
		obj=array.getJSONObject(i);
		lgs[i]=(String) obj.get("Sdn");
		}
	    System.out.println("data is: "+lgs);
	    //Iterator it=lgs;
	    //Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    System.out.println("iterator value");
	    modelAndView.addObject("list2",lgs);
		modelAndView.setViewName("LBG");
		return modelAndView;
	}
	@RequestMapping(value="/news", method=RequestMethod.GET)
	public ModelAndView newsget(ModelAndView modelAndView, data dt)
	{
		modelAndView.setViewName("news");
		return modelAndView;
	}
	@RequestMapping(value="/cktN", method=RequestMethod.GET)
	public ModelAndView crtnpost(ModelAndView modelAndView,data dt) throws IOException, InterruptedException
	{
	String map=ap.news("cricket");
	ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
    ArrayList<String> data=(ArrayList<String>)RecMap.get("arts");
    System.out.println("data is: "+data);
    Iterator it=data.iterator();
    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
    modelAndView.addObject("newsList",iterable);
    modelAndView.setViewName("news");
	return modelAndView;
	}
	@RequestMapping(value="/scrN", method=RequestMethod.GET)
	public ModelAndView scrnpost(ModelAndView modelAndView,data dt) throws IOException, InterruptedException
	{
	String map=ap.news("soccer");
	ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
    ArrayList<String> data=(ArrayList<String>)RecMap.get("arts");
    System.out.println("data is: "+data);
    Iterator it=data.iterator();
    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
    modelAndView.addObject("newsList",iterable);
    modelAndView.setViewName("news");
	return modelAndView;
	}
	@RequestMapping(value="/tnsN", method=RequestMethod.GET)
	public ModelAndView tnsnpost(ModelAndView modelAndView,data dt) throws IOException, InterruptedException
	{
	String map=ap.news("tennis");
	ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
    ArrayList<String> data=(ArrayList<String>)RecMap.get("arts");
    System.out.println("data is: "+data);
    Iterator it=data.iterator();
    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
    modelAndView.addObject("newsList",iterable);
    modelAndView.setViewName("news");
	return modelAndView;
	}
	@RequestMapping(value="/ftblN", method=RequestMethod.GET)
	public ModelAndView basketpost(ModelAndView modelAndView,data dt) throws IOException, InterruptedException
	{
	String map=ap.news("basketball");
	ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
    ArrayList<String> data=(ArrayList<String>)RecMap.get("arts");
    System.out.println("data is: "+data);
    Iterator it=data.iterator();
    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
    modelAndView.addObject("newsList",iterable);
    modelAndView.setViewName("news");
	return modelAndView;
	}
	@RequestMapping(value="/hkyN", method=RequestMethod.GET)
	public ModelAndView khynpost(ModelAndView modelAndView,data dt) throws IOException, InterruptedException
	{
	String map=ap.news("hockey");
	ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
    ArrayList<String> data=(ArrayList<String>)RecMap.get("arts");
    System.out.println("data is: "+data);
    Iterator it=data.iterator();
    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
    modelAndView.addObject("newsList",iterable);
    modelAndView.setViewName("news");
	return modelAndView;
	}
	/*@RequestMapping(value="/byDate", method=RequestMethod.GET)
	public ModelAndView bdget(data input,ModelAndView modelAndView)
	{
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/byDate", method=RequestMethod.POST)
	public ModelAndView bdpost(data input,ModelAndView modelAndView) throws IOException, InterruptedException, ParseException
	{
		String gm = input.getGame();
	String map=ap.bydate(input.getGame());
	System.out.println(gm);
	System.out.println("Methiod called");
	ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
    ArrayList<String> data=(ArrayList<String>)RecMap.get("Stages");
    Iterator it=data.iterator();
    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
    modelAndView.addObject("mList",iterable);
    modelAndView.setViewName("bydate");
	return modelAndView;
	}*/
	
	
	@RequestMapping(value="/lgbygm", method=RequestMethod.GET)
	public ModelAndView lgget(ModelAndView modelAndView, data dt)
	{
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/ckt", method=RequestMethod.GET)
	public ModelAndView csrget(ModelAndView modelAndView, data dt) throws IOException, InterruptedException
	{
		String map=ap.lgsByGame("cricket");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Ccg");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/scr", method=RequestMethod.GET)
	public ModelAndView scrget(ModelAndView modelAndView, data dt) throws IOException, InterruptedException
	{
		String map=ap.lgsByGame("soccer");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Ccg");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/ftbl", method=RequestMethod.GET)
	public ModelAndView ftblget(ModelAndView modelAndView, data dt) throws IOException, InterruptedException
	{
		String map=ap.lgsByGame("basketball");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Ccg");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/hky", method=RequestMethod.GET)
	public ModelAndView hkyget(ModelAndView modelAndView, data dt) throws IOException, InterruptedException
	{
		String map=ap.lgsByGame("hockey");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Ccg");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/tns", method=RequestMethod.GET)
	public ModelAndView tnsget(ModelAndView modelAndView, data dt) throws IOException, InterruptedException
	{
		String map=ap.lgsByGame("tennis");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Ccg");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("bydate");
		return modelAndView;
	}
	@RequestMapping(value="/live", method=RequestMethod.GET)
	public ModelAndView live(ModelAndView modelAndView, data dt)
	{
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
	@RequestMapping(value="/liveC", method=RequestMethod.GET)
	public ModelAndView lcget(ModelAndView modelAndView, data dt) throws IOException, InterruptedException
	{
		String map=ap.live("cricket");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Stages");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
	@RequestMapping(value="/liveB", method=RequestMethod.GET)
	public ModelAndView lbget(ModelAndView modelAndView, data dt) throws IOException, InterruptedException
	{
		String map=ap.live("basketball");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Stages");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
	@RequestMapping(value="/liveS", method=RequestMethod.GET)
	public ModelAndView lsget(ModelAndView modelAndView, data dt) throws IOException, InterruptedException
	{
		String map=ap.live("soccer");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Stages");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
	@RequestMapping(value="/liveT", method=RequestMethod.GET)
	public ModelAndView ltget(ModelAndView modelAndView, data dt) throws IOException, InterruptedException
	{
		String map=ap.live("tennis");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Stages");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
	@RequestMapping(value="/liveH", method=RequestMethod.GET)
	public ModelAndView lhget(ModelAndView modelAndView, data dt) throws IOException, InterruptedException
	{
		String map=ap.live("hockey");
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(map, Map.class);
	    ArrayList<String> stages=(ArrayList<String>)RecMap.get("Stages");
	    Iterator it=stages.iterator();
	    Iterable<Object> iterable = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0),false).collect(Collectors.toList());
	    modelAndView.addObject("mList",iterable);
		modelAndView.setViewName("livematch");
		return modelAndView;
	}
}
