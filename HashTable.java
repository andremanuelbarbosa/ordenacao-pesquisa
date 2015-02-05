package OrdenacaoPesquisa;

import java.io.Serializable;
import java.util.Vector;

public class HashTable implements Serializable
{  
    private static final int DEFAULT_TABLE_SIZE = 100001;
    public int currentSize = 0;
    public int occupied = 0;
    public int modCount = 0;
    private HashEntry[] array;
    
    int aux = 0;
    
    public Vector dados = new Vector();
    public Vector tempo  = new Vector();
    
    private long inicialTime;
    private int numDados;
    
    public HashTable()
    {
        this.array = new HashEntry[DEFAULT_TABLE_SIZE];
        this.clear();
    }
    
    public HashEntry[] getTable()
    {
        return this.array;
    }

    public int find(Comparable obj)
    {
        for(int i = 0; i < DEFAULT_TABLE_SIZE; i++)
        {
            if(array[i] != null)
                if(array[i].obj.equals(obj))
                    return array[i].occur;
        }
        return 0;
    }
    
    private static boolean isActive(HashEntry[] arr,int pos)
    {
        return arr[pos] != null && arr[pos].isActive;
    }
    
    public boolean add(Comparable obj)
    {
        if(aux == 0)
        {
            numDados = 0;
            inicialTime = System.currentTimeMillis();
            aux = 1;
        }
        
        int pos = findPos(obj);
        
        if(isActive(array,pos))
        {
            if(obj.equals(array[pos].obj))
                array[pos].occur++;
            else
                return false;
        }
        else
            array[pos] = new HashEntry(obj);
        
        currentSize++;
        occupied++;
        modCount++;
        
        if(occupied > array.length / 2)
            rehash();

        numDados++;
        dados.add(new Integer(numDados));
        tempo.add(new Integer((int) (System.currentTimeMillis() - inicialTime)));
        
        return true;
    }
    
    private void rehash()
    {
        HashEntry[] oldArray = array;
        
        oldArray = new HashEntry[nextPrime(4 * currentSize)];
        currentSize = 0;
        occupied = 0;
        
        for(int i = 0; i < oldArray.length; i++)
            if(isActive(oldArray,i))
                add(oldArray[i].obj);
    }
    
    private int findPos(Comparable obj)
    {
        int col = 0;
        int pos = (obj == null) ? 0 : Math.abs(obj.hashCode() % array.length);
        
        while(array[pos] != null)
        {
            if(obj == null)
            {
                if(array[pos].obj == null)
                    break;
            }
            else if(obj.equals(array[pos].obj))
                break;
            pos += 2 * ++col - 1;
            if(pos >= array.length)
                pos -= array.length;
        }
        return pos;
    }
    
    public void clear()
    {
        aux = 0;
        for(int i = 0; i < array.length; i++)
            array[i] = null;
        dados.clear();
        tempo.clear();
    }
    
    private static int nextPrime(int n)
    {
        if(n % 2 == 0)
            n++;
        
        for(; !isPrime(n); n += 2)
            ;
        
        return n;
    }
    
    private static boolean isPrime(int n)
    {
        if(n == 2 || n == 3)
            return true;
        
        if(n == 1 || n % 2 == 0)
            return false;
        
        for(int i = 3; i * i <= n; i += 2)
            if(n % i == 0)
                return false;
        
        return true;
    }
    
    public class HashEntry implements Serializable
    {
        public Comparable obj;
        public boolean isActive;
        public int occur;
        
        public HashEntry(Comparable obj)
        {
            this.obj = obj;
            this.isActive = true;
            this.occur = 1;
        }
        
        public String toString()
        {
            return this.obj.toString() + " - " + this.occur;
        }
    }
}