package projectx.northwind.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // Şifreleri hashlemek için BCrypt encoder bean'i
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Tüm endpoint'lere erişimi serbest bırakır, login ekranını kapatır
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // tüm istekler serbest
                .csrf(csrf -> csrf.disable()) // CSRF koruması devre dışı (form vs. kullanılmıyor çünkü)
                .formLogin(login -> login.disable()) // login ekranı kapalı
                .httpBasic(basic -> basic.disable()); // basic auth da kapalı

        return http.build();
    }
}

