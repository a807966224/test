package com.practice.test.backstage.daos;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.practice.test.backstage.beans.Emp;

/**
 * mapper 对应人员映射类  
 * @author Scott
 *
 */
public interface EmpDao{
	
	/**
	 * 获取人员分页集合
	 * @param skip  从哪条开始获取数据
	 * @param size  每页显示多少条数据
	 * @return
	 */
	@SelectProvider(type=com.practice.test.backstage.daos.impl.EmpSql.class,method="getEmpForPage")
	public List<Emp> getEmpForPage(@Param("skip") Integer skip,@Param("size") Integer size);

	/**
	 * 获取数据数量
	 * @return
	 */
	@SelectProvider(type=com.practice.test.backstage.daos.impl.EmpSql.class,method="getEmpForCount")
	public Integer getEmpForCount();
}
