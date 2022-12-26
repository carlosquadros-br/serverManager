package io.getarrays.server;

import io.getarrays.server.model.Server;
import io.getarrays.server.repo.ServerRepo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static io.getarrays.server.enumeration.Status.SERVER_DOWN;
import static io.getarrays.server.enumeration.Status.SERVER_UP;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Server API", version = "1.0", description = "Server connect API"))
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepo serverRepo) {
        return args -> {
            serverRepo.save(new Server(null, "192.168.1.160", "Windows 11", "16gb", "Personal PC", "http:localhost:8080/server/image/server.png", SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.161", "Ubuntu Linux", "32gb", "Personal PC", "http:localhost:8080/server/image/server.png", SERVER_DOWN));
			serverRepo.save(new Server(null, "192.168.1.162", "Windows 11", "16gb", "Personal PC", "http:localhost:8080/server/image/server.png", SERVER_UP));
        };
    }
}
