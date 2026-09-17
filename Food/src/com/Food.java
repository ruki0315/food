package com;

public class Food {
	private String OrderNo;
	private static int tianbulat;//甜不辣
	private int bawan;//肉圓
	private int stinkytofu;//臭豆腐
	private int sum;
	private boolean vip;
	private int quantity;
	
	public Food(String OrderNo, int tianbulat, int bawan, int stinkytofu,boolean vip) {
		
		if(tianbulat>=0 && bawan>=0 && stinkytofu>=0)
		{
		this.OrderNo = OrderNo;
		this.tianbulat = tianbulat;
		this.bawan = bawan;
		this.stinkytofu = stinkytofu;
		this.vip = vip;
		this.quantity = 0;
		sum=tianbulat*55+bawan*50+stinkytofu*65;
		}
	}

	public String getOrderNo() {
		return OrderNo;
	}

	public void setName(String OrderNo) {
		this.OrderNo = OrderNo;
	}

	public static int getTianbulat() {
		return tianbulat;
	}

	public void setTianbulat(int tianbulat) {
		this.tianbulat = tianbulat;
	}

	public int getBawan() {
		return bawan;
	}

	public void setBawan(int bawan) {
		this.bawan = bawan;
	}

	public int getStinkytofu() {
		return stinkytofu;
	}

	public void setStinkytofu(int stinkytofu) {
		this.stinkytofu = stinkytofu;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}
	public int getQuantity() {
		return quantity;
	}
	
	//Methods
	
	// 計算總購買件數 (使用 Operator 累加 +=)
    public int calculatesum() {
        int sum = 0;
        sum += this.tianbulat;
        sum += this.bawan;
        sum += this.stinkytofu;
        return sum;
    }
    
    	public void addTianbulat() {
    		tianbulat++;
    	}
    	
    	public static void minusTianbulat() {
    		if(tianbulat>0) {
    			tianbulat--;
    		}
    	}
    	public void addBawan() {
    		bawan++;
    	}
    
    public void minusBawan() {
    		if(bawan>0) {	
    			bawan--;}
    }
    
    public void addStinkytofu() {
    		stinkytofu++;
    }
    public void minusStinkytofu() {
    		if(stinkytofu>0) {
    			stinkytofu--;
    		}
    }
    
    // 依據 VIP 與消費門檻取得折扣率 (if / else if / else)
    	public double getDiscountRate(double subtotal) {
        if (!this.vip) {
            return 0.0;       // 非 VIP：無折扣 (0% off)
        } else if (subtotal>= 300.0) {
            return 0.20;      // VIP 滿 300：享 8 折 (20% off)
        } else {
            return 0.10;      // VIP 未滿 300：享 9 折 (10% off)
        }
    }
    	 // 計算最終金額 (使用減法 - 與乘法 *)
    	    public double calculateFinalTotal() {
    	    	double subtotal = this.sum;
    	    	double discountRate = getDiscountRate(subtotal);
    	    double discountAmount = subtotal * discountRate;
    	    return subtotal - discountAmount;
    	    }
    	    
    	void show()
    		{
    		double subtotal = this.sum;
    		double discountRate = this.getDiscountRate(subtotal);
    	    double discountAmount = subtotal * discountRate;
    		
    		    System.out.println("===== 台灣小吃訂購單 =====" +
    	                "\n訂單編號：" + this.OrderNo +
    	                "\n甜不辣：" + this.tianbulat + " 份" +
    	                "\n肉圓：" + this.bawan + " 份" +
    	                "\n臭豆腐：" + this.stinkytofu + " 份" +
    	                "\n總數量：" + this.calculatesum() + " 件" +
    	                "\n會員：" + (this.vip ? "是" : "否") +
    	                "\n訂單小計：" + (int)sum + " 元" +
    	                "\n折扣率：" + (int)(discountRate*100) + "%" +
    	                "\n折扣金額：" + (int)discountAmount + " 元" +
    	                "\n應付金額：" + (int)calculateFinalTotal() + " 元");
    		}
}
