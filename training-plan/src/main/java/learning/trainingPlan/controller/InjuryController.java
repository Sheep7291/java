package learning.trainingPlan.controller;

import jakarta.validation.Valid;
import learning.trainingPlan.client.InjuryClient;
import learning.trainingPlan.jms.InjuryDto;
import learning.trainingPlan.response.ResponseObject;
import learning.trainingPlan.service.InjuryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class InjuryController {

    private final InjuryClient injuryClient;
    private final InjuryService injuryService;

    @PostMapping("add")
    ResponseEntity<ResponseObject> sendInjury(Authentication authentication, @Valid @RequestBody InjuryDto injuryDto){
        injuryDto.setUsername(authentication.getName());
        ResponseObject responseObject = new ResponseObject(injuryService.addInjury(injuryDto));
        return ResponseEntity.ok(responseObject);
    }

    @GetMapping("/injuries")
    ResponseEntity<List<InjuryDto>> getInjuriesByUsername(@RequestParam String username){
        List<InjuryDto> injuryDtoList = injuryService.getInjuriesByUsername(username);
        if (injuryDtoList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(injuryDtoList);
    }

}
