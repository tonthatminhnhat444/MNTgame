package GameDemo;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScoreFrame {
    public static void showScoresDialog() {

        //  モーダルダイアログ作成
        JDialog dialog = new JDialog();
        dialog.setTitle("ランキング");            
        dialog.setSize(400, 300);                 
        dialog.setLocationRelativeTo(null);      
        dialog.setModal(true);  // ⚡ モーダル設定（閉じるまで処理停止）

        // テーブルモデル作成
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("名前");   // プレイヤー名列
        model.addColumn("スコア"); // スコア列
        model.addColumn("時間");   // プレイ時間（mm:ss形式）

        //データベースからスコア取得
        List<PlayerScore> scores = DatabaseManager.getAllScores();

        //  テーブルに行を追加 
        for (PlayerScore ps : scores) {

            // 秒数を分:秒に変換
            int totalSeconds = ps.getTimePlayed();
            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;

            String timeStr = String.format("%02d:%02d", minutes, seconds); // mm:ss

            model.addRow(new Object[]{
                ps.getName(),   // プレイヤー名
                ps.getScore(),  // スコア
                timeStr         // プレイ時間（mm:ss）
            });
        }

        // ===== JTable作成とスクロールペイン追加 =====
        JTable table = new JTable(model);
        dialog.add(new JScrollPane(table));

        // ===== ダイアログ表示（モーダル） =====
        dialog.setVisible(true);
    }
}
