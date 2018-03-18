package xin.wuzijian.gobang.states;

import xin.wuzijian.gobang.element.Checkerboard;
import xin.wuzijian.gobang.element.Chess;

public class RightSlashState extends AroundState {

	@Override
	public boolean getState(int i, int j, int id, Chess[][] board) {
		return checkLine(i-1, j+1, id, board)|| checkLine(i+1, j-1, id, board);
	}

	@Override
	public int getCount(int x, int y, int id, Chess[][] board) {
		//向右上检查
		int i = x;
		int j = y;
		System.out.println("向右上检查");
		while((i>0 && j<Checkerboard.LENGTH_OF_BOARD) 
				&& board[--i][++j]!=null && id == board[i][j].getId()) {
			count++;
		}
		//向左下检查并将i,j归位
		i = x;
		j = y;
		while((i<Checkerboard.HEIGHT_OF_BOARD && j>0) 
				&& board[++i][--j]!=null && id == board[i][j].getId()) {
			count++;
		}
		return count;
	}

}
