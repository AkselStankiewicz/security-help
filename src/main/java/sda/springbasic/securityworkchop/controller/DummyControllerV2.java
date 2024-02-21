package sda.springbasic.securityworkchop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dummyV2")
public class DummyControllerV2 {

    @GetMapping("/get")
    public ResponseEntity<String> getMethod() {
        return ResponseEntity.ok("Welcome from GET method");
    }

    @PostMapping("/post")
    public ResponseEntity<String> postMethod() {
        return ResponseEntity.ok("Welcome from POST method");
    }

    @PutMapping("/put")
    public ResponseEntity<String> putMethod() {
        return ResponseEntity.ok("Welcome from PUT method");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMethod() {
        return ResponseEntity.ok("Welcome from DELETE method");
    }
}
