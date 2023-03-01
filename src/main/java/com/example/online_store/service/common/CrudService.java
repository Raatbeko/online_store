package com.example.online_store.service.common;

import com.example.online_store.domain.common.BaseEntity;
import com.example.online_store.exception.NotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.access.method.P;

import java.util.Collection;
import java.util.List;

public interface CrudService<T, P> {

    T get(@NotNull P id) throws NotFoundException;

    Collection<T> get(@NotNull List<P> ids) throws NotFoundException;

    T saveOrUpdate(@NotNull T t);

    void saveOrUpdate(@NotNull Collection<T> t);
}
