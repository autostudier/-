
package cn.guida.snake;//声明文件所在的包

/**
 * 程序的主运行文件
 * @author liuxin
 *
 */
//声明公共类

//导入窗口类

import javax.swing.JFrame;

public class Main {
	//程序入口
	public static void main(String[] args){
		//在内存中新建窗口，变量名为window
		JFrame window = new JFrame();
		//设置窗口可见
		window.setVisible(true);
		//设置窗口大小
		window.setSize(400,500);
		//设置居中
		window.setLocationRelativeTo(null);
		//设置默认关闭操作
		window.setDefaultCloseOperation(3);
		//新建蛇面板对象
		SnakePanel panel = new SnakePanel();
		//窗口添加面板
		window.add(panel);
		//窗口添加键盘监听器
		window.addKeyListener(panel);
		//面板添加监听器
		panel.addKeyListener(panel);
		//调用run方法
		panel.run();
	}
	
}








