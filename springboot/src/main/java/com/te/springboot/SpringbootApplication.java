package com.te.springboot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Scheduled(fixedDelay = 1000)
	public void schedule() throws InterruptedException {
		LocalDateTime cuTime=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formaterTime=cuTime.format(formatter);
		log.info("time is "+formaterTime);
		Thread.sleep(1000);
	}
}
