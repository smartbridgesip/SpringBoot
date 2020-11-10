package com.hemlata.app.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hemlata.app.model.Balance;
import com.hemlata.app.model.Categories;
import com.hemlata.app.model.Expenses;
import com.hemlata.app.model.User;
import com.hemlata.app.repository.BalanceRepo;
import com.hemlata.app.repository.ExpensesRepo;
import com.hemlata.app.repository.UserRepository;
@Controller
public class ExpenseController {

	long loggedInUser;
@Autowired
private ExpensesRepo xrepo;
	

@Autowired
private UserRepository userRepository;

@Autowired
private BalanceRepo balrepo;
	
BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
int baltot=0;
@RequestMapping(value="/", method=RequestMethod.GET)
public String dispform(ModelAndView modelAndView,Expenses exp)
{
	//System.out.println(xrepo.catWiseamts().spliterator());
	modelAndView.setViewName("home");
	return "redirect:/login";
}




@RequestMapping(value="/register", method=RequestMethod.GET)
public ModelAndView displayRegistration(ModelAndView modelAndView, User user) {
	modelAndView.addObject("user", user);
	modelAndView.setViewName("register");
	return modelAndView;
}


@RequestMapping(value="/register", method=RequestMethod.POST)
public String registerUser(ModelAndView modelAndView, User user) {
	String path = null;
	String email=user.getEmailId();
	System.out.println(email);
	User existingUser = userRepository.findByEmailIdIgnoreCase(email);
	if(existingUser != null) {
		modelAndView.addObject("message","This email already exists!");
		modelAndView.setViewName("error");
	} else {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		//sendEmail(user.getEmailId());
		modelAndView.addObject("emailId", user.getEmailId());
		 path="redirect:/login";
	}
	
	return path;
}

@RequestMapping(value="/login", method=RequestMethod.GET)
public ModelAndView displayLogin(ModelAndView modelAndView, User user) {
	modelAndView.addObject("user", user);
	modelAndView.setViewName("login");
	return modelAndView;
}
@RequestMapping(value="/login", method=RequestMethod.POST)
public ModelAndView loginUser(ModelAndView modelAndView, User user) {
	String email=user.getEmailId();
	User existingUser = userRepository.findByEmailIdIgnoreCase(email);
	System.out.println(existingUser);
	if(existingUser != null) {
		if (encoder.matches(user.getPassword(), existingUser.getPassword())){
			// successfully logged in
			loggedInUser=existingUser.getUserid();
			System.out.println("user id: "+loggedInUser);
			modelAndView.addObject("message", "You Have Successfully Logged into Expense tracker Application!");
			modelAndView.setViewName("loggedInHome");
		} else {
			// wrong password
			modelAndView.addObject("message", "Incorrect password. Try again.");
			modelAndView.setViewName("login");
		}
	} else {	
		modelAndView.addObject("message", "The email provided does not exist!");
		modelAndView.setViewName("login");
	}	
	return modelAndView;
}


@RequestMapping(value="/logout", method=RequestMethod.GET)
public ModelAndView displayLogout(ModelAndView modelAndView, com.hemlata.app.model.User user) {
	modelAndView.addObject("user", user);
	modelAndView.setViewName("login");
	return modelAndView;
}

@RequestMapping(value="/loginSuccess", method=RequestMethod.GET)
public ModelAndView loginSoccess(ModelAndView modelAndView)
{
	modelAndView.setViewName("LoggedInHome");
	return modelAndView;
}

@RequestMapping(value="/addXpense", method=RequestMethod.GET)
public ModelAndView showAddXpense(ModelAndView modelAndView, Expenses xpense, Categories cats) {
	modelAndView.addObject("xpense", xpense);
	//modelAndView.addObject("categories", catrepo.findAll());
	modelAndView.setViewName("addXpense");
	return modelAndView;
}
@RequestMapping(value="/addXpense", method=RequestMethod.POST)
public String addXpense(ModelAndView modelAndView,Expenses xpense,Balance balance) {
	try {
		if((xpense.getAmount())>(balrepo.Balsum(loggedInUser)))
		{
			modelAndView.addObject("message","Your balance is low you can't spend money!!!");
			modelAndView.setViewName("viewXpense");
		}
		else
		{
			xpense.setLogged(loggedInUser);
			xrepo.save(xpense);
			balance.setBal(-(xpense.getAmount()));
			balrepo.save(balance);
			modelAndView.addObject("message","Expenses Added Suceesfully");
			modelAndView.setViewName("viewXpense");
		}
	}
	catch(Exception e)
	{
		modelAndView.addObject("message", e.getMessage());
		modelAndView.setViewName("AddMoney");
	}
	 return "redirect:/ViewXpense";
}

	
@RequestMapping(value="/ViewXpense", method=RequestMethod.GET)
public ModelAndView viewXpense(ModelAndView modelAndView, Expenses xpense) {
	//donorRepository.findAll();
	/*int sum= xrepo.amountsum();
	modelAndView.addObject("totalXpense", sum);
	modelAndView.addObject("xpenses", xrepo.findAll());
	modelAndView.setViewName("ViewXpense");*/
	try{
		//modelAndView.addObject("xpenses", xrepo.findAll());
		System.out.println(loggedInUser);
		modelAndView.addObject("xpenses", xrepo.xpensesbylogin(loggedInUser));
		modelAndView.setViewName("viewXpense");
	}
	catch(Exception e)
	{
		modelAndView.addObject("message", e.getMessage());
		modelAndView.setViewName("loggedinHome");
	}
	return modelAndView;
}


@RequestMapping(value="/AddMoney", method=RequestMethod.GET)
public ModelAndView addMoney(ModelAndView modelAndView, Balance balance) {
	try{
		modelAndView.addObject("balance", balance);
	modelAndView.setViewName("AddMoney");
	}
	catch(Exception e)
	{
		modelAndView.addObject("message", e.getMessage());
		modelAndView.setViewName("loggedinHome");
	}
	return modelAndView;
}

@RequestMapping(value="/AddMoney", method=RequestMethod.POST)
public ModelAndView saveMoney(ModelAndView modelAndView,Balance balance) {
	try {
		balance.setBallog(loggedInUser);
		balrepo.save(balance);
		modelAndView.addObject("message","You have successfully added money to your wallet!!");
		modelAndView.setViewName("AddMoney");
		
	}
	catch(Exception e)
	{
		modelAndView.addObject("message", e.getMessage());
		modelAndView.setViewName("AddMoney");
	}
	return modelAndView;
}

@RequestMapping(value="/viewBalance", method=RequestMethod.GET)
public ModelAndView viewbalance(ModelAndView modelAndView, Balance balance) {
	//donorRepository.findAll();
	modelAndView.addObject("totalbalance", balrepo.Balsum(loggedInUser));
	modelAndView.setViewName("ViewBalance");
	try{
		baltot=balrepo.Balsum(loggedInUser);
		modelAndView.addObject("tbal", baltot);
		modelAndView.setViewName("viewBalance");
	}
	catch(Exception e)
	{
		modelAndView.addObject("message", e.getMessage());
		modelAndView.setViewName("loggedinHome");
	}
	return modelAndView;
}

@RequestMapping("/delete/{id}")
public String delete(@PathVariable Integer id){
    xrepo.deleteById(id);
    return "redirect:/ViewXpense";
}




@GetMapping("/viewXpenseAnalysis")
public ModelAndView viewCharts(ModelAndView modelAndView,Expenses xpense) {
	modelAndView.setViewName("ViewXpenseAnalysis");
	return modelAndView;
}
@GetMapping("/CatWiseGraph")
public ModelAndView CatWiseGraph(ModelAndView modelAndView,Expenses xpense) {
	modelAndView.setViewName("CatWiseGraph.html");
	return modelAndView;
}
@GetMapping("/Last7DaysGraph")
public ModelAndView Last7DaysGraph(ModelAndView modelAndView,Expenses xpense) {
	modelAndView.setViewName("Last7DaysGraph");
	return modelAndView;
}
@GetMapping("/MonthlyGraph")
public ModelAndView MonthlyGraph(ModelAndView modelAndView,Expenses xpense) {
	modelAndView.setViewName("MonthlyGraph");
	return modelAndView;
}
@GetMapping("/YearWiseGraph")
public ModelAndView YearWiseGraph(ModelAndView modelAndView,Expenses xpense) {
	modelAndView.setViewName("YearWiseGraph");
	return modelAndView;
}

@GetMapping("/CatWiseGraph/data")
public  ResponseEntity<Map<String, Integer>> getPieChart(ModelAndView modelAndView) {
	int amts[];
	String allcts[];
	amts=xrepo.catWiseamts(loggedInUser);
	allcts=xrepo.cats(loggedInUser);
	Map<String, Integer> graphData = new TreeMap<>();
	System.out.println(xrepo.cats(loggedInUser).length);
    for(int i=0;i<xrepo.cats(loggedInUser).length;i++)
	{graphData.put(allcts[i], amts[i]);
    System.out.println(graphData);}    
    modelAndView.addObject("chartData",graphData);
    modelAndView.addObject("cnt",xrepo.count());
    modelAndView.setViewName("bargraph");
	return  new ResponseEntity<>(graphData, HttpStatus.OK);	
}
@GetMapping("/YearWiseGraph/data")
public  ResponseEntity<Map<String, Integer>> YearWiseGraphData(ModelAndView modelAndView) {
	int amts[];
	String years[];
	amts=xrepo.yearWiseTotal(loggedInUser);
	years=xrepo.Getyears(loggedInUser);
	Map<String, Integer> graphData = new TreeMap<>();
	System.out.println(xrepo.cats(loggedInUser).length);
    for(int i=0;i<amts.length;i++)
	{ graphData.put(years[i], amts[i]);
    System.out.println(graphData);}    
    modelAndView.addObject("chartData",graphData);
    modelAndView.addObject("cnt",xrepo.count());
    modelAndView.setViewName("bargraph");
	return  new ResponseEntity<>(graphData, HttpStatus.OK);
}
@GetMapping("/MonthWiseGraph/data")
public  ResponseEntity<Map<String, Integer>> MonthWiseGraphData(ModelAndView modelAndView) {
	int amts[];
	String months[];
	amts=xrepo.monthWiseTotal(loggedInUser);
	months=xrepo.GetMonths(loggedInUser);
	Map<String, Integer> graphData = new TreeMap<>();
	System.out.println(xrepo.cats(loggedInUser).length);
    for(int i=0;i<months.length;i++)
	{
    graphData.put(months[i], amts[i]);
    System.out.println(graphData);}    
    modelAndView.addObject("chartData",graphData);
    modelAndView.addObject("cnt",xrepo.count());
    modelAndView.setViewName("bargraph");
	return  new ResponseEntity<>(graphData, HttpStatus.OK);
}
@GetMapping("/Last7DaysGraph/data")
public  ResponseEntity<Map<String, Integer>> Last7DaysGraphData(ModelAndView modelAndView) {
	int amts[];
	String weekDates[];
	amts=xrepo.getWeeklyTotal();
	weekDates=xrepo.getWeekDates();
	Map<String, Integer> graphData = new TreeMap<>();
    for(int i=0;i<amts.length;i++)
	{
    graphData.put(weekDates[i], amts[i]);
    System.out.println(graphData);
	}    
    modelAndView.addObject("chartData",graphData);
    modelAndView.addObject("cnt",xrepo.count());
    modelAndView.setViewName("bargraph");
	return  new ResponseEntity<>(graphData, HttpStatus.OK);
}

}

