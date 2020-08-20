package codebreaker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeBreakerFirst {
	public static void main(String[] args) {
		String title = "***CodeBreaker***";
		String rule = "隠された３つの数字をあてます\n"
				+ "1つの数字は1から6の間です\n"
				+ "3つの答えの中に同じ数字はありません\n"
				+ "入力した数字の、\n"
				+ "位置と数字が当たっていたらヒット、\n"
				+ "数字だけ当たっていたらブローとカウントします。\n"
				+ "全部当てたら(3つともヒットになったら)終了です。\n\n";
//		int[] answer = new int[3];
//		int[] input = new int[3];
//		int hit = 0, blow = 0, count = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(title);
		System.out.println(rule);
	}
}
