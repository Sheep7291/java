package learning.trainingPlan.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class TrainerDto {
    private Long id;
    @NotBlank
    private String username;
    @FutureOrPresent
    private LocalDate accountStartDate;
    @Future
    private LocalDate accountEndDate;
    private List<ClientDto> clientDtos;
}