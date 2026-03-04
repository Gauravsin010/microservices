package com.micro.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDTO {

    @Schema(
            description = "Account Number of Eazy Bank account", example = "3454433243"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Should be 10 digits")
    @NotEmpty(message = "AccountNumber can not be a null or empty")
    private Long customerId;

    @Schema(
            description = "Account type of Eazy Bank account", example = "Savings"
    )
    @NotEmpty(message = "accountType can not be a null or empty")
    private String accountType;

    @Schema(
            description = "Eazy Bank branch address", example = "123 NewYork"
    )
    @NotEmpty(message = "branchAddress can not be a null or empty")
    private String branchAddress;
}
