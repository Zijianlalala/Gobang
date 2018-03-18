package xin.wuzijian.gobang.memento;

import xin.wuzijian.gobang.element.Chess;

/**
 * 备忘录类
 */
public class Memento {
	private Chess[][] oldBoard;
	
	public Memento(Chess[][] state) {
		this.oldBoard = state;
	}
	
	public Chess[][] getOldBoard() {
		return this.oldBoard;
	}
}
