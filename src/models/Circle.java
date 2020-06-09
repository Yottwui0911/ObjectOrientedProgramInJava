package models;

import interfaces.Shape;

public class Circle implements Shape {

	private Double radius;

	private Circle(Builder builder) {
		this.radius = builder.radius;
	}

	public Double getArea() {
		return Math.pow(this.radius, 2) * Math.PI;
	}

	public static class Builder {
		private Double radius;

		public static Builder builder() {
			return new Builder();
		}

		Builder() {
		}

		public Builder radius(Double radius) {
			this.radius = radius;
			return this;
		}

		public Circle build() {
			if (radius == null) {
				throw new NullPointerException();
			}
			return new Circle(this);
		}
	}
}
