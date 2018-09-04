package br.com.cinq.spring.data.sample.rest;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.repository.CityRepository;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author willian
 */
@Service
@Path("cities")
public class CityController {
    private CityRepository repository;
    
    @Autowired
    public CityController(CityRepository cityRepository) {
        this.repository = cityRepository;
    }

    @GET
    @Produces("application/json")
    public List<City> cities(@QueryParam("country") String country){
        return this.repository.findByCountry_NameIgnoreCaseContaining(country);
    }

}
