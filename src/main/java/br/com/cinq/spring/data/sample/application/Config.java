package br.com.cinq.spring.data.sample.application;

import br.com.cinq.spring.data.sample.rest.CityController;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Register Jersey modules
 * @author Adriano Kretschmer
 */
@Configuration
@Component
@ApplicationPath("rest")
public class Config extends ResourceConfig {

    public Config() {
        packages("br.com.cinq.spring.data.sample.rest");
        register(CityController.class);
    }

}