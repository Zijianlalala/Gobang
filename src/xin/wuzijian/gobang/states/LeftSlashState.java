package xin.wuzijian.gobang.states;

import xin.wuzijian.gobang.Chess;

public class LeftSlashState extends AroundState {

	@Override
	public boolean getState(int i, int j, int id, Chess[][] board) {
		return checkLine(i-1, j-1, id, board) || checkLine(i+1, j+1, id, board);
	}
	
	//查看沿当前方向相连的同色棋子的个数
	public int getCount() {
		return 0;
	}

}
