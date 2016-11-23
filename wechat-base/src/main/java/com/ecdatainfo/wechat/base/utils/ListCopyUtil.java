package com.ecdatainfo.wechat.base.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * 数组拷贝工具
 * @author changt
 */
public class ListCopyUtil {

	/**
	 * 拷贝工具
	 * @param it
	 * @param factory
	 * @param <S>
	 * @param <T>
	 * @return
	 */
	public static <S,T> List<T> copyAsList(Iterator<S> it,ObjectFactory<S,T> factory){
		List<T> targetList = new ArrayList<T>();
		if(it != null ){
			T target = null;
			S source = null;
			while(it.hasNext()){
				source = it.next();
				target = factory.newInstance();
				factory.before(source, target);
				deepCopy(source,target);
				factory.after(source, target);
				targetList.add(target);
			}
		}
		return targetList;
	}

	/**
	 * 拷贝工具
	 * @param it
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> copyAsList(Iterator<?> it,Class<T> clazz){
		List<T> targetList = new ArrayList<T>();
		if(it != null ){
			T target = null;
			try {
				while(it.hasNext()){
					target = clazz.newInstance();
					deepCopy(it.next(),target);
					targetList.add(target);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return targetList;
	}

	/**
	 * 拷贝工具
	 * @param it
	 * @param factory
	 * @param <S>
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <S,T> T[] copyAsArray(Iterator<S> it,ObjectFactory<S,T> factory){
		List<T> targetList =  copyAsList(it, factory);
		return (T[])targetList.toArray();
	}

	/**
	 * 拷贝工具
	 * @param it
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] copyAsArray(Iterator<?> it,Class<T> clazz){
		List<T> targetList =  copyAsList(it, clazz); 
		return (T[])targetList.toArray();
	}
	/**
	 * 深度拷贝，暂不实现
	 * @param source
	 * @param target
	 */
	public static void deepCopy(Object source,Object target){
		BeanUtils.copyProperties(source, target);
	}
}