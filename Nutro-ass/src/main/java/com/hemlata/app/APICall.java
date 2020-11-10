package com.hemlata.app;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APICall {
	public String data(String query) throws InterruptedException, IOException
	{

		String encoded=URLEncoder.encode(query,"UTF-8").replace("+", "%20");
		String url="https://rapidapi.p.rapidapi.com/recipes/quickAnswer?q="+encoded;
		System.out.println("Enecoded query: "+encoded);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	
	return response.body();
	}
	public String Joke() throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://rapidapi.p.rapidapi.com/food/jokes/random"))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	
	return response.body();
	}
	public String trivia() throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://rapidapi.p.rapidapi.com/food/trivia/random"))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String recipeByCal(int cals) throws IOException, InterruptedException
	{
		String url="https://rapidapi.p.rapidapi.com/recipes/mealplans/generate?targetCalories="+cals+"&timeFrame=day";
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
		
	}
	public String convertAmount(String a,String b,String c, float d) throws IOException, InterruptedException
	{

		String url="https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/convert?ingredientName="+a+"&targetUnit="+b+"&sourceUnit="+c+"&sourceAmount="+d;
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(url))
			.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
			.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
			.method("GET", HttpRequest.BodyPublishers.noBody())
			.build();
	HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	System.out.println(response.body());
	return response.body();
	}
	
	public String nutByDish(String name) throws IOException, InterruptedException
	{
		String encoded=URLEncoder.encode(name,"UTF-8").replace("+", "%20");
		String url="https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/guessNutrition?title="+encoded;
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(url))
			.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
			.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
			.method("GET", HttpRequest.BodyPublishers.noBody())
			.build();
	HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	System.out.println(response.body());
	return response.body();
	}
}
