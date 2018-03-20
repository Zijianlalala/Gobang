package xin.wuzijian.gobang.states;

import xin.wuzijian.gobang.element.Checkerboard;
import xin.wuzijian.gobang.element.Chess;

public class HorizontalState extends AroundState {
	// 单例模式 避免生成大量的状态对象
	private static HorizontalState singleton;
	public static HorizontalState getInstance() {
		if (singleton == null) {
			singleton = new HorizontalState();
		}
		count = 1;
		return singleton;
	}
	@Override
	public boolean getState(int i, int j, int id, Chess[][] board) {
		return checkLine(i,j-1,id,board) || checkLine(i,j+1,id,board);
	}

	@Override
	public int getCount(int x, int y, int id, Chess[][] board) {
		int j = y;
		//向左检查
		while(j>0 && board[x][--j]!=null && id == board[x][j].getId()) {
			count++;
		}
		//向右检查并将j归位
		j = y;
		while(j<Checkerboard.LENGTH_OF_BOARD && board[x][++j]!=null 
				&& id == board[x][j].getId()) {
			count++;
		}
		return count;
	}

}
