package com.example.online_store.service.common.impl;


import com.example.online_store.exception.NotFoundException;
import com.example.online_store.service.common.CrudService;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional(readOnly = true)
public class DefaultCrudService<T, P extends Serializable> implements CrudService<T, P> {

    private final CrudRepository<T, P> crudRepository;

    public DefaultCrudService(@NotNull CrudRepository<T, P> crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public T get(P id) throws NotFoundException {
        return crudRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Запись не найдена для id: " + id));
    }

    @Override
    public Collection<T> get(@NotNull List<P> ids) throws NotFoundException {
        List<T> list = new ArrayList<>();

        for (P id : ids){
            list.add(get(id));
        }
        return list;
    }

    @Override
    public T saveOrUpdate(T t) {
        return crudRepository.save(t);
    }

    @Override
    public void saveOrUpdate(Collection<T> t) {
        List<T> persisted = new ArrayList<>();

        for (T currentObject : t) {
            persisted.add(saveOrUpdate(currentObject));
        }
    }
}
