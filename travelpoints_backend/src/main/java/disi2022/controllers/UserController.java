package disi2022.controllers;


import disi2022.converter.UserConverter;
import disi2022.dtos.CredentialsDTO;
import disi2022.dtos.ResetPasswordDTO;
import disi2022.dtos.UserDTO;
import disi2022.entities.User;
import disi2022.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Collection<UserDTO>> getUsers() {
        List<UserDTO> dtos = userService.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
        User user = userService.getOne(id);
        return new ResponseEntity<>(UserConverter.userToDto(user), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return new ResponseEntity<>(UserConverter.userToDto(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO dto) {
        if(userService.findByUsername(dto.getUsername()) == null){
            User user = userService.add(UserConverter.dtoToUser(dto));
            return new ResponseEntity<>(UserConverter.userToDto(user), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody UserDTO dto) {
        dto.setId(id);
        User user = userService.update(UserConverter.dtoToUser(dto));
        return new ResponseEntity<>(UserConverter.userToDto(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody CredentialsDTO credentials) {
        UserDTO user = userService.login(credentials);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        if(userService.resetPassword(resetPasswordDTO)){
            return new ResponseEntity<>("Password Changed Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Password Doesn't Match With Current One", HttpStatus.BAD_REQUEST);
    }
}
