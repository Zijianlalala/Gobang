package xin.wuzijian.gobang;

import xin.wuzijian.gobang.states.AroundState;
import xin.wuzijian.gobang.states.HorizontalState;
import xin.wuzijian.gobang.states.LeftSlashState;
import xin.wuzijian.gobang.states.RightSlashState;
import xin.wuzijian.gobang.states.VerticalState;

/**
 * 棋子类
 * @author wuzijian
 *
 */
public class Chess {
	//id=1时是黑棋，id=0时是白棋
	private int id;
	//棋子的周围状态
	private AroundState state ;
	//棋子的横坐标
	private int x;
	//棋子的纵坐标
	private int y;
	
	public Chess() {}
	public Chess(int id, int x, int y) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
	}
	public boolean getState(Chess[][] board, int type) {
		boolean result = false;
		switch(type) {
		case AroundState.LEFT_SLASH_STATE:
			state = new LeftSlashState();
			break;
		case AroundState.RIGHT_SLASH_STATE:
			state = new RightSlashState();
			break;
		case AroundState.HORIZONTAL_STATE:
			state = new HorizontalState();
			break;
		case AroundState.VERTICAL_STATE:
			state = new VerticalState();
			break;
		}
		result = state.getState(x, y, id, board);
		return result;
	}
	
	
	
	
	//setter&&getter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
