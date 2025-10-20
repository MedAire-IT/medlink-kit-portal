package com.medlink.portal.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class ProcessingResults {
    public List<String> processingErrors = new ArrayList<>();
    public boolean runSuccess = false;
    public LocalDateTime runStart = LocalDateTime.now();
    public LocalDateTime runEnd;
    public double runTimeMinutes;
}


