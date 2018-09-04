package br.com.cinq.spring.data.sample.repository;

import br.com.cinq.spring.data.sample.entity.City;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author willian
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByCountry_NameIgnoreCaseContaining(String country);
}
