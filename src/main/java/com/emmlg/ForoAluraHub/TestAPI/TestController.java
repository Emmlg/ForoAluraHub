package com.emmlg.ForoAluraHub.TestAPI;

import com.emmlg.ForoAluraHub.Exceptions.ForoAluraHubExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/exception")
    public void throwCustomException() {
        throw new ForoAluraHubExceptions(
                HttpStatus.NOT_FOUND,
                List.of("Test Error 1", "Test Error 2"),
                "This is a test exception",
                "Test Process"
        );
    }

    @GetMapping("/nullpointer")
    public void throwNullPointerException() {
        throw new NullPointerException("This is a null pointer exception test");
    }

    @GetMapping("/illegalargument")
    public void throwIllegalArgumentException(@RequestParam(required = false) String param) {
        if (param == null) {
            throw new IllegalArgumentException("Missing required parameter");
        }
    }
}
