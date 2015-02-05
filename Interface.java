package OrdenacaoPesquisa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

public class Interface extends JFrame
{
    public Interface()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        GridBagConstraints gridBagConstraints;
        
        //Frame Principal
        this.setSize(1000,700);
        this.setLocation(10,20);
        this.setTitle("Eficiência de algoritmos de ordenação e pesquisa");
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                exitForm(evt);
            }
        });
        
        //Painel das Ferramentas
        this.jPanelFerramentas.setLayout(new GridBagLayout());
        this.jPanelFerramentas.setMaximumSize(new java.awt.Dimension(130,700));
        this.jPanelFerramentas.setMinimumSize(new java.awt.Dimension(130,700));
        this.jPanelFerramentas.setPreferredSize(new java.awt.Dimension(130,700));
        
            //Botão do Varrimento
            this.jButtonVarrimento.setText("Varrimento");
            this.jButtonVarrimento.setToolTipText("Executa o varrimento do ficheiro seleccionado");
            this.jButtonVarrimento.setPreferredSize(new Dimension(100,25));
            this.jButtonVarrimento.setMinimumSize(new Dimension(100,25));
            this.jButtonVarrimento.setMaximumSize(new Dimension(100,25));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            this.jButtonVarrimento.setEnabled(false);
            this.jButtonVarrimento.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    jButtonVarrimentoActionPerformed(evt);
                }
            });
            this.jPanelFerramentas.add(jButtonVarrimento,gridBagConstraints);
            
            //Botão da pesquisa
            this.jButtonPesquisa.setText("Pesquisa");
            this.jButtonPesquisa.setToolTipText("Pesquisa a palavra que desejar no ficheiro seleccionado");
            this.jButtonPesquisa.setPreferredSize(new Dimension(100,25));
            this.jButtonPesquisa.setMinimumSize(new Dimension(100,25));
            this.jButtonPesquisa.setMaximumSize(new Dimension(100,25));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            this.jButtonPesquisa.setEnabled(false);
            this.jButtonPesquisa.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    jButtonPesquisaActionPerformed(evt);
                }
            });
            this.jPanelFerramentas.add(jButtonPesquisa,gridBagConstraints);
            
            //Caixa de texto da pesquisa
            this.jTextFieldPesquisa.setText("");
            this.jTextFieldPesquisa.setToolTipText("Insira a palavra que deseja pesquisar");
            this.jTextFieldPesquisa.setPreferredSize(new Dimension(100,25));
            this.jTextFieldPesquisa.setMinimumSize(new Dimension(100,25));
            this.jTextFieldPesquisa.setMaximumSize(new Dimension(100,25));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            this.jTextFieldPesquisa.setEnabled(false);
            this.jPanelFerramentas.add(jTextFieldPesquisa,gridBagConstraints);
        
        this.getContentPane().add(jPanelFerramentas,BorderLayout.WEST);
        
        //Painel das tabelas e do ficheiro
        this.jPanelOutput.setLayout(new GridBagLayout());
        this.jPanelOutput.setMaximumSize(new java.awt.Dimension(850,700));
        this.jPanelOutput.setMinimumSize(new java.awt.Dimension(850,700));
        this.jPanelOutput.setPreferredSize(new java.awt.Dimension(850,700));
        
            //TextArea do ficheiro a pesquisar
            this.jTextAreaFicheiro.setText("");
            this.jTextAreaFicheiro.setToolTipText("Conteúdo do ficheiro que deseja pesquisar");
            this.jTextAreaFicheiro.setPreferredSize(new Dimension(850,250));
            this.jTextAreaFicheiro.setMinimumSize(new Dimension(850,250));
            this.jTextAreaFicheiro.setMaximumSize(new Dimension(850,250));
            this.jTextAreaFicheiro.setEnabled(false);
            this.jTextAreaFicheiro.addKeyListener(new KeyListener()
            {
                public void keyTyped(KeyEvent evt)
                {
                    jTextAreaFicheiroKeyTyped(evt);
                }
                public void keyPressed(KeyEvent evt) { }
                public void keyReleased(KeyEvent evt) { }
            });
            this.jTextAreaFicheiro.addMouseListener(new MouseListener()
            {
                public void mousePressed(MouseEvent evt)
                {
                    jTextAreaFicheiroMousePressed(evt);
                }
                public void mouseClicked(MouseEvent evt) { }
                public void mouseReleased(MouseEvent evt) { }
                public void mouseEntered(MouseEvent evt) { }
                public void mouseExited(MouseEvent evt) { }
            });
            
            //ScrollPane que contém a TextArea do ficheiro a pesquisar
            this.jScrollPaneFicheiro = new JScrollPane(jTextAreaFicheiro);
            this.jScrollPaneFicheiro.setPreferredSize(new Dimension(850,250));
            this.jScrollPaneFicheiro.setMinimumSize(new Dimension(850,250));
            this.jScrollPaneFicheiro.setMaximumSize(new Dimension(850,250));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            this.jPanelOutput.add(jScrollPaneFicheiro,gridBagConstraints);
            
            //Label que faz de separador 1
            this.jLabelSeparator1.setText("");
            this.jLabelSeparator1.setToolTipText(null);
            this.jLabelSeparator1.setPreferredSize(new Dimension(850,5));
            this.jLabelSeparator1.setMinimumSize(new Dimension(850,5));
            this.jLabelSeparator1.setMaximumSize(new Dimension(850,5));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            this.jLabelSeparator1.setEnabled(false);
            this.jPanelOutput.add(jLabelSeparator1,gridBagConstraints);
            
            //Tabela dos resultados do varrimento
            this.jTableVarrimento.setPreferredSize(new Dimension(850,250));
            this.jTableVarrimento.setMinimumSize(new Dimension(850,250));
            this.jTableVarrimento.setMaximumSize(new Dimension(850,250));
            this.jTableVarrimento.setEnabled(false);
            
            //ScrollPane que contém a tabela dos varrimentos
            this.jScrollPaneTableVarrimento = new JScrollPane(jTableVarrimento);
            this.jScrollPaneTableVarrimento.setPreferredSize(new Dimension(850,250));
            this.jScrollPaneTableVarrimento.setMinimumSize(new Dimension(850,250));
            this.jScrollPaneTableVarrimento.setMaximumSize(new Dimension(850,250));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            this.jPanelOutput.add(jScrollPaneTableVarrimento,gridBagConstraints);
            
            //Label que faz de separador 2
            this.jLabelSeparator2.setText("");
            this.jLabelSeparator2.setToolTipText(null);
            this.jLabelSeparator2.setPreferredSize(new Dimension(850,5));
            this.jLabelSeparator2.setMinimumSize(new Dimension(850,5));
            this.jLabelSeparator2.setMaximumSize(new Dimension(850,5));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            this.jLabelSeparator2.setEnabled(false);
            this.jPanelOutput.add(jLabelSeparator2,gridBagConstraints);
            
            //Tabela das comparações entre as estruturas de dados
            this.jTablePesquisa.setPreferredSize(new Dimension(850,100));
            this.jTablePesquisa.setMinimumSize(new Dimension(850,100));
            this.jTablePesquisa.setMaximumSize(new Dimension(850,100));
            this.jTablePesquisa.setEnabled(false);
            
            //ScrollPane que contém a tabela da pesquisa
            this.jScrollPaneTablePesquisa = new JScrollPane(jTablePesquisa);
            this.jScrollPaneTablePesquisa.setPreferredSize(new Dimension(850,100));
            this.jScrollPaneTablePesquisa.setMinimumSize(new Dimension(850,100));
            this.jScrollPaneTablePesquisa.setMaximumSize(new Dimension(850,100));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;
            this.jPanelOutput.add(jScrollPaneTablePesquisa,gridBagConstraints);
        
        this.getContentPane().add(jPanelOutput,BorderLayout.CENTER);
        
        //Paineis separadores do inicio e do fim da frame
        this.jPanelInicioHorizontal.setPreferredSize(new Dimension(1000,5));
        this.jPanelInicioHorizontal.setMinimumSize(new Dimension(1000,5));
        this.jPanelInicioHorizontal.setMaximumSize(new Dimension(1000,5));
        this.getContentPane().add(jPanelFimVertical,BorderLayout.NORTH);
        
        this.jPanelFimHorizontal.setPreferredSize(new Dimension(1000,5));
        this.jPanelFimHorizontal.setMinimumSize(new Dimension(1000,5));
        this.jPanelFimHorizontal.setMaximumSize(new Dimension(1000,5));
        this.getContentPane().add(jPanelFimVertical,BorderLayout.SOUTH);
        
        this.jPanelFimVertical.setPreferredSize(new Dimension(5,700));
        this.jPanelFimVertical.setMinimumSize(new Dimension(5,700));
        this.jPanelFimVertical.setMaximumSize(new Dimension(5,700));
        this.getContentPane().add(jPanelFimVertical,BorderLayout.EAST);
        
        //MenuBar da Frame Principal

            //Menu ficheiro
            this.jMenuFicheiro.setText("Ficheiro");
            this.jMenuFicheiro.setToolTipText("Operações sobre o ficheiro");

                //Item para criar um novo ficheiro
                this.jMenuItemFicheiroNovo.setText("Novo");
                this.jMenuItemFicheiroNovo.setToolTipText("Cria um novo ficheiro para pesquisa");
                this.jMenuItemFicheiroNovo.setHorizontalTextPosition(SwingConstants.RIGHT);
                this.jMenuItemFicheiroNovo.setIcon(new ImageIcon(getClass().getResource("/Trab1/ICONES/NEW.JPG")));
                this.jMenuItemFicheiroNovo.setEnabled(true);
                this.jMenuItemFicheiroNovo.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) 
                    {
                        jMenuItemFicheiroNovoActionPerformed(evt);
                    }
                });
                this.jMenuFicheiro.add(jMenuItemFicheiroNovo);
                
                //Item para abrir um ficheiro
                this.jMenuItemFicheiroAbrir.setText("Abrir");
                this.jMenuItemFicheiroAbrir.setToolTipText("Abre um ficheiro para pesquisa");
                this.jMenuItemFicheiroAbrir.setHorizontalTextPosition(SwingConstants.RIGHT);
                this.jMenuItemFicheiroAbrir.setIcon(new ImageIcon(getClass().getResource("/Trab1/ICONES/OPEN.JPG")));
                this.jMenuItemFicheiroAbrir.setEnabled(true);
                this.jMenuItemFicheiroAbrir.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) 
                    {
                        jMenuItemFicheiroAbrirActionPerformed(evt);
                    }
                });
                this.jMenuFicheiro.add(jMenuItemFicheiroAbrir);
                
                //Item para fechar o ficheiro
                this.jMenuItemFicheiroFechar.setText("Fechar");
                this.jMenuItemFicheiroFechar.setToolTipText("Fecha o ficheiro que está a ser usado para pesquisa");
                this.jMenuItemFicheiroFechar.setHorizontalTextPosition(SwingConstants.RIGHT);
                this.jMenuItemFicheiroFechar.setIcon(new ImageIcon(getClass().getResource("/Trab1/ICONES/EMPTY.JPG")));
                this.jMenuItemFicheiroFechar.setEnabled(false);
                this.jMenuItemFicheiroFechar.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) 
                    {
                        jMenuItemFicheiroFecharActionPerformed(evt);
                    }
                });
                this.jMenuFicheiro.add(jMenuItemFicheiroFechar);
                
                //Separador 1
                this.jSeparatorFicheiro1.setEnabled(false);
                this.jMenuFicheiro.add(jSeparatorFicheiro1);
                
                //Item para guardar o ficheiro
                this.jMenuItemFicheiroGuardar.setText("Guardar");
                this.jMenuItemFicheiroGuardar.setToolTipText("Guarda o ficheiro que está a ser usado para pesquisa");
                this.jMenuItemFicheiroGuardar.setHorizontalTextPosition(SwingConstants.RIGHT);
                this.jMenuItemFicheiroGuardar.setIcon(new ImageIcon(getClass().getResource("/Trab1/ICONES/SAVE.JPG")));
                this.jMenuItemFicheiroGuardar.setEnabled(false);
                this.jMenuItemFicheiroGuardar.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) 
                    {
                        jMenuItemFicheiroGuardarActionPerformed(evt);
                    }
                });
                this.jMenuFicheiro.add(jMenuItemFicheiroGuardar);
                
                //Item para guardar o ficheiro com outro nome
                this.jMenuItemFicheiroGuardarComo.setText("Guardar como...");
                this.jMenuItemFicheiroGuardarComo.setToolTipText("Guarda o ficheiro que está a ser usado para pesquisa");
                this.jMenuItemFicheiroGuardarComo.setHorizontalTextPosition(SwingConstants.RIGHT);
                this.jMenuItemFicheiroGuardarComo.setIcon(new ImageIcon(getClass().getResource("/Trab1/ICONES/SAVE.JPG")));
                this.jMenuItemFicheiroGuardarComo.setEnabled(false);
                this.jMenuItemFicheiroGuardarComo.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) 
                    {
                        jMenuItemFicheiroGuardarComoActionPerformed(evt);
                    }
                });
                this.jMenuFicheiro.add(jMenuItemFicheiroGuardarComo);
                
                //Separador 2
                this.jSeparatorFicheiro2.setEnabled(false);
                this.jMenuFicheiro.add(jSeparatorFicheiro2);
                
                //Item para sair do programa
                this.jMenuItemFicheiroSair.setText("Sair");
                this.jMenuItemFicheiroSair.setToolTipText("Sai do programa");
                this.jMenuItemFicheiroSair.setHorizontalTextPosition(SwingConstants.RIGHT);
                this.jMenuItemFicheiroSair.setIcon(new ImageIcon(getClass().getResource("/Trab1/ICONES/DELETE.JPG")));
                this.jMenuItemFicheiroSair.setEnabled(true);
                this.jMenuItemFicheiroSair.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) 
                    {
                        exitForm(null);
                    }
                });
                this.jMenuFicheiro.add(jMenuItemFicheiroSair);

            this.jMenuBar.add(jMenuFicheiro);

            //Menu Estruturas
            this.jMenuEstruturas.setText("Estruturas");
            this.jMenuEstruturas.setToolTipText("Operações sobre as estruturas");

                //Item para abrir estruturas
                this.jMenuItemEstruturasAbrir.setText("Abrir");
                this.jMenuItemEstruturasAbrir.setToolTipText("Abre estruturas par realizar a pesquisa");
                this.jMenuItemEstruturasAbrir.setHorizontalTextPosition(SwingConstants.RIGHT);
                this.jMenuItemEstruturasAbrir.setIcon(new ImageIcon(getClass().getResource("/Trab1/ICONES/OPEN.JPG")));
                this.jMenuItemEstruturasAbrir.setEnabled(true);
                this.jMenuItemEstruturasAbrir.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) 
                    {
                        jMenuItemEstruturasAbrirActionPerformed(evt);
                    }
                });
                this.jMenuEstruturas.add(jMenuItemEstruturasAbrir);
                
                //Item para fechar estruturas
                this.jMenuItemEstruturasFechar.setText("Fechar");
                this.jMenuItemEstruturasFechar.setToolTipText("Fecha as estruturas que estão a ser utilizadas");
                this.jMenuItemEstruturasFechar.setHorizontalTextPosition(SwingConstants.RIGHT);
                this.jMenuItemEstruturasFechar.setIcon(new ImageIcon(getClass().getResource("/Trab1/ICONES/EMPTY.JPG")));
                this.jMenuItemEstruturasFechar.setEnabled(false);
                this.jMenuItemEstruturasFechar.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) 
                    {
                        jMenuItemEstruturasFecharActionPerformed(evt);
                    }
                });
                this.jMenuEstruturas.add(jMenuItemEstruturasFechar);
                
                //Separador 1
                this.jSeparatorEstruturas1.setEnabled(false);
                this.jMenuEstruturas.add(jSeparatorEstruturas1);
                
                //Item para guardar as estruturas
                this.jMenuItemEstruturasGuardar.setText("Guardar");
                this.jMenuItemEstruturasGuardar.setToolTipText("Guarda as estruturas que estão a ser usadas para efectuar a pesquisa");
                this.jMenuItemEstruturasGuardar.setHorizontalTextPosition(SwingConstants.RIGHT);
                this.jMenuItemEstruturasGuardar.setIcon(new ImageIcon(getClass().getResource("/Trab1/ICONES/SAVE.JPG")));
                this.jMenuItemEstruturasGuardar.setEnabled(false);
                this.jMenuItemEstruturasGuardar.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) 
                    {
                        jMenuItemEstruturasGuardarActionPerformed(evt);
                    }
                });
                this.jMenuEstruturas.add(jMenuItemEstruturasGuardar);
                
                //Item para guardar as estruturas com outro nome
                this.jMenuItemEstruturasGuardarComo.setText("Guardar como...");
                this.jMenuItemEstruturasGuardarComo.setHorizontalTextPosition(SwingConstants.RIGHT);
                this.jMenuItemEstruturasGuardarComo.setIcon(new ImageIcon(getClass().getResource("/Trab1/ICONES/SAVE.JPG")));
                this.jMenuItemEstruturasGuardarComo.setEnabled(false);
                this.jMenuItemEstruturasGuardarComo.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) 
                    {
                        jMenuItemEstruturasGuardarComoActionPerformed(evt);
                    }
                });
                this.jMenuEstruturas.add(jMenuItemEstruturasGuardarComo);
            
            this.jMenuBar.add(jMenuEstruturas);
            
            //Menu Opcoes
            this.jMenuOpcoes.setText("Opções");
            this.jMenuOpcoes.setToolTipText("Opções do programa");
            
                this.jMenuItemOpcoesGraficoMemoria.setText("Gráfico desempenho da inserção");
                this.jMenuItemOpcoesGraficoMemoria.setToolTipText("Visualiza o gráfico do desempenho da memória");
                this.jMenuItemOpcoesGraficoMemoria.setHorizontalTextPosition(SwingConstants.RIGHT);
                this.jMenuItemOpcoesGraficoMemoria.setIcon(new ImageIcon(getClass().getResource("/Trab1/ICONES/EMPTY.JPG")));
                this.jMenuItemOpcoesGraficoMemoria.setEnabled(false);
                this.jMenuItemOpcoesGraficoMemoria.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                        jMenuItemOpcoesGraficoMemoriaActionPerformed(evt);
                    }
                });
                this.jMenuOpcoes.add(jMenuItemOpcoesGraficoMemoria);
            
            this.jMenuBar.add(jMenuOpcoes);
            
            //Menu Ajuda
            this.jMenuAjuda.setText("Ajuda");
            this.jMenuAjuda.setToolTipText("Ajuda sobre o programa");
            
            this.jMenuBar.add(jMenuAjuda);
                
        this.setJMenuBar(jMenuBar);
        
        //Popup Menu
            this.jMenuItemPopupMenuUsarTextoSeleccionado.setText("Usar o texto seleccionado");
            this.jMenuItemPopupMenuUsarTextoSeleccionado.setToolTipText("Usa o texto seleccionado para o varrimento e pesquisa");
            this.jMenuItemPopupMenuUsarTextoSeleccionado.setEnabled(true);
            this.jMenuItemPopupMenuUsarTextoSeleccionado.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    jMenuItemPopupMenuUsarTextoSeleccionadoActionPerformed(evt);
                }
            });
            this.jPopupMenu.add(jMenuItemPopupMenuUsarTextoSeleccionado);
    }
    
    private void jMenuItemPopupMenuUsarTextoSeleccionadoActionPerformed(ActionEvent evt)
    {
        switch(testFicheiroSaved())
        {
            case -1:
                break;
            case 0:
                gravaFicheiro();
                break;
            case 1:
                break;
            case 2:
                return ;
        }
        
        switch(testEstruturasSaved())
        {
            case -1:
                break;
            case 0:
                gravaEstruturas();
                break;
            case 1:
                break;
            case 2:
                return ;
        }
        
        ficheiroStarted = 1;
        ficheiroSaved = 0;
        ficheiroModified = 1;
        ficheiroOpened = 0;
        ficheiroSavedBefore = 0;
        
        estruturasModified = 0;
        estruturasOpened = 0;
        estruturasSaved = 0;
        estruturasSavedBefore = 0;
        estruturasStarted = 0;
        
        jMenuItemFicheiroFechar.setEnabled(true);
        jMenuItemFicheiroGuardar.setEnabled(true);
        jMenuItemFicheiroGuardarComo.setEnabled(true);
        
        jMenuItemEstruturasGuardar.setEnabled(true);
        jMenuItemEstruturasGuardarComo.setEnabled(true);
        
        jMenuItemOpcoesGraficoMemoria.setEnabled(false);
        
        jButtonPesquisa.setEnabled(false);
        jButtonVarrimento.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);

        jTextAreaFicheiro.setEnabled(true);
        String str = jTextAreaFicheiro.getSelectedText();
        int num = 0;
        jTextAreaFicheiro.setText(str);
        StringTokenizer tok = new StringTokenizer(str,"\n");
        while(tok.hasMoreTokens())
        {
            tok.nextToken();
            num++;
        }
        jTextAreaFicheiro.setPreferredSize(new Dimension(850,16 * num));
        
        jTableVarrimento.setModel(new Interface.MyTableModel(new Vector(),new Vector()));
        jTableVarrimento.setPreferredSize(new Dimension(850,250));
        jTablePesquisa.setModel(new Interface.MyTableModel(new Vector(),new Vector()));
        jTablePesquisa.setPreferredSize(new Dimension(850,250));
    }
    
    private void jMenuItemOpcoesGraficoMemoriaActionPerformed(ActionEvent evt)
    {
        Graphic g = new Graphic();
    }
    
    private void jTextAreaFicheiroKeyTyped(KeyEvent evt)
    {
        ficheiroModified = 1;
        ficheiroSaved = 0;
        
        jButtonVarrimento.setEnabled(false);
        jButtonPesquisa.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);
        jMenuItemFicheiroGuardar.setEnabled(true);
        jMenuItemFicheiroGuardarComo.setEnabled(true);
        jMenuItemOpcoesGraficoMemoria.setEnabled(false);
    }
    
    private void jTextAreaFicheiroMousePressed(MouseEvent evt)
    {
        if(jTextAreaFicheiro.isEnabled())
            if(jTextAreaFicheiro.getSelectedText() != null)
                if(SwingUtilities.isRightMouseButton(evt))
                {
                    this.jPopupMenu.show(jTextAreaFicheiro,evt.getX(),evt.getY());
                }
    }
    
    private void jButtonVarrimentoActionPerformed(ActionEvent evt)
    {
        GestorEstruturas.varrimento();
        updateTableVarrimento();
        updateTablePesquisa();
        jButtonVarrimento.setEnabled(false);
    }
    
    private void jButtonPesquisaActionPerformed(ActionEvent evt)
    {
        if(jTextFieldPesquisa.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Tem que introduzir uma palavra para a pesquisa.","Erro na pesquisa!",JOptionPane.ERROR_MESSAGE);
        else
        {
            int val = GestorEstruturas.find(jTextFieldPesquisa.getText());
            if(val == -1)
                JOptionPane.showMessageDialog(null,"Estruturas possivelmente mal construídas.","Erro no programa!",JOptionPane.ERROR_MESSAGE);
            else if(val == 0)
                JOptionPane.showMessageDialog(null,"A palavra que pesquisou não existe no ficheiro.","Palavra não existente!",JOptionPane.ERROR_MESSAGE);
            else
            {
                JOptionPane.showMessageDialog(null,"A palavra \"" + jTextFieldPesquisa.getText() + "\" tem " + val + " ocorrências no ficheiro.","Palavra encontrada!",JOptionPane.OK_OPTION);
                updateTablePesquisa();
            }
        }
    }
    
    private void jMenuItemFicheiroNovoActionPerformed(ActionEvent evt)
    {
        switch(testFicheiroSaved())
        {
            case -1:
                break;
            case 0:
                gravaFicheiro();
                break;
            case 1:
                break;
            case 2:
                return ;
        }
        
        ficheiroStarted = 1;
        ficheiroSaved = 0;
        ficheiroModified = 1;
        ficheiroOpened = 0;
        ficheiroSavedBefore = 0;
        
        estruturasModified = 0;
        estruturasOpened = 0;
        estruturasSaved = 0;
        estruturasSavedBefore = 0;
        estruturasStarted = 0;
        
        jButtonPesquisa.setEnabled(false);
        jButtonVarrimento.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);
        
        jMenuItemFicheiroFechar.setEnabled(true);
        jMenuItemFicheiroGuardar.setEnabled(true);
        jMenuItemFicheiroGuardarComo.setEnabled(true);
        
        jMenuItemEstruturasFechar.setEnabled(false);
        jMenuItemEstruturasGuardar.setEnabled(false);
        jMenuItemEstruturasGuardarComo.setEnabled(false);
        
        jMenuItemOpcoesGraficoMemoria.setEnabled(false);
        
        jTextAreaFicheiro.setEnabled(true);
        jTextAreaFicheiro.setText("");
        jTextAreaFicheiro.setPreferredSize(new Dimension(850,250));
    }
    
    public void jMenuItemFicheiroAbrirActionPerformed(ActionEvent evt)
    {
        switch(testFicheiroSaved())
        {
            case -1:
                break;
            case 0:
                gravaFicheiro();
                break;
            case 1:
                break;
            case 2:
                return ;
        }

        if(jFileChooser.showOpenDialog(null) == 0)
        {
            if(GestorFicheiros.existeFicheiroLeitura(jFileChooser.getSelectedFile().toString()))
            {
                if(GestorFicheiros.leFicheiro())
                {
                    ficheiroOpened = 1;
                    ficheiroSaved = 1;
                    ficheiroModified = 0;
                    ficheiroStarted = 0;
                    ficheiroSavedBefore = 1;
                    
                    estruturasModified = 1;
                    estruturasOpened = 0;
                    estruturasSaved = 0;
                    estruturasSavedBefore = 0;
                    estruturasStarted = 0;
                    
                    jTableVarrimento.setModel(new Interface.MyTableModel(new Vector(),new Vector()));
                    jTableVarrimento.setPreferredSize(new Dimension(850,250));
                    jTablePesquisa.setModel(new Interface.MyTableModel(new Vector(),new Vector()));
                    jTablePesquisa.setPreferredSize(new Dimension(850,250));
                    
                    jTextAreaFicheiro.setText("");
                    LinkedList lst = GestorFicheiros.getLinhasFicheiro();
                    for(ListIterator lstITR = lst.listIterator(); lstITR.hasNext(); )
                        jTextAreaFicheiro.append(lstITR.next().toString() + "\n");
                    jTextAreaFicheiro.setPreferredSize(new Dimension(850,16 * lst.size()));
                    jTextAreaFicheiro.setEnabled(true);
                    
                    jMenuItemFicheiroFechar.setEnabled(true);
                    jMenuItemFicheiroGuardar.setEnabled(false);
                    jMenuItemFicheiroGuardarComo.setEnabled(true);
                    
                    nomeFicheiroSaved = jFileChooser.getSelectedFile().toString();
                    if(GestorEstruturas.add(jFileChooser.getSelectedFile().toString()))
                    {
                        jButtonVarrimento.setEnabled(true);
                        jButtonPesquisa.setEnabled(true);
                        jTextFieldPesquisa.setEnabled(true);
                        
                        jMenuItemEstruturasGuardar.setEnabled(true);
                        jMenuItemEstruturasGuardarComo.setEnabled(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"O programa não conseguiu adicionar para as estruturas.","Erro ao adicionar para as estruturas!",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"O programa não conseguiu ler o ficheiro.","Erro na leitura do ficheiro!",JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null,"O ficheiro que tentou abrir não existe.","Ficheiro não existe!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void jMenuItemFicheiroFecharActionPerformed(ActionEvent evt)
    {
        switch(testFicheiroSaved())
        {
            case -1:
                break;
            case 0:
                gravaFicheiro();
                break;
            case 1:
                break;
            case 2:
                return ;
        }

        ficheiroOpened = 0;
        ficheiroModified = 0;
        ficheiroSaved = 0;
        ficheiroStarted = 0;
        ficheiroSavedBefore = 0;
        
        estruturasModified = 0;
        estruturasOpened = 0;
        estruturasSaved = 0;
        estruturasSavedBefore = 0;
        estruturasStarted = 0;
        
        jMenuItemFicheiroFechar.setEnabled(false);
        jMenuItemFicheiroGuardar.setEnabled(false);
        jMenuItemFicheiroGuardarComo.setEnabled(false);
        jMenuItemOpcoesGraficoMemoria.setEnabled(false);
        
        jMenuItemEstruturasFechar.setEnabled(false);
        jMenuItemEstruturasGuardar.setEnabled(false);
        jMenuItemEstruturasGuardarComo.setEnabled(false);
        
        jMenuItemOpcoesGraficoMemoria.setEnabled(false);
        
        jTextAreaFicheiro.setText("");
        jTextAreaFicheiro.setSize(new Dimension(850,250));
        jTextAreaFicheiro.setEnabled(false);

        jButtonVarrimento.setEnabled(false);
        jButtonPesquisa.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);
        
        jTableVarrimento.setModel(new Interface.MyTableModel(new Vector(),new Vector()));
        jTableVarrimento.setPreferredSize(new Dimension(850,250));
        jTablePesquisa.setModel(new Interface.MyTableModel(new Vector(),new Vector()));
        jTablePesquisa.setPreferredSize(new Dimension(850,250));
    }
    
    private void jMenuItemFicheiroGuardarActionPerformed(ActionEvent evt)
    {
        gravaFicheiro();
    }
    
    private void jMenuItemFicheiroGuardarComoActionPerformed(ActionEvent evt)
    {
        if(jFileChooser.showSaveDialog(null) == 0)
        {
            if(GestorFicheiros.existeFicheiroEscrita(jFileChooser.getSelectedFile().toString()))
            {
                LinkedList lst = new LinkedList();
                String str = jTextAreaFicheiro.getText();
                StringTokenizer tok = new StringTokenizer(str,"\n");
                while(tok.hasMoreTokens())
                    lst.add(tok.nextToken());
                if(!GestorFicheiros.escreveFicheiro(lst))
                {
                    JOptionPane.showMessageDialog(null,"O programa não conseguiu escrever o ficheiro.","Erro na escrita do ficheiro!",JOptionPane.ERROR_MESSAGE);
                    ficheiroSavedBefore = 0;
                }
                else
                {
                    nomeFicheiroSaved = jFileChooser.getSelectedFile().toString();
                    
                    jMenuItemFicheiroGuardar.setEnabled(false);
                    
                    jMenuItemEstruturasGuardar.setEnabled(true);
                    jMenuItemEstruturasGuardarComo.setEnabled(true);
                    
                    jButtonVarrimento.setEnabled(true);
                    jButtonPesquisa.setEnabled(true);
                    jTextFieldPesquisa.setEnabled(true);
                    
                    ficheiroSavedBefore = 1;
                    ficheiroSaved = 1;
                    ficheiroModified = 0;
                }
            }
            else
                JOptionPane.showMessageDialog(null,"O programa não conseguiu abrir o ficheiro para escrita.","Erro na escrita do ficheiro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jMenuItemEstruturasAbrirActionPerformed(ActionEvent evt)
    {   
        switch(testFicheiroSaved())
        {
            case -1:
                break;
            case 0:
                gravaFicheiro();
                break;
            case 1:
                break;
            case 2:
                return ;
        }
        
        switch(testEstruturasSaved())
        {
            case -1:
                break;
            case 0:
                gravaEstruturas();
                break;
            case 1:
                break;
            case 2:
                return ;
        }
        
        if(jFileChooser.showOpenDialog(null) == 0)
        {
            if(GestorEstruturas.leEstruturas(jFileChooser.getSelectedFile().toString()))
            {
                ficheiroModified = 0;
                ficheiroOpened = 0;
                ficheiroSaved = 0;
                ficheiroSavedBefore = 0;
                ficheiroStarted = 0;

                estruturasModified = 0;
                estruturasOpened = 1;
                estruturasSaved = 1;
                estruturasSavedBefore = 1;

                jMenuItemFicheiroFechar.setEnabled(false);
                jMenuItemFicheiroGuardar.setEnabled(false);
                jMenuItemFicheiroGuardarComo.setEnabled(false);

                jTextAreaFicheiro.setText("");
                jTextAreaFicheiro.setSize(new Dimension(850,250));
                jTextAreaFicheiro.setEnabled(false);

                jButtonVarrimento.setEnabled(true);
                jButtonPesquisa.setEnabled(true);
                jTextFieldPesquisa.setEnabled(true);

                jMenuItemEstruturasFechar.setEnabled(true);
                jMenuItemEstruturasGuardar.setEnabled(false);
                jMenuItemEstruturasGuardarComo.setEnabled(true);
                
                jMenuItemOpcoesGraficoMemoria.setEnabled(true);
                
                jTableVarrimento.setModel(new Interface.MyTableModel(new Vector(),new Vector()));
                jTableVarrimento.setPreferredSize(new Dimension(850,250));
                jTablePesquisa.setModel(new Interface.MyTableModel(new Vector(),new Vector()));
                jTablePesquisa.setPreferredSize(new Dimension(850,250));
            }
            else
                JOptionPane.showMessageDialog(null,"O programa não conseguiu ler as estruturas correctamente.","Erro na leitura das estruturas!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void jMenuItemEstruturasFecharActionPerformed(ActionEvent evt)
    {
        switch(testEstruturasSaved())
        {
            case -1:
                break;
            case 0:
                gravaEstruturas();
                break;
            case 1:
                break;
            case 2:
                return ;
        }
        
        estruturasModified = 0;
        estruturasOpened = 0;
        estruturasSaved = 0;
        estruturasSavedBefore = 0;
        
        jButtonVarrimento.setEnabled(false);
        jButtonPesquisa.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);

        jMenuItemEstruturasFechar.setEnabled(false);
        jMenuItemEstruturasGuardar.setEnabled(false);
        jMenuItemEstruturasGuardarComo.setEnabled(false);

        jMenuItemOpcoesGraficoMemoria.setEnabled(false);

        jTableVarrimento.setModel(new Interface.MyTableModel(new Vector(),new Vector()));
        jTableVarrimento.setPreferredSize(new Dimension(850,250));
        jTablePesquisa.setModel(new Interface.MyTableModel(new Vector(),new Vector()));
        jTablePesquisa.setPreferredSize(new Dimension(850,250));
    }
    
    private void jMenuItemEstruturasGuardarActionPerformed(ActionEvent evt)
    {
        gravaEstruturas();
    }
    
    private void jMenuItemEstruturasGuardarComoActionPerformed(ActionEvent evt)
    {
        if(jFileChooser.showSaveDialog(null) == 0)
        {
            if(GestorEstruturas.gravaEstruturas(jFileChooser.getSelectedFile().toString()))
            {
                estruturasSaved = 1;
                estruturasModified = 0;
                estruturasSavedBefore = 1;
                
                jMenuItemEstruturasGuardar.setEnabled(false);
                
                jMenuItemOpcoesGraficoMemoria.setEnabled(true);
                
                jButtonVarrimento.setEnabled(true);
                jButtonPesquisa.setEnabled(true);
                jTextFieldPesquisa.setEnabled(true);
            }
            else
                JOptionPane.showMessageDialog(null,"O programa não conseguiu abrir o ficheiro para escrita.","Erro na escrita das estruturas!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int testFicheiroSaved()
    {
        int aux = 0;
        
        if(ficheiroSaved == 0)
        {
            if(ficheiroModified != 0)
            {
                switch(JOptionPane.showConfirmDialog(null,"O ficheiro em que está a trabalhar não foi guardado.\nDeseja guardar?","Guardar ficheiro?",JOptionPane.YES_NO_CANCEL_OPTION))
                {
                    case 0:
                        aux = 0;
                        break;
                    case 1:
                        aux = 1;
                        break;
                    case 2:
                        aux = 2;
                        break;
                }
            }
            else
                aux = -1;
        }
        else
            aux = -1;
        
        return aux;
    }
    
    private int testEstruturasSaved()
    {
        int aux = 0;
        
        if(estruturasSaved == 0)
        {
            if(estruturasModified != 0)
            {
                switch(JOptionPane.showConfirmDialog(null,"As estruturas em que está a trabalhar não foram guardadas.\nDeseja guardar?","Guardar estruturas?",JOptionPane.YES_NO_CANCEL_OPTION))
                {
                    case 0:
                        aux = 0;
                        break;
                    case 1:
                        aux = 1;
                        break;
                    case 2:
                        aux = 2;
                        break;
                }
            }
            else
                aux = -1;
        }
        else
            aux = -1;
        
        return aux;
    }
    
    private void gravaFicheiro()
    {
        if(ficheiroSavedBefore == 0)
        {
            jFileChooser.showSaveDialog(null);
            nomeFicheiroSaved = jFileChooser.getSelectedFile().toString();
            if(nomeFicheiroSaved != null)
            {
                ficheiroSavedBefore = 1;
                gravaFicheiro();
            }
            else
                JOptionPane.showMessageDialog(null,"O nome que introduziu para o ficheiro não é válido.","Erro na escrita do ficheiro!",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if(GestorFicheiros.existeFicheiroEscrita(nomeFicheiroSaved))
            {
                LinkedList lst = new LinkedList();
                String str = jTextAreaFicheiro.getText();
                StringTokenizer tok = new StringTokenizer(str,"\n");
                while(tok.hasMoreTokens())
                    lst.add(tok.nextToken());
                if(!GestorFicheiros.escreveFicheiro(lst))
                {
                    JOptionPane.showMessageDialog(null,"O programa não conseguiu escrever o ficheiro.","Erro na escrita do ficheiro!",JOptionPane.ERROR_MESSAGE);
                    ficheiroSavedBefore = 0;
                }
                else
                {
                    ficheiroSavedBefore = 1;
                    ficheiroSaved = 1;
                    ficheiroModified = 0;
                    
                    if(GestorEstruturas.add(nomeFicheiroSaved))
                    {
                        jButtonVarrimento.setEnabled(true);
                        jButtonPesquisa.setEnabled(true);
                        jTextFieldPesquisa.setEnabled(true);
                        
                        jMenuItemFicheiroGuardar.setEnabled(false);
                        
                        jMenuItemEstruturasGuardar.setEnabled(true);
                        jMenuItemEstruturasGuardarComo.setEnabled(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"O programa não conseguiu adicionar para as estruturas.","Erro ao adicionar para as estruturas!",JOptionPane.ERROR_MESSAGE);
                }
            }
            else
                JOptionPane.showMessageDialog(null,"O programa não abrir o ficheiro para escrita.","Erro na escrita do ficheiro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void gravaEstruturas()
    {
        if(estruturasSavedBefore == 0)
        {
            jFileChooser.showSaveDialog(null);
            nomeEstruturasSaved = jFileChooser.getSelectedFile().toString();
            if(nomeEstruturasSaved != null)
            {
                estruturasSavedBefore = 1;
                gravaEstruturas();
            }
            else
                JOptionPane.showMessageDialog(null,"O nome que introduziu para o ficheiro não é válido.","Erro na escrita das estruturas!",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if(GestorEstruturas.gravaEstruturas(nomeEstruturasSaved))
            {
                estruturasSaved = 1;
                estruturasSavedBefore = 1;
                estruturasModified = 0;
                
                jMenuItemEstruturasGuardar.setEnabled(false);
        
                jMenuItemOpcoesGraficoMemoria.setEnabled(true);

                jButtonVarrimento.setEnabled(true);
                jButtonPesquisa.setEnabled(true);
                jTextFieldPesquisa.setEnabled(true);
            }
            else
                JOptionPane.showMessageDialog(null,"O programa não abrir o ficheiro para escrita.","Erro na escrita das estruturas!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateTableVarrimento()
    {
        Vector colsVarrimento = new Vector();
        Vector rowsVarrimento = new Vector();

        colsVarrimento.add("Palavra");
        colsVarrimento.add("Ocorrencias");
        
        LinkedList l = GestorEstruturas.getVarrimento();
        for(ListIterator lstITR = l.listIterator(); lstITR.hasNext(); )
        {
            String aux = lstITR.next().toString();
            StringTokenizer tok = new StringTokenizer(aux," - ");
            Vector v = new Vector();
            v.add(tok.nextToken());
            v.add(tok.nextToken());
            rowsVarrimento.add(v);
        }
        
        jTableVarrimento.setPreferredSize(new Dimension(850,16 * rowsVarrimento.size()));
        
        Interface.MyTableModel myModel = new Interface.MyTableModel(rowsVarrimento,colsVarrimento);
        jTableVarrimento.setModel(myModel);
        
        TableColumn column;
        
        column = jTableVarrimento.getColumnModel().getColumn(0);
        column.setPreferredWidth(600);
        
        column = jTableVarrimento.getColumnModel().getColumn(1);
        column.setPreferredWidth(250);
    }
    
    private void updateTablePesquisa()
    {
        Vector colsPesquisa = new Vector();
        Vector rowsPesquisa = new Vector();
        
        colsPesquisa.add("Operação");
        colsPesquisa.add("Estrutura");
        colsPesquisa.add("Tempo (ms)");
        
        String tempos[] = GestorEstruturas.getTempos();
        for(int i = 0; i < tempos.length; i++)
        {
            Vector v = new Vector();
            if(i == 0 || i == 1)
                v.add("Adicionar");
            else if(i == 2 || i == 3)
                v.add("Pesquisar");
            else if(i == 4 || i == 5)
                v.add("Varrimento");
            else
                v.add("Tempo médio de inserção");
            if(i == 0 || i == 2 || i == 4 || i == 6)
                v.add("Binary Tree");
            else
                v.add("Hash Table");
            v.add(tempos[i]);
            rowsPesquisa.add(v);
        }
        
        jTablePesquisa.setPreferredSize(new Dimension(850,16 * rowsPesquisa.size()));
        
        Interface.MyTableModel myModel1 = new Interface.MyTableModel(rowsPesquisa,colsPesquisa);
        jTablePesquisa.setModel(myModel1);
        
        TableColumn column;
        
        column = jTablePesquisa.getColumnModel().getColumn(0);
        column.setPreferredWidth(300);
        
        column = jTablePesquisa.getColumnModel().getColumn(1);
        column.setPreferredWidth(300);
        
        column = jTablePesquisa.getColumnModel().getColumn(2);
        column.setPreferredWidth(250);
    }
    
    private void exitForm(WindowEvent evt)
    {
        System.exit(0);
    }
    
    public static void main(String args[])
    {
        new Interface().show();
    }
    
    /*--------------------------------------
    Variáveis da classe
    --------------------------------------*/
    
    //JMenuBar
    private JMenuBar jMenuBar = new JMenuBar();
        private JMenu jMenuFicheiro = new JMenu();
            private JMenuItem jMenuItemFicheiroNovo = new JMenuItem();
            private JMenuItem jMenuItemFicheiroAbrir = new JMenuItem();
            private JMenuItem jMenuItemFicheiroFechar = new JMenuItem();
            private JSeparator jSeparatorFicheiro1 = new JSeparator();
            private JMenuItem jMenuItemFicheiroGuardar = new JMenuItem();
            private JMenuItem jMenuItemFicheiroGuardarComo = new JMenuItem();
            private JSeparator jSeparatorFicheiro2 = new JSeparator();
            private JMenuItem jMenuItemFicheiroSair = new JMenuItem();
        private JMenu jMenuEstruturas = new JMenu();
            private JMenuItem jMenuItemEstruturasAbrir = new JMenuItem();
            private JMenuItem jMenuItemEstruturasFechar = new JMenuItem();
            private JSeparator jSeparatorEstruturas1 = new JSeparator();
            private JMenuItem jMenuItemEstruturasGuardar = new JMenuItem();
            private JMenuItem jMenuItemEstruturasGuardarComo = new JMenuItem();
        private JMenu jMenuOpcoes = new JMenu();
            private JMenuItem jMenuItemOpcoesGraficoMemoria = new JMenuItem();
        private JMenu jMenuAjuda = new JMenu();
        
    //Painel das ferramentas
    private JPanel jPanelFerramentas = new JPanel();
        private JButton jButtonVarrimento = new JButton();
        private JButton jButtonPesquisa = new JButton();
        private JTextField jTextFieldPesquisa = new JTextField();
    
    //Painel do ficheiro e das tabelas
    private JPanel jPanelOutput = new JPanel();
        private JTextArea jTextAreaFicheiro =  new JTextArea();
        private JScrollPane jScrollPaneFicheiro;
        private JLabel jLabelSeparator1 = new JLabel();
        private JTable jTableVarrimento = new JTable();
        private JScrollPane jScrollPaneTableVarrimento;
        private JLabel jLabelSeparator2 = new JLabel();
        private JTable jTablePesquisa = new JTable();
        private JScrollPane jScrollPaneTablePesquisa;
    
    //Paineis separadores do inicio ou fim da frame
    private JPanel jPanelInicioHorizontal = new JPanel();
    private JPanel jPanelFimHorizontal = new JPanel();
    private JPanel jPanelFimVertical = new JPanel();
        
    //Diversas
    private JFileChooser jFileChooser = new JFileChooser();
    
    private JPopupMenu jPopupMenu = new JPopupMenu();
        private JMenuItem jMenuItemPopupMenuUsarTextoSeleccionado = new JMenuItem();
    
    private int ficheiroStarted = 0;
    private int estruturasStarted = 0;
    private int ficheiroSaved = 0;
    private int estruturasSaved = 0;
    private int ficheiroSavedBefore = 0;
    private int estruturasSavedBefore = 0;
    private String nomeFicheiroSaved;
    private String nomeEstruturasSaved;
    private int ficheiroOpened = 0;
    private int estruturasOpened = 0;
    private int ficheiroModified = 0;
    private int estruturasModified = 0;
    
    private class MyTableModel extends AbstractTableModel
    {
        private Vector data;
        private Vector colNames;
        
        public MyTableModel(Vector data, Vector colNames)
        {
            this.data = data;
            this.colNames = colNames;
        }
        
        public String getColumnName(int col)
        {
            return colNames.get(col).toString();
        }

        public int getRowCount()
        {
            return data.size();
        }

        public int getColumnCount()
        {
            return colNames.size();
        }

        public Object getValueAt(int row, int col)
        {
            Vector aux = (Vector) data.get(row);
            return aux.get(col);
        }

        public boolean isCellEditable(int row, int col)
        {
            return true;
        }

        public void setValueAt(Object value, int row, int col)
        {
            Vector aux = (Vector) data.get(row);
            aux.set(col,value);
            fireTableCellUpdated(row,col);
        }
    }
}