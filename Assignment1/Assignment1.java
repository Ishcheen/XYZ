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
        String url="https://docs.oracle.com/javase/6/docs/api/java/util/regex/package-summary.html";
        Download.DownloadWebPage(url);
    }
    
}


/**
 * Read and download web page content from given URLs to a html file.
 * @param url an URL object corresponding to the address of the web page 
 * @param sc a scanner class object to read content of web page using openStream()
 * @param sb an empty string buffer object to append the content of web page in html format
 * @param result a string object in which string buffer sb will be converted and html tags are removed using replaceAll(regex, "")
 * @param writer a buffered writer object to write the result in a text file
 * @return text content at particular web page corresponding to the given URL. Save it in Content.txt in a form of a string
 */
class Download{
    public static void DownloadWebPage(String link){
        try{
            URL url=new URL(link);
            Scanner sc=new Scanner(url.openStream());
            StringBuffer sb=new StringBuffer();
            while(sc.hasNext()){
                sb.append(sc.next());
            }
            String result=sb.toString();
            result=result.replaceAll("\\<.*?\\>","");
            BufferedWriter writer= new BufferedWriter(new FileWriter("Content.txt"));
            writer.write(result);
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

