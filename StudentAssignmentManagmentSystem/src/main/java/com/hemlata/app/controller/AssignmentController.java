package com.hemlata.app.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hemlata.app.model.Assignment;
import com.hemlata.app.model.Document;
import com.hemlata.app.model.DocumentSubmit;
import com.hemlata.app.model.Instructor;
import com.hemlata.app.model.Student;
import com.hemlata.app.payload.Response;
import com.hemlata.app.repository.AssignmentRepository;
import com.hemlata.app.repository.InstructorRepository;
import com.hemlata.app.repository.StudentReposiotry;
import com.hemlata.app.repository.subRepo2;

@Controller
public class AssignmentController {
	long currId;
	long curRoll;
	long loggedInUser;
	Date dueDate;
	@Autowired
	private InstructorRepository insRepo;
	
	@Autowired
	private StudentReposiotry studRepo;
	
	@Autowired
	private AssignmentRepository assRepo;
	@Autowired
	private subRepo2 srepo;

BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView dispform(ModelAndView modelAndView)
	{
		modelAndView.setViewName("index");
		return modelAndView;
	}
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView dishome(ModelAndView modelAndView)
	{
		modelAndView.setViewName("index");
		return modelAndView;
	}
	@RequestMapping(value="/regIns", method=RequestMethod.GET)
	public ModelAndView dispRegIns(ModelAndView modelAndView,Instructor ins)
	{
		modelAndView.addObject("ins",ins);
		modelAndView.setViewName("RegIns");
		return modelAndView;
	}
	@RequestMapping(value="/regIns", method=RequestMethod.POST)
	public ModelAndView registerUser(ModelAndView modelAndView, Instructor ins) {
		String path = null;
		String email=ins.getEmailId();
		System.out.println(email);
		Instructor existingUser = insRepo.findByEmailIdIgnoreCase(email);
		if(existingUser != null) {
			modelAndView.addObject("message","This email already exists!");
			modelAndView.addObject("ins", ins);
			modelAndView.setViewName("RegIns");
		} else {
			ins.setPass(encoder.encode(ins.getPass()));
			insRepo.save(ins);
			//sendEmail(user.getEmailId());
			modelAndView.addObject("ins", ins);
			modelAndView.setViewName("index");
			modelAndView.addObject("message","Registration Succesfull!!!!");
		}

		return modelAndView;
	}
	
