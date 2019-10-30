package tn.vote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * To enable injection of BCryptPasswordEncoder as a bean
 * @author RBH
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	   @Override
       public void addResourceHandlers(ResourceHandlerRegistry registry){
            registry.addResourceHandler("/uploads/**")
               .addResourceLocations("/uploads")
               .setCachePeriod(0);
       }

}
