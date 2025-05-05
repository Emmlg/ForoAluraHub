package com.emmlg.ForoAluraHub.user.service;

import com.emmlg.ForoAluraHub.user.dto.UserDto;
import com.emmlg.ForoAluraHub.util.GeneralResponse;

import java.util.List;

public interface IUserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Integer id);

    UserDto getUserByUserName(String userName);

    UserDto updateUser(Integer id, UserDto userDto);

    GeneralResponse deleteUser(Integer id);

    List<UserDto> getAllUsers();
}
