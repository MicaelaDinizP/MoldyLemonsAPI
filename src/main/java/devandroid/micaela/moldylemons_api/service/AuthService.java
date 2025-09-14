package devandroid.micaela.moldylemons_api.service;

import devandroid.micaela.moldylemons_api.exception.EmailAlreadyExistsException;
import devandroid.micaela.moldylemons_api.exception.InvalidCredentialsException;
import devandroid.micaela.moldylemons_api.model.Couple;
import devandroid.micaela.moldylemons_api.repository.CoupleRepository;
import devandroid.micaela.moldylemons_api.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class AuthService {

    private final CoupleRepository coupleRepository;
    private PasswordEncoder passwordEncoder;
    private SecurityConfig securityConfig;

    @Autowired
    public AuthService(CoupleRepository coupleRepository, PasswordEncoder passwordEncoder,
                       SecurityConfig securityConfig) {
        this.coupleRepository = coupleRepository;
        this.passwordEncoder = passwordEncoder;
        this.securityConfig = securityConfig;
    }

    public Couple login(String email, String rawPassword) {
        Optional<Couple> couple = coupleRepository.findByEmail(email);
        if (!coupleRepository.findByEmail(email).isPresent()
                || !checkPassword(rawPassword, couple.get().getPassword())){
            throw new InvalidCredentialsException();
        }
        return couple.get();
    }

    public Couple register(String email, String password) {
        if (coupleRepository.findByEmail(email).isPresent()) {
            throw new EmailAlreadyExistsException(email);
        }
        String pepperedPassword = password + securityConfig.getPepper();
        String hashedPassword = passwordEncoder.encode(pepperedPassword);

        Couple couple = new Couple();
        couple.setEmail(email);
        couple.setPassword(hashedPassword);
        return coupleRepository.save(couple);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        String pepperedPassword = rawPassword + securityConfig.getPepper();
        return passwordEncoder.matches(pepperedPassword, encodedPassword);
    }
}