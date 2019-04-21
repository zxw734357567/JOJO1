package com.example.demo.configurations.springsecurity;

import com.example.demo.configurations.springsecurity.SecurityUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/3/29  14:48.
 * @Modified by:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityUserDetail securityUserDetail;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用自定义的用户信息,并将数据加密
        auth.userDetailsService(securityUserDetail).passwordEncoder(new BCryptPasswordEncoder());
       // super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
      //  web.ignoring().antMatchers("/templates/**");
        web.ignoring().antMatchers("/**/*.css", "/swagger-ui/**","/**/*.js","/v2/api-docs", "/webjars/**","/swagger-resources/**");
    }

    //note : authorize:认证
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.csrf().disable().authorizeRequests()
                .antMatchers("/login","/swagger-ui.html").permitAll()//制定该路径可以访问,其他不可以访问
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/user/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .exceptionHandling().accessDeniedPage("/access?error");
        // @formatter:on
    }
}
