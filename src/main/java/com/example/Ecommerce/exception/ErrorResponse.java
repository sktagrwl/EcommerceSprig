package com.example.Ecommerce.exception;

import lombok.*;

import java.time.LocalDateTime;




@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {

    public int status;

    private String message;

    private LocalDateTime timestamp;

    public ErrorResponse(int status, String message, LocalDateTime timestamp){

        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }


}
