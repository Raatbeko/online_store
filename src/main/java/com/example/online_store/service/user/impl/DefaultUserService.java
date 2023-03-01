package com.example.online_store.service.user.impl;

import com.example.online_store.domain.User;
import com.example.online_store.service.common.impl.DefaultCrudService;
import com.example.online_store.service.user.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService extends DefaultCrudService<User, Long> implements UserService {
    public DefaultUserService(
            @Qualifier("userRepository") CrudRepository<User, Long> crudRepository) {
        super(crudRepository);
    }
}
