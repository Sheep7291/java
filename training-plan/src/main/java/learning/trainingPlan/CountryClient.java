package learning.trainingPlan;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "wger", url = "https://wger.de/api/v2")
public interface CountryClient {

    @GetMapping("/exercise/search")
    Object getAllCountries(
            @RequestParam("language") String language,
            @RequestParam("term") String term
    );
}