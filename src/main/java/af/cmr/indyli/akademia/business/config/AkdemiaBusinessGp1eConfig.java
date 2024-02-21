package af.cmr.indyli.akademia.business.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EntityScan("af.cmr.indyli.akademia.business.entity")
@EnableJpaRepositories("af.cmr.indyli.akademia.business.dao")
@ComponentScan(basePackages = { "af.cmr.indyli.akademia.business.*" })
public class AkdemiaBusinessGp1eConfig {

	@Bean(value = "akdemia-modelmapper")
	@Scope(value = "singleton")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
