# Food 專案內容簡介 (README)

## 專案概述
本專案為基於 Java 開發的 **Food** 應用程式，開發環境採用 Eclipse IDE 結構進行專案管理。系統內含食物/食品相關資料模型、圖形使用者介面（GUI）以及對應的單元測試與功能驗證。

---

## 專案目錄結構

```text
Food/
├── .classpath                          # Eclipse 專案類別路徑配置檔
├── .project                            # Eclipse 專案定義與建置配置
├── .settings/                          # Eclipse 偏好設定目錄
│   ├── org.eclipse.core.resources.prefs # 專案資源編碼設定 (UTF-8)
│   └── org.eclipse.jdt.core.prefs       # Java 編譯器相關設定
├── bin/                                # 編譯產出之位元組碼 (Bytecode)
│   └── com/
│       ├── Food.class                  # 核心資料模型類別檔
│       ├── Foodtest.class              # 測試類別檔
│       ├── FoodUI.class                # GUI 主視窗介面類別檔
│       └── FoodUI$1.class              # GUI 事件監聽/內部匿名類別檔
├── src/                                # 原始程式碼目錄 (Source Code)
│   └── com/
│       ├── Food.java                   # 食物/餐點實體類別 (Model)
│       ├── Foodtest.java               # 測試與除錯執行檔 (Test Runner)
│       └── FoodUI.java                 # 圖形使用者介面元件 (Swing/AWT UI)
└── Food.jar                            # 專案封裝之可執行/發布 JAR 封裝檔
```

---

## 模組與核心架構說明

本專案採用典型的 MVC（模型-視圖）分層思維，程式碼位於 `com` 套件下：

### 1. 核心模型 (`com.Food`)
* **檔案**：`src/com/Food.java`（編譯為 `Food.class`）
* **職責**：封裝食物物件的屬性與商業邏輯，包含食品名稱、價格、卡路里或分類等基本欄位，並提供標準的 Getter / Setter 與資料驗證方法。

### 2. 圖形使用者介面 (`com.FoodUI`)
* **檔案**：`src/com/FoodUI.java`（包含內部匿名類別 `FoodUI$1.class`）
* **職責**：提供終端使用者操作介面（基於 Java Swing / AWT）。包含輸入表單、按鈕事件處理、選單或清單瀏覽等互動功能。

### 3. 測試與驗證模組 (`com.Foodtest`)
* **檔案**：`src/com/Foodtest.java`（編譯為 `Foodtest.class`）
* **職責**：提供主程式（`main` 方法）或單元測試用例，用於驗證 `Food` 模型的功能性與邏輯運算是否正常。

### 4. 應用程式封裝 (`Food.jar`)
* 根目錄提供預先封裝完成的 `Food.jar`，方便直接進行發布或跨環境執行。

---

## 環境需求與編碼

* **開發工具**：Eclipse IDE（或相容之 IntelliJ IDEA / VS Code）
* **JDK 版本**：Java Standard Edition (Java SE)
* **文字編碼**：`UTF-8`（已於 `org.eclipse.core.resources.prefs` 規範）

---

## 執行與部署指南

### 1. 直接執行 JAR 檔案
在終端機中切換至專案根目錄，執行以下指令：
```bash
java -jar Food.jar
```

### 2. 透過原始碼編譯與執行
若需手動重新編譯並執行：
```bash
# 編譯原始碼至 bin 目錄
javac -encoding UTF-8 -d bin src/com/*.java

# 執行 GUI 介面
java -cp bin com.FoodUI

# 或執行測試程式
java -cp bin com.Foodtest
```
