# Gobang
五子棋

## 背景
下午上人工智能的时候看旁边同学在玩五子棋，于是开始想实现的逻辑。尽管大二的时候就想写一个试试，但是现在才开始动手ORZ。欢迎fork。

游戏界面（没有图形界面的Low货...）

![Checkerboard](https://raw.githubusercontent.com/Zijianlalala/Images/master/board.png)

## 实现
目前只实现了五子连珠的基本逻辑，可以在控制台进行双人下棋。

### 流程图
![Flowchart](https://raw.githubusercontent.com/Zijianlalala/Images/master/GobangFlowChart.png)

### UML图

#### 第一版本UML
![GoBangUML](https://raw.githubusercontent.com/Zijianlalala/Images/master/GoBangUML.png)


## 目前存在的问题
* 大量重复代码，耦合度高，可维护性差

## 已解决
* 棋子落下的位置可以被新棋子覆盖。
* 输入坐标的时候只能输入单个数字，没有异常处理。
* 重构了棋盘类中检查周围是否有棋子的方法。将其抽象到状态类中。

## 待实现
* 悔棋功能
* 图形界面





