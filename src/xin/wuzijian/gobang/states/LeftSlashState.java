package xin.wuzijian.gobang.states;

import xin.wuzijian.gobang.element.Checkerboard;
import xin.wuzijian.gobang.element.Chess;

public class LeftSlashState extends AroundState {

	@Override
	public boolean getState(int i, int j, int id, Chess[][] board) {
		return checkLine(i-1, j-1, id, board) || checkLine(i+1, j+1, id, board);
	}
	
	//查看沿当前方向相连的同色棋子的个数
	public int getCount(int x, int y, int id, Chess[][] board) {
		int i = x;
		int j = y;
		//向左上检查
		while((i>0 && j>0) && board[--i][--j]!=null && id == board[i][j].getId()) {
			count++;
		}
		//向右下检查并将i,j归位
		i = x;
		j = y;
		while((i<Checkerboard.HEIGHT_OF_BOARD && j<Checkerboard.LENGTH_OF_BOARD) 
				&& board[++i][++j]!=null &&id == board[i][j].getId()) {
			count++;
		}
		return 0;
	}

}
