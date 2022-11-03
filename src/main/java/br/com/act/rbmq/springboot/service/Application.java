package br.com.act.rbmq.springboot.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.act.rbmq.springboot.service.constants.DefaultSystemMessages.*;

@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/")
	public String getStatusService(){
		return MSG_SYSTEM_ONLINE;
	}
}
