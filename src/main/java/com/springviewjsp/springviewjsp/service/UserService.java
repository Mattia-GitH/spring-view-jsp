package com.springviewjsp.springviewjsp.service;

import com.springviewjsp.springviewjsp.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserModel createUser (UserModel userModel);

    List<UserModel> listUsers();

    UserModel userById(Long id);

    UserModel updateUser (UserModel userModel, Long id);

    String delete (long id);
}
