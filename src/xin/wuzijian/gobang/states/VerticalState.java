package xin.wuzijian.gobang.states;

import xin.wuzijian.gobang.element.Checkerboard;
import xin.wuzijian.gobang.element.Chess;

public class VerticalState extends AroundState {

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
