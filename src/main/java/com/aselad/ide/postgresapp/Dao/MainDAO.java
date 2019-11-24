package com.aselad.ide.postgresapp.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MainDAO<T> {

    Page<T> getAll(Pageable pageable);

    T add (T o);

    T update(T o, long id);

    T getById(long id);

    T deleteById (long id);
}
