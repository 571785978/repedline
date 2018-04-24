package com.example.base;

import java.util.List;

public interface BaseDao<T> {
    /**
     * 保存
     * @param entity
     * @return
     */
    public int save(T entity);

    /**
     * 查询
     * @param entity
     * @return
     */
    public T get(T entity);

    /**
     * 根据ID 查询
     * @param id
     * @return
     */
    public T getById(Integer id);

    /**
     * 删除
     * @param entity
     * @return
     */
    public void delete(T entity);

    /**
     * 根据ID 删除
     * @param id
     * @return
     */
    public void deleteById(Integer id);

    /**
     * 修改
     * @param entity
     * @return
     */
    public T update(T entity);

    /**
     * 批量修改或删除
     * @param entities
     */
    public void batchInsertOrUpdate(List<T> entities);
}
