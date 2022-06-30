package Group6.capstone.config;

import Group6.capstone.Interceptor.UpdateInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final UpdateInterceptor updateInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(updateInterceptor)
                .order(1)
                .addPathPatterns("/", "/statics", "/statics/**");
    }
}
