package xin.wuzijian.gobang.states;

import xin.wuzijian.gobang.Chess;

public  abstract class AroundState {
	public static final int LEFT_SLASH_STATE = 1;
	public static final int RIGHT_SLASH_STATE = 3;
	public static final int VERTICAL_STATE = 2;
	public static final int	HORIZONTAL_STATE = 4;
	public static final int[] STATE = 
		{LEFT_SLASH_STATE,VERTICAL_STATE,RIGHT_SLASH_STATE,HORIZONTAL_STATE};
	
	public abstract boolean getState(int i, int j, int id, Chess[][] board);
	
	
	protected boolean checkLine(int i, int j, int id, Chess[][] board) {
		return board[i][j]!=null && board[i][j].getId() == id;
	}
	
}
