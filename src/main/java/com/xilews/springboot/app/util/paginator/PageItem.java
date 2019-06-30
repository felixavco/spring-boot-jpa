package com.xilews.springboot.app.util.paginator;

public class PageItem {

	private int number; 
	private boolean isCurrent;
	
	public PageItem(int number, boolean isCurrent) {
		this.number = number;
		this.isCurrent = isCurrent;
	}

	public int getNumber() {
		return number;
	}

	public boolean isCurrent() {
		return isCurrent;
	}
	
	
}
