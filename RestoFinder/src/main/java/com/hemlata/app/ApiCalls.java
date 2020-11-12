package com.hemlata.app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiCalls {
	public void data() throws IOException, InterruptedException
	{
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://us-restaurant-menus.p.rapidapi.com/restaurants/search/geo?lon=-73.992378%09&lat=40.68919&distance=1&page=1"))
			.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
			.header("x-rapidapi-host", "us-restaurant-menus.p.rapidapi.com")
			.method("GET", HttpRequest.BodyPublishers.noBody())
			.build();
	HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	System.out.println(response.body());
	JSONObject obj_JSONObject = new JSONObject(response.body().toString());
	JSONObject obj_JSONObject2 = new JSONObject(obj_JSONObject.get("result").toString());
    JSONArray obj_JSONArray = obj_JSONObject2.getJSONArray("data");
    System.out.println(obj_JSONArray);
    System.out.println("--" + obj_JSONArray.length());
    JSONObject obj_JSONObjectArray = obj_JSONArray.getJSONObject(5);
    JSONObject obj=obj_JSONObjectArray.getJSONObject("geo");
    System.out.println("--element 5---");
    System.out.println(obj_JSONObjectArray);
    System.out.println("--geo 5");
    System.out.println(obj);
	}
	JSONObject mainString;
	JSONObject jsonresultString;
	JSONArray dataArray ;
	public String byzip(long zip) throws IOException, InterruptedException
	{
		String url="https://us-restaurant-menus.p.rapidapi.com/restaurants/zip_code/"+zip+"?page=1";
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "us-restaurant-menus.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		//System.out.println(response.body());
		mainString = new JSONObject(response.body().toString());
		jsonresultString = new JSONObject(mainString.get("result").toString());
		dataArray = jsonresultString.getJSONArray("data");
		
		return response.body();
	}
	public String bystate(String state) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String url="https://us-restaurant-menus.p.rapidapi.com/restaurants/state/"+state+"?page=1";
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "us-restaurant-menus.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String munus(int id)throws IOException, InterruptedException
	{
		String url="https://us-restaurant-menus.p.rapidapi.com/restaurant/"+id+"/menuitems?page=1";
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "us-restaurant-menus.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
}

