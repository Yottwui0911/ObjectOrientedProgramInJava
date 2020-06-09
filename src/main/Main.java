package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import interfaces.Shape;
import models.AnswerPrinter;
import models.Circle;
import models.Square;
import models.Triangle;
import utils.ShapeUtil;

public class Main {

	public static void main(String[] args) {

		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;
		List<Triangle> triangles = new ArrayList<Triangle>();
		List<Square> squares = new ArrayList<Square>();
		List<Circle> circles = new ArrayList<Circle>();

		try {
			//読み込みファイルのインスタンス生成
			//ファイル名を指定する
			fi = new FileInputStream("shapes.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//読み込み行
			String line;

			Boolean first = true;

			//列名を管理する為の配列
			String[] arr = null;

			//1行ずつ読み込みを行う
			while ((line = br.readLine()) != null) {
				if (first) {
					// 一行目は無視
					first = false;
					continue;
				}

				String[] fragments = line.split(",");

				triangles.add(Triangle.Builder.builder().height(Double.parseDouble(fragments[0]))
						.bottom(Double.parseDouble(fragments[1])).build());
				squares.add(Square.Builder.builder().height(Double.parseDouble(fragments[2]))
						.bottom(Double.parseDouble(fragments[3])).build());
				circles.add(Circle.Builder.builder().radius(Double.parseDouble(fragments[4])).build());

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 課題2
		List<String> answer_2 = triangles.stream()
				.map(Triangle::getArea)
				.map(x -> BigDecimal.valueOf(x).setScale(2, RoundingMode.HALF_UP).toPlainString())
				.collect(Collectors.toList());

		AnswerPrinter.Answer(2, answer_2);

		// 課題3
		Boolean isExist_3 = false;

		for (Triangle triangle : triangles) {
			isExist_3 = triangle.getArea() > 1000;
			
			// trueになれば抜ける
			if(isExist_3){
				break;
			}
		}

		AnswerPrinter.Answer(3, isExist_3.toString());

		// 課題4
		Boolean isExist_4 = triangles.stream().anyMatch(x -> x.getArea() > 1000);

		AnswerPrinter.Answer(4, isExist_4.toString());

		// 課題5
		String answer_5 = triangles.stream()
				.map(Triangle::getArea)
				.filter(x -> x > 1000)
				.map(x -> BigDecimal.valueOf(x).setScale(2, RoundingMode.HALF_UP).toPlainString())
				.findFirst()
				.orElseGet(() -> "0");

		AnswerPrinter.Answer(5, answer_5);

		// 課題6
		long answer_6 = triangles.stream()
				.filter(x -> x.getArea() > 1000)
				.count();

		AnswerPrinter.Answer(6, Long.toString(answer_6));

		// 課題7
		Double answer_7 = triangles.stream()
				.collect(Collectors.summarizingDouble(x -> x.getArea()))
				.getAverage();

		AnswerPrinter.Answer(7, BigDecimal.valueOf(answer_7).setScale(2, RoundingMode.HALF_UP).toPlainString());

		// 課題8
		List<String> answer_8 = triangles
				.stream()
				.sorted(Comparator.comparingDouble(Triangle::getArea))
				.map(Triangle::getArea)
				.sorted(Comparator.reverseOrder())
				.limit(10)
				.map(x -> BigDecimal.valueOf(x).setScale(2, RoundingMode.HALF_UP).toPlainString())
				.collect(Collectors.toList());

		AnswerPrinter.Answer(8, answer_8);

		// 課題10
		List<String> answer_10 = squares.stream()
				.map(Square::getArea)
				.map(x -> BigDecimal.valueOf(x).setScale(2, RoundingMode.HALF_UP).toPlainString())
				.collect(Collectors.toList());

		AnswerPrinter.Answer(10, answer_10);

		// 課題11
		Boolean answer_11 = squares.stream().anyMatch(x -> x.getArea() > 1000);

		AnswerPrinter.Answer(11, answer_11.toString());

		// 課題13
		List<String> answer_13 = circles.stream()
				.map(Circle::getArea)
				.map(x -> BigDecimal.valueOf(x).setScale(2, RoundingMode.HALF_UP).toPlainString())
				.collect(Collectors.toList());

		AnswerPrinter.Answer(13, answer_13);

		// 課題14
		Boolean answer_14 = circles.stream().anyMatch(x -> x.getArea() > 1000);

		AnswerPrinter.Answer(14, answer_14.toString());

		List<Shape> shapes = new ArrayList<Shape>();
		shapes.addAll(triangles);
		shapes.addAll(squares);
		shapes.addAll(circles);

		// 課題16
		Double sum = ShapeUtil.SumShapes(shapes);
		AnswerPrinter.Answer(16, BigDecimal.valueOf(sum).setScale(2, RoundingMode.HALF_UP).toPlainString());
	}
}
