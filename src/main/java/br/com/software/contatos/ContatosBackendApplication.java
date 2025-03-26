package br.com.software.contatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ContatosBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContatosBackendApplication.class, args);
	}

}
