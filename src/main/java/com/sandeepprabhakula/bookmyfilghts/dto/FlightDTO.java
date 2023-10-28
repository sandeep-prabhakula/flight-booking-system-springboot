package com.sandeepprabhakula.bookmyfilghts.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

    private String src;
    private String dest;
    private String date;
}
