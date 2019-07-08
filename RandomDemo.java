package cn.guida.demo;
//导入随机数类
import java.util.Random;
/**
 * 随机数的练习
 * @author Administrator
 *
 */
public class RandomDemo {

	public static void main(String[] args) {
		//新建随机数工具，变量名为ran
		Random ran = new Random();
		//随机产生0~20的整数
		int num=ran.nextInt (20);
		//输出num
		System.out.println(num);
		//随机产生0 15.。。。300
		int num1=ran.nextInt (20)*15;
		//输出的快捷键 syso+alt+/+enter
		System.out.println(num1);
		//随机产生5~100之间的整数
		int num3=ran.nextInt(95)+5;
		System.out.println(num3);
		
		
	}

}
