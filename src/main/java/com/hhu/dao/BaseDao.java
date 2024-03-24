package com.hhu.dao;
import java.util.List;

/**
 * @version 1.0
 * @date 2024-3-22
 * @param <T>
 */
public interface BaseDao<T> {
    /**
     * 添加数据
     * @param t
     * @throws Exception
     */
    void insert(T t)throws Exception;

    /**
     * 修改数据
     * @param t
     * @throws Exception
     */
    void update(T t)throws Exception;

    /**
     * 删除数据
     * @param pk
     * @throws Exception
     */
    void delete(Long pk)throws Exception;

    /**
     * 批量删除
     * @param pks
     * @throws Exception
     */
    void batchDelete(Long[] pks)throws Exception;

    /**
     * 全查询
     * @return
     * @throws Exception
     */
    List<T> selectAll()throws Exception;

    /**
     * 条件查询
     * @param t
     * @return
     * @throws Exception
     */
    List<T> selectBySelective(T t)throws Exception;

    /**
     * 单个查询
     * @param pk
     * @return
     * @throws Exception
     */
    T selectById(Long pk)throws Exception;
}
