/*
 * Classname: Assigment1.java
 */
import java.util.*;
import java.net.*;
import java.io.*;
/**
 * 
 */
public class Assignment1{
    public static void main(String[] args)
    {
        
    }
    
}
/**
 * Read and download web page content from given URLs to a html file.
 * @param url an URL object corresponding to the address of the web page 
 * @param reader a buffered reader to read the input stream from URL
 * @param writer connect the buffered writer stream to file object where web content will be downloaded
 * @param line string type variable to read lines from web page
 * @return content at particular web page corresponding to the given URL
 */
class Download{
    public static void DownloadWebPage(String link){
        try{
            URL url=new URL(link);
            BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer= new BufferedWriter(new FileWriter("Download.html"));
            String line;
            while((line=reader.readLine())!=null){
                writer.write(line);
            }
            reader.close();
            writer.close();
        }
        catch ( MalformedURLException merror){
            System.out.println("Malformed URL Exception");
        }
        catch ( IOException ioerror){
            System.out.println("IO Exception raised");
        }
    }
}