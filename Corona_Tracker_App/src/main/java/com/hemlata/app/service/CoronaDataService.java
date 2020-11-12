package com.hemlata.app.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hemlata.app.models.LocationStats;
//import com.hemlata.app.repos.repos;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class CoronaDataService {
	
	
	static String ydate() {
//String yestD=null; 
		
		//variable to store date in string format
		//String yesterdayDate=null; 
		String datey=null;
		int yday;
		String ymon;
		String yyear;
		//to get calendar instance 
		Calendar cal = Calendar.getInstance();
		
		//subtract 1 from calendar current date 
		//cal.add(Calendar.DATE, -1);
		
		//format date
		DateFormat dateFormat = new SimpleDateFormat("dd");
		
		//get formatted date
		datey=dateFormat.format(cal.getTime());
		yday=Integer.parseInt(datey);
		yday=yday-1;
		
DateFormat datemon = new SimpleDateFormat("mm");
		//get formatted date
		ymon=datemon.format(cal.getTime());
		
		
DateFormat dateyear = new SimpleDateFormat("yyyy");
		
		//get formatted date
		yyear=dateyear.format(cal.getTime());
		
		datey=Integer.toString(yday);
		List<String> vallist = Arrays.asList("09",datey,yyear);
		String ydate = String.join("-",vallist);
		System.out.println("Yesterday's date = "+ ydate);
		return ydate;
	}
	static String name_url="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/";
	static String yd=ydate();
	static List<String> valuesList = Arrays.asList(name_url,yd,".csv");
	static String complete_url = String.join("",valuesList);
	
	//public static final repos reps = null;
    private static String VIRUS_DATA_URL =complete_url;
    		private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse);
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.get("Province_State"));
            locationStat.setCountry(record.get("Country_Region"));
           locationStat.setCc(Integer.parseInt(record.get("Confirmed")));
            locationStat.setDc(Integer.parseInt(record.get("Deaths")));
            locationStat.setRc(Integer.parseInt(record.get("Recovered")));
          //  locationStat.setAc(Integer.parseInt(record.get("Active")));
            
            ////int latestCases = Integer.parseInt(record.get(record.size() - 1));
           // int prevDayCases = Integer.parseInt(record.get(record.size() - 2));
           // locationStat.setLatestTotalCases(latestCases);
           // locationStat.setDiffFromPrevDay(latestCases - prevDayCases);
            newStats.add(locationStat);
        }
        this.allStats = newStats;
    }

}
