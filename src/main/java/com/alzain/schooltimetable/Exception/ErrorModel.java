package com.alzain.schooltimetable.Exception;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorModel {
    private int status ;
    private String message ;
    private long timestamp ;
}
