package com.hemlata.app.Controller;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemlata.app.Model.Phrase;
import com.hemlata.app.Repository.PhraseRepo;

@Controller
public class controller {
	String word;
	//ApiCalls ap=new ApiCalls(); //create object of the ApiCall.java class to access methods inside it
	ApiCalls ap=new ApiCalls();
	@Autowired
	PhraseRepo repo;
	@GetMapping("/") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView home(ModelAndView modelAndView)
	{
		modelAndView.setViewName("index");
		return modelAndView;
	}
	@GetMapping("/WP") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView WPgethome(ModelAndView modelAndView, Phrase inp)
	{
		modelAndView.addObject("inp",inp);
		modelAndView.setViewName("wordHome");
		return modelAndView;
	}
	@PostMapping("/WP") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView WPposthome(ModelAndView modelAndView, Phrase inp)
	{
		word=inp.getWord().toLowerCase();
		modelAndView.addObject("word",word);
		modelAndView.addObject("inp",inp);
		modelAndView.setViewName("wordHomePost");
		return modelAndView;
	}
	
	@GetMapping("/syns") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView synshome(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		modelAndView.addObject("word",word);
		String synss=ap.synd(word);
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(synss, Map.class);
	  //  Map<String, Object> slist=(Map<String, Object>) RecMap.get("synonyms");
	    ArrayList<String> slist=(ArrayList<String>)RecMap.get("synonyms");
	    modelAndView.addObject("slist",slist);
		modelAndView.setViewName("syns");
		return modelAndView;
	}
	@GetMapping("/ants") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView antshome(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		modelAndView.addObject("word",word);
		String synss=ap.ants(word);
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(synss, Map.class);
	  //  Map<String, Object> slist=(Map<String, Object>) RecMap.get("synonyms");
	    ArrayList<String> alist=(ArrayList<String>)RecMap.get("antonyms");
	    modelAndView.addObject("alist",alist);
		modelAndView.setViewName("ants");
		return modelAndView;
	}
	@GetMapping("/defs") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView defshome(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		modelAndView.addObject("word",word);
		String synss=ap.defs(word);
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(synss, Map.class);
	  //  Map<String, Object> slist=(Map<String, Object>) RecMap.get("synonyms");
	    ArrayList<String> list=(ArrayList<String>)RecMap.get("definitions");
	    Iterator dlistt=list.iterator(); //convert map to iterable object
	    Iterable<Object> dlist = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(dlistt, 0),false).collect(Collectors.toList());
	    
	    modelAndView.addObject("dlist",dlist);
		
