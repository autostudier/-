package cn.guida.snake;
//导入画笔类		提示的快捷键 alt+/
import java.awt.Graphics;
//导入随机类
import java.util.Random;

//导入面板类
import javax.swing.JPanel;

/**
 * 游戏的面板类
 * @author Administrator
 *
 */
/**
 * 继承：子类继承父类，子类拥有父类的所有特征
 * 		子类可以重写父类和加强父类方法
 * 语法：子类 extends 父类
 * @author Administrator
 */
public class SnakePanel extends JPanel{
	//定义食物
	Cell food;
	//定义蛇
	Cell[] snake;
	/*构造方法:给属性赋初始值，给食物和蛇赋初值
	 * 语法：类名（）{赋值的过程} 	构造方法的方法名和类名一致
	 */
	SnakePanel(){
		//给food赋值
		food=new Cell();
		//新建随机数工具，变量名为ran
		Random ran=new Random();
		//给x，y赋值
		food.x=ran.nextInt(20)*15;
		food.y =ran.nextInt(20)*15;
		//给snake赋值
		snake=new Cell[3];
		//snake数组装上格子
		for(int i=0;i<snake.length;i++){
			snake[i]=new Cell();
			snake[i].x=i*15;
			snake[i].y=0;
			
		}
		
		
	}
	/*
	 * 画画的方法，只负责画——画食物、画蛇
	 * g:画笔
	 */
	
	public void paint(Graphics g){
		//画笔——画游戏范围 	draw ：画		Rect：矩形
		g.drawRect(0, 0, 300, 300);
		//画笔画食物 	fill填充
		g.fillRect(food.x, food.y, food.width, food.height);
		//画笔画蛇
		for(int i=0;i<snake.length;i++){
			g.fillRect(snake[i].x, snake[i].y, snake[i].width, snake[i].height);
		}
	}
	
}































