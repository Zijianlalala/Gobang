package xin.wuzijian.gobang.states;

import xin.wuzijian.gobang.element.Checkerboard;
import xin.wuzijian.gobang.element.Chess;

public class VerticalState extends AroundState {
	// 单例模式 避免生成大量的状态对象
	private static VerticalState singleton;

	public static VerticalState getInstance() {
		if (singleton == null) {
			singleton = new VerticalState();
		}
		count = 1;
		return singleton;
	}
	@Override
	public boolean getState(int i, int j, int id, Chess[][] board) {
		return checkLine(i-1,j,id,board) || checkLine(i+1,j,id,board);
	}

	@Override
	public int getCount(int x, int y, int id, Chess[][] board) {
		//向上检查
		int i = x;
		System.out.println("向上检查");
		while(i>0 && board[--i][y]!=null && id == board[i][y].getId()) {
			count++;
		}
		//将i归位并向下检查
		i = x;
		while(i<Checkerboard.HEIGHT_OF_BOARD && board[++i][y]!=null
				&&id == board[i][y].getId()) {
			count++;
		}
		return count;
	}

}
