package xin.wuzijian.gobang;
/**
 * 棋盘类
 * @author wuzijian
 *
 */
public class Checkerboard {
	// 维护一个棋盘（二维数组）
	private Chess[][] board = new Chess[12][12];
	
	public Checkerboard() {
//		for(int i = 0; i < 12; i++) {
//			for(int j = 0; j < 12; j++) {
//				board[i][j] = new Chess();
//			}
//		}
	}

	
	public boolean addChess(Chess chess) {
		int i = chess.getPosition().getX();
		int j = chess.getPosition().getY();
		board[i][j] = chess;
		if (checkAround(chess)) {
			return true;
		}
		return false;
	}
	// 查看四个方向是否有相邻同色棋子  1.左上右下 2.上下 3.左下右上 4.左右
	//???没有注意边界
	public boolean checkAround(Chess chess) {
		//当前棋子的位置
		int i = chess.getPosition().getX();
		int j = chess.getPosition().getY();
		boolean result = false;
		if(checkLine(chess,i-1,j-1)|| checkLine(chess,i+1,j+1)) {
			result = checkBang(chess, 1);
		} else if(checkLine(chess,i-1,j) || checkLine(chess,i+1,j)) {
			result = checkBang(chess, 2);
		} else if(checkLine(chess,i-1,j+1) || checkLine(chess,i+1,j-1)) {
			result = checkBang(chess, 3);
		} else if(checkLine(chess,i,j-1) || checkLine(chess,i,j+1)){
			result = checkBang(chess, 4);
		}
		return result;
	}
	private boolean checkLine(Chess c, int i, int j) {
		return board[i][j]!=null && board[i][j].getId() == c.getId();
	}	
	// 查看沿当前方向是否有五个连续的同色棋子
	private boolean checkBang(Chess chess, int type) {
		// 计数器，当计数器到达5时，五子连珠
		int count = 1;
		int i = chess.getPosition().getX();
		int j = chess.getPosition().getY();
		if(type == 1) {
			//向左上检查
			while((i>0 && j>0) && board[--i][--j]!=null && chess.getId() == board[i][j].getId()) {
				count++;
			}
			//向右下检查并将i,j归位
			i = chess.getPosition().getX();
			j = chess.getPosition().getY();
			while((i<12 && j<12) && board[++i][++j]!=null &&chess.getId() == board[i][j].getId()) {
				count++;
			}
		} else if(type == 2) {
			//向上检查
			while((i>0 && j>0) && board[--i][j]!=null && chess.getId() == board[i][j].getId()) {
				count++;
			}
			//向下检查并将i,j归位
			i = chess.getPosition().getX();
			j = chess.getPosition().getY();
			while((i<12 && j<12) && board[++i][j]!=null &&chess.getId() == board[i][j].getId()) {
				count++;
			}
		} else if(type == 3) {
			//向右上检查
			while((i>0 && j>0) && board[--i][++j]!=null && chess.getId() == board[i][j].getId()) {
				count++;
			}
			//向左下检查并将i,j归位
			i = chess.getPosition().getX();
			j = chess.getPosition().getY();
			while((i<12 && j<12) && board[++i][--j]!=null &&chess.getId() == board[i][j].getId()) {
				count++;
			}
		}else if(type == 4) {
			//向左检查
			while((i>0 && j>0) && board[i][--j]!=null && chess.getId() == board[i][j].getId()) {
				count++;
			}
			//向右检查并将i,j归位
			i = chess.getPosition().getX();
			j = chess.getPosition().getY();
			while((i<12 && j<12) && board[i][++j]!=null &&chess.getId() == board[i][j].getId()) {
				count++;
			}
		}
		
		if(count == 5) {
			return true;
		}
 		return false;
	}
	//展示当前棋盘
	public void showBoard() {
		for(int i = 0; i < 12; i++) {
			System.out.print(i + " ");
			for(int j = 1; j < 12; j++) {
				if(i == 0) {
					System.out.print(j + "  ");
					continue;
				}
				System.out.print((board[i][j]!=null?board[i][j].getId():"-") + "  ");
			}
			System.out.println();
		}
	}
}
