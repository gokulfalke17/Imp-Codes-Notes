package com.nt.coding.challanges;

class A implements Cloneable {
	int a = 10;
	int b = 20;

	public void m1() {
		System.out.println(a + " " + b);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class CloneEx {

	public static void main(String[] args) throws CloneNotSupportedException {

		/*A  a = new A();
		a.m1();
		
		A a1 = (A)a.clone();
		
		a1.m1();*/
		
		int val = m1();
		System.out.println(val); //

		try {
			System.exit(0);
		} finally {
			System.out.println("hiii");
		}

		// marker -> empty -> Cloneable, Serialible, Random
		// functional -> one abstract (defincation), default and static methods
		// Runnable, Callable, Interable, Intorator, Function, Predicate, Consumer,
		// Supplier, BiSupplier, BiConsumer
		// simple -> any thing -> user defined interface

	}

	private static int m1() {
		try {
			return 1; 
		} finally {
			return 2; 
		}
	}
}
