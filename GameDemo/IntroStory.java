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
 * クラス名：IntroStory
 *
 * 概要：
 * 　本クラスはゲーム開始前のストーリー演出画面を管理する。
 *
 * 主な機能：
 * 　・プレイヤー名入力
 * 　・ストーリーダイアログ表示
 * 　・タイプライター演出（文字を一文字ずつ表示）
 * 　・Next / Back ボタン制御
 * 　・最終的にIntroScreenへ遷移
 */
public class IntroStory {
	 
    /**
     * ストーリーダイアログデータ
     *
     * ・各要素は1画面分のセリフ
     * ・String[] = 1ページ内の複数行テキスト
     */
    private static ArrayList<String[]> dialogs = new ArrayList<>();

    /**
     * タイピング演出用タイマー
     * ・一定間隔で文字を追加表示する
     */
    static Timer typingTimer; 
  
    /**
     * static初期化ブロック
     *
     * ・ゲーム開始時に一度だけ実行される
     * ・ストーリー内容をすべて登録
     */
    static {

        // ===== タイトル画面 =====
        dialogs.add(new String[]{
            "-----ーーーー> PLAY GAME <ーーーー--- ",
            "　          皆さんようこそ　",
            "　      💰大阪の宝物をさがそう💰",
            "　　　　　　",
            "　　　　  　",
            "      Next ボタンを押してください。"
        });

        // ===== ストーリー本編 =====
        dialogs.add(new String[]{
            "📍 大阪・難波 —— 運命の日",
            "　　　　　　",
            "ある日,ニャット君は",
            "大阪・難波の街をあてもなく歩いていた。",
            "ネオンは眩しいのに、🌃💡✨",
            "心はどこか空っぽやった。"
        });

        dialogs.add(new String[]{
            "ふと目に入ったのは、",
            "一軒のパチンコ店。",
            "「一回もやったことないし……",
            "ちょっとだけ、やってみよか。」",
            "そう思い、彼は店に入った。"
        });

        dialogs.add(new String[]{
            "🎰 誘惑",
            "　　　",
            "最初は――勝った。",
            "玉が落ちる音。",
            "増えていくお金。",
            "心が踊った。",
            "www(^_^)www"
        });

        dialogs.add(new String[]{
            "でもな……",
            "一回、また一回。",
            "気づいた時には――",
            "財布は、すっからかんやった。",
            "　😢😢😢😢😢　　",
            "　😭😭😭😭😭　　",         
        });

        dialogs.add(new String[]{
            "😢 絶望",
            "　　　",
            "ニャット君は、その場に崩れ落ちた。",
            "金はない。",
            "希望もない。",
            "これからどうしたらいいやろう。",
            "まったくわからなかった。"
        });

        dialogs.add(new String[]{
            "そして",
            "",
            "",
            "急に........"
        });

        dialogs.add(new String[]{
            "✨ “神様が出現しました",
            "👤 神様：",
            "「なんや、",
            "なんでそんな泣いとるんや？」"
        });

        dialogs.add(new String[]{
            " ニャット：",
            "「ぼくは……",
            "パチンコをして……",
            "全部、負けてしまいまして……」"
        });

        dialogs.add(new String[]{
            "👤 神様：",
            "「アホやなぁ。」",
            "パチンコっちゅうのはな、",
            "ほどほどに遊ぶもんや。",
            "人生、全部賭けるもんちゃうで。」"
        });

        dialogs.add(new String[]{
            " ニャット：",
            "「僕はまだ若うて、",
            "世の中の厳しさを知りませんでした。",
            "妻に知られたら……",
            "きっと離婚されてしまいます。",
            "僕は間違っていました……",
            "どうすればいいんでしょうか……」"
        });

        dialogs.add(new String[]{
            "👤 神様：",
            "「まぁな、",
            "自分のやったことには",
            "責任取らなあかん。」"
        });

        dialogs.add(new String[]{
            "👤 神様：",
            "「せやけどな……",
            "お前、たぶん家族のために",
            "金稼ごうとしてただけやろ。知らんけど...",
            "まあまあ、お前は悪い奴やとは思わへん。」"
        });

        dialogs.add(new String[]{
            "👤 神様：",
            "「しゃあない。",
            "ワシが助けたる。」"
        });

        dialogs.add(new String[]{
            " ニャット：",
            "「ほ、本当ですか！？",
            "ありがとうございます、神様！」"
        });

        dialogs.add(new String[]{
            "👤 神様：",
            "「せやけどな、",
            "そんな簡単には助けへんで。",
            "お前がほんまに",
            "信用できる奴かどうか、",
            "試練で確かめたる。」"
        });

        dialogs.add(new String[]{
            " ニャット：",
            "「もう他に道はありません……",
            "何でもします！」"
        });

        dialogs.add(new String[]{
            "👤 神様：",
            "「よっしゃ。",
            "明日の朝7時、",
            "箕面萱野駅に来い",
            "そっから歩いて",
            "勝尾寺まで行くんや。」",
        });

        dialogs.add(new String[]{
            "👤 神様：",
            "「道中にはな、",
            "9つの試練が待っとる。",
            "全部乗り越えられたら……",
            "1000万円、くれてやる。」"
        });

        dialogs.add(new String[]{
            " ニャット：",
            "「そ、そんな……",
            "信じられません……",
            "でも……",
            "電車に乗るお金すらありません。」"
        });

        dialogs.add(new String[]{
            "👤 神様：",
            "「はぁ……",
            "ほんま、情けないやっちゃな。」"
        });

        dialogs.add(new String[]{
            "👤 神様：",
            "「しゃあないわ。",
            "1５00円、貸したる。",
            "明日勝ったら――",
            "ちゃんと返すんやで。」"
        });

        dialogs.add(new String[]{
            " ニャット：",
            "「はい……",
            "ほんまに、ありがとうございました。」"
        });

        dialogs.add(new String[]{
            "ニャット君は試練をやり遂げたが、",
            "神様は姿を消してしまった。",
            "彼がこの試練を無事に",
            "乗り越えられるかどうかはわからない。」",
        });

        dialogs.add(new String[]{
            "　　      なので、皆さん　　",
            "        ",
            "        ",
            "かわいそうなニャット君を成功させよう!!!",
            "　下のBeginボタンを押してください！"
        });
    }
    
