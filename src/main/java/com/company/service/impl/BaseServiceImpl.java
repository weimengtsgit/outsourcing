package com.company.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.transaction.annotation.Transactional;

import com.company.dao.BaseDao;
import com.company.service.BaseServiceI;

/**
 * 
 * @author wuyq
 *
 * @param <T>
 * @param <ID>
 */
public abstract class BaseServiceImpl<T> implements BaseServiceI<T>{
	protected static final char[] codeSource = new char[]{'2','3','4','5','6','7','8',
			'a','b','d','e','f','h','j','m','n','q','r','t',
			'A','B','D','E','F','G','H','J','M','N','Q','R','T'};
	
	public abstract BaseDao<T> getDao();
	
//	@Transactional
//	public void merge(List<T> curList) throws Exception {
//		List<T> preList = findALL();
//		merge(preList, curList);
//	}
	
//	@Transactional
//	public void merge(List<T> before, List<T> after) throws Exception {
//		//List<T> preList = findALL();
//		List<T> delList = new ArrayList<T>();
//		if (before != null && !before.isEmpty()) {
//			for (T preItem : before) {
//				boolean found = false;
//				for (T curItem : after) {
//					if (curItem.getId() != null && preItem.getId().equals(curItem.getId())) {
//						found = true;
//						break;
//					}
//				}
//				if (!found) {
//					delList.add(preItem);
//				}
//			}
//			delete(delList);
//		}
//		
//		update(after);
//	}
	
	/**
	 * 基本业务处理：增
	 * @param t
	 * @return T 增加的实体
	 */
	@Transactional
	public T add(T t) throws Exception{
		return getDao().save(t);
	}
	
	@Transactional
	public List<T> add(Iterable<T> t) throws Exception {
		List<T> list = new ArrayList<T>();
		Iterator<T> iter = getDao().save(t).iterator();
		for( ; iter.hasNext();) {
			list.add(iter.next());
		}
		return list;
	}
	/**
	 * 基本业务处理：删
	 * @param t 删除的实体,请保证t的id存在
	 * @return void
	 */
	@Transactional
	public void delete(T t) {
		getDao().delete(t);
	}
	
	@Transactional
	public void delete(Iterable<T> t) {
		if( t == null  ) {
			return;
		}
		getDao().delete(t);
	}
	
	@Transactional
	public void deleteALL() {
		getDao().deleteAll();
	}
	
	/**
	 * 基本业务处理：删
	 * @param id 删除的实体的id,请保证t的id存在
	 * @return void
	 */
	@Transactional
	public void delete(String id) {
		getDao().delete(id);
	}
	
	
	/**
	 * 基本业务处理：群删
	 * @param ids 删除的实体的id字符串,格式: id1,id2,id3
	 * @return void
	 */
	@Transactional
	public void batchDelete(String ids) {
		if( ids != null && ids.length() > 0 ) {
			 for( String id : ids.split(",")) {
				 getDao().delete(id);
			 }
		 }
	}
	
	/**
	 * 基本业务处理：群删
	 * @param ids 删除的实体的id字符串,格式: id1,id2,id3
	 * @return void
	 */
	@Transactional
	public void batchDelete(Iterable<String> ids) {
		if( ids != null  ) {
			 for( String id : ids) {
				 getDao().delete(id);
			 }
		 }
	}
	
	/**
	 * 基本业务处理：改
	 * @param t 要更新的实体,请保证t的id存在
	 * @return T 更新后的实体
	 */
	@Transactional
	public T update(T t) {
//		t.setModifyDate(new Date());
		return getDao().save(t);
	}
	
	@Transactional
	public List<T> update(Iterable<T> t) {
		if( t == null  ) {
			return null;
		}
//		for( T item : t) {
//			item.setModifyDate(new Date());
//		}
		Iterator<T> iterator = getDao().save(t).iterator();
		List<T> list = new ArrayList<T>();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}
	
	/**
	 * 基本业务处理：查
	 * @param id
	 * @return 查到的数据
	 */
	@Transactional(readOnly=true)
	public T findOne(String id) {
		return getDao().findOne(id);
	}
	
	public List<T> findALL(Iterable<String> ids) {
		List<T> list = new ArrayList<T>();
		Iterator<T> iter = getDao().findAll(ids).iterator();
		for( ; iter.hasNext();) {
			list.add(iter.next());
		}
		return list;
	}
	/**
	 * 基本业务处理：查
	 * @param id
	 * @return 查到的数据
	 */
	@Transactional(readOnly=true)
	public List<T> findALL() {
		List<T> list = new ArrayList<T>();
		Iterator<T> iter = getDao().findAll().iterator();
		for( ; iter.hasNext();) {
			list.add(iter.next());
		}
		return list;
	}
	
//    public PageRequest buildPageRequest(PageHelper ph) {
//        Sort sort = null;
//        Direction d = Direction.ASC;
//        String s = "createDate";
//        if( ph.getOrder()!= null && ph.getOrder().equals("desc")) {
//        	d = Direction.DESC;
//        }
//        if(ph.getSort()!= null && ph.getSort().length() > 0) {
//        	s = ph.getSort();
//        }
//        sort = new Sort(d, s);
//        
//        return new PageRequest(ph.getPage() - 1, ph.getRows(), sort);
//    }
	
//	@Transactional
//	public void disable(String id) {
//		T t = getDao().findOne(id);
//		t.setDelFlagType(DelFlagType.DEL);
//		getDao().save(t);
//	}
//	
//	@Transactional
//	public void enable(String id) {
//		T t = getDao().findOne(id);
//		t.setDelFlagType(DelFlagType.UNDEL);
//		getDao().save(t);
//	}
	
	@Transactional(readOnly=true)
	public long count() {
		return getDao().count();
	}
	
	public String whereToString(List<String> wheres) {
		String queryStr = "";
		if( !wheres.isEmpty() ) {
			boolean first = true;
			for( String string : wheres ) {
				if( first ) {
					first = false;
				} else {
					queryStr += " AND ";
				}
				queryStr += " " + string +" ";
			}
		}
		
		return queryStr;
	}
	
	public String whereToStringWithOr(List<String> wheres) {
		String queryStr = "";
		if( !wheres.isEmpty() ) {
			boolean first = true;
			for( String string : wheres ) {
				if( first ) {
					first = false;
				} else {
					queryStr += " OR ";
				}
				queryStr += " " + string +" ";
			}
		}
		
		return queryStr;
	}
	
	protected String getCode(int length) {
		int codeLength = codeSource.length;
		Random random = new Random();
		
		char[] code = new char[length];
		for( int i = 0 ; i < length; i++) {
			int index = random.nextInt(codeLength);
			code[i] = codeSource[index];
		}
	
		return new String(code);
	}
}
