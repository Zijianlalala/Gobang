# Gobang
五子棋

## 背景
下午上人工智能的时候看旁边同学在玩五子棋，于是开始想实现的逻辑。尽管大二的时候就想写一个试试，但是现在才开始动手ORZ。欢迎fork。

游戏界面（没有图形界面很Low...）

![Checkerboard](https://raw.githubusercontent.com/Zijianlalala/Images/master/board.png)

## 实现
目前只实现了五子连珠的基本逻辑，可以在控制台进行双人下棋。

### 流程图
![Flowchart](https://raw.githubusercontent.com/Zijianlalala/Images/master/GobangFlowChart.png)

### UML图

#### 第一版本UML图
![GoBangUML](https://raw.githubusercontent.com/Zijianlalala/Images/master/GoBangUML.png)

#### 第二版UML图
还没画


## 目前存在的问题
* 没有悔棋功能
* 没有图形界面

## 已解决
* 修复棋子坐标选择的合法性。
* 修复针对输入坐标时的格式异常。
* 重构了棋盘类中有关状态的大量重复代码，将其抽象到状态类中。







