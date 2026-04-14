package GameDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final String URL =
    "jdbc:mysql://localhost:33060/gamedb";
    private static final String USER = "root";
    private static final String PASSWORD = "pass";

    /**
     * プレイヤーのスコアをデータベースに保存する
     *  playerName プレイヤー名
     *  score スコア
     *  timePlayed プレイ時間（秒）
     */
   public static void saveScore(String playerName, int score, int timePlayed) {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        return;
    }

    String sql = "INSERT INTO player_scores(name, score, time_played) VALUES (?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, playerName);
        pstmt.setInt(2, score);
        pstmt.setInt(3, timePlayed);

        pstmt.executeUpdate();

        System.out.println("ゲームクリア: " + playerName + " - " + score + " - " + timePlayed + " 秒");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    /**
     * データベースから全スコアを取得
     *  PlayerScoreのリスト
     */
    public static List<PlayerScore> getAllScores() {
        List<PlayerScore> list = new ArrayList<>();
        String sql = "SELECT name, score, time_played FROM player_scores ORDER BY score DESC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                int score = rs.getInt("score");
                int timePlayed = rs.getInt("time_played"); // 秒を直接取得
              

                list.add(new PlayerScore(name, score, timePlayed));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
