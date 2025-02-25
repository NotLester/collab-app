package edu.manipal.cse.questionbankservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "user-service", path = "/api/v1")
public interface FacultyClient {

    @GetMapping("/faculty/exists/{id}")
    Boolean facultyExistsById(@PathVariable UUID id);
}
