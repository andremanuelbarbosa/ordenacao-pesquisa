package OrdenacaoPesquisa;

import java.io.Serializable;
import java.util.Stack;
import java.util.Vector;
import java.util.EmptyStackException;

public class BinaryTree implements Serializable
{
    public Node root;
    
    public Vector dados = new Vector();
    public Vector tempo = new Vector();
    
    private long inicialTime;
    private int numDados;
    
    private boolean flag;
    
    public BinaryTree()
    {
        root = null;
        flag = false;
    }
    
    public void add(Comparable obj)
    {
        if(!flag)
        {
            inicialTime = System.currentTimeMillis();
            flag = true;
            numDados = 0;
        }
        
        if(root == null)
            root = new Node(obj);
        else 
            add(root,obj);
    }
    
    private void add(Node node,Comparable obj)
    {
        int val = node.obj.compareTo(obj);

        if(val == 0)
        {
            node.occur++;
            numDados++;
            dados.add(new Integer(numDados));
            tempo.add(new Integer((int) (System.currentTimeMillis() - inicialTime)));
        }
        else if(val > 0)
        {
            if(node.left == null)
            {
                node.left = new Node(obj);
                numDados++;
                dados.add(new Integer(numDados));
                tempo.add(new Integer((int) (System.currentTimeMillis() - inicialTime)));
            }
            else
                add(node.left,obj);
        }
        else
        {
            if(node.right == null)
            {
                node.right = new Node(obj);
                numDados++;
                dados.add(new Integer(numDados));
                tempo.add(new Integer((int) (System.currentTimeMillis() - inicialTime)));
            }
            else
                add(node.right,obj);
        }
    }
    
    public int find(Comparable obj)
    {
        if(root == null) 
            return 0;
        else
            return find(root,obj);
    }
    
    private int find(Node node,Comparable obj)
    {
        int val = node.obj.compareTo(obj);
        
        if(val == 0)
            return node.occur;
        else if(val > 0)
        {
            if(node.left == null) 
                return 0;
            else
                return find(node.left,obj);
        }
        else 
        {
            if(node.right == null) 
                return 0;
            else
                return find(node.right,obj);
        }
    }

    public void clear()
    {
        root = null;
        flag = false;
        dados.clear();
        tempo.clear();
    }
    
    public class Node implements Serializable
    {
        public Comparable obj;
        public Node left;
        public Node right;
        public int occur;
        
        public Node(Comparable obj)
        {
            this.obj = obj;
            this.left = null;
            this.right = null;
            this.occur = 1;
        }
        
        public String toString()
        {
            return this.obj.toString() + " - " + this.occur;
        }
    }
}