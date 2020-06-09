package models;

import interfaces.Shape;

public class Triangle implements Shape {

	private Double height;
	private Double bottom;

	private Triangle(Builder builder) {
		this.height = builder.height;
		this.bottom = builder.bottom;
	}

	public Double getArea() {
		return this.height * this.bottom / 2.0;
	}

	public static class Builder {
		private Double height;
		private Double bottom;

		public static Builder builder() {
			return new Builder();
		}

		Builder() {
		}

		public Builder height(Double height) {
			this.height = height;
			return this;
		}

		public Builder bottom(Double bottom) {
			this.bottom = bottom;
			return this;
		}

		public Triangle build() {
			if (height == null || bottom == null) {
				throw new NullPointerException();
			}
			return new Triangle(this);
		}
	}
}
