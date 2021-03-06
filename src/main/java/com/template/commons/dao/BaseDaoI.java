package com.template.commons.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: BaseDaoI
 * @Description:
 * @author Peter Jia
 * @date 2016-3-11 上午9:02:20
 * 
 */
public interface BaseDaoI<T> {
	public Serializable save(T o);

	public void delete(T o);

	public void update(T o);

	public void saveOrUpdate(T o);

	public List<T> find(String hql);

	@SuppressWarnings("rawtypes")
	public List findSQL(String hql, Class T);

	@SuppressWarnings("rawtypes")
	public List findSQL(String hql);

	public List<T> find(String hql, Object[] param);

	public List<T> find(String hql, List<Object> param);

	public List<T> find(String hql, Object[] param, Integer page, Integer rows);

	public List<T> find(String hql, List<Object> param, Integer page,
			Integer rows);

	public T get(Class<T> c, Serializable id);

	public T get(String hql, Object[] param);

	public T get(String hql, List<Object> param);

	public Long count(String hql);

	public Long count(String hql, Object[] param);

	public Long count(String hql, List<Object> param);

	public Integer executeHql(String hql);

	public Integer executeHql(String hql, Object[] param);

	public Integer executeHql(String hql, List<Object> param);
}
