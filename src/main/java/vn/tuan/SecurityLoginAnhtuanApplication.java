package vn.tuan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.tuan.entity.Role;
import vn.tuan.entity.User;
import vn.tuan.repository.RoleRepository;
import vn.tuan.repository.UserRepository;

@SpringBootApplication
public class SecurityLoginAnhtuanApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SecurityLoginAnhtuanApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityLoginAnhtuanApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Role userRole = roleRepository.findByName("ROLE_USER")
                    .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_USER")));

            if (userRepository.findByUsername("anhtuan01").isEmpty()) {
                User user = new User();
                user.setUsername("anhtuan01");
                user.setEmail("anhtuan@gmail.com");
                user.setPassword(passwordEncoder.encode("123456"));
                user.setFullName("Anh Tuấn");
                user.setImages("/images/user.png");
                user.setRole(userRole);
                user.setEnabled(true);
                
                userRepository.save(user);
            }
        };
    }
}