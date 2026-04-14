package GameDemo;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class IntroScreen {

    /**
     * メソッド名：show
     *
     * 概要：
     * 　イントロ画面を生成し、表示する。
     *
     * 処理内容：
     * 　1. フレーム生成
     * 　2. 背景パネル作成
     * 　3. ボタンパネル作成
     * 　4. イベント登録
     * 　5. 画面表示
     */
    public static void show() {

        //  メインフレーム作成
        JFrame frame = new JFrame("Game Demo");
        frame.setSize(600, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== BACKGROUND PANEL =====
        /**
         * 背景画像表示用パネル
         *
         * ・poster.png を背景として表示
         * ・paintComponentをオーバーライドし、
         *   パネルサイズに合わせて画像を描画する
         */
        JPanel mainPanel = new JPanel() {

            // 背景画像読み込み
            Image bg = new ImageIcon("images/poster.png").getImage();

            /**
             * 背景描画処理
             *
             * g Graphicsオブジェクト
             */
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // パネル全体に画像を拡大描画
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
            }
        };

        // メインパネルをフレームに設定
        frame.setContentPane(mainPanel);

        // ===== BUTTON PANEL =====
        /**
         * ボタン表示用パネル
         *
         * ・透過設定（背景を見せるため）
         * ・FlowLayoutを使用して中央配置
         */
        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);

        // レイアウト設定
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 600));

        // ボタン生成
        JButton playBtn = new JButton(" プレー");
        JButton rulesBtn = new JButton(" ルール");

        /**
         * ※スタイル変更用メソッド（現在はコメントアウト）
         * styleButton(playBtn);
         * styleButton(rulesBtn);
         */

        // ボタンをパネルへ追加
        btnPanel.add(playBtn);
        btnPanel.add(rulesBtn);

        // ボタンパネルをメインパネルへ追加
        mainPanel.add(btnPanel);

        // ===== EVENTS =====
        /**
         * 「プレー」ボタン押下時の処理
         *
         * ・現在の画面を閉じる
         * ・GameScreenを表示する
         */
        playBtn.addActionListener(e -> {
            frame.dispose();       // イントロ画面を閉じる
            GameScreen.show();     // ゲーム画面表示
        });

        /**
         * 「ルール」ボタン押下時の処理
         *
         * ・ゲームの遊び方をダイアログで表示
         */
        rulesBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                frame,
                "🎮 ルール:\n\n" +
                        "1. 矢印キーでキャラクターを移動させます。\n" +
                        "2. モンスターのゲートで質問に答えます。\n" +
                        "3. 正しい答えをすべての9問に答えたらゲームクリアです。\n" +
                        "4. 間違った答えを選ぶと最初からやり直しになります。",
                "ルール",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        //  画面表示
        frame.setVisible(true);
    }
}
