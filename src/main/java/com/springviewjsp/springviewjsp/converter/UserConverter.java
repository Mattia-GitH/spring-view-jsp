package com.springviewjsp.springviewjsp.converter;

import com.springviewjsp.springviewjsp.entity.UserEntity;
import com.springviewjsp.springviewjsp.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public UserModel toModel(UserEntity entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        return model;
    }

    public List<UserModel> listToModels(List<UserEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserEntity toEntity(UserModel model) {
        UserEntity entity = new UserEntity();
        entity.setName(model.getName());
        entity.setSurname(model.getSurname());
        return entity;
    }

    public List<UserEntity> listToEntities(List<UserModel> modelList) {
        return modelList.stream().map(this::toEntity).collect(Collectors.toList());
    }


}
