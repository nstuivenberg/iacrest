package nl.hu.iac.controller;

import nl.hu.iac.domain.City;
import nl.hu.iac.service.CityService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by Nick Stuivenberg on 21-6-2017.
 */
@RestController
@RequestMapping(value = "/city")
public class CityController {

    private final CityService cityService = new CityService();


    @RequestMapping("/")
    public @ResponseBody String itWorks() {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.POST, value="/insert")
    public City addCity(@RequestBody City c) {
        return cityService.addCity(c);
    }

    @RequestMapping(method = RequestMethod.POST, value="/calculate/{cityName}/{benefit}")
    public String calculateCostsPerInhabitantGivenTheHeightOfTheUnemploymentBenefits(@PathVariable String cityName,@PathVariable String benefit,

                                                                                     HttpServletResponse response) {
        // Ik vind de if check niet zo netjes hier, maar anders komt de response van zo diep in de applicatie...
        if(!cityService.hasCityWithName(cityName)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "The city with name: " + cityName +" cannot be found";
        }
        if(!isDouble(benefit)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Cannot convert input to a double";
        }
        return cityService.costPerInhabitantsCalculated(cityName, Double.parseDouble(benefit));
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
