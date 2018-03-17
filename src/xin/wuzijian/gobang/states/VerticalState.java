package xin.wuzijian.gobang.states;

import xin.wuzijian.gobang.Chess;

public class VerticalState extends AroundState {

	@Override
	public boolean getState(int i, int j, int id, Chess[][] board) {
		return checkLine(i-1,j,id,board) || checkLine(i+1,j,id,board);
	}

}