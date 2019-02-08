import javax.swing.*;
import java.awt.*;

public class help {
    static Toolkit kit = Toolkit.getDefaultToolkit();
        public void help (){
        JFrame frame = new JFrame("Помощь");
        JPanel panel = new JPanel();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2 - 150, dimension.height/2 - 75, 300,150);
    }
}
