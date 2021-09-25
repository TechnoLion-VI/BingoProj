import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme;

import java.io.IOException;

public class BingoRunner {
    public static void main(String[] args) throws IOException {
        FlatMaterialDarkerIJTheme.setup();
        BingoGame bingoGame = new BingoGame();
    }
}
