package ac.za.cput.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applies to all endpoints
                .allowedOrigins("*") // Allows all origins (for development)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allows standard HTTP methods
                .allowedHeaders("*") // Allows all headers
                .allowCredentials(false);
    }
}
