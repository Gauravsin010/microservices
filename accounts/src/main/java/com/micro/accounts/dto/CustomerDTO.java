package com.micro.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDTO {

    @Schema(
            description = "Name of the customer", example = "Gaurav Singh"
    )
    @NotEmpty(message = "Name cannot be null")
    @Size(min = 5, max = 30, message = "Name should be between 5 to 30")
    private String name;

    @Schema(
            description = "Email address of the customer", example = "abcd@xyz.com"
    )
    @NotEmpty(message = "email cannot be empty")
    @Email(message = "Should be valid email")
    private String email;

    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Should be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountsDTO accountsDTO;
}
