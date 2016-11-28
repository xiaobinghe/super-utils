package com.locensate.superlibray.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * -------------------------------------
 * <p>
 * 项目名称： lepro
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：集合工具类list的排序
 * <p>
 * 作者： xiaobinghe
 * <p>
 * 时间： 2016/11/16
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class ListUtils {

	private ListUtils(){
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	/** 判断集合是否为空 */
	public static boolean isEmpty(List<Object> list) {

		if (list == null) {
			return true;
		}
		return false;

	}

	/** 判断集合是否为空 */
	public static <T> int size(List<T> mDatas) {

		if (mDatas == null) {
			return 0;
		}
		return mDatas.size();

	}

	/** 按照排序字段进行排序 */
	public static void sortIntegerList(List<Integer> list) {
		if (list != null) {
			Comparator comp = new Comparator() {
				public int compare(Object o1, Object o2) {
					int r1 = (Integer) o1;
					int r2 = (Integer) o2;
					return r1 - r2;
				}
			};
			Collections.sort(list, comp);
		}
	}


}
