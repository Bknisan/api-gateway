package controller;

import common.commonConstraints;
import org.springframework.web.bind.annotation.*;
import repository.handlersRepository;

import java.util.HashMap;
import java.util.Map;

import static common.commonConstraints.*;

@RestController
public class apiGateWayRestController {

    private handlersRepository handlersRepository = new handlersRepository();

    @CrossOrigin
    @GetMapping("/login/{userName}/{password}")
    public boolean Login(@PathVariable String userName, @PathVariable String password) {
        Map<String, String> details = new HashMap<>();
        details.put(commonConstraints.USER_NAME, userName);
        details.put(commonConstraints.PASSWORD, password);
        return handlersRepository.getHandler(LOGIN).handleRequest(details);
    }

    @CrossOrigin
    @GetMapping("/register/{userName}/{password}/{email}")
    public Map<Boolean, String> Register(@PathVariable String userName, @PathVariable String password, @PathVariable String email) {
        Map<String, String> details = new HashMap<>();
        details.put(commonConstraints.USER_NAME, userName);
        details.put(commonConstraints.PASSWORD, password);
        details.put(commonConstraints.EMAIL, email);
        Map<Boolean, String> response = new HashMap<>();
        // if exists return failure message.
        if (handlersRepository.getHandler(REGISTER).handleRequest(details)) {
            response.put(false, "email already registered");
            return response;
        }
        response.put(true, "user created successfully");
        return response;
    }
}