	@RequestMapping(value="/regStud", method=RequestMethod.GET)
	public ModelAndView dispRegStud(ModelAndView modelAndView,Student stud )
	{
		modelAndView.addObject("stud",stud);
		modelAndView.setViewName("RegStud");
		return modelAndView;
	}
	@RequestMapping(value="/regStud", method=RequestMethod.POST)
	public ModelAndView regStud(ModelAndView modelAndView,Student stud) {
		String path = null;
		String email=stud.getEmailId();
		System.out.println(email);
		Student existingUser =studRepo.findByEmailIdIgnoreCase(email);
		if(existingUser != null) {
			modelAndView.addObject("message","This email already exists!");
			modelAndView.addObject("stud", stud);
			modelAndView.setViewName("RegStud");
		} else {
			stud.setPass(encoder.encode(stud.getPass()));
			studRepo.save(stud);
			//sendEmail(user.getEmailId());
			modelAndView.addObject("emailId", stud.getEmailId());
			modelAndView.addObject("stud", stud);
			modelAndView.setViewName("index");
			modelAndView.addObject("message","Registration Succesfull!!!!");
			  
		}
		
		return modelAndView;
	}
@RequestMapping(value="/loginIns", method=RequestMethod.GET)
public ModelAndView displayLogin(ModelAndView modelAndView, Instructor ins) {
	modelAndView.addObject("ins", ins);
	modelAndView.setViewName("loginIns");
	return modelAndView;
}


@RequestMapping(value="/loginIns", method=RequestMethod.POST)
public ModelAndView displayloginIns(ModelAndView modelAndView,Instructor ins) {
	String email=ins.getEmailId();
	Instructor existingUser = insRepo.findByEmailIdIgnoreCase(email);
	System.out.println(existingUser);
	if(existingUser != null) {
		// use encoder.matches to compare raw password with encrypted password

		if (encoder.matches(ins.getPass(), existingUser.getPass())){
			// successfully logged in
			loggedInUser=existingUser.getInstId();
			System.out.println("user id: "+loggedInUser);
			String msg="Welcome !! "+ existingUser.getFname()+ " " + existingUser.getLname();
			modelAndView.addObject("message", msg);
			modelAndView.setViewName("loggedInIns");
		} else {
			// wrong password
			modelAndView.addObject("message", "Incorrect password. Try again.");
			modelAndView.addObject("ins", ins);
			modelAndView.setViewName("LoginIns");
		}
	} else {	
		modelAndView.addObject("message", "The email provided does not exist!");
		modelAndView.addObject("ins", ins);
		modelAndView.setViewName("LoginIns");
	}
	
	return modelAndView;
}

@RequestMapping(value="/loginStud", method=RequestMethod.GET)
public ModelAndView loginStud(ModelAndView modelAndView,Student stud) {
	modelAndView.addObject("stud", stud);
	modelAndView.setViewName("loginStud");
	return modelAndView;
}


@RequestMapping(value="/loginStud", method=RequestMethod.POST)
public ModelAndView StudPost(ModelAndView modelAndView,Student stud) {
	String email=stud.getEmailId();
	Student existingUser = studRepo.findByEmailIdIgnoreCase(email);
	System.out.println(existingUser);
	if(existingUser != null) {
		// use encoder.matches to compare raw password with encrypted password

		if (encoder.matches(stud.getPass(), existingUser.getPass())){
			// successfully logged in
			loggedInUser=existingUser.getRoll();
			System.out.println("Student roll number: "+loggedInUser);
			curRoll=existingUser.getRoll();
			modelAndView.addObject("message", existingUser.getFname()+"!!  Successfully Logged in");
			modelAndView.setViewName("loggedInStud");
		} else {
			// wrong password
			modelAndView.addObject("message", "Incorrect password. Try again.");
			modelAndView.addObject("stud", stud);
			modelAndView.setViewName("loginStud");
		}
	} else {	
		modelAndView.addObject("message", "The email provided does not exist!");
		modelAndView.addObject("stud",stud);
		modelAndView.setViewName("loginStud");
	}
	return modelAndView;
}


@RequestMapping(value="/logout", method=RequestMethod.GET)
public ModelAndView displayLogout(ModelAndView modelAndView) {
	modelAndView.setViewName("home");
	loggedInUser= 0; 
	return modelAndView;
}
@RequestMapping(value="/uploadNewAss", method=RequestMethod.GET)
public ModelAndView uploadAss(ModelAndView modelAndView,Assignment ass) {
	modelAndView.addObject("ass", ass);
	modelAndView.setViewName("uploadAss");
	return modelAndView;}
@RequestMapping(value="/uploadNewAss", method=RequestMethod.POST)
public String saveAss(ModelAndView modelAndView,Assignment ass) {
	assRepo.save(ass);
	currId= ass.getAssID();
	dueDate=ass.getDueDate();
	System.out.println("currently ass id "+ currId);
	modelAndView.addObject("ass", ass);
	modelAndView.addObject("message", "Assignment Data Saved Succesfully!! proceed to upload assignment question");
	modelAndView.setViewName("uploadAss");
	return "redirect:/homeDoc";
}
@Autowired 
com.hemlata.app.repository.DocRepo drepo;
@GetMapping("/homeDoc")
public String home(Model model)
{Iterable<com.hemlata.app.model.Document> listDocs=drepo.findAll();
	model.addAttribute("listDocs",listDocs);
	return "home";}
@PostMapping("/upload")
public String uploadFile(@RequestParam("document") MultipartFile multipartfile, RedirectAttributes ra)
{
	String fileName = StringUtils.cleanPath( multipartfile.getOriginalFilename());
	com.hemlata.app.model.Document document = new com.hemlata.app.model.Document();
	document.setId(currId);
	document.setStatus("pending");
	document.setDueDate((java.sql.Date) dueDate);
	try {
		document.setNAme(fileName);
		document.setContent((multipartfile.getBytes()));
		document.setSize(multipartfile.getSize());
		drepo.save(document);		
	} catch (IOException e) {e.printStackTrace();}
	ra.addFlashAttribute("message","file has been uploaded succesfully");
	 return "redirect:/uploadNewAss";}

@RequestMapping(value="/penAss", method=RequestMethod.GET)
public ModelAndView penAss(ModelAndView modelAndView,Assignment ass) {
	//modelAndView.addObject("assignments", assRepo.findAll());

	Iterable<com.hemlata.app.model.Document> listDocs=drepo.findAll();
	//Iterable<com.hemlata.app.model.Document> listDocs=drepo.findbylogger(curRoll);
	modelAndView.addObject("listDocs",listDocs);
	modelAndView.setViewName("penAss");
	return modelAndView;
}

@RequestMapping(value="/ViewResp", method=RequestMethod.GET)
public ModelAndView ViewResp(ModelAndView modelAndView) {
	Iterable<com.hemlata.app.model.DocumentSubmit> listDocs=srepo.findAll();
	modelAndView.addObject("listDocs",listDocs);
	modelAndView.setViewName("viewRes");
	return modelAndView;
}

@RequestMapping(value="/submitAss", method=RequestMethod.GET)
public ModelAndView subAss(ModelAndView modelAndView, DocumentSubmit ds) {
	modelAndView.addObject("ds",ds);
	modelAndView.setViewName("subAssHome");
	return modelAndView;
}
@RequestMapping(value="/submitAss", method=RequestMethod.POST)
public String submitAss(ModelAndView modelAndView, DocumentSubmit ds,@RequestParam("document") MultipartFile multipartfile, RedirectAttributes ra) throws ParseException {
	/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now(); 
	String curDate;
	curDate=dtf.format(now);
	System.out.println(curDate);
	Date date=new SimpleDateFormat("dd/MM/yyyy").parse(curDate);
//	System.out.println(sDate1+"\t"+date1);*/
	//java.sql.Date date=(java.sql.Date) new Date();
	String fileName = StringUtils.cleanPath( multipartfile.getOriginalFilename());
	DocumentSubmit documentS = new DocumentSubmit();
	documentS.setId(curRoll);
	System.out.println(documentS.getAssId());
	System.out.println(ds.getAssId());
	documentS.setAssId(ds.getAssId());
	documentS.setUploadedDate(srepo.getCurDate());
	drepo.updateStatus(ds.getAssId(),"submiited");
	try {
		
		documentS.setNAme(fileName);
		documentS.setContent((multipartfile.getBytes()));
		documentS.setSize(multipartfile.getSize());
		//document.setUpload_Time((java.sql.Date) new Date());
		srepo.save(documentS);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	ra.addFlashAttribute("message","file has been uploaded succesfully");
	 return "redirect:/penAss";
}


@GetMapping("/download")
public void downloadFile(@Param("id") long id,HttpServletResponse response) throws Exception {
	Optional<com.hemlata.app.model.Document> result= drepo.findById(id);
	if(!result.isPresent())
	{
		throw new Exception("Could not find attachment ");
	}
	com.hemlata.app.model.Document document=result.get();
	response.setContentType("application/octet-stream");
	String headerKey = "Content-Disposition";
	String hraderValue = "attachment; filename="+ document.getNAme();
	response.setHeader(headerKey, hraderValue);
	ServletOutputStream outstream = response.getOutputStream();
	outstream.write(document.getContent());
	outstream.close();
}
}
