package edu.scut.main;

public class Main {
	class A{
		protected void name(){
			System.out.println("name");
		}
	}
	
	class B extends A{
		public void name() {
			
		}
	}
	
	static class Test{
		public int num=1;
	}
	
	public static void main(String[] arg) {
		String a = new String("adc");
		String b = "adc";
		System.out.println(a==b);
		
		System.out.println("dsfsd"+1);
//		int num = 1;
//		changeValue(num);
//		System.out.println(num);
//		
//		Test test = new Main.Test();
//		changeValue(test.num);
//		System.out.println(test.num);
//		
//		changeValue(test);
//		System.out.println(test.num);
	}
	
	public static void changeValue(int num) {
		num++;
		System.out.println(num);
	}
	
	public static void changeValue(Test test) {
		test.num++;
		System.out.println(test.num);
	}

}
