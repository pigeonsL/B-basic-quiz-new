package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    @NotBlank
    @Size(max = 12, min = 5, message = "用户名不合法")
    private String name;
    @NotBlank
    @Size(max = 12, min = 5, message = "密码不合法")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[1-9])(?=.*[_]).{5,12}$", message = "密码不合法")
    private String passwd;
    @NotBlank
    @Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$", message = "邮箱不合法")
    private String email;
}
