package com.candy.utils;

import java.util.List;

public class PageBean {
	//当前页数
	private Integer currentPage;
	//总记录数
	private Integer totalCount;
	//每页条数
	private Integer pageSize;
	//总页数
	private Integer totalPage;
	//分页列表数据
	private List list;
	
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		
		this.totalCount = totalCount;
		//下面这两个参数如果前端没有选择，则需要初始化一个值
		this.currentPage = currentPage;
		
		if(this.currentPage == null) {
			//如果页面没有指定显示哪一页，显示第一页
			this.currentPage = 1;
		}
		
		this.pageSize = pageSize;
		
		if(this.pageSize == null) {
			//如果每页显示条数没有指定，默认每页显示3条
			this.pageSize = 3;
		}
		
		//计算总页数
		this.totalPage = (this.totalCount+this.pageSize -1)/this.pageSize;
		
		//判断当前页数是否合法
		//如果当前页数小于1 
		if(this.currentPage < 1) {
			this.currentPage = 1;
		}
		//如果当前页数大于总页数
		if(this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
	}

	//计算起始索引
	public int getStart() {
		return (this.currentPage-1)*this.pageSize;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	
	
}