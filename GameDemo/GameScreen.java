package GameDemo;

import javax.swing.JFrame;

public class GameScreen {

    /**
     * メソッド名：show
     *
     * 概要：
     * 　ゲーム画面を表示する。
     *
     * 処理内容：
     * 　1. JFrame生成
     * 　2. GamePanel生成
     * 　3. パネルをフレームに追加
     * 　4. サイズ設定
     * 　5. 画面中央配置
     * 　6. 終了動作設定
     * 　7. 画面表示
     */
    public static void show() {
       JFrame gameFrame = new JFrame("大阪の宝物をさがそう");
       GamePanel panel = new GamePanel();
        	gameFrame.add(panel);
        	gameFrame.setSize(1500, 800);
        	gameFrame.setLocationRelativeTo(null);
        	gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	gameFrame.setVisible(true);
    }
}
