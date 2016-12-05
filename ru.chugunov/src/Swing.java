import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Andrey Chugunov on 20.09.2016.
 */
public class Swing extends JFrame{
    private JButton button = new JButton("Press");

    public Swing() {
        super("Simple Example");
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        JPanel panel = new JPanel();
        container.add(panel);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int x = button.getX();
                int y = button.getY() + button.getHeight();
                JPopupMenu jPopupMenu = new JPopupMenu();
                jPopupMenu.setFont(jPopupMenu.getFont().deriveFont(Font.BOLD));

                jPopupMenu.add(new AbstractAction("Exit") {

                    private static final long serialVersionUID = 1L;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }).setFont(jPopupMenu.getFont().deriveFont(Font.BOLD));

            }
        });
        container.add(button);
    }

    public static void main(String[] args) {
        Swing app = new Swing();
        app.setVisible(true);
    }
}
