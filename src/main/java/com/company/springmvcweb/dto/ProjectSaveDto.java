package com.company.springmvcweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSaveDto {
    private String title;
    private String location;
    private String date;
    private String description;
}
