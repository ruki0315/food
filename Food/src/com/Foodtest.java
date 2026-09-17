package com;

public class Foodtest {

	public static void main(String[] args) {
		// 1：非VIP顧客（金額超過300元）
        Food order1 = new Food("ORD-001", 2, 2, 2, false);
        order1.show();

        System.out.println();

        // 2：VIP會員，消費未滿300元
        Food order2 = new Food("ORD-002", 1, 2, 1, true);
        order2.show();

        System.out.println();

        // 3：VIP會員，消費恰好達到300元邊界
        Food order3 = new Food("ORD-003", 2, 1, 2, true);
        order3.show();
    }
}
