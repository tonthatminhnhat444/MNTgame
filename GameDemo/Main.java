package GameDemo;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            //  IntroStoryに移動します。
            IntroStory.show();
        });
    }
}
