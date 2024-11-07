package com.ersin.spring_data_jpa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
    @NotEmpty(message = "First name can not be empty")
    @Size(min = 3, max = 20)
    private String firstName;
    @NotEmpty(message = "First name can not be empty")
    @Size(min = 3, max = 20)
    private String lastName;
    @NotEmpty(message = "Date of birth can not be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthOfDate;

}
