package com.mokhtar.demo.rest;
import com.mokhtar.demo.dto.UserRequestDto;
import com.mokhtar.demo.dto.UserResponceDto;
import com.mokhtar.demo.entity.User;
import com.mokhtar.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponceDto> getUserById(@PathVariable Long id) {
        UserResponceDto user= userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserResponceDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }


    @PostMapping("/users")
    public ResponseEntity<User> postUser(@RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(userService.Save(userRequestDto), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> putUser(@RequestBody UserRequestDto userRequestDto,@PathVariable Long id){
        return new ResponseEntity<>(userService.update(userRequestDto,id), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);

    }
}
