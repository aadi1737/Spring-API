package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entity.UserEntity;
import net.engineeringdigest.journalApp.Entity.UserRequestDTO;
import net.engineeringdigest.journalApp.Entity.UserResponseDTO;
import net.engineeringdigest.journalApp.Services.UserServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping
    public List<UserResponseDTO> getAllUser(){
        List<UserEntity> all = userServices.getAll();
        List<UserResponseDTO> dtoList = new ArrayList<>();

        for(UserEntity user:all){
            UserResponseDTO dto = new UserResponseDTO();
            dto.setId(user.getId());
            dto.setUserName(user.getUserName());
            dto.setRole(user.getRole());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @PostMapping
    public boolean addUser(@RequestBody UserRequestDTO dto){
        UserEntity user = new UserEntity();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        boolean b = userServices.saveUser(user);
        return b;
    }

    @GetMapping("/id/{id}")
    public UserResponseDTO getUserById(@PathVariable ObjectId id){
        UserEntity user = userServices.getById(id);
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUserName(user.getUserName());
        dto.setRole(user.getRole());
        dto.setId(user.getId());
        return dto;
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping
//    public UserResponseDTO updateUser(@RequestBody UserRequestDTO dto){
//
//    }
}