		modelAndView.setViewName("defs");
		return modelAndView;
	}
	@GetMapping("/egs") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView egshome(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		modelAndView.addObject("word",word);
		String synss=ap.egs(word);
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(synss, Map.class);
	  //  Map<String, Object> slist=(Map<String, Object>) RecMap.get("synonyms");
	    ArrayList<String> list=(ArrayList<String>)RecMap.get("examples");
	    Iterator elistt=list.iterator(); //convert map to iterable object
	    Iterable<Object> elist = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(elistt, 0),false).collect(Collectors.toList());
	    
	    modelAndView.addObject("elist",elist);
		
		modelAndView.setViewName("egs");
		return modelAndView;
	}
	@GetMapping("/rhs") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView rhshome(ModelAndView modelAndView) throws IOException, InterruptedException
	{
		modelAndView.addObject("word",word);
		String synss=ap.rhs(word);
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(synss, Map.class);
	  Map<String, Object> rhmap=(Map<String, Object>) RecMap.get("rhymes");
	    ArrayList<String> list=(ArrayList<String>)rhmap.get("all");
	    Iterator rlistt=list.iterator(); //convert map to iterable object
	    Iterable<Object> rlist = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(rlistt, 0),false).collect(Collectors.toList());
	    
	    modelAndView.addObject("rlist",rlist);
	
		modelAndView.setViewName("rhs");
		return modelAndView;
	}
	
	
	@GetMapping("/TP") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView TPgethome(ModelAndView modelAndView, Phrase inp)
	{
		modelAndView.addObject("inp",inp);
		modelAndView.setViewName("textHome");
		return modelAndView;
	}
	@GetMapping("/EP") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView EPgethome(ModelAndView modelAndView, Phrase inp)
	{
		modelAndView.addObject("inp",inp);
		modelAndView.setViewName("pext");
		return modelAndView;
	}
	@PostMapping("/EP") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView EPposthome(ModelAndView modelAndView, Phrase inp) throws IOException, InterruptedException
	{
		
		String text=inp.getText();
		System.out.println("text is: "+text);
		String jstring=ap.pext(text);
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(jstring, Map.class);
	    ArrayList<String> list=(ArrayList<String>)RecMap.get("NP");
	    Iterator rlistt=list.iterator(); //convert map to iterable object
	    Iterable<Object> pext = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(rlistt, 0),false).collect(Collectors.toList());
	    
	    modelAndView.addObject("pext",pext);
		modelAndView.addObject("inp",inp);
		modelAndView.setViewName("pext");
		return modelAndView;
	}
	@GetMapping("/ST") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView STgethome(ModelAndView modelAndView, Phrase inp)
	{
		modelAndView.addObject("inp",inp);
		modelAndView.setViewName("stem");
		return modelAndView;
	}
	@PostMapping("/ST") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView STposthome(ModelAndView modelAndView, Phrase inp) throws IOException, InterruptedException
	{
		
		String text=inp.getText();
		System.out.println("text is: "+text);
		String jstring=ap.stem(text);
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(jstring, Map.class);
	    String stext=(String) RecMap.get("text");
	    modelAndView.addObject("stext",stext);
		modelAndView.addObject("inp",inp);
		modelAndView.setViewName("stem");
		return modelAndView;
	}
	@GetMapping("/TS") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView TSgethome(ModelAndView modelAndView, Phrase inp)
	{
		modelAndView.addObject("inp",inp);
		modelAndView.setViewName("sentm");
		return modelAndView;
	}
	@PostMapping("/TS") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView TSposthome(ModelAndView modelAndView, Phrase inp) throws IOException, InterruptedException
	{
		
		String text=inp.getText();
		System.out.println("text is: "+text);
		String jstring=ap.sentm(text);
		ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> RecMap=mapper.readValue(jstring, Map.class);
	    Map<String, Object> prob=(Map<String, Object>) RecMap.get("probability");
	    String nutr=prob.get("neutral").toString();
	    String pos= prob.get("pos").toString();
	    String neg=prob.get("neg").toString();
	    modelAndView.addObject("nut",nutr);
	    modelAndView.addObject("pos",pos);
	    modelAndView.addObject("neg",neg);
		modelAndView.addObject("inp",inp);
		modelAndView.setViewName("sentm");
		return modelAndView;
	}
	@GetMapping("/DL") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView DLgethome(ModelAndView modelAndView, Phrase inp)
	{
		modelAndView.addObject("inp",inp);
		modelAndView.setViewName("dl");
		return modelAndView;
	}
	langCode lg=new langCode();
	@PostMapping("/DL") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView DLposthome(ModelAndView modelAndView, Phrase inp) throws IOException, InterruptedException
	{
		
		String text=inp.getText();
		System.out.println("text is: "+text);
		String jstring=ap.dl(text);
	   // JSONObject obj_JSONObject = new JSONObject(jstring);
	   // String lang1= ( obj_JSONObject.get("language")).toString();
	   // JSONObject obj_JSONObjectArray = obj_JSONArray.getJSONObject(0);
	   // String lang1=(obj_JSONObjectArray.getJSONObject("language")).toString();
	   JSONArray js=new JSONArray(jstring);
	   JSONObject obj=(JSONObject) js.get(0);
	   String str=obj.get("language").toString();
		//ObjectMapper mapper = new ObjectMapper();
	    //Map<String, Object> RecMap=mapper.readValue(jstring, Map.class);
	    //Map<String, Object> prob=(Map<String, Object>) RecMap.get("0");
	   // String lang1=(prob.get("language")).toString();
	   String lang=lg.codes(str);
	    System.out.println("lang is "+lang);
	    modelAndView.addObject("lang",lang);

		modelAndView.addObject("inp",inp);
		modelAndView.setViewName("dl");
		return modelAndView;
	}
}
