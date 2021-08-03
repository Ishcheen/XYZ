/*
 * Classname: Assigment1.java
 */
import java.util.*;
import java.net.*;
import java.io.*;


public class Assignment1{
    public static void main(String[] args)
    {
        ReadAFile.readUrls();
        ReadAFile.readWords();
    }
    
}


class ReadAFile{
    /**
     * readUrls method-
     * For each url present in urls.txt, it calculates the count for first three words 
     * present in words.txt and display it in Output1.txt.
     */
    public static void readUrls(){
        try{
            File urlsFile= new File("./urls.txt");
            FileReader fileReader=new FileReader(urlsFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            BufferedWriter writer= new BufferedWriter(new FileWriter("Output1.txt"));
            while((line=reader.readLine())!=null){
                downloadWebPage(line);
                writer.write(line);
                writer.write("\n");
               
                File wordFile=new File("words.txt");
                FileReader fileRdr=new FileReader(wordFile);
                BufferedReader rdr=new BufferedReader(fileRdr);
                String word;
                int n=0;
                while((word=rdr.readLine())!=null && n<3){
                    n++;
                    int count=matchCount(word);
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
    /**
     * readWords method-
     * For each word present in words.txt, it calculates its total occurence in websites corresponding to all links of urls.txt file.
     * The total count is written in Output2.txt file in the format 'word-count'
     */
    public static void readWords(){
        try{
            File wordFile=new File("./words.txt");
            FileReader fileRdr=new FileReader(wordFile);
            BufferedReader rdr=new BufferedReader(fileRdr);
            String word;
            while((word=rdr.readLine())!=null){
                int count=0;
                File urlsFile= new File("./urls.txt");
                FileReader fileReader=new FileReader(urlsFile);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                BufferedWriter writer= new BufferedWriter(new FileWriter("Output2.txt",true));
                while((line=reader.readLine())!=null){
                    downloadWebPage(line);
                    count+=matchCount(word);
                }
                writer.write(word+"-"+count);
                writer.write("\n");
                writer.close();
            }
        }
        catch ( IOException ioerror){
            System.out.println("IO Exception raised");
        }
        
    }
    /**
     * matchCount method-
     * It takes a word as argument and count its occurence in Content.txt file
     * @param index -Index of occurence of word in Content.txt file
     * @param count- Total count of occurence of given word in Content.txt file
     */
    public static int matchCount(String word){
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
    
    /**
     * downloadWebPage method-
     * It takes an url as an argument and store the html document corresponding to the url in String Buffer sb.
     * Text content visible on the website is extracted from html doc and is written in Content.txt file.
     * @param url -URL type object of the required website link.
     * @param sb- String Buffer to store the website content
     * @param result- Data is stored in the String format in result from sb to be written in the file Content.txt  
     */
    public static void downloadWebPage(String link){
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