    /**
     * プレイヤー名保持変数
     */
    public static String playerName;

    /**
     * イントロストーリー画面表示メソッド
     */
    public static void show() {

        // プレイヤー名入力ダイアログ
        playerName = JOptionPane.showInputDialog("お名前を入力してください:");

        // 未入力時のデフォルト名設定
        if (playerName == null || playerName.isEmpty())
            playerName = "PLAYER_NONAME";

        // フレーム生成
        JFrame frame = new JFrame("Story");
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // メインパネル（BorderLayout使用）
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        // テキスト表示エリア
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 26));
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.YELLOW);

        // ボタン生成
        JButton nextBtn = new JButton("Next");
        JButton backBtn = new JButton("Back");
        backBtn.setEnabled(false);

        JPanel btnPanel = new JPanel();
        btnPanel.add(backBtn);
        btnPanel.add(nextBtn);

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

        // 現在表示中のページ番号
        final int[] idx = {0};

        // 最初のページ表示
        typeText(textArea, dialogs.get(idx[0]));

        // ===== Nextボタン処理 =====
        nextBtn.addActionListener(e -> {

            if (idx[0] < dialogs.size() - 1) {
                idx[0]++;
                typeText(textArea, dialogs.get(idx[0]));
                backBtn.setEnabled(true);
            }

            if (idx[0] == dialogs.size() - 1) {

                nextBtn.setText("Begin");

                nextBtn.removeActionListener(nextBtn.getActionListeners()[0]);

                nextBtn.addActionListener(ev -> {
                    frame.dispose();
                    IntroScreen.show();
                });
            }
        });

        // ===== Backボタン処理 =====
        backBtn.addActionListener(e -> {

            if (idx[0] > 0) {
                idx[0]--;
                typeText(textArea, dialogs.get(idx[0]));
            }

            backBtn.setEnabled(idx[0] != 0);
            nextBtn.setText("Next");
        });
    }

    /**
     * タイプライター演出メソッド
     *
     *  textArea 表示エリア
     * lines    表示する文字列配列
     */
    static void typeText(JTextArea textArea, String[] lines) {

        if (typingTimer != null && typingTimer.isRunning())
            typingTimer.stop();

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
}
