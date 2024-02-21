package sda.springbasic.securityworkchop.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DummyController {

    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello From My API");
    }

//    @Secured("ROLE_ADMIN")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/forAdmin")
    public ResponseEntity<String> helloForAdmin() {
        return ResponseEntity.ok("Hello My Admin!");
    }

//    @RolesAllowed("USER")
    @GetMapping("/forUser")
    public ResponseEntity<String> helloForUser() {
        return ResponseEntity.ok("Hello My User!");
    }

//    @PreAuthorize("true")
    @GetMapping("/forAll")
    public ResponseEntity<String> helloForAll() {
        return ResponseEntity.ok("Hello All!");
    }
}
