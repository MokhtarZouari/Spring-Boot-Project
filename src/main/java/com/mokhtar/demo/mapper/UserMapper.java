package com.mokhtar.demo.mapper;

import com.mokhtar.demo.dto.UserRequestDto;
import com.mokhtar.demo.dto.UserResponceDto;
import com.mokhtar.demo.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User DtoToEntity(UserRequestDto userRequestDto);

    UserResponceDto EntityToDto(User user);

}
