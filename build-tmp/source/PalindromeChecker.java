import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}
public boolean palindrome(String word)
{
  String letter = noTags(word);
  letter = letter.toLowerCase();
  int last = letter.length() -1;
  for(int c = 0; c < letter.length(); c++)
  {
    if(letter.charAt(c) != letter.charAt(last))
    {
      return false;
    }
    last--;
  }
  return true;
}
public String noTags(String word)
{
  String letter = new String();
  for(int g = 0; g < word.length(); g++)
  {
    if(Character.isLetter(word.charAt(g)) == true)
    {
      letter = letter + (word.charAt(g));
    }
  }
  return letter;
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
