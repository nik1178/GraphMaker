import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame{
    
    //for now the graphs will only accept cosinus
    MyFrame(){

        Graph graph1 = new Graph("1",300,100,1);
        Graph graph2 = new Graph("2",300,100,1);

        this.add(graph1);
        this.add(graph2);

        this.setLayout(new FlowLayout());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
