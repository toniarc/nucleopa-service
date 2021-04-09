package br.gov.pa.prodepa.nucleopa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.gov.pa.prodepa.pae.common", "br.gov.pa.prodepa.nucleopa"})
public class NucleopaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NucleopaApplication.class, args);
	}
}
