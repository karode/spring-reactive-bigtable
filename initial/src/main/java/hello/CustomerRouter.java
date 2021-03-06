package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CustomerRouter {

	@Bean
	public RouterFunction<ServerResponse> customerRoute(CustomerHandler customerHandler) {

		return RouterFunctions
			.route(RequestPredicates.POST("/customers").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), customerHandler::create);
	}
}