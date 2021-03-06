package com.practice.test.backstage.daos;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.practice.test.backstage.beans.Dept;

/**
 * mapper 对应部门映射类  
 * @author Scott
 *
 */
public interface DeptDao{
	
	/**
	 * 获取人员分页集合
	 * @param skip  从哪条开始获取数据
	 * @param size  每页显示多少条数据
	 * @return
	 */
	@SelectProvider(type=com.practice.test.backstage.daos.impl.DeptSql.class,method="getDeptForPage")
	@Results({
        @Result(property="id",column="id"),
        @Result(property="empList",column="id",javaType=List.class,
        many=@Many(select="com.practice.test.backstage.daos.EmpDao.getListByDeptId"))
    })
	public List<Dept> getDeptForPage(@Param("skip") Integer skip,@Param("size") Integer size);

	/**
	 * 获取数据数量
	 * @return
	 */
	@SelectProvider(type=com.practice.test.backstage.daos.impl.DeptSql.class,method="getDeptForCount")
	public Integer getDeptForCount();
	
	/**
	 * 获取唯一数据
	 * @return
	 */
	@SelectProvider(type=com.practice.test.backstage.daos.impl.DeptSql.class,method="get")
	@Results({
			@Result(id=true,property="id",column="id"),
			@Result(property="empList",column="id",
			many=@Many(select="com.practice.test.backstage.daos.EmpDao.getListByDeptId"))
	})
	public Dept get(@Param("id") Long id);
	
	/**
	 * 添加
	 * @param dept
	 */
	@InsertProvider(type=com.practice.test.backstage.daos.impl.DeptSql.class,method="insert")
	public void insert(@Param("dept") Dept dept);
	
	/**
	 * 修改
	 * @param dept
	 */
	@UpdateProvider(type=com.practice.test.backstage.daos.impl.DeptSql.class,method="update")
	public void update(@Param("dept") Dept dept);
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteProvider(type=com.practice.test.backstage.daos.impl.DeptSql.class,method="delete")
	public void delete(@Param("id") Long id);
	
	
	@SelectProvider(type=com.practice.test.backstage.daos.impl.DeptSql.class,method="getList")
	public List<Dept> getList();
}
