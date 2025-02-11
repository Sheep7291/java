package learning.trainingPlan.dto;

import java.time.LocalDate;
import java.util.List;

public class TrainerDto {
    private Long id;
    private String username;
    private LocalDate accountStartDate;
    private LocalDate accountEndDate;
    private List<ClientDto> clientDtos;
}