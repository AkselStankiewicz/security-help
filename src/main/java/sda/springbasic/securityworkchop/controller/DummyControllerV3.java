package sda.springbasic.securityworkchop.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dummyV3")
public class DummyControllerV3 {

    @GetMapping("/get")
    @RolesAllowed({"ADMIN", "GUEST"})
    public ResponseEntity<String> getMethod() {
        return ResponseEntity.ok("Welcome from GET method");
    }

    @PostMapping("/post")
    @RolesAllowed({"ADMIN", "GUEST"})
//    @Secured({"ROLE_ADMIN", "ROLE_GUEST"})
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_GUEST')")
    public ResponseEntity<String> postMethod() {
        return ResponseEntity.ok("Welcome from POST method");
    }

    @PutMapping("/put")
    @RolesAllowed({"ADMIN", "GUEST"})
    public ResponseEntity<String> putMethod() {
        return ResponseEntity.ok("Welcome from PUT method");
    }

    @DeleteMapping("/delete")
    @RolesAllowed({"ADMIN", "GUEST"})
    public ResponseEntity<String> deleteMethod() {
        return ResponseEntity.ok("Welcome from DELETE method");
    }
}
