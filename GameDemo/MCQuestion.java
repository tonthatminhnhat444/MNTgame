package GameDemo;

import java.util.List;

public class MCQuestion {

    /**
     * 問題文
     * 例：「2 + 3 = ?」
     */
    String question;

    /**
     * 選択肢リスト
     * 例：["4", "5", "6", "7"]
     */
    List<String> options;

    /**
     * 正解のインデックス番号
     *
     * ・0始まりのインデックス
     * ・optionsリストの何番目が正解かを示す
     *
     * 例：
     *  correct = 1 → options.get(1) が正解
     */
    int correct;

    /**
     * 解説文
     *
     * ・回答後に表示される説明テキスト
     * ・学習目的のための補足説明を含む
     */
    String explanation;

    /**
     * コンストラクタ
     *
     * 機能：
     * 　問題データを初期化する。
     *
     *  question     問題文
     *  options      選択肢リスト
     *  correct      正解インデックス
     * explanation  解説文
     */
    public MCQuestion(
            String question,
            List<String> options,
            int correct,
            String explanation
    ) {
        this.question = question;
        this.options = options;
        this.correct = correct;
        this.explanation = explanation;
    }
}
