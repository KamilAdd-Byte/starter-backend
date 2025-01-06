package pl.ryestarter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.ArrayList;
import java.util.List;

@Data
@ConfigurationProperties("starter.cors")
class CORSConfigurationProperties {

    private final List<String> allowedOrigins = new ArrayList<>();

    private final List<String> allowedMethods = new ArrayList<>();

    private final List<String> allowedHeaders = new ArrayList<>();

}
