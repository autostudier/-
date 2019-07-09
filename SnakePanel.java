package cn.guida.snake;
//导入画笔类		提示的快捷键 alt+/
import java.awt.Graphics;
//导入随机类
import java.util.Random;

//导入面板类
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

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

public class SnakePanel extends JPanel implements KeyListener{
	
	//定义食物
	Cell food;
	//定义蛇
	Cell[] snake;
	/*构造方法:给属性赋初始值，给食物和蛇赋初值
	 * 语法：类名（）{赋值的过程} 	构造方法的方法名和类名一致
	 */
	/*
	 * 用数字代表方向
	 * 不用改变的、不可改变的量 常量
	 * 常量用大写——约定俗成
	 */
	public static final int LEFT=-1;
	public static final int RIGHT=1;
	public static final int UP=-2;
	public static final int DOWN =2;
	
	
	//定义蛇头默认方向

	int direction =RIGHT;
	
	
	
	
	SnakePanel(){
		newFood();
		//给snake赋值
		snake=new Cell[3];
		//snake数组装上格子
		for(int i=0;i<snake.length;i++){
			snake[i]=new Cell();
			snake[i].x=i*15;
			snake[i].y=0;
			
		}
		
		
	}
	//新建食物的方法
	public void newFood(){
		//给food赋值
		food=new Cell();
		//新建随机数工具，变量名为ran
		Random ran=new Random();
		//给x，y赋值
		food.x=ran.nextInt(20)*15;
		food.y =ran.nextInt(20)*15;
	}
	/*
	 * 画画的方法，只负责画——画食物、画蛇
	 * g:画笔
	 */
	
	public void paint(Graphics g){
		//调用父类的方法
		super.paint(g);
		//画笔——画游戏范围 	draw ：画		Rect：矩形
		g.drawRect(0, 0, 300, 300);
//		//画分数
//		g.drawRect(300, 0, 100, 100);
//		String str="分数";
//		g.drawString(str, 300, 0);
		//画笔画食物 	fill填充
		g.fillRect(food.x, food.y, food.width, food.height);
		//画笔画蛇
		for(int i=0;i<snake.length;i++){
			g.fillRect(snake[i].x, snake[i].y, snake[i].width, snake[i].height);
		}
	}
	

	
/**
 * 蛇移动的方法：run方法
 */
	public void run(){
		while(true){
			//1改变蛇的坐标
			//移动后的第i个格子等于移动前的第i+1个格子
			for(int i=0;i<snake.length-1;i++){
				snake[i]=snake[i+1];
			}
			//新建格子，安在蛇头
			snake[snake.length-1]=new Cell();
			/*如果默认向右移动
			 * 蛇头的x等于倒数第二个格子的x+15
			 * 蛇头y等于倒数第二个格子的y
			 */
			snake[snake.length-1].x=snake[snake.length-2].x+15;
			snake[snake.length-1].y=snake[snake.length-2].y;
			
			if(direction==LEFT){
				snake[snake.length-1].x=snake[snake.length-2].x-15;
				snake[snake.length-1].y=snake[snake.length-2].y;
			}
			if(direction==RIGHT){
				snake[snake.length-1].x=snake[snake.length-2].x+15;
				snake[snake.length-1].y=snake[snake.length-2].y;
			}
			if(direction==UP){
				snake[snake.length-1].x=snake[snake.length-2].x;
				snake[snake.length-1].y=snake[snake.length-2].y-15;
			}
			if(direction==DOWN){
				snake[snake.length-1].x=snake[snake.length-2].x;
				snake[snake.length-1].y=snake[snake.length-2].y+15;	
			}
			/*
			 * 如果蛇头等于300
			 * 或者蛇头的x=-15
			 * 或者蛇头的y=300
			 * 或者蛇头的y=-15
			 */
			if(snake[snake.length-1].x==300||
				snake[snake.length-1].x==-15||
				snake[snake.length-1].y==300||
				snake[snake.length-1].y==-15){
				System.out.println("your snake is dead!");
				break;
			}
			/*
			 * 蛇吃食物则扩容且新建食物
			 */
			if(snake[snake.length-1].x==food.x&&
					snake[snake.length-1].y==food.y){
				//扩容
				snake=Arrays.copyOf(snake, snake.length+1);
				//把食物加入蛇头
				snake[snake.length-1]=food;
				//新建食物
				newFood();
			}
			//蛇咬到自己则死
			boolean flag=false;
			for(int i=0;i<snake.length-5;i++){
				if(snake[snake.length-1].x==snake[i].x&&
					snake[snake.length-1].y==snake[i].y) flag=true;
					
			}
			if(flag==true){
				System.out.println("Your snake is bitting itself!");
				break;
			}
			
			
			//2重画
			
			repaint();
			//3控制蛇的速度
			/*Thread暂时理解为贪吃蛇
			 * sleep（500）：每走一步，停顿500毫秒
			 */
			try {
				int speed=500;
				
				if(snake.length>20)
					speed=50;
				else if(snake.length>15)
					speed=100;
				else if(snake.length>10)
					speed=200;
				else if(snake.length>5)
					speed=300;
				
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/*
	 * 按键方法
	 * KeyEent:键盘事件类
	 * e 键盘事件
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//获取按键编码
		int code =e.getKeyCode();
		if(code==37&&direction!=RIGHT){
			direction=LEFT;
		}
		if(code==38&&direction!=DOWN){
			direction=UP;
		}
		if(code==39&&direction!=LEFT){
			direction=RIGHT;
		}
		if(code==40&&direction!=UP){
			direction=DOWN;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
	
		
	}





}























