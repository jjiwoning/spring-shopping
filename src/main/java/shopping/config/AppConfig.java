package shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    private static final int TIMEOUT = 5000;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(getHttpTimeoutRequestFactory());
    }

    private ClientHttpRequestFactory getHttpTimeoutRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
            = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(TIMEOUT);
        return clientHttpRequestFactory;
    }
}
