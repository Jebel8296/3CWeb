package io.vertx.web;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.vertx.core.Vertx;
import io.vertx.web.vertx.IDAuthMonitor;

@SpringBootApplication
public class WebApplication {

	private static final Logger LOG = Logger.getLogger(WebApplication.class);

	@Autowired
	private IDAuthMonitor iDAuthMonitor;

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@PostConstruct
	public void deployVerticle() {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(iDAuthMonitor);
	}
}
