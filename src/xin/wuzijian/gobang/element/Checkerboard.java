package xin.wuzijian.gobang.element;

import xin.wuzijian.gobang.states.AroundState;

/**
 * 棋盘类
 * @author wuzijian
 *
 */
public class Checkerboard {
	public static final int HEIGHT_OF_BOARD = 12;
	public static final int LENGTH_OF_BOARD = 12;
	// 维护一个棋盘（二维数组）
	private Chess[][] board = new Chess[HEIGHT_OF_BOARD][LENGTH_OF_BOARD];
	
	public boolean addChess(Chess chess) {
		int i = chess.getX();
		int j = chess.getY();
		board[i][j] = chess;	
		if (checkAround(chess)) return true;
		return false;
	}
	
	//判断该位置是否已经有棋子以及坐标是否越界
	public boolean isAvailable(int i, int j) {
		boolean result1 = i>0&&i<HEIGHT_OF_BOARD;
		boolean result2 = j>0&&j<LENGTH_OF_BOARD;
		return result1 && result2 && board[i][j]==null;
	}
	
	// 查看四个方向是否有相邻同色棋子，若有则查看是否构成五子连珠 
	private boolean checkAround(Chess chess) {
		boolean result = false;
		for(int i = 0; i < AroundState.STATE.length; i++) {
			if(chess.getState(board, AroundState.STATE[i])) {
				result = checkBang(chess, AroundState.STATE[i]);
			}
		}
		return result;
	}	
	
	// 查看沿当前方向是否有五个连续的同色棋子
	private boolean checkBang(Chess chess, int type) {
		// 计数器，当计数器到达5时，五子连珠
		int count = 1;
		for(int i = 0; i < AroundState.STATE.length; i++) {
			if(type == AroundState.STATE[i]) {
				count = chess.getCount(board, type);
			}
		}
 		return count==5?true:false;
	}
	
	//展示当前棋盘
	public void showBoard() {
		for(int i = 0; i < HEIGHT_OF_BOARD; i++) {
			System.out.print(i + " ");
			for(int j = 1; j < LENGTH_OF_BOARD; j++) {
				if(i == 0) {
					System.out.print(j + "  ");
					continue;
				}
				System.out.print((board[i][j]!=null?board[i][j].getId():"-") + "  ");
			}
			System.out.println();
		}
	}
}
