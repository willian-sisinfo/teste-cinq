package br.com.cinq.spring.data.sample.application;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.CityRepository;
import br.com.cinq.spring.data.sample.repository.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author willian
 */
@Component
public class AppCommandRunner implements CommandLineRunner {

    private CityRepository repository;
    private CountryRepository countryRepository;
    
    @Autowired
    public AppCommandRunner(CityRepository repository, CountryRepository countryRepository) {
        this.repository = repository;
        this.countryRepository = countryRepository;
    }
    
    @Override
    public void run(String... strings) throws Exception {
        List<City> cities = this.repository.findAll();
        
        if(cities.isEmpty()) {
            Country bra = new Country("Brazil");
            Country us = new Country("United States");
            Country fra = new Country("France");
            
            this.countryRepository.save(bra);
            this.countryRepository.save(us);
            this.countryRepository.save(fra);

            cities.add(new City("Curitiba", bra));
            cities.add(new City("Rio de Janeiro", bra));
            cities.add(new City("Manaus", bra));
            cities.add(new City("Fortaleza", bra));

            cities.add(new City("New York", us));
            cities.add(new City("Los Angeles", us));
            cities.add(new City("Atlanta", us));

            cities.add(new City("Paris", fra));
            cities.add(new City("Lyon", fra));

            this.repository.save(cities);            
        } 
    }

    
}
