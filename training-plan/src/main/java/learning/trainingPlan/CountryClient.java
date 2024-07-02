package learning.trainingPlan;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "countryClient", url = "https://restcountries.com/v2")
public interface CountryClient {

    @GetMapping("/all")
    List<Object> getAllCountries();
}
