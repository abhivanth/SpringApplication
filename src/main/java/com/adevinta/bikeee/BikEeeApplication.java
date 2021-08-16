package com.adevinta.bikeee;

import com.adevinta.bikeee.service.PedelecsOverviewService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BikEeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikEeeApplication.class, args).getBean(PedelecsOverviewService.class);

	}

}
