package xin.wuzijian.gobang.play;

import java.util.Scanner;

import xin.wuzijian.gobang.element.Checkerboard;
import xin.wuzijian.gobang.element.Chess;
import xin.wuzijian.gobang.memento.CareTaker;

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
		//声明备忘录管理者
		CareTaker careTaker = new CareTaker();
		//开始游戏
		while(true) {
			board.showBoard();
//			if(i > 2) {
//				//询问棋手要悔棋吗
//				System.out.print("您要悔棋吗?(yes/no):");
//				String isUndo = sc.nextLine();
//				if(!"".equals(isUndo) && "yes".equals(isUndo)) {
//					board.setMemento(careTaker.getMemento());
//					i--;
//					continue;
//				}
//			}
			String header = i%2==0?"请白棋手下棋。":"请黑棋手下棋。";
			System.out.print(header + "\n若要悔棋输入：'undo'" 
						+"\n输入您落棋的坐标，用逗号隔开：");
			String input = sc.nextLine();
			int[] position = null;
			try {
				position = parseInput(input);
			} catch (Exception e) {
				System.out.println("请以指定格式输入，如：\"5,5\"。");
				continue;
			}
			if (position == null) {
				board.setMemento(careTaker.getMemento());
				i--;
				continue;
			}
			//将当前状态保存到备忘录中
			careTaker.setMemento(board.createMemento());

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
		if(!"".equals(input) && "undo".equals(input)) {
			return null;
		}
		String[] arr = input.split(",");
		int[] result = {Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
		return result;
	}

}
