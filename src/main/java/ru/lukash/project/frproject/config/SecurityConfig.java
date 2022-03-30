package ru.lukash.project.frproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
//    private final DataSource dataSource;
//
//    public SecurityConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//       auth.jdbcAuthentication().dataSource(dataSource);
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(userBuilder.username("Admin").password("Admin").roles("Admin"))
                .withUser(userBuilder.username("User").password("User").roles("User"));
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/**").hasRole("Admin").antMatchers("/api/polls","api/user_answers")
                .hasAnyRole("Admin","User")
                .and().formLogin().permitAll()
                .defaultSuccessUrl("/api/polls", true).permitAll();


    }
}
