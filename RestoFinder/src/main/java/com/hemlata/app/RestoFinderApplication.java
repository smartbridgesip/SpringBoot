package com.hemlata.app;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestoFinderApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(RestoFinderApplication.class, args);
		//ApiCalls ap=new ApiCalls();
		//ap.data();
	}

}
