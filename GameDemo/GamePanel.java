package GameDemo;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener {

    int tileSize = 83;
    long lastMoveTime = 0;
    int playerRow = 0, playerCol = 0;
    Timer gameTimer;
    boolean gameOver = false;

    int score = 0;

   
    int time_left = 600; 

    int[][] map = {
        {2,0,0,5,1,0,1,0,0,0,0,0,1,0,0,0,5},
        {1,1,1,0,1,1,1,0,1,1,0,0,0,0,1,1,0},
        {1,0,0,0,1,1,0,0,0,0,5,1,1,1,0,0,0},
        {0,0,1,1,1,5,0,1,1,1,1,1,0,0,0,1,1},
        {0,1,0,0,0,0,1,1,1,0,0,0,0,1,1,0,0},
        {5,1,0,1,1,1,1,0,0,5,1,1,1,1,0,0,0},
        {0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,5},
        {0,1,1,1,0,1,0,1,1,5,0,0,0,1,0,1,0},
        {0,0,0,0,0,1,0,0,0,0,1,1,0,0,5,1,3}
    };

    HashMap<String, MCQuestion> questions = new HashMap<>();
    HashMap<String, Boolean> unlocked = new HashMap<>();
    Image[][] mapImages = new Image[map.length][map[0].length];

    Image tree1 = new ImageIcon("images/tree1.png").getImage();
    Image sand = new ImageIcon("images/sand.png").getImage();
    Image hito = new ImageIcon("images/hito.png").getImage();
    Image monster = new ImageIcon("images/monster.png").getImage();
    Image monster1 = new ImageIcon("images/monster1.png").getImage();
    Image money = new ImageIcon("images/money.gif").getImage();

    public GamePanel() {

        setFocusable(true);
        addKeyListener(this);

        initQuestions();
        initMapImages();
        
        setFocusable(true);
        addKeyListener(this);

        initQuestions();     // クイズ設定
        initMapImages();
        initDecorations();   
        
        //画面を飾ります。
      
        
        gameTimer = new Timer(1000, e -> {

            if (gameOver) return;

            time_left--;

            repaint();

            if (time_left <= 0) {
                time_left = 0;
                gameOver = true;

                int time_played = 600;

                EndScreen.showResult(score, time_played);
                ScoreFrame.showScoresDialog();

                int choice = JOptionPane.showConfirmDialog(
                        this,
                        "時間切れです！\nスコア: " + score +
                        "\n\nもう一度プレイしますか？",
                        "タイムアップ",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE
                );

                if (choice == JOptionPane.OK_OPTION) {
                    resetGame();  
                } else {
                    System.exit(0);
                }
            }
        });

        gameTimer.start();
    }
    void initDecorations() {
        mapImages[0][5] = new ImageIcon("images/taki1.png").getImage();
        mapImages[0][6] = new ImageIcon("images/taki2.png").getImage();
        mapImages[1][5] = new ImageIcon("images/taki3.png").getImage();
        mapImages[1][6] = new ImageIcon("images/taki4.png").getImage();
        mapImages[1][0] = new ImageIcon("images/eki.png").getImage();
        mapImages[1][7] = new ImageIcon("images/hashi_left.png").getImage();
        mapImages[1][8] = new ImageIcon("images/hashi_right.png").getImage();
        mapImages[8][0] = new ImageIcon("images/gate1.png").getImage();
        mapImages[5][11] = new ImageIcon("images/otera_1.png").getImage();
        mapImages[6][11] = new ImageIcon("images/otera_2.png").getImage();
        mapImages[6][10] = new ImageIcon("images/daruma.png").getImage();
        mapImages[6][12] = new ImageIcon("images/daruma.png").getImage();
        mapImages[3][7] = new ImageIcon("images/momiji.png").getImage();
        mapImages[3][8] = new ImageIcon("images/momiji.png").getImage();
        mapImages[3][9] = new ImageIcon("images/momiji.png").getImage();
        mapImages[3][10] = new ImageIcon("images/momiji.png").getImage();
        mapImages[3][11] = new ImageIcon("images/momiji.png").getImage();
        mapImages[1][9] = new ImageIcon("images/momiji.png").getImage();
        mapImages[0][12] = new ImageIcon("images/momiji.png").getImage();
        }
    
    void initQuestions() {

        ArrayList<MCQuestion> list = new ArrayList<>();

     // 質問1
        list.add(new MCQuestion(
            "VTIジャパンの主な拠点はどこにありますか？",
            Arrays.asList(
                "日本とベトナム",
                "日本とアメリカ",
                "日本と韓国",
                "日本のみ"
            ),
            0,
            "正解は「日本とベトナム」です。日本側とベトナム側のエンジニアが連携して開発を行う体制があります。"
        ));
        //質問2
         list.add(new MCQuestion(
             "これは大阪人のおかんたちの口癖です。\n答えを選んでください「明日の・・・」",
             Arrays.asList("天気","あめちゃん","パン","ポン酢"),
             2,
             "直訳すると「明日食べるパン」ですが、実際には\n👉 「明日の朝ごはん用のパン」\n👉 「明日用に確保しておく食べ物」" +
             "\n明日のパンがないと、困ります。パンを焼くだけ、便利だと言われています。" +
             "\n使い方の例:\n👉 「食べないで！今日のパンじゃない、明日のパンやで！」\n👉 「あかんあかん、それは明日のパン！」"
         ));
         
      // 質問3
         list.add(new MCQuestion(
             "VTIジャパンの特徴として正しいものはどれですか？",
             Arrays.asList(
                 "完全に日本人のみの会社",
                 "海外開発を行わない会社",
                 "日本とベトナムのチームで協力して開発する会社",
                 "ゲーム開発専門会社"
             ),
             2,
             "正解は「日本とベトナムのチームで協力して開発する会社」です。オフショア開発モデルを活用しています。"
         ));
      // 質問4
         list.add(new MCQuestion(
             "VTIジャパンがよく扱う開発分野はどれですか？",
             Arrays.asList(
                 "ゲーム機製造",
                 "Web・モバイルアプリ開発",
                 "農業機械開発",
                 "食品加工"
             ),
             1,
             "正解は「Web・モバイルアプリ開発」です。企業向けのシステム開発やアプリ開発を多く手がけています。"
         ));

       //質問5
         list.add(new MCQuestion(
         	    "例えばあなたはITエンジニアです。\n急に他のITエンジニアさんに「月が綺麗ですね」と言われたら、正しい反応は？",
         	    Arrays.asList(
         	        "I love you だと思う",
         	        "察してドキドキする",
         	        "じっと相手の目を見ながらスペック確認する",
         	        "恥ずかしくて、ニコニコする"
         	    ),
         	    2,
         	    "人によりそれぞれですが、ITエンジニアとしてロマンより仕様ですね。まず解像度、次にスペックです。"
         	));
      // 質問6
         list.add(new MCQuestion(
             "VTIジャパンの親会社であるVTIはどこの国の企業ですか？",
             Arrays.asList(
                 "日本",
                 "ベトナム",
                 "アメリカ",
                 "韓国"
             ),
             1,
             "正解は「ベトナム」です。VTIジャパンはベトナムのVTIグループの日本法人です。"
         ));

       //質問7
         list.add(new MCQuestion(
         	    "黒いスーツの二人が銀行で話しています。\n" +
         	    "A:「今日は大阪の銀行で魚を釣るつもりです。」\n" +
         	    "B:「わかりました。たくさん釣って、その後で魚鍋をたくさん食べましょう。」\n" +
         	    "話し終えた瞬間、後ろから誰かが二人を止めました。\n" +
         	    "C:「銀行で魚を釣るとは、どういう意味ですか？」\n" +
         	    "あなたはどう思いますか？",
         	    Arrays.asList(
         	        "二人は魚が食べたくて想像していた",
         	        "AさんはATMでオンライン釣りを試している",
         	        "Bさんは銀行に巨大な魚の池があると思った",
         	        "魚を釣る = Fishing 🐟 -> Phishing 💻 = フィッシング"
         	    ),
         	    3,
         	    "答えは4です。「魚を釣る」という表現はフィッシング（Phishing）を意味する、ITセキュリティの言葉遊びです。" +
         	    "\nあの二人はハッカーです。はっきり言うと、捕まってしまうでしょう。" +
         	    "\nそれにしても、大阪の警察には勝てません。"
         	));


       //質問8
         list.add(new MCQuestion(
         	    "二人の会話を読んで、駅名「十三」の正しい読み方はどれでしょう？\n\n"
         	    + "A: 「この駅、十三って書いてあるけど、じゅうそうでしょ？」\n"
         	    + "B: 「いや、僕はじゅうさんだと思うな。ほら、数としての十三だし。」\n"
         	    + "A: 「でも大阪ではよく『じゅうそう』って聞くよ？」\n"
         	    + "B: 「うーん…結局、数として読むなら？」",
         	    Arrays.asList(
         	        "じゅうそう",
         	        "じゅうさん",
         	        "じゅうそ",
         	        "じゅうしゃん"
         	    ),
         	    1,
         	    "この問題の正解は「じゅうさん」です。会話の最後で、数として読む場合の正しい読み方になります。\n大阪の地名としては『じゅうそう』もありますが、ここでは数として読むのがポイントです。"
         	));

       //質問9
         list.add(new MCQuestion(
         	    "大阪名物『551蓬莱の豚まん』の551は何を意味している？",
         	    Arrays.asList(
         	        "創業者の誕生日",
         	        "電話番号",
         	        "住所の番地",
         	        "意味は特にない"
         	    ),
         	    1,
         	    "正解は「電話番号」です。元々は店の電話番号の下3桁から取ったと言われています。"
         	));
     //質問はランダム的に表す。
     Collections.shuffle(list);



        int i = 0;
        for (int r=0;r<map.length;r++)
            for (int c=0;c<map[0].length;c++)
                if (map[r][c]==5) {

                    String k = r+","+c;

                    questions.put(k, list.get(i % list.size()));
                    unlocked.put(k, false);
                    i++;
                }
    }

    void initMapImages() {

        for (int r=0; r<map.length; r++) {
            for (int c=0; c<map[0].length; c++) {

                switch(map[r][c]) {
                    case 0: mapImages[r][c] = sand; break;
                    case 1: mapImages[r][c] = tree1; break;
                    case 2: mapImages[r][c] = null; break;
                    case 3: mapImages[r][c] = money; break;
                    case 5: mapImages[r][c] = monster; break;
                }
            }
        }
    }

   @Override
protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    for (int r = 0; r < map.length; r++)
        for (int c = 0; c < map[0].length; c++)
            if (mapImages[r][c] != null)
                g.drawImage(mapImages[r][c],
                        c * tileSize, r * tileSize, tileSize, tileSize, this);

    g.drawImage(hito,
            playerCol * tileSize, playerRow * tileSize,
            tileSize, tileSize, this);

    int hour = time_left / 3600;
    int minute = (time_left % 3600) / 60;
    int second = time_left % 60;

    
    g.drawString(
        String.format("時間: %02d:%02d:%02d", hour, minute, second),
        8, 20
    );

    g.drawString("点数: " + score, 8, 40);
}

    @Override
    public void keyPressed(KeyEvent e) {

        if (gameOver) return;

       
        long now = System.currentTimeMillis();
        if (now - lastMoveTime < 120) return;
        lastMoveTime = now;

        int nr = playerRow, nc = playerCol;

        if (e.getKeyCode()==KeyEvent.VK_UP) nr--;
        if (e.getKeyCode()==KeyEvent.VK_DOWN) nr++;
        if (e.getKeyCode()==KeyEvent.VK_LEFT) nc--;
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) nc++;

        if (nr<0||nc<0||nr>=map.length||nc>=map[0].length||map[nr][nc]==1) return;

        if (map[nr][nc]==5 && !unlocked.get(nr+","+nc)) {
            if (!askQuestion(nr,nc)) return;
        }

        if (map[nr][nc]==3) {

            gameOver = true;

            JOptionPane.showMessageDialog(this,
                "🎉ゲームクリア！",
                "ゲームクリア",
                JOptionPane.INFORMATION_MESSAGE);

            int time_played = 600 - time_left;

            EndScreen.showResult(score, time_played);
            ScoreFrame.showScoresDialog();
            EndScreen.showEndKaiwa();
        }

        playerRow = nr;
        playerCol = nc;
        repaint();
    }
    boolean askQuestion(int r, int c) {

        MCQuestion q = questions.get(r + "," + c);

        Object ans = JOptionPane.showInputDialog(
                this,
                q.question,
                "Question",
                JOptionPane.QUESTION_MESSAGE,
                null,
                q.options.toArray(),
                null
        );

        boolean correct =
                ans != null && q.options.indexOf(ans) == q.correct;

        if (correct) {
            JOptionPane.showMessageDialog(this,"⭕ 正解！");
        } else {
            JOptionPane.showMessageDialog(this,"❌ 間違った!");
        }

        JOptionPane.showMessageDialog(this, q.explanation);

        if (correct) {
            unlocked.put(r + "," + c, true);
            mapImages[r][c] = monster1;
            score++;
            return true;
        }

        
        gameOver = true;
       

        int time_played = 600 - time_left;
        EndScreen.showResult(score, time_played);
        ScoreFrame.showScoresDialog();

       
        int choice = JOptionPane.showConfirmDialog(
                this,
                "スコア: " + score +
                "\n時間: " + time_played +
                "\n\nもう一度プレイしますか？",
                "ゲームオーバー",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // OK = chơi lại
        if (choice == JOptionPane.OK_OPTION) {
            resetGame();
        } else {
            System.exit(0);
        }

        return false;
    }

    void resetGame() {

        playerRow = 0;
        playerCol = 0;

        score = 0;
        time_left = 600;

        gameOver = false;

        unlocked.clear();
        questions.clear();

        initQuestions();

        initMapImages();     
        initDecorations();    

        gameTimer.restart();

        repaint();
    
    }
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
