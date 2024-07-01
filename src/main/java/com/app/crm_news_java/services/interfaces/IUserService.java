package com.app.crm_news_java.services.interfaces;

import com.app.crm_news_java.presentation.dto.UserDTO;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDTO> findAll();

    UserDTO create(UserDTO userDTO);

    UserDTO getAuthUser(Long id);

    UserDTO findById(Long id);

    UserDTO update(UserDTO userDTO, Long id);

    String delete(Long id);

}
