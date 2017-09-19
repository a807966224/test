package com.practice.test.backstage.daos;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

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
	public List<Emp> getEmpForPage(@Param("emp") Emp emp,@Param("skip") Integer skip,@Param("size") Integer size);

	/**
	 * 获取数据数量
	 * @return
	 */
	@SelectProvider(type=com.practice.test.backstage.daos.impl.EmpSql.class,method="getEmpForCount")
	public Integer getEmpForCount(@Param("emp") Emp emp);
	
	/**
	 * 获取唯一数据
	 * @return
	 */
	@SelectProvider(type=com.practice.test.backstage.daos.impl.EmpSql.class,method="get")
	@Results({
		@Result(property="deptId",column="deptId"),
		@Result(property="dept",column="deptId",
		one=@One(select="com.practice.test.backstage.daos.DeptDao.get"))
	})
	public Emp get(@Param("id") Long id);
	
	/**
	 * 添加
	 * @param emp
	 */
	@InsertProvider(type=com.practice.test.backstage.daos.impl.EmpSql.class,method="insert")
	public void insert(@Param("emp") Emp emp);
	
	/**
	 * 修改
	 * @param emp
	 */
	@UpdateProvider(type=com.practice.test.backstage.daos.impl.EmpSql.class,method="update")
	public void update(@Param("emp") Emp emp);
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteProvider(type=com.practice.test.backstage.daos.impl.EmpSql.class,method="delete")
	public void delete(@Param("id") Long id);
	
	/**
	 * 根据部门ID查询人员集合
	 * @param id
	 * @return
	 */
	@SelectProvider(type=com.practice.test.backstage.daos.impl.EmpSql.class,method="getListByDeptId")
	public List<Emp> getListByDeptId(@Param("id") Long id);
}
