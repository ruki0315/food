package com;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class FoodUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtOrderNo;
    private JTextField txtTianbulat;
    private JTextField txtBawan;
    private JTextField txtStinkytofu;
    private JCheckBox chkVip;
    private JTextArea txtOutput;
    private JLabel lblDateValue;

    /**
     * 程式進入點 (Launch the application)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FoodUI frame = new FoodUI();
                    frame.setLocationRelativeTo(null); // 啟動時螢幕置中
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 建立 JFrame 介面 (Create the frame)
     */
    public FoodUI() {
        setTitle("台灣小吃點餐系統 - Food POS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 520);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // ================= 頂部大標題 =================
        JLabel lblTitle = new JLabel("台灣小吃訂購結帳系統");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("微軟正黑體", Font.BOLD, 22));
        lblTitle.setBounds(10, 15, 684, 35);
        contentPane.add(lblTitle);

        // ================= 左側：點餐設定面板 =================
        JPanel panelInput = new JPanel();
        panelInput.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), "點餐設定", 
                TitledBorder.LEADING, TitledBorder.TOP, new Font("微軟正黑體", Font.BOLD, 14), null));
        panelInput.setBounds(20, 60, 360, 405);
        contentPane.add(panelInput);
        panelInput.setLayout(null);

        // 1. 訂購日期顯示
        JLabel lblDate = new JLabel("訂購日期：");
        lblDate.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        lblDate.setBounds(20, 25, 80, 25);
        panelInput.add(lblDate);

        lblDateValue = new JLabel(getCurrentDateTime());
        lblDateValue.setFont(new Font("微軟正黑體", Font.BOLD, 13));
        lblDateValue.setForeground(new Color(0, 102, 204));
        lblDateValue.setBounds(105, 25, 200, 25);
        panelInput.add(lblDateValue);

        // 2. 訂單編號
        JLabel lblOrderNo = new JLabel("訂單編號：");
        lblOrderNo.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        lblOrderNo.setBounds(20, 60, 80, 25);
        panelInput.add(lblOrderNo);

        txtOrderNo = new JTextField();
        txtOrderNo.setText("ORD-001");
        txtOrderNo.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        txtOrderNo.setBounds(105, 60, 160, 25);
        panelInput.add(txtOrderNo);
        txtOrderNo.setColumns(10);

        // 3. 甜不辣 ($55)
        JLabel lblTianbulat = new JLabel("甜不辣 ($55)：");
        lblTianbulat.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        lblTianbulat.setBounds(20, 100, 110, 25);
        panelInput.add(lblTianbulat);

        JButton btnMinusTian = new JButton("-");
        btnMinusTian.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        btnMinusTian.setBounds(135, 100, 45, 25);
        panelInput.add(btnMinusTian);

        txtTianbulat = new JTextField("0");
        txtTianbulat.setHorizontalAlignment(SwingConstants.CENTER);
        txtTianbulat.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        txtTianbulat.setBounds(185, 100, 50, 25);
        panelInput.add(txtTianbulat);

        JButton btnPlusTian = new JButton("+");
        btnPlusTian.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        btnPlusTian.setBounds(240, 100, 45, 25);
        panelInput.add(btnPlusTian);

        // 4. 肉圓 ($50)
        JLabel lblBawan = new JLabel("肉圓 ($50)：");
        lblBawan.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        lblBawan.setBounds(20, 140, 110, 25);
        panelInput.add(lblBawan);

        JButton btnMinusBawan = new JButton("-");
        btnMinusBawan.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        btnMinusBawan.setBounds(135, 140, 45, 25);
        panelInput.add(btnMinusBawan);

        txtBawan = new JTextField("0");
        txtBawan.setHorizontalAlignment(SwingConstants.CENTER);
        txtBawan.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        txtBawan.setBounds(185, 140, 50, 25);
        panelInput.add(txtBawan);

        JButton btnPlusBawan = new JButton("+");
        btnPlusBawan.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        btnPlusBawan.setBounds(240, 140, 45, 25);
        panelInput.add(btnPlusBawan);

        // 5. 臭豆腐 ($65)
        JLabel lblStinky = new JLabel("臭豆腐 ($65)：");
        lblStinky.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        lblStinky.setBounds(20, 180, 110, 25);
        panelInput.add(lblStinky);

        JButton btnMinusStinky = new JButton("-");
        btnMinusStinky.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        btnMinusStinky.setBounds(135, 180, 45, 25);
        panelInput.add(btnMinusStinky);

        txtStinkytofu = new JTextField("0");
        txtStinkytofu.setHorizontalAlignment(SwingConstants.CENTER);
        txtStinkytofu.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        txtStinkytofu.setBounds(185, 180, 50, 25);
        panelInput.add(txtStinkytofu);

        JButton btnPlusStinky = new JButton("+");
        btnPlusStinky.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        btnPlusStinky.setBounds(240, 180, 45, 25);
        panelInput.add(btnPlusStinky);

        // 6. VIP 會員勾選框
        chkVip = new JCheckBox("VIP 會員 (未滿300打9折 / 滿300打8折)");
        chkVip.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
        chkVip.setBounds(20, 220, 310, 25);
        panelInput.add(chkVip);

        // ================= 操作功能按鈕區 (排版為四個按鈕) =================
        // 第一排按鈕：計算結帳 & 清空重填
        JButton btnCalculate = new JButton("計算結帳");
        btnCalculate.setFont(new Font("微軟正黑體", Font.BOLD, 14));
        btnCalculate.setBounds(30, 270, 130, 35);
        panelInput.add(btnCalculate);

        JButton btnClear = new JButton("清空重填");
        btnClear.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        btnClear.setBounds(180, 270, 130, 35);
        panelInput.add(btnClear);

        // 第二排按鈕：列印收據 & 離開系統
        JButton btnPrint = new JButton("列印收據");
        btnPrint.setFont(new Font("微軟正黑體", Font.BOLD, 14));
        btnPrint.setBounds(30, 320, 130, 35);
        panelInput.add(btnPrint);

        JButton btnExit = new JButton("離開系統");
        btnExit.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        btnExit.setBounds(180, 320, 130, 35);
        panelInput.add(btnExit);

        // ================= 右側：訂單明細收據面板 =================
        JPanel panelOutput = new JPanel();
        panelOutput.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), "明細收據", 
                TitledBorder.LEADING, TitledBorder.TOP, new Font("微軟正黑體", Font.BOLD, 14), null));
        panelOutput.setBounds(395, 60, 295, 405);
        contentPane.add(panelOutput);
        panelOutput.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(15, 25, 265, 365);
        panelOutput.add(scrollPane);

        txtOutput = new JTextArea();
        txtOutput.setForeground(new Color(255, 0, 0));
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 13));
        scrollPane.setViewportView(txtOutput);

        // ================= 事件監聽器 (Action Listeners) =================

        // 甜不辣加減事件
        btnPlusTian.addActionListener(e -> updateQty(txtTianbulat, 1));
        btnMinusTian.addActionListener(e -> updateQty(txtTianbulat, -1));

        // 肉圓加減事件
        btnPlusBawan.addActionListener(e -> updateQty(txtBawan, 1));
        btnMinusBawan.addActionListener(e -> updateQty(txtBawan, -1));

        // 臭豆腐加減事件
        btnPlusStinky.addActionListener(e -> updateQty(txtStinkytofu, 1));
        btnMinusStinky.addActionListener(e -> updateQty(txtStinkytofu, -1));

        // 清空重填事件
        btnClear.addActionListener(e -> {
            lblDateValue.setText(getCurrentDateTime()); // 更新當前時間
            txtOrderNo.setText("");
            txtTianbulat.setText("0");
            txtBawan.setText("0");
            txtStinkytofu.setText("0");
            chkVip.setSelected(false);
            txtOutput.setText("");
            txtOrderNo.requestFocus();
        });

        // 計算結帳事件
        btnCalculate.addActionListener(e -> calculateAndPrintReceipt());

        // 列印按鈕事件
        btnPrint.addActionListener(e -> {
            if (txtOutput.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "尚未產生收據明細，無法列印！", "提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                // 呼叫 Java 內建列印對話框
                boolean complete = txtOutput.print();
                if (complete) {
                    JOptionPane.showMessageDialog(this, "列印作業完成！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "列印失敗: " + ex.getMessage(), "錯誤", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 離開按鈕事件
        btnExit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this, 
                    "確定要結束並離開系統嗎？", 
                    "離開確認", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE
            );
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

    /**
     * 取得當前時間字串格式 (yyyy-MM-dd HH:mm)
     */
    private String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    /**
     * 數量變更輔助方法 (防呆：禁止負數、防止非數值輸入)
     */
    private void updateQty(JTextField field, int delta) {
        try {
            int val = Integer.parseInt(field.getText().trim());
            val += delta;
            if (val < 0) {
                val = 0;
            }
            field.setText(String.valueOf(val));
        } catch (NumberFormatException ex) {
            field.setText("0");
        }
    }

    /**
     * 讀取畫面數值、實例化 Food 物件並計算收據
     */
    private void calculateAndPrintReceipt() {
        String orderNo = txtOrderNo.getText().trim();
        if (orderNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "請輸入訂單編號！", "提醒", JOptionPane.WARNING_MESSAGE);
            txtOrderNo.requestFocus();
            return;
        }

        try {
            int tian = Integer.parseInt(txtTianbulat.getText().trim());
            int ba = Integer.parseInt(txtBawan.getText().trim());
            int stinky = Integer.parseInt(txtStinkytofu.getText().trim());

            if (tian < 0 || ba < 0 || stinky < 0) {
                JOptionPane.showMessageDialog(this, "餐點數量不可為負數！", "錯誤", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean isVip = chkVip.isSelected();

            // 建立 Food 實例
            Food order = new Food(orderNo, tian, ba, stinky, isVip);

            // 獲取各項計算數值
            int subtotal = order.getSum();
            double discountRate = order.getDiscountRate(subtotal);
            double discountAmount = subtotal * discountRate;
            double finalTotal = order.calculateFinalTotal();

            // 組裝輸出明細（加入開單日期）
            StringBuilder sb = new StringBuilder();
            sb.append("===== 台灣小吃訂購單 =====\n");
            sb.append("開單時間：").append(getCurrentDateTime()).append("\n");
            sb.append("訂單編號：").append(order.getOrderNo()).append("\n");
            sb.append("--------------------------\n");
            sb.append("甜不辣 ($55)：").append(Food.getTianbulat()).append(" 份\n");
            sb.append("肉 圓 ($50)：").append(order.getBawan()).append(" 份\n");
            sb.append("臭豆腐 ($65)：").append(order.getStinkytofu()).append(" 份\n");
            sb.append("--------------------------\n");
            sb.append("總購買數：").append(order.calculatesum()).append(" 件\n");
            sb.append("會員身分：").append(order.isVip() ? "VIP 會員" : "一般顧客").append("\n");
            sb.append("訂單小計：").append(subtotal).append(" 元\n");
            sb.append("折扣比率：").append((int) (discountRate * 100)).append("%\n");
            sb.append("折扣折抵：").append((int) discountAmount).append(" 元\n");
            sb.append("==========================\n");
            sb.append("應付金額：").append((int) finalTotal).append(" 元\n");

            txtOutput.setText(sb.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "數量欄位請輸入合法的整數數字！", "輸入格式錯誤", JOptionPane.ERROR_MESSAGE);
        }
    }
}