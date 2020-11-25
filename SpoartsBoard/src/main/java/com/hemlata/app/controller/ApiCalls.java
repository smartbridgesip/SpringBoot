package com.hemlata.app.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ApiCalls {
	public String lgsByGame(String game) throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://livescore6.p.rapidapi.com/leagues/v2/list?Category="+game))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "livescore6.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String news(String game) throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://livescore6.p.rapidapi.com/news/list?category="+game))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "livescore6.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String live(String game) throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://livescore6.p.rapidapi.com/matches/v2/list-live?Category="+game))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "livescore6.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
}
