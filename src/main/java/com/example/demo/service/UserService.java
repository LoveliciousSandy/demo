package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userrepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO) {
        userrepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

  public List <UserDTO>getAllUsers(){
 List<User> userlist =userrepo.findAll();
 return  modelMapper.map(userlist, new TypeToken<List <UserDTO>>(){}.getType());
    }
    public  UserDTO updateUser(UserDTO userDTO){
        userrepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userrepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }
}
