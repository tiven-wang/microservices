package wang.tiven.microservices.apigateway.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	// static imports from GatewayFilters and RoutePredicates
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		//@formatter:off
		return builder.routes()
				.route(r -> r.path("/inventory/**")
					.filters(f ->
							f.rewritePath("/inventory/(?<segment>.*)", "/${segment}"))
					.uri("http://localhost:8091")
				)
				.build();
		//@formatter:on
	}
}
