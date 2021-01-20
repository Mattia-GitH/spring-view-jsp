package com.springviewjsp.springviewjsp.service;

import com.springviewjsp.springviewjsp.converter.UserConverter;
import com.springviewjsp.springviewjsp.entity.UserEntity;
import com.springviewjsp.springviewjsp.exception.UserNotFoundException;
import com.springviewjsp.springviewjsp.model.UserModel;
import com.springviewjsp.springviewjsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository repository;
    private final UserConverter converter;

    @Autowired
    public UserServiceImp(UserRepository repository, UserConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        UserEntity toSave = repository.save(converter.toEntity(userModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<UserModel> listUsers() {
        List<UserEntity> userEntities = repository.findAll();
        return converter.listToModels(userEntities);
    }

    @Override
    public UserModel userById(Long id) {
        Optional<UserEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            throw new UserNotFoundException("User not found: " + id);
        }
    }

    @Override
    public UserModel updateUser(UserModel userModel, Long id) {
        Optional<UserEntity> optionalUserEntity = repository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity update = optionalUserEntity.get();
            update.setName(userModel.getName());
            update.setSurname(userModel.getSurname());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new UserNotFoundException("User not found id: " + userModel.getId());
        }
    }

    @Override
    public String delete(long id) {
        Optional<UserEntity> userEntityOptional = repository.findById(id);
        if (userEntityOptional.isPresent()) {
            repository.delete(userEntityOptional.get());
            return "User deleted " + userEntityOptional.get();
        } else {
            throw new UserNotFoundException("User not found id: " + id);
        }
    }
}
