package com.nt.coding.challanges;

public class OverloadingCode {

	public void print(int a) {
		System.out.println("OverloadingCode.print(int) :: " + a);
	}

	public void print(Integer a) {
		System.out.println("OverlxoadingCode.print(Integer) :: " + a);
	}
	
	public static void main(String[] args) {
		OverloadingCode oc = new OverloadingCode();
		oc.print(null);
	}
}
