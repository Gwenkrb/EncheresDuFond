package fr.eni.encheresdufond.configuration.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class EncheresSecurityConfig {
	
    JdbcUserDetailsManager  JdbcUserDetailsManager;
	
	@Bean
	UserDetailsManager users(DataSource dataSource) {
		JdbcUserDetailsEnchereManager users = new JdbcUserDetailsEnchereManager(dataSource);
		// Modifier et tester la requête
		users.setUsersByUsernameQuery("SELECT pseudo, mot_de_passe, 'true' as enabled FROM UTILISATEURS WHERE pseudo = ? OR email = ?");
		// Modifier et tester la requête
		users.setAuthoritiesByUsernameQuery("SELECT pseudo, administrateur FROM UTILISATEURS WHERE pseudo = ?");
		return users;
	}

	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/login").permitAll()
				.requestMatchers("/connexion").authenticated().requestMatchers("/css/*").permitAll()
				.requestMatchers("/images/*").permitAll().requestMatchers("/").permitAll().anyRequest().denyAll());

		http.formLogin(form -> {
			form.loginPage("/login");
			form.permitAll();
			form.defaultSuccessUrl("/connexion");
		});

		http.logout(form -> {
			form.invalidateHttpSession(true);
			form.clearAuthentication(true);
			form.deleteCookies("JSESSIONID");
			form.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
			form.logoutSuccessUrl("/").permitAll();
		});

		return http.build();
	}

}
