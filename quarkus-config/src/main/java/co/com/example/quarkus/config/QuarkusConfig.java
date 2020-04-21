package co.com.example.quarkus.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/hello")
public class QuarkusConfig {

    @ConfigProperty(name = "config.hello.message")
    private String message;

    @ConfigProperty(name = "config.hello.optional.message", defaultValue = "I'm optional")
    private String optionalMessage;

    @ConfigProperty(name = "config.hello.optional")
    private Optional<String> anotherWayOptionalMessage;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello " + message + "\n" + optionalMessage + "\n" + anotherWayOptionalMessage.orElse("I'm still optional");
    }
}