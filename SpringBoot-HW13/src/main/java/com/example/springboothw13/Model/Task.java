package com.example.springboothw13.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Task {

    private String  id , title , description , status;
}
