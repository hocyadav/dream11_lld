package io.hari.dream11.dao;

import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 5/24/2021
 */
public interface BaseDao<E> {
    E saveOrUpdate(E entity);
    void saveMultiple(E... entities);
    E findById(Long entityId);
    void delete(E entity);
    List<E> findAll();
}
