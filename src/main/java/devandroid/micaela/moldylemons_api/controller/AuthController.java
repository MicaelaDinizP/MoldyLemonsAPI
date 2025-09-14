package devandroid.micaela.moldylemons_api.controller;

import devandroid.micaela.moldylemons_api.dto.RegisterRequest;
import devandroid.micaela.moldylemons_api.dto.LoginRequest;
import devandroid.micaela.moldylemons_api.model.Couple;
import devandroid.micaela.moldylemons_api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Couple couple = authService.login(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );
        return ResponseEntity.ok(couple.getEmail() + " authorized!");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        Couple savedCouple = authService.register(
                registerRequest.getEmail(),
                registerRequest.getPassword()
        );

        savedCouple.setPassword(null);
        return ResponseEntity.status(204).body(savedCouple.getEmail() + " created!");
    }
}