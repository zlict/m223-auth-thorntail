package ch.zli.m223.example.auth.domain.form;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Represents the data transfer object for sign ins.
 */
public class Credentials implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
