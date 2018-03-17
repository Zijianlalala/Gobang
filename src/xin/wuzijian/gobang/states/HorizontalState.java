package xin.wuzijian.gobang.states;

import xin.wuzijian.gobang.Chess;

public class HorizontalState extends AroundState {

	@Override
	public boolean getState(int i, int j, int id, Chess[][] board) {
		return checkLine(i,j-1,id,board) || checkLine(i,j+1,id,board);
	}

}
