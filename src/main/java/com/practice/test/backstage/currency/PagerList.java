package com.practice.test.backstage.currency;

import java.util.List;

/**
 * 简易的分页包装器
 * @author Scott
 *
 * @param <T>
 */
public class PagerList<T> {

	private Integer currentPage;//当前第几页
	private Integer pageSize;//每页显示多少条数据
	private Integer totalSize;//总数量
	private Integer totalPage;//总页数
	private String prefixRequest;//流转路径
	
	private List<T> list;

	/**
	 * @param pageNo	第几页
	 * @param pageSize	每页容量
	 * @param sourceList	源数据
	 */
	public PagerList(Integer pageNo,Integer pageSize,String prefixUrl,List<T> sourceList,Integer counts){
        
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
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getPrefixRequest() {
		return prefixRequest;
	}

	public void setPrefixRequest(String prefixRequest) {
		this.prefixRequest = prefixRequest;
	}
	
}
