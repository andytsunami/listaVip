package br.com.caelum.listaVip;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@PropertySources({
	@PropertySource("classpath:configuracao.properties"),	
})


public class Configuracao {
	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
	
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("db.driver"));
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.username"));
		ds.setPassword(env.getProperty("db.password"));
		
		return ds;
	}
}