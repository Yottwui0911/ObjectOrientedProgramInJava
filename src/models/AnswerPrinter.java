package models;

import java.util.ArrayList;
import java.util.List;

public class AnswerPrinter {

	private static String start(int num) {
		return "========= 課題" + num + " Start =========";
	}

	private static String end(int num) {
		return "========= 課題" + num + "  end  =========";
	}

	public static void Answer(int num, String answer) {
		List<String> answers = new ArrayList<String>();
		answers.add(answer);
		Answer(num, answers);
	}

	public static void Answer(int num, List<String> answers) {

		System.out.println(start(num));
		System.out.println("");

		for (String answer : answers) {
			System.out.println(answer);
		}

		System.out.println("");
		System.out.println(end(num));
		System.out.println("");
	}

}
