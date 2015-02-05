package OrdenacaoPesquisa;

import java.util.Vector;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public abstract class GestorEstruturas implements Serializable
{   
    private static BinaryTree binaryTree = new BinaryTree();
    private static HashTable hashTable = new HashTable();
    
    public static Vector addBinaryTreeDados;
    public static Vector addHashTableDados;
    public static Vector addBinaryTreeTimes;
    public static Vector addHashTableTimes;
    
    private static long tempoAddBinaryTree = 0;
    private static long tempoAddHashTable = 0;
    private static long tempoFindBinaryTree = 0;
    private static long tempoFindHashTable = 0;
    private static long tempoVarrimentoBinaryTree = 0;
    private static long tempoVarrimentoHashTable = 0;
    private static float tempoMedioInsercaoBinaryTree = 0;
    private static float tempoMedioInsercaoHashTable = 0;

    private static LinkedList aux = new LinkedList();
    private static int tamanho = 0;
    
    public static boolean add(String ficheiro)
    {
        binaryTree.clear();
        hashTable.clear();
        
        tamanho = 0;
        
        LinkedList lst;
        int num = 0;
        long tempoInicial, tempoFinal;
        
        if(GestorFicheiros.existeFicheiroLeitura(ficheiro))
        {
            if(GestorFicheiros.leFicheiro())
                lst = GestorFicheiros.getLinhasFicheiro();
            else
                return false;
        }
        else
            return false;
        
        tempoInicial = System.currentTimeMillis();
        for(ListIterator listITR = lst.listIterator(); listITR.hasNext(); )
        {
            String str = listITR.next().toString();
            StringTokenizer strTok = new StringTokenizer(str," \\|!\"#$%&/()=?'«»+*´`~,;.:-_<>’[]");
            while(strTok.hasMoreTokens())
            {
                num++;
                binaryTree.add(strTok.nextToken());
            }
        }
        tempoFinal = System.currentTimeMillis();
        
        addBinaryTreeDados = binaryTree.dados;
        addBinaryTreeTimes = binaryTree.tempo;
        
        tempoAddBinaryTree = tempoFinal - tempoInicial;
        tempoMedioInsercaoBinaryTree = (float) tempoAddBinaryTree / (float) num;

        num = 0;
        
        tempoInicial = System.currentTimeMillis();
        for(ListIterator listITR = lst.listIterator(); listITR.hasNext(); )
        {
            String str = listITR.next().toString();
            StringTokenizer strTok = new StringTokenizer(str," \\|!\"#$%&/()=?'«»+*´`~,;.:-_<>’[]");
            while(strTok.hasMoreTokens())
            {
                num++;
                hashTable.add(strTok.nextToken());
            }
        }
        tempoFinal = System.currentTimeMillis();
        
        addHashTableDados = hashTable.dados;
        addHashTableTimes = hashTable.tempo;
        
        tempoAddHashTable = tempoFinal - tempoInicial;
        tempoMedioInsercaoHashTable = (float) tempoAddHashTable / (float) num;
        
        return true;
    }

    public static int find(Comparable obj)
    {
        int occurBinaryTree, occurHashTable;
        long tempoInicial, tempoFinal;
        
        tempoInicial = System.currentTimeMillis();
        occurBinaryTree = binaryTree.find(obj);
        tempoFinal = System.currentTimeMillis();
        tempoFindBinaryTree = tempoFinal - tempoInicial;
        
        tempoInicial = System.currentTimeMillis();
        occurHashTable = hashTable.find(obj);
        tempoFinal = System.currentTimeMillis();
        tempoFindHashTable = tempoFinal - tempoInicial;
        
        return occurBinaryTree != occurBinaryTree ? -1 : occurBinaryTree;
    }

    public static void varrimento()
    {
        long tempoInicial, tempoFinal;
        
        tamanho = 0;
        
        aux.clear();
        
        tempoInicial = System.currentTimeMillis();
        postOrder(binaryTree.root);
        tempoFinal = System.currentTimeMillis();
        tempoVarrimentoBinaryTree = tempoFinal - tempoInicial;
        
        aux.clear();
        
        tempoInicial =  System.currentTimeMillis();
        varreHashTable();
        tempoFinal = System.currentTimeMillis();
        tempoVarrimentoHashTable = tempoFinal - tempoInicial;
        
        aux.clear();
        
        putDecreaseOrder();
    }

    private static void postOrder(BinaryTree.Node node)
    {
        if(node != null)
        {
            tamanho++;
            aux.add(node.toString());
            postOrder(node.left);
            postOrder(node.right);
        }
    }
    
    private static void varreHashTable()
    {
        HashTable.HashEntry[] array1 = new HashTable.HashEntry[tamanho];
        HashTable.HashEntry[] array = hashTable.getTable();
        
        int cont = 0;
        
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] != null)
            {
                array1[cont] = array[i];
                cont++;
            }
        }

        for(int i = 0; i < array1.length; i++)
        {
            aux.add(array1[i].toString());
        }
    }
    
    private static void putDecreaseOrder()
    {
        HashTable.HashEntry[] array1 = new HashTable.HashEntry[tamanho];
        HashTable.HashEntry[] array = hashTable.getTable();
        
        int cont = 0;
        
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] != null)
            {
                array1[cont] = array[i];
                cont++;
            }
        }
    
        int num = 0;
        for(int i = array1.length - 1; i >= 0; i--)
        {
            for(int j = array1.length - 1; j > num; j--)
            {
                if(array1[j].occur > array1[j - 1].occur)
                {
                    HashTable.HashEntry auxHashEntry = array1[j];
                    array1[j] = array1[j - 1];
                    array1[j - 1] = auxHashEntry;
                }
            }
            num++;
        }
        
        for(int i = 0; i < array1.length; i++)
        {
            aux.add(array1[i].toString());
        }
    }
    
    public static boolean guardarVarrimento(String ficheiro)
    {
        if(GestorFicheiros.existeFicheiroEscrita(ficheiro))
        {
            if(GestorFicheiros.escreveFicheiro(aux))
                return true;
            else
                return false;
        }
        else
            return false;
    }
    
    public static LinkedList getVarrimento()
    {
        return aux;
    }
    
    public static boolean gravaEstruturas(String path)
    {
        ObjectOutputStream objectOuput;
        
        try
        {
            objectOuput = new ObjectOutputStream(new FileOutputStream(path));
            objectOuput.writeObject(binaryTree);
            objectOuput.writeObject(hashTable);
            objectOuput.close();
            
            return true;
        }
        catch(IOException e)
        {
            return false;
        }
    }

    public static boolean leEstruturas(String path)
    {
        ObjectInputStream objectInput;
        
        try
        {
            objectInput = new ObjectInputStream(new FileInputStream(path));
            binaryTree.clear();
            hashTable.clear();
            binaryTree = (BinaryTree) objectInput.readObject();
            hashTable = (HashTable) objectInput.readObject();
            objectInput.close();
            
            addBinaryTreeDados = binaryTree.dados;
            addBinaryTreeTimes = binaryTree.tempo;           
            addHashTableDados = hashTable.dados;
            addHashTableTimes = hashTable.tempo;

            clearTempos();
            
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public static void clearTempos()
    {
        tempoMedioInsercaoBinaryTree = 0;
        tempoMedioInsercaoHashTable = 0;
        tempoAddBinaryTree = 0;
        tempoAddHashTable = 0;
        tempoFindBinaryTree = 0;
        tempoFindHashTable = 0;
        tempoVarrimentoBinaryTree = 0;
        tempoVarrimentoHashTable = 0;
    }
    
    public static String [] getTempos()
    {
        String [] tempos = {"","","","","","","",""};
        
        tempos[0] = Float.toString((float) tempoAddBinaryTree);
        tempos[1] = Float.toString((float) tempoAddHashTable);
        tempos[2] = Float.toString((float) tempoFindBinaryTree);
        tempos[3] = Float.toString((float) tempoFindHashTable);
        tempos[4] = Float.toString((float) tempoVarrimentoBinaryTree);
        tempos[5] = Float.toString((float) tempoVarrimentoHashTable);
        tempos[6] = Float.toString(tempoMedioInsercaoBinaryTree);
        tempos[7] = Float.toString(tempoMedioInsercaoHashTable);
        
        return tempos;
    }
}