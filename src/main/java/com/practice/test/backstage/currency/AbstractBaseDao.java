package com.practice.test.backstage.currency;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 此类用来调用sql xml文件对应sql
 * 
 * @author 
 *
 * @param <T>
 */
public abstract class AbstractBaseDao<T extends BaseBean> extends SqlSessionDaoSupport implements BaseDao<T> {

	//根据条件查询数据集合
    private static final String SQL_SELECT_ALL = "selectAll";
    //查询数据总量
    private static final String SQL_SELECT_COUNT = "selectCount";
	//添加
	private static final String SQL_INSERT = "insert";
    //删除
	private static final String SQL_DELETE_BY_PRIMARY_KEY = "delete";
	//批量删除
	private static final String SQL_DELETE_BATCH_BY_PRIMARY_KEY = "deleteBatch";
    //修改
	private static final String SQL_UPDATE_BY_PRIMARY_KEY = "update";
    //根据主键查询唯一数据
	private static final String SQL_SELECT_BY_PRIMARY_KEY = "get";
	
	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	    super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	    super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	/**
	 * 获取xml完全限定名
	 * @param sqlId	默认对应的ID值
	 * @return
	 */
	public String getStatement(String sqlId) {
		
		String name = this.getClass().getName();//获取类名（包路径+类名）
		
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append(name).append(".").append(sqlId);
		
		return stringBuffer.toString();
    }
	
	@Override
	public List<T> selectAll(T t) {
		return getSqlSession().selectList(getStatement(SQL_SELECT_ALL),t);
	}

	@Override
	public Integer selectCount() {
		return getSqlSession().selectOne(getStatement(SQL_SELECT_COUNT));
	}

	@Override
	public Integer insert(T t) {
		return getSqlSession().insert(getStatement(SQL_INSERT), t);
	}

	@Override
	public Integer update(T t) {
		return getSqlSession().insert(getStatement(SQL_UPDATE_BY_PRIMARY_KEY), t);
	}

	@Override
	public Integer delete(Long id) {
		return getSqlSession().delete(getStatement(SQL_DELETE_BY_PRIMARY_KEY), id);
	}

	@Override
	public T get(Long id) {
		return getSqlSession().selectOne(SQL_SELECT_BY_PRIMARY_KEY, id);
	}

	@Override
	public Integer deleteBatch(Map paramters) {
		return getSqlSession().delete(SQL_DELETE_BATCH_BY_PRIMARY_KEY, paramters);
	}

	
}
