package Rios.Vinicius.musica.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Autowired
    private JwtTokenStore tokenStore;

    //configurar os endpoints
    private static final String[] PUBLIC = { "/","/oauth/token","/h2/**" };
    private static final String[] OPERATOR_OR_ADMIN = {
            "/albuns/**",
            "/artistas/**",
            "/cidades/**",
            "/estados/**",
            "/paises/**",
            "/festivais/**",
            "/generos/**"};
    private static final String[] ADMIN = {"/usuarios/**","/funcoes/**" };

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception{
          resources.tokenStore(tokenStore);
    }

    @Override // liberação do H2
    public void configure(HttpSecurity http) throws Exception {
        if (Arrays.asList(environment.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        //Autorização de rotas
        http.authorizeRequests().antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, "OPERATORS_OR_ADMINS").permitAll()
                .antMatchers(OPERATOR_OR_ADMIN).hasAnyRole("OPERATOR", "ADMIN")
                .antMatchers(ADMIN).hasRole("ADMIN")
                .anyRequest().authenticated();

    }

}
