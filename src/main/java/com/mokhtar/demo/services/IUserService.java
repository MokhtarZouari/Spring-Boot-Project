package com.mokhtar.demo.services;

import com.mokhtar.demo.dto.UserRequestDto;
import com.mokhtar.demo.dto.UserResponceDto;
import com.mokhtar.demo.entity.User;
import java.util.List;

public interface IUserService {

    UserResponceDto getUserById(Long id);

    List<UserResponceDto> getAll();

    User Save(UserRequestDto userRequestDto);

    User update(UserRequestDto userRequestDto,Long id);

    String delete(Long id);
}
