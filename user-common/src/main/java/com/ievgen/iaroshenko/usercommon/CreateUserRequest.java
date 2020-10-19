package com.ievgen.iaroshenko.usercommon;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class CreateUserRequest {
    @NotNull
    String firstName;
    @NotNull
    String lastName;

    @NotNull
    String userName;

    @NotNull
    String password;

    @NotNull
    String email;
}
