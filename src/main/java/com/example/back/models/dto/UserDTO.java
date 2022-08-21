package com.example.back.models.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Valid
public class UserDTO {

    @NotEmpty(message = "{userdto.username.notempty}")
    @NotNull(message = "{userdto.username.notnull}")
    @Size(min = 4, max = 64, message = "{userdto.username.size}")
    private String userName;

    @NotEmpty(message = "{userdto.password.notempty}")
    @Size(min = 8, max = 64, message = "{userdto.username.size}")
    private String password;

    @NotEmpty(message = "{userdto.password.notempty}")
    @Size(min = 8, max = 64, message = "{userdto.password.size}")
    private String repeatPassword;

    @NotEmpty(message = "{userdto.email.notempty}")
    @Email(message = "{userdto.email.vaild}")
    private String mailAddress;

    @AssertTrue(message = "{userdto.password.compare}")
    public boolean isPasswordsEqual() {
        return password.equals(repeatPassword);
    }

}