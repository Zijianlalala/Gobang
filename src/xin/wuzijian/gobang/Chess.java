package xin.wuzijian.gobang;
/**
 * 棋子类
 * @author wuzijian
 *
 */
public class Chess {
	//id=1时是黑棋，id=0时是白棋
	private int id;
	//棋子的坐标
	private Position position;
	
	
	public Chess() {}
	public Chess(int id, Position position) {
		super();
		this.id = id;
		this.position = position;
	}
	
	//setter&&getter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	
}
