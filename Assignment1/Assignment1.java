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
        ReadAFile.ReadUrls();
    }
    
}


class ReadAFile{
    
    public static void ReadUrls(){
        try{
            File urlsFile= new File("./urls.txt");
            FileReader fileReader=new FileReader(urlsFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            BufferedWriter writer= new BufferedWriter(new FileWriter("Output1.txt"));
            while((line=reader.readLine())!=null){
                DownloadWebPage(line);
                writer.write(line);
                writer.write("\n");
                /**To read a word from words.txt */
                File wordFile=new File("words.txt");
                FileReader fileRdr=new FileReader(wordFile);
                BufferedReader rdr=new BufferedReader(fileRdr);
                String word;
                int n=0;
                while((word=rdr.readLine())!=null && n<3){
                    n++;
                    int count=MatchCount(word);
                    writer.write(word+"-"+count);
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch ( IOException ioerror){
            System.out.println("IO Exception raised");
        }
    }

    public static int MatchCount(String word){
        if(word==null){
            return 0;
        }
        int index=0;
        int count=0;
        try{
            File content= new File("Content.txt");
            FileReader fileReader=new FileReader(content);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while((line=reader.readLine())!=null){
               while(true){
                    index=line.indexOf(word, index);
                    if(index!=-1){
                        count++;
                        index+=word.length();
                    }else{
                        break;
                    }
               }
            }
        }
        catch ( IOException ioerror){
            System.out.println("IO Exception raised");
        }
         
        return count;
    }

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


