import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Graph extends JPanel implements ActionListener{
    
    String formula;
    int x,y,height,width;
    double scale;
    int calculationSteps = 5; // the more steps, the more values it checks between each "scale" dot, aka between each X (if scale=1)

    //for now everything is hardcoded for the exact thing I need
    Graph(String formula, int width, int height, double scale){
        this.formula = formula;
        this.height = height;
        this.width = width;
        this.scale = scale;

        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.black);

        evalFormula();

        Timer timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.white);
        g2.drawLine(0, height/2, width, height/2);
        
        g2.setPaint(Color.cyan);
        g2.translate(0, height/2);
        for(double x=0; x<width; x+=1.0/calculationSteps){
            g2.fillOval((int)x, -(int)(double)allYs.get((int)x*calculationSteps), 2, 2);
        }
    }

    ArrayList<Double> allYs = new ArrayList<>();
    void evalFormula(){
        for(double x=0; x<width; x+=1.0/calculationSteps){
            getFormulaResultForX(x);
        }
    }
    double B = 50;
    double Smax = 50;
    double currentAngle = 90;
    double prevS = 0;



    void getFormulaResultForX(double x){
        //U = BS/t

        if(formula.equals("1")) {
            double currentS = Smax*Math.sin(Math.toRadians(currentAngle));
            double Sdiff = currentS-prevS;
            double result = -this.B * Sdiff;
            allYs.add(result);
            currentAngle++;
            prevS = currentS;
        }
        if(formula=="2"){
            double currentS = Smax*Math.sin(Math.toRadians(currentAngle));
            double Sdiff = currentS-prevS;
            double result = this.B * currentS/50;
            allYs.add(result);
            currentAngle++;
            prevS = currentS;
        }
    }

}
