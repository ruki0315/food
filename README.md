# 台灣傳統小吃訂單結帳系統 (Food Order System)

本專案為以 Java 物件導向程式設計（OOP）實作之台灣傳統小吃訂購與結帳計算模組，包含餐點計費、品項數量動態增減、會員資格判定與階梯式折扣優惠計算。

---

## 一、 專案簡介 (Project Overview)

本系統模擬台灣傳統小吃店的結帳與點餐流程，核心模組為 `Food.java`，主要功能涵蓋：
- **訂單資訊管理**：記錄專屬訂單編號（`OrderNo`）與顧客 VIP 會員資格（`vip`）。
- **品項計費計算**：支援甜不辣、肉圓、臭豆腐等傳統小吃的數量記錄與費用小計。
- **數量調整與防呆機制**：提供餐點的增減方法，並加入防呆判定，防止數量小於 0。
- **會員階梯折扣計算**：根據顧客是否具備 VIP 身分及消費門檻，自動套用對應折扣優惠。
- **明細排版輸出**：提供 `show()` 方法印出格式化的結帳明細（含品項、總件數、原價、折扣率、折扣金額與實付金額）。

---

## 二、 菜單與計費標準 (Menu & Pricing)

| 品項名稱 | 程式變數名稱 | 單價 (NTD) | 說明 |
| :--- | :--- | :--- | :--- |
| **甜不辣** | `tianbulat` | **$55** / 份 | 經典台式甜不辣 |
| **肉圓** | `bawan` | **$50** / 份 | 傳統風味肉圓 |
| **臭豆腐** | `stinkytofu` | **$65** / 份 | 酥脆香濃臭豆腐 |

### 基礎小計公式：
$$\text{Subtotal (sum)} = (\text{tianbulat} \times 55) + (\text{bawan} \times 50) + (\text{stinkytofu} \times 65)$$

---

## 三、 會員折扣優惠規則 (Discount Policy)

系統透過 `getDiscountRate(subtotal)` 方法依據消費金額門檻與會員身分進行階梯判定：

| 客戶身分 | 消費小計金額門檻 | 折扣率 (Discount Rate) | 折扣說明 |
| :--- | :--- | :--- | :--- |
| **一般顧客 (`vip = false`)** | 不限金額 | **0% (0.0)** | 原價計費，無折扣 |
| **VIP 會員 (`vip = true`)** | 未滿 300 元 | **10% off (0.10)** | 享有 **9 折** 優惠 |
| **VIP 會員 (`vip = true`)** | 滿 300 元 (含) 以上 | **20% off (0.20)** | 享有 **8 折** 優惠 |

### 結算公式：
- **折扣金額 (`discountAmount`)** = $\text{Subtotal} \times \text{Discount Rate}$
- **實付總額 (`finalTotal`)** = $\text{Subtotal} - \text{discountAmount}$

---

## 四、 核心架構與類別說明 (`com.Food`)

### 1. 成員屬性 (Fields)
- `private String OrderNo`：訂單編號。
- `private int tianbulat`：甜不辣份數。
- `private int bawan`：肉圓份數。
- `private int stinkytofu`：臭豆腐份數。
- `private int sum`：訂單小計原價。
- `private boolean vip`：是否為 VIP 會員。
- `private int quantity`：總數量預留欄位。

### 2. 主要方法 (Key Methods)
- **建構子** `Food(String OrderNo, int tianbulat, int bawan, int stinkytofu, boolean vip)`：
  - 驗證三項餐點數量皆 $\ge 0$。
  - 初始化訂單屬性並計算初始小計 `sum`。
- **數量調整與防呆方法**：
  - `addTianbulat()` / `minusTianbulat()`：甜不辣數量增減（具備 `> 0` 防呆）。
  - `addBawan()` / `minusBawan()`：肉圓數量增減（具備 `> 0` 防呆）。
  - `addStinkytofu()` / `minusStinkytofu()`：臭豆腐數量增減（具備 `> 0` 防呆）。
- **運算與輸出方法**：
  - `calculatesum()`：加總計算所有餐點的總購買件數。
  - `getDiscountRate(double subtotal)`：判定並傳回該訂單適用的折扣率。
  - `calculateFinalTotal()`：計算扣除折扣後的應付總額。
  - `show()`：終端機格式化輸出完整結帳明細。

---

## 五、 控制台明細輸出範例 (Console Output Example)

```text
===== 台灣小吃訂購單 =====
訂單編號：ORD-001
甜不辣：2 份
肉圓：2 份
臭豆腐：2 份
總數量：6 件
會員：是
訂單小計：340 元
折扣率：20%
折扣金額：68 元
應付金額：272 元
六、 程式優化與後續維護建議 (Refactoring Notes)
避免使用 static 修飾實例變數：

原始碼中 tianbulat 與 minusTianbulat() 若宣告為 static，會造成所有建立的 Food 物件共用同一份甜不辣數量，建議改回一般的物件屬性（Instance Field）。

數量異動連動更新小計：

呼叫 add...() 或 minus...() 調整數量後，建議連動重新計算 sum，避免結帳金額停留在建構時的初值。

物件導向設計擴充：

未來可新增品項類別（如 MenuItem）或使用 Enum 管理小吃品項與單價，使系統更具擴充性（如增加貢丸湯、蚵仔煎等）。
