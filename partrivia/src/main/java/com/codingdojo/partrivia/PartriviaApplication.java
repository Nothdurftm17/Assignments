package com.codingdojo.partrivia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;

@SpringBootApplication
public class PartriviaApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(PartriviaApplication.class, args);
	}

}
