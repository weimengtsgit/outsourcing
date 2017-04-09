package com.company.service;

import java.util.List;

/**
 * 所有业务层的基类,这里封装了一些通用的方法
 *
 * @param <T>
 * @param <ID>
 */
public interface BaseServiceI<T>{
	
//	public void merge(List<T> t) throws Exception;
//	public void merge(List<T> before, List<T> after) throws Exception;
	
	/**
	 * 基本业务处理：增
	 * @param t
	 * @return T 增加的实体
	 */
	public T add(T t) throws Exception;
	
	/**
	 * 基本业务处理：批量增
	 * @param t
	 * @return T 增加的实体
	 */
	public List<T> add(Iterable<T> t) throws Exception;
	
	/**
	 * 基本业务处理：删
	 * @param t 删除的实体,请保证t的id存在
	 * @return void
	 */
	public void delete(T t);
	public void delete(Iterable<T> t);
	
	/**
	 * 基本业务处理：删
	 * @param id 删除的实体的id,请保证t的id存在
	 * @return void
	 */
	public void delete(String id);
	
	/**
	 * 基本业务处理：群删
	 * @param ids 删除的实体的id字符串,格式: id1,id2,id3
	 * @return void
	 */
	public void batchDelete(String ids);
	public void batchDelete(Iterable<String> ids);
	
	public void deleteALL();
	
	/**
	 * 基本业务处理：改
	 * @param t 要更新的实体,请保证t的id存在
	 * @return T 更新后的实体
	 */
	public T update(T t);
	
	public List<T> update(Iterable<T> t);
	
	/**
	 * 基本业务处理：查
	 * @param id
	 * @return 查到的数据
	 */
	public T findOne(String id);
	public List<T> findALL(Iterable<String> ids);
	
	public List<T> findALL(); 
	
//	public void disable(String id);
//	public void enable(String id);
	public long count();
	
	/**
     * 创建分页请求.
     */
   // public PageRequest buildPageRequest(PageHelper ph);
    
    public String whereToString(List<String> wheres);
}
