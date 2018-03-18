package xin.wuzijian.gobang.states;

import xin.wuzijian.gobang.element.Checkerboard;
import xin.wuzijian.gobang.element.Chess;

public class HorizontalState extends AroundState {

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
