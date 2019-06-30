package com.xilews.springboot.app.util.paginator;

import java.util.List;
import java.util.ArrayList;


import org.springframework.data.domain.Page;

public class PageRender<T> {
	private String url; 
	private Page<T> page;
	private int totalPages; 
	private int elementsPerPage;
	private int currentPage;
	private List<PageItem> pages;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<PageItem>();
		
		elementsPerPage = page.getSize();
		totalPages = page.getTotalPages();
		currentPage = page.getNumber() + 1;
		
		int fromPage, toPage;
		if(totalPages <= elementsPerPage) {
			fromPage = 1;
			toPage = totalPages;
		} else {
			if(currentPage <= elementsPerPage/2) {
				fromPage = 1;
				toPage = elementsPerPage;
			} else if(currentPage >= totalPages - elementsPerPage/2) {
				fromPage = totalPages - elementsPerPage + 1;
				toPage = elementsPerPage;
			} else {
				fromPage = currentPage - elementsPerPage/2;
				toPage = elementsPerPage;
			}
		}
		
		for(int i = 0; i < toPage; i++) {
			pages.add(new PageItem(fromPage + i, currentPage == fromPage + i));
		}
	}

	
	public String getUrl() {
		return url;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<PageItem> getPages() {
		return pages;
	}

	public int getCurrentPage() {
		return currentPage;
	} 
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean hasNext() {
		return page.hasNext();
	}
	
	public boolean hasPrevious() {
		return page.hasPrevious();
	}
	
}
