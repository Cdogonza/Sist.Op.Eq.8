
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jpere
 */
public class Grafica extends JPanel{
    static int a ;
    static int x;
    static int y;
    static int tamx;
    static JPanel p;
    
    public Grafica(){
        setLayout(null);
        setPreferredSize(new Dimension(1800,280));
        
    }
    public void Dibujar(int i, JPanel p,int tamMax, int cantProcesos){
        a += 40;
        x += 1000/tamMax;
        y = 310 - ((i+1) * (290/cantProcesos));
        tamx += 1000/tamMax;
        Graphics g = p.getGraphics();
        paint(g);
        cambiaColor(i, g);
        g.fillRect(  x, y, tamx , (240/cantProcesos));
        p.revalidate();
        Color x = new Color(63,51,30);
        p.setBackground(x);
        tamx = 0;
        
    }

    private static HashMap<Integer, Color> colores;
    private static ArrayList<Integer> valorColor;
    
    private void cambiaColor(int i, Graphics g){
        if (valorColor == null || colores == null){
            valorColor = new ArrayList<Integer>();
            colores = new HashMap<Integer, Color>();
        }
        if (!valorColor.contains(i)){
            valorColor.add(i);
            Random rand = new Random(); //instance of random class
            int tope = 256;            
            int ran = rand.nextInt(tope);
            int ran1 = rand.nextInt(tope);
            int ran2 = rand.nextInt(tope);
            Color nuevoColor = new Color(ran1, ran2, ran);
            colores.put(i, nuevoColor);
        }
        
        g.setColor(colores.get(i));
    }
}
