package com.work.junit.mockito.andSpring;

public class Calculator {
	private Rectangle rectangle;

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public int getArea() {
		return rectangle.getLength() * rectangle.getBreadth();
	}

}
