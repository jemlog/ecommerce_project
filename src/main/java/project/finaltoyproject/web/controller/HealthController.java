package project.finaltoyproject.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "health Controller",description = "health controller desc")
public class HealthController {

    @Operation(summary = "health check method",description = "health check will occur",tags = {"hello"})
    @GetMapping("/health")
    public String healthCheck()
    {
        return "healthCheck ok";
    }

}
