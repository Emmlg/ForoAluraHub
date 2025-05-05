package com.emmlg.ForoAluraHub.user.controller;

import com.emmlg.ForoAluraHub.user.dto.UserDto;
import com.emmlg.ForoAluraHub.user.service.UserService;
import com.emmlg.ForoAluraHub.util.GeneralResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Controller", description = "Enpoint of User CRUD operations")
@AllArgsConstructor
@RestController
@RequestMapping("${api.prefix}/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/list")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping()
    public UserDto updateUser(@RequestParam Integer userId, @RequestBody UserDto userDto) {
        return userService.updateUser(userId, userDto);
    }

    @DeleteMapping("/{userId}")
    public GeneralResponse deleteUser(@PathVariable Integer userId) {
        return userService.deleteUser(userId);
    }

}
