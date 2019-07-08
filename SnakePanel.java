package cn.guida.snake;
//导入面板类
import javax.swing.JPanel;
//导入画笔类		提示的快捷键 alt+/
import java.awt.Graphics;


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
	/*
	 * 画画的方法，只负责画——画食物、画蛇
	 * g:画笔
	 */
	
	public void paint(Graphics g){
		//画笔——画游戏范围 	draw ：画		Rect：矩形
		g.drawRect(0, 0, 300, 300);
		
	}
	
}




