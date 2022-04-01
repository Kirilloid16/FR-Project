package ru.lukash.project.frproject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PollDto {
    private int id;
    private String name;
    private String description;
    private LocalDate start_point;
    private LocalDate end_point;
}
