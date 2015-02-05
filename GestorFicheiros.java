package OrdenacaoPesquisa;

import java.io.*;
import java.util.*;

/** Classe que gere os ficheiros
 */
public abstract class GestorFicheiros 
{
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static LinkedList linhasFicheiro = new LinkedList();
    
    /** Verifica se existe o ficheiro
     * @param nome Nome do ficheiro
     * @return Verdadeiro se o ficheiro existe, falso se não existe
     */    
    public static boolean existeFicheiroLeitura(String nome)
    {
        try
        {
            bufferedReader = new BufferedReader(new FileReader(nome));
            return true;
        }
        catch(FileNotFoundException e)
        {
            return false;
        }
    }
    
    public static boolean existeFicheiroEscrita(String nome)
    {
        try
        {
            bufferedWriter = new BufferedWriter(new FileWriter(nome));
            return true;
        }
        catch(IOException e)
        {
            return false;
        }
    }
    
    /** Le o ficheiro
     * @return Verdadeiro se consegue ler o ficheiro, falso se não consegue
     */    
    public static boolean leFicheiro()
    {
        try
        {
            linhasFicheiro.clear();
            String linha = bufferedReader.readLine();
            while (linha != null)
            {
                linhasFicheiro.add (linha);
                linha = bufferedReader.readLine();   
            }
            try
            {
                bufferedReader.close();
                return true;
            }
            catch(IOException e)
            {
                return false;
            }
        }
        catch(IOException e)
        {
            return false;
        }
    }
    
    public static boolean escreveFicheiro(LinkedList linhas)
    {
        try
        {
            for(int i = 0; i < linhas.size(); i++)
            {
                bufferedWriter.write(linhas.get(i).toString() + "\n");
            }
            try
            {
                bufferedWriter.close();
                return true;
            }
            catch(IOException e)
            {
                return false;
            }
        }
        catch(IOException e)
        {
            return false;
        }
    }
    
    /** Retorna as linhas do ficheiro
     * @return Linhas do ficheiro
     */    
    public static LinkedList getLinhasFicheiro()
    {
        return linhasFicheiro;
    }
}