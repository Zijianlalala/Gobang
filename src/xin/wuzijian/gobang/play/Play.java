package xin.wuzijian.gobang.play;

import java.util.Scanner;

import xin.wuzijian.gobang.element.Checkerboard;
import xin.wuzijian.gobang.element.Chess;

/**
 * 游戏类（测试类）
 * @author wuzijian
 *
 */
public class Play {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//用于改变下棋回合
		int i = 2;
		//声明棋盘
		Checkerboard board = new Checkerboard();
		//开始游戏
		while(true) {
			board.showBoard();
			String header = i%2==0?"请白棋手下棋。":"请黑棋手下棋。";
			System.out.print(header + "\n输入您落棋的坐标，用逗号隔开：");
			String input = sc.nextLine();
			int[] position;
			try {
				position = parseInput(input);
			} catch (Exception e) {
				System.out.println("请以指定格式输入，如：\"5,5\"。");
				continue;
			}
			//新建棋子
			Chess chess = new Chess(i%2==0?0:1,position[0],position[1]);
			//判断该位置能否下棋
			if(!board.isAvailable(chess.getX(), chess.getY())) {
				System.out.println("请重新选择合法坐标");
				continue;
			}
			//将棋子添加到棋盘上并判断是否胜利
			if(board.addChess(chess)) {
				board.showBoard();
				System.out.println( (i%2==0?"白棋":"黑棋") + "胜出，游戏结束。");
				break;
			} 
			i++;
		}
		sc.close();
			
	}

	private static int[] parseInput(String input) {
		String[] arr = input.split(",");
		int[] result = {Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
		return result;
	}

}
