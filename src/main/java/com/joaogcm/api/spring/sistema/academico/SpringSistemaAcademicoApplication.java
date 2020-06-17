package com.joaogcm.api.spring.sistema.academico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaogcm.api.spring.sistema.academico.configuration.Configuracao;

@SpringBootApplication
public class SpringSistemaAcademicoApplication extends Configuracao {
	public static void main(String[] args) {
		SpringApplication.run(SpringSistemaAcademicoApplication.class, args);
	}
}