package utils;

import java.util.List;
import java.util.stream.Collectors;

import interfaces.Shape;

public class ShapeUtil {
	public static Double SumShapes(List<Shape> shapes) {
		return shapes.stream()
				.collect(Collectors.summarizingDouble(x -> x.CalcArea()))
				.getSum();
	}
}
