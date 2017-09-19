package com.practice.test.backstage.emp;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一属性，用来分页查询
 * 分页条件与分页属性都需要保留 
 * @author Scott
 *
 */
public class Test {

	public static void main(String[] args) {
		
		//此处保留分页属性
		B b = new C(1,2,"a",new ArrayList(),1);
		
		System.out.println(b.getPrefixRequest());
	}
}



/**
 * 存放获取数据方法
 * IPager
 * @author Scott
 *
 */
interface A{
	public Integer getCurrentPage();
	public Integer getPageSize();
	public Integer getTotalSize();
	public Integer getTotalPage();
	public String getPrefixRequest();
	public List getList();
}

/**
 * 放置属性 并实现A类方法
 * ImplPager
 * @author Scott
 *
 */
abstract class B implements A{
	
	private Integer currentPage;//当前第几页
	private Integer pageSize;//每页显示多少条数据
	private Integer totalSize;//总数量
	private Integer totalPage;//总页数
	private String prefixRequest;//流转路径
	
	private List list;
	
	public B(Integer pageNo,Integer pageSize,String prefixUrl,List sourceList,Integer counts){
        
		if(sourceList==null){
            return;
        }
        
        this.totalSize = counts;
        
        this.pageSize = pageSize;
        
        this.prefixRequest = prefixUrl;
        
        this.totalPage = this.totalSize % this.pageSize == 0 ? this.totalSize / this.pageSize : this.totalSize / this.pageSize + 1;
        
        if(this.totalPage < pageNo){
            this.currentPage = this.totalPage;
        }else{
            this.currentPage = pageNo;
        }
        
        this.list = sourceList;
   }
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public void setPrefixRequest(String prefixRequest) {
		this.prefixRequest = prefixRequest;
	}

	public void setList(List list) {
		this.list = list;
	}

	@Override
	public Integer getCurrentPage() {
		return this.currentPage;
	}

	@Override
	public Integer getPageSize() {
		return this.pageSize;
	}

	@Override
	public Integer getTotalSize() {
		return this.totalSize;
	}

	@Override
	public Integer getTotalPage() {
		return this.totalPage;
	}

	@Override
	public String getPrefixRequest() {
		return this.prefixRequest;
	}

	@Override
	public List getList() {
		return this.list;
	}

	
}

/**
 * 实例化B与A的相关属性
 * 
 * @author Scott
 * BaseBean
 */
class C extends B{

	public C(Integer pageNo, Integer pageSize, String prefixUrl, List sourceList, Integer counts) {
		super(pageNo, pageSize, prefixUrl, sourceList, counts);
	}

}

