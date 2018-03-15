package xin.wuzijian.gobang;

import java.util.Scanner;

/**
 * 游戏类（测试类）
 * @author wuzijian
 *
 */
public class Play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 2;
		Scanner sc = new Scanner(System.in);
		//声明棋盘
		Checkerboard board = new Checkerboard();
		int x;
		int y;
		while(true) {
			board.showBoard();
			if(i%2 == 0) {
				System.out.println("请白棋手下棋");
			} else {
				System.out.println("请黑棋手下棋");
			}
			System.out.print("输入您落棋的横坐标：");
			x = sc.nextInt();
			System.out.print("输入您落棋的纵坐标：");
			y = sc.nextInt();
			Chess chess = new Chess(i%2==0?0:1,new Position(x,y));
			if(board.addChess(chess)) {
				board.showBoard();
				System.out.println( (i%2==0?"白棋":"黑棋") + "胜出，游戏结束。");
				break;
			}
			i++;
		}
	}

}
