package br.com.mvp.springkeycloak.controller;

import br.com.mvp.springkeycloak.jwt.CustomJwt;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-admin")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    public String helloAdmin() {
        var jwt = (CustomJwt) SecurityContextHolder.getContext().getAuthentication();
        return "Hello Admin: " + jwt.getFirstname();
    }

    @GetMapping("/hello-user")
    @PreAuthorize("hasAuthority('ROLE_user')")
    public String helloUser() {
        var jwt = (CustomJwt) SecurityContextHolder.getContext().getAuthentication();
        return "Hello User: " + jwt.getFirstname();
    }
}
