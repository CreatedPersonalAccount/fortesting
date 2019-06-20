package ru.frost.training.dto;

import lombok.Data;

@Data
public class CompanyInfoDto {

    /** Code some company. */
    private String symbol;

    /** The Name some company. */
    private String name;

    /** Price of company. */
    private String price;

}
