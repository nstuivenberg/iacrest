package nl.hu.iac.service;

import nl.hu.iac.domain.City;
import nl.hu.iac.repositories.CityRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Nick Stuivenberg on 21-6-2017.
 */
@RunWith(SpringRunner.class)
public class CityServiceTest {

    @TestConfiguration
    static class CityServiceImplContextConf {
        @Bean
        public  CityService cityService() {
            return new CityService();
        }
    }


    @Autowired
    private CityService cityService;

    @MockBean
    private CityRepo cityRepo;

    @Test
    public void whenValidNameThenCityShouldBeFound() {
        String name="London";
        cityService = new CityService();
        cityRepo = new CityRepo();
        City cityObject = new City();
        cityObject.setCityName("London");
        cityService.addCity(cityObject);
        City found = cityService.getCityByName(name);
        assertThat(found.getCityName())
                .isEqualTo(name);
    }
}
