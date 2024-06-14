package com.app.crm_news_java.services.impl;

import com.app.crm_news_java.persist.entities.UserEntity;
import com.app.crm_news_java.persist.repositories.IUserRepository;
import com.app.crm_news_java.presentation.dto.UserDTO;
import com.app.crm_news_java.services.interfaces.IUserService;
import org.apache.catalina.User;
import org.apache.tomcat.jni.Library;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<UserDTO> findAll() {
        return this.userRepository.findUsers()
                .stream()
                .map(entity -> modelMapper.map(entity, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        try{
            UserEntity user = modelMapper.map(userDTO, UserEntity.class);
            this.userRepository.save(user);
            return userDTO;
        }catch (Exception e){
            throw new UnsupportedOperationException("Error al crear el usuario.");
        }
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<UserEntity> user = this.userRepository.findById(id);
        if(user.isPresent()){
            return modelMapper.map(user.get(), UserDTO.class);
        }
        return new UserDTO();
    }

    @Override
    public UserDTO update(UserDTO userDTO, Long id) {
        Optional<UserEntity> user = this.userRepository.findById(id);
        if(user.isPresent()){
            UserEntity userEd = user.get();
            userEd.setName(userDTO.getName());
            userEd.setSurnames(userDTO.getSurnames());
            userEd.setAge(userDTO.getAge());
//            userEd.setPassword(userDTO.getPassword());
            userEd.setEmail(userDTO.getEmail());
            userEd.setBorn(userDTO.getBorn());
            userEd.setLastModifiedDate(new Date());

            this.userRepository.save(userEd);
            return modelMapper.map(userEd, UserDTO.class);
        }
        throw new IllegalArgumentException("Usuario no encontrado.");
    }

    @Override
    public String delete(Long id) {
        Optional<UserEntity> user = this.userRepository.findById(id);
        if(user.isPresent()){
            this.userRepository.delete(user.get());
            return "Usuario eliminado con éxito";
        }
        return "User no encontrado";
    }
}
