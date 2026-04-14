package GameDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 * クラス名：EndScreen
 *
 * 概要：
 * 　ゲーム終了後のストーリー表示および結果画面を管理するクラス。三つのメソッドがあります。(showEndKaiwa, TypeText, showResult)
 *
 * 責務：
 * 　・エンディング会話の表示
 * 　・タイプライター風テキスト演出
 * 　・スコア結果の表示
 * 　・データベースへのスコア保存
 */
public class EndScreen {

    /** 会話データ格納用リスト */
    private static ArrayList<String[]> dialogs = new ArrayList<>();

    /** 文字アニメーション用タイマー */
    static Timer typingTimer;

    /**
     * 静的初期化ブロック
     * エンディング会話データを設定する。
     */
    static {
    	dialogs.add(new String[]{
    			"神様：",
    		    "ニャット君、ゲームクリアおめでとう！",
    		    "１０００万円の手続きをよろしくね",
    		    "これからも遊ばずに頑張ってね",
    		    "あとは1500円ね。忘れないように！",
    		});

        dialogs.add(new String[]{
            "ニャット：",
            "😭😭😭😭😭",
            "ありがとうございます。本当に助かりました。",
            "これからもあえてパチンコに入りません。",
            "これからも........",
            ".   .    .   .  .",
        });
        dialogs.add(new String[]{
	        "ニャットの妻：",
	        "「ねえ,ねえ",	          
	        "あなた、起きてや、もう八時半だぜ。",
	        "何をしてんねん、もううう",
	        "出勤しないつもり？？？」",
	        });

        dialogs.add(new String[]{
            "ニャット：",
            "「ええ",
            "１０００万円",
            "俺の１０００万円はどこに飛んだ。",
            "😢😢😢😢😢",
        });

        dialogs.add(new String[]{
            "ニャットの妻：",
            "「１０００万円？？、",
            "あ、夢か。１０００万円があるなんて",
            "ありえへんやろう。",
            "ほら、ニャットちゃん",
            "現実世界に戻って、朝ご飯を食べて、",
            "いっぱい働いて、お金を稼いてね。(^_^)",
            "ニャットちゃんのことが大好きだよ。」"
        });

        dialogs.add(new String[]{
            "ニャット:",
            "　　　",
            "そんな………",
            "くやーーーっ！！せ、せ、せ、せ、せ、せ、せ、せ、せ、せ、せ、せ、せーーーいっ！！",
        });

        dialogs.add(new String[]{
            "-----ーーーー> END　GAME <ーーーー--- ",
            "　      💰大阪の宝物をさがそう💰",
            "　",
            "     |ご参加ありがとうございました。|",       
        });
    }

    /**
     * メソッド名：showEndKaiwa
     *
     * 概要：
     * 　エンディング会話画面を表示する。
     *
     * 処理内容：
     * 　1. フレーム生成
     * 　2. テキストエリア設定
     * 　3. Next / Back ボタン設定
     * 　4. 会話表示制御
     */
    public static void showEndKaiwa() {

        // フレーム作成
        JFrame frame = new JFrame("Story");
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        // テキスト表示エリア設定
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 26));
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.YELLOW);

        // ボタン作成
        JButton nextBtn = new JButton("Next");
        JButton backBtn = new JButton("Back");

        JPanel btnPanel = new JPanel();
        btnPanel.add(backBtn);
        btnPanel.add(nextBtn);

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

        // 現在表示中の会話インデックス
        final int[] idx = {0};

        // 初期表示
        typeText(textArea, dialogs.get(idx[0]));

        /**
         * Nextボタン処理
         * 次の会話へ進む
         */
        nextBtn.addActionListener(e -> {

            if (idx[0] < dialogs.size() - 1) {
                idx[0]++;
                typeText(textArea, dialogs.get(idx[0]));
            }

            backBtn.setEnabled(true);

            // 最終ページの場合、EXITボタンへ変更
            if (idx[0] == dialogs.size() - 1) {
                nextBtn.setText("EXIT");
                nextBtn.removeActionListener(nextBtn.getActionListeners()[0]);
                nextBtn.addActionListener(ev -> System.exit(0));
            }
        });

        /**
         * Backボタン処理
         * 前の会話へ戻る
         */
        backBtn.addActionListener(e -> {

            if (idx[0] > 0) {
                idx[0]--;
                typeText(textArea, dialogs.get(idx[0]));
            }

            if (idx[0] == 0) {
                backBtn.setEnabled(false);
            }

            nextBtn.setText("Next");
        });
    }

    /**
     * メソッド名：typeText
     *
     * 概要：
     * 　文字を1文字ずつ表示するタイプライター演出を行う。
     *
     *  textArea 表示対象テキストエリア
     *  lines    表示する文字列配列
     */
    public static void typeText(JTextArea textArea, String[] lines) {

        // 既存タイマー停止
        if (typingTimer != null && typingTimer.isRunning()) {
            typingTimer.stop();
        }

        textArea.setText("");

        final int[] lineIndex = {0};
        final int[] charIndex = {0};

        typingTimer = new Timer(30, null);

        typingTimer.addActionListener(e -> {

            if (lineIndex[0] >= lines.length) {
                typingTimer.stop();
                return;
            }

            String line = lines[lineIndex[0]];

            if (charIndex[0] < line.length()) {
                textArea.append(String.valueOf(line.charAt(charIndex[0])));
                charIndex[0]++;
                textArea.setCaretPosition(textArea.getDocument().getLength());
            } else {
                textArea.append("\n");
                lineIndex[0]++;
                charIndex[0] = 0;
            }
        });

        typingTimer.start();
    }

    /**
     * メソッド名：showResult
     *
     * 概要：
     * 　ゲーム結果（スコア・時間）を表示し、
     * 　データベースへ保存する。
     *
     *  score        獲得スコア
     *  timeElapsed  経過時間（秒）
     */
    public static void showResult(int score, int time_played) {

        int minutes = time_played / 60;
        int seconds = time_played % 60;

        String msg = "PlayerName: " + IntroStory.playerName +
                     "\n点数: " + score +
                     "\n時間: " + minutes + " 分 " + seconds + " 秒";

        // 結果表示
        JOptionPane.showMessageDialog(null, msg, "結果", JOptionPane.INFORMATION_MESSAGE);

        // データベースへ保存
        DatabaseManager.saveScore(IntroStory.playerName, score, time_played);

        JOptionPane.showMessageDialog(null, "データベースに保存されました。");
    }
}
