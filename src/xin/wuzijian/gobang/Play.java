package xin.wuzijian.gobang;

import java.util.Scanner;

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
			//显示棋盘
			board.showBoard();
			if(i%2 == 0) {
				System.out.println("请白棋手下棋。");
			} else {
				System.out.println("请黑棋手下棋。");
			}
			//输入落棋的坐标，如："3,3"
			System.out.print("输入您落棋的坐标，用逗号隔开：");
			String input = sc.nextLine();
			Position p = new Position();
			try {
				p = parseInput(input);
			} catch (Exception e) {
				//解决输入格式异常
				System.out.println(e.toString());
				System.out.println("请以指定格式输入，如：\"5,5\"。");
				continue;
			}
			//新建棋子
			Chess chess = new Chess(i%2==0?0:1,p);
			//判断是否胜利或出现复写棋盘的异常
			int k = board.addChess(chess);
			if(k == 1) {
				//五子连珠，游戏结束
				board.showBoard();
				System.out.println( (i%2==0?"白棋":"黑棋") + "胜出，游戏结束。");
				break;
			} else if(k == -1) {
				//棋子重复下在一个坐标上
				System.out.println("该坐标已有棋子，请重新选择坐标。");
				continue;
			}
			i++;
		}
			
	}
	//处理输入的字符串，并以Postion类型数组输出
	private static Position parseInput(String input) {
		String[] arr = input.split(",");
		Position p = new Position();
		p.setX(Integer.parseInt(arr[0]));
		p.setY(Integer.parseInt(arr[1]));
		return p;
	}

}
