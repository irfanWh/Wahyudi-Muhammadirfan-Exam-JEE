package ma.enset.controlebackend.web;

import lombok.AllArgsConstructor;
import ma.enset.controlebackend.dto.LoginRequestDTO;
import ma.enset.controlebackend.dto.LoginResponseDTO;
import ma.enset.controlebackend.entities.AppUser;
import ma.enset.controlebackend.repositories.AppUserRepository;
import ma.enset.controlebackend.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private AppUserRepository appUserRepository;
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        AppUser user = appUserRepository.findByUsername(request.getUsername());

        String token = jwtUtil.generateToken(user);

        return new LoginResponseDTO(token);
    }
}