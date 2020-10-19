package com.ievgen.iaroshenko.usercommon;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class CreateUserResponse {
    @NotNull
    String uuid;
}
