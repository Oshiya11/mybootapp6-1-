package te4a.spring.boot.myapp13.mybootapp13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Pbkdf2PasswordEncoder の最新のコンストラクタを使用
        String secret = "mySecret"; // 適切なシークレット値に変更してください
        int iterations = 185000; // 推奨される最小反復回数
        int hashWidth = 256; // 出力ハッシュのビット長
        return new Pbkdf2PasswordEncoder(secret, iterations, hashWidth, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers(new AntPathRequestMatcher("/webjars/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/loginForm")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/users")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/users/create")).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginProcessingUrl("/login")
                .loginPage("/loginForm")
                .failureUrl("/loginForm?error")
                .defaultSuccessUrl("/books", true)
                .usernameParameter("username")
                .passwordParameter("password")
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/loginForm")
            );
        return http.build();
    }
}
