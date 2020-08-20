package codebreaker;

import java.io.BufferedReader;
import java.io.IOException;
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
		int[] answer = new int[3];
		int[] input = new int[3];
		int hit = 0, blow = 0, count = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//タイトルとルールの表示
		System.out.println(title);
		System.out.println(rule);

		//ランダムな答えの作成
		for(int i=0; i<answer.length; i++) {
			boolean flag = false;
			answer[i] = (int)(Math.random()*6 + 1);
			do {
				flag = false;
				for(int j=i-1; j>=0; j--) {
					if(answer[i]==answer[j]) {
						flag = true;
						answer[i]=(int)(Math.random()*6 + 1);
					}
				}
			} while(flag);
		}
			//答えを表示
			String shown_answer = "";
			for(int i=0;i<answer.length;i++) {
				shown_answer += answer[i];
			}
			System.out.println("答えは " + shown_answer);

		//ゲーム
		while(true) {
			count++;
			System.out.println("***" + count + "回目***");
			for(int i=0;i<answer.length;i++) {
				System.out.print( (i+1) + "個目 : ");
				try {
					input[i] = Integer.parseInt(br.readLine());
				}catch(NumberFormatException e) {
					System.err.println("数値を入力してください");
					i--;
				}catch(IOException e) {
					System.err.println("もう一度入力してください");
					i--;
				}
			}
				//入力した数値を表示
				String shown_input = "";
				for(int i=0;i<input.length;i++) {
					shown_input += input[i];
				}
				System.out.println("あなたの選んだ数字は " + shown_input);

			//答えの判断
			hit = 0;
			blow = 0;
			for(int i=0;i<answer.length;i++) {
				for(int j=0;j<answer.length;j++) {
					if(i == j && input[i] == answer[j]) {
						hit++;
					}else if(input[i] == answer[j]) {
						blow++;
					}
				}
			}

			//判断の表示
			System.out.println("ヒット : " + hit + " | ブロー : " + blow);
		}

	}
}
