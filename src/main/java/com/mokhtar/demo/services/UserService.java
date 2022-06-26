package com.mokhtar.demo.services;

import com.mokhtar.demo.dao.UserDao;

import com.mokhtar.demo.dto.UserRequestDto;
import com.mokhtar.demo.dto.UserResponceDto;
import com.mokhtar.demo.entity.User;
import com.mokhtar.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserDao userDao;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    public UserResponceDto getUserById(Long id){
        return userMapper.EntityToDto(userDao.findById(id).orElseThrow(()->new IllegalStateException("user not found"))) ;
    }

    public List<UserResponceDto> getAll(){
        return userDao.findAll().stream().map(user->
                userMapper.EntityToDto(user)).collect(Collectors.toList());
    }

    public User Save(UserRequestDto user){
        return userDao.save(userMapper.DtoToEntity(user));
    }

    @Override
    public User update(UserRequestDto userRequestDto, Long id) {
        userRequestDto.setId(id);
        return userDao.save(userMapper.DtoToEntity(userRequestDto));
    }

    @Override
    public String delete(Long id) {
        User user=userDao.findById(id).orElseThrow(() -> new IllegalStateException("user not found"));
        userDao.delete(user);
        return "The user of id "+id+" is deleted";
    }


}
