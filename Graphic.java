package OrdenacaoPesquisa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class Graphic extends JFrame
{
    private Vector addBinaryTreeDados;
    private Vector addHashTableDados;
    private Vector addBinaryTreeTimes;
    private Vector addHashTableTimes;
    
    private Vector labelXX = new Vector();
    private Vector labelYY = new Vector();

    private int maxX = 0;
    private int minX = 32767;
    private int maxY = 0;
    private int minY = 32767;
    
    public Graphic()
    {
        this.addBinaryTreeDados = GestorEstruturas.addBinaryTreeDados;
        this.addBinaryTreeTimes = GestorEstruturas.addBinaryTreeTimes;
        this.addHashTableDados = GestorEstruturas.addHashTableDados;
        this.addHashTableTimes = GestorEstruturas.addHashTableTimes;
        
        this.makeLabels();
        this.initComponents();
        this.show();
        this.repaint();
    }
    
    private void makeLabels()
    {
        for(int i = 0; i < addBinaryTreeTimes.size(); i++)
        {
            int value = ((Integer) addBinaryTreeTimes.get(i)).intValue();
            if(value > maxX)
                maxX = value;
            if(value < minX)
                minX = value;
        }
        
        for(int i = 0; i < addHashTableTimes.size(); i++)
        {
            int value = ((Integer) addHashTableTimes.get(i)).intValue();
            if(value > maxX)
                maxX = value;
            if(value < minX)
                minX = value;
        }
        
        int difX = (maxX - minX) / 7;

        labelXX.add("" + minX);
        for(int i = 1; i < 7; i++)
            labelXX.add("" + (minX + i * difX));
        labelXX.add("" + maxX);

        for(int i = 0; i < addBinaryTreeDados.size(); i++)
        {
            int value = ((Integer) addBinaryTreeDados.get(i)).intValue();
            if(value > maxY)
                maxY = value;
            if(value < minY)
                minY = value;
        }
        
        for(int i = 0; i < addHashTableDados.size(); i++)
        {
            int value = ((Integer) addHashTableDados.get(i)).intValue();
            if(value > maxY)
                maxY = value;
            if(value < minY)
                minY = value;
        }
        
        int difY = (maxY - minY) / 7;
        
        labelYY.add("" + minY);
        for(int i = 1; i < 7; i++)
            labelYY.add("" + (minY + i * difY));
        labelYY.add("" + maxY);
    }
    
    private void initComponents()
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();;
        
        this.setLocation(50,50);
        this.setTitle("Gráfico do desempenho da inserção");
        this.setResizable(false);
        this.setBackground(new Color(255,255,255));
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                exitForm(evt);
            }
        });
        
        this.jPanelLabelsYY.setLayout(new GridBagLayout());
        this.jPanelLabelsYY.setMaximumSize(new java.awt.Dimension(100,400));
        this.jPanelLabelsYY.setMinimumSize(new java.awt.Dimension(100,400));
        this.jPanelLabelsYY.setPreferredSize(new java.awt.Dimension(100,400));

            this.jLabelYY1.setPreferredSize(new Dimension(100,50));
            this.jLabelYY1.setForeground(Color.gray);
            this.jLabelYY1.setHorizontalAlignment(SwingConstants.RIGHT);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            this.jPanelLabelsYY.add(jLabelYY1,gridBagConstraints);

            this.jLabelYY2.setPreferredSize(new Dimension(100,50));
            this.jLabelYY2.setForeground(Color.gray);
            this.jLabelYY2.setHorizontalAlignment(SwingConstants.RIGHT);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            this.jPanelLabelsYY.add(jLabelYY2,gridBagConstraints);

            this.jLabelYY3.setPreferredSize(new Dimension(100,50));
            this.jLabelYY3.setForeground(Color.gray);
            this.jLabelYY3.setHorizontalAlignment(SwingConstants.RIGHT);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            this.jPanelLabelsYY.add(jLabelYY3,gridBagConstraints);

            this.jLabelYY4.setPreferredSize(new Dimension(100,50));
            this.jLabelYY4.setForeground(Color.gray);
            this.jLabelYY4.setHorizontalAlignment(SwingConstants.RIGHT);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            this.jPanelLabelsYY.add(jLabelYY4,gridBagConstraints);

            this.jLabelYY5.setPreferredSize(new Dimension(100,50));
            this.jLabelYY5.setForeground(Color.gray);
            this.jLabelYY5.setHorizontalAlignment(SwingConstants.RIGHT);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;
            this.jPanelLabelsYY.add(jLabelYY5,gridBagConstraints);
            
            this.jLabelYY6.setPreferredSize(new Dimension(100,50));
            this.jLabelYY6.setForeground(Color.gray);
            this.jLabelYY6.setHorizontalAlignment(SwingConstants.RIGHT);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 5;
            this.jPanelLabelsYY.add(jLabelYY6,gridBagConstraints);

            this.jLabelYY7.setPreferredSize(new Dimension(100,50));
            this.jLabelYY7.setForeground(Color.gray);
            this.jLabelYY7.setHorizontalAlignment(SwingConstants.RIGHT);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 6;
            this.jPanelLabelsYY.add(jLabelYY7,gridBagConstraints);

            this.jLabelYY8.setPreferredSize(new Dimension(100,50));
            this.jLabelYY8.setForeground(Color.gray);
            this.jLabelYY8.setHorizontalAlignment(SwingConstants.RIGHT);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 7;
            this.jPanelLabelsYY.add(jLabelYY8,gridBagConstraints);
        
        this.getContentPane().add(jPanelLabelsYY,BorderLayout.WEST);
        
        this.jPanelDesenho.setMaximumSize(new java.awt.Dimension(800,400));
        this.jPanelDesenho.setMinimumSize(new java.awt.Dimension(800,400));
        this.jPanelDesenho.setPreferredSize(new java.awt.Dimension(800,400));
        this.getContentPane().add(jPanelDesenho,BorderLayout.CENTER);
        
        this.jPanelLabelsXX.setLayout(new GridBagLayout());
        this.jPanelLabelsXX.setMaximumSize(new java.awt.Dimension(800,50));
        this.jPanelLabelsXX.setMinimumSize(new java.awt.Dimension(800,50));
        this.jPanelLabelsXX.setPreferredSize(new java.awt.Dimension(800,50));
        
            this.jEmptyLabelXX.setPreferredSize(new Dimension(100,50));
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            this.jPanelLabelsXX.add(jEmptyLabelXX,gridBagConstraints);
        
            this.jLabelXX1.setPreferredSize(new Dimension(100,50));
            this.jLabelXX1.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 0;
            this.jPanelLabelsXX.add(jLabelXX1,gridBagConstraints);
            
            this.jLabelXX2.setPreferredSize(new Dimension(100,50));
            this.jLabelXX2.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 0;
            this.jPanelLabelsXX.add(jLabelXX2,gridBagConstraints);
            
            this.jLabelXX3.setPreferredSize(new Dimension(100,50));
            this.jLabelXX3.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = 0;
            this.jPanelLabelsXX.add(jLabelXX3,gridBagConstraints);

            this.jLabelXX4.setPreferredSize(new Dimension(100,50));
            this.jLabelXX4.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 0;
            this.jPanelLabelsXX.add(jLabelXX4,gridBagConstraints);

            this.jLabelXX5.setPreferredSize(new Dimension(100,50));
            this.jLabelXX5.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.gridx = 5;
            gridBagConstraints.gridy = 0;
            this.jPanelLabelsXX.add(jLabelXX5,gridBagConstraints);

            this.jLabelXX6.setPreferredSize(new Dimension(100,50));
            this.jLabelXX6.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.gridx = 6;
            gridBagConstraints.gridy = 0;
            this.jPanelLabelsXX.add(jLabelXX6,gridBagConstraints);

            this.jLabelXX7.setPreferredSize(new Dimension(100,50));
            this.jLabelXX7.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.gridx = 7;
            gridBagConstraints.gridy = 0;
            this.jPanelLabelsXX.add(jLabelXX7,gridBagConstraints);

            this.jLabelXX8.setPreferredSize(new Dimension(100,50));
            this.jLabelXX8.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.gridx = 8;
            gridBagConstraints.gridy = 0;
            this.jPanelLabelsXX.add(jLabelXX8,gridBagConstraints);
        
        this.getContentPane().add(jPanelLabelsXX,BorderLayout.SOUTH);
        
        this.pack();
    }
    
    public void paint(Graphics g)
    {
        float escX = 700 / (float) (maxX - minX);
        float escY = 350 / (float) (addBinaryTreeTimes.size());
        
        if(maxX == minX)
        {
            g.setColor(Color.red);
            int p = ((Integer) addBinaryTreeDados.get(0)).intValue();
            int p1 = ((Integer) addBinaryTreeDados.get(addBinaryTreeDados.size() - 1)).intValue();
            g.drawLine(jPanelLabelsYY.getSize().width + 50,470 - jPanelLabelsXX.getSize().height - 25,jPanelLabelsYY.getSize().width + 750,45);
            g.setColor(Color.blue);
            p = ((Integer) addHashTableDados.get(0)).intValue();
            p1 = ((Integer) addHashTableDados.get(addHashTableDados.size() - 1)).intValue();
            g.drawLine(jPanelLabelsYY.getSize().width + 50,470 - jPanelLabelsXX.getSize().height - 25,jPanelLabelsYY.getSize().width + 750,45);
        }
        else
        {
            g.setColor(Color.red);
            for(int i = 0; i < addBinaryTreeTimes.size() - 1; i++)
            {
                int p = ((Integer) addBinaryTreeTimes.get(i)).intValue();
                int p1 = ((Integer) addBinaryTreeTimes.get(i + 1)).intValue();
                g.drawLine(jPanelLabelsYY.getSize().width + 50 + (int) ((float) p * escX) - (int) ((float) minX * escX),470 - jPanelLabelsXX.getSize().height - 25 - (int) (i * escY),jPanelLabelsYY.getSize().width + 50 + (int) ((float) p1 * escX) - (int) ((float) minX * escX),470 - jPanelLabelsXX.getSize().height - 25 - (int) ((i + 1) * escY));
            }
            g.setColor(Color.blue);
            for(int i = 0; i < addHashTableTimes.size() - 1; i++)
            {
                int p = ((Integer) addHashTableTimes.get(i)).intValue();
                int p1 = ((Integer) addHashTableTimes.get(i + 1)).intValue();
                g.drawLine(jPanelLabelsYY.getSize().width + 50 + (int) ((float) p * escX) - (int) ((float) minX * escX),470 - jPanelLabelsXX.getSize().height - 25 - (int) (i * escY),jPanelLabelsYY.getSize().width + 50 + (int) ((float) p1 * escX) - (int) ((float) minX * escX),470 - jPanelLabelsXX.getSize().height - 25 - (int) ((i + 1) * escY));
            }
        }
        
        g.setColor(Color.red);
        g.drawString("BinaryTree",110,40);
        g.setColor(Color.blue);
        g.drawString("HashTable",110,60);
        g.setColor(Color.gray);
        g.drawString("Nº Inserções",110,80);
        g.setColor(Color.black);
        g.drawString("Tempo (ms)",110,100);
        
        this.jLabelYY1.setText(labelYY.get(7).toString());
        this.jLabelYY2.setText(labelYY.get(6).toString());
        this.jLabelYY3.setText(labelYY.get(5).toString());
        this.jLabelYY4.setText(labelYY.get(4).toString());
        this.jLabelYY5.setText(labelYY.get(3).toString());
        this.jLabelYY6.setText(labelYY.get(2).toString());
        this.jLabelYY7.setText(labelYY.get(1).toString());
        this.jLabelYY8.setText(labelYY.get(0).toString());
        
        this.jLabelXX1.setText(labelXX.get(0).toString());
        this.jLabelXX2.setText(labelXX.get(1).toString());
        this.jLabelXX3.setText(labelXX.get(2).toString());
        this.jLabelXX4.setText(labelXX.get(3).toString());
        this.jLabelXX5.setText(labelXX.get(4).toString());
        this.jLabelXX6.setText(labelXX.get(5).toString());
        this.jLabelXX7.setText(labelXX.get(6).toString());
        this.jLabelXX8.setText(labelXX.get(7).toString());
        
        this.jPanelLabelsYY.repaint();
        this.jPanelLabelsXX.repaint();
    }
    
    private void exitForm(WindowEvent evt)
    {
        this.hide();
    }
    
    private JPanel jPanelLabelsYY = new JPanel();
        private JLabel jLabelYY1 = new JLabel();
        private JLabel jLabelYY2 = new JLabel();
        private JLabel jLabelYY3 = new JLabel();
        private JLabel jLabelYY4 = new JLabel();
        private JLabel jLabelYY5 = new JLabel();
        private JLabel jLabelYY6 = new JLabel();
        private JLabel jLabelYY7 = new JLabel();
        private JLabel jLabelYY8 = new JLabel();
    private JPanel jPanelLabelsXX = new JPanel();
        private JLabel jEmptyLabelXX = new JLabel();
        private JLabel jLabelXX1 = new JLabel();
        private JLabel jLabelXX2 = new JLabel();
        private JLabel jLabelXX3 = new JLabel();
        private JLabel jLabelXX4 = new JLabel();
        private JLabel jLabelXX5 = new JLabel();
        private JLabel jLabelXX6 = new JLabel();
        private JLabel jLabelXX7 = new JLabel();
        private JLabel jLabelXX8 = new JLabel();
    private JPanel jPanelDesenho = new JPanel();
}