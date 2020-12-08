package com.hemlata.app.Controller;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class ApiCalls {
	
	//API Call to get leagues of the different games
	public String word(String word) throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/"+word))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	
	public String synd(String word) throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/"+word+"/synonyms"))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String ants(String word) throws IOException, InterruptedException
	{
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/"+word+"/antonyms"))
			.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
			.header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
			.method("GET", HttpRequest.BodyPublishers.noBody())
			.build();
	HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	System.out.println(response.body());
	return response.body();
	}
	public String defs(String word) throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/"+word+"/definitions"))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String egs(String word) throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/"+word+"/examples"))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String rhs(String word) throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/"+word+"/rhymes"))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String pext(String text) throws IOException, InterruptedException
	{
		String encoded=URLEncoder.encode(text,"UTF-8").replace("+", "%20");
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://japerk-text-processing.p.rapidapi.com/phrases/"))
				.header("content-type", "application/x-www-form-urlencoded")
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "japerk-text-processing.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString("text="+encoded+"&language=english"))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String stem(String text) throws IOException, InterruptedException
	{
		String encoded=URLEncoder.encode(text,"UTF-8").replace("+", "%20");
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://japerk-text-processing.p.rapidapi.com/stem/"))
				.header("content-type", "application/x-www-form-urlencoded")
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "japerk-text-processing.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString("language=english&stemmer=porter&text="+encoded))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String sentm(String text) throws IOException, InterruptedException
	{
		String encoded=URLEncoder.encode(text,"UTF-8").replace("+", "%20");
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://japerk-text-processing.p.rapidapi.com/sentiment/"))
				.header("content-type", "application/x-www-form-urlencoded")
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "japerk-text-processing.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString("language=english&text="+encoded))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String dl(String text) throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://microsoft-translator-text.p.rapidapi.com/Detect?api-version=3.0"))
				.header("content-type", "application/json")
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "microsoft-translator-text.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString("[\r\n    {\r\n        \"Text\": \""+text+"\"\r\n    }\r\n]"))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
}
