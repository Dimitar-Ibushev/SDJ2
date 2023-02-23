package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadBible
{
   public static void main(String[] args) throws IOException
   {
      String[] bible = loadFile("./src/bible.txt");
      System.out.println("Bible loaded...");
      String[] dictionary = loadFile("./src/dictionary.txt");
      System.out.println("Dictionary loaded...");
   }
   
   public static boolean isInASortedArray(String word, String[] words)
   {
      return isInASortedArray(word, words, 0, words.length - 1);
   }
   
   private static boolean isInASortedArray(String word, String[] words, int start, int end)
   {
      if (start > end)
      {
         return false;
      }
      int middle = (start + end) / 2;
      int compare = word.compareTo(words[middle]);
      if (compare == 0)
      {
         return true;
      }
      if (compare < 0)
      {
         end = middle - 1;
      }
      else
      {
         start = middle + 1;
      }
      return isInASortedArray(word, words, start, end);
   }
   public static String[] loadFile(String filename)
    {
      ArrayList<String> words = new ArrayList<>();
      File file = new File(filename);
      Scanner in = null;
      try
      {
         in = new Scanner(file);
         while (in.hasNext())
         {
            String token = in.next();
            if (!token.matches(".*\\d+.*"))
            {
               Pattern p = Pattern.compile("[^a-z0-9 ]",
                     Pattern.CASE_INSENSITIVE);
               Matcher m = p.matcher(token);
               if (m.find())
               {
                  token = token.replaceAll("[^\\w\\s]", "");
               }
               words.add(token.toLowerCase());
            }
         }
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      in.close();
      String[] all = new String[words.size()];
      return words.toArray(all);
    }
}