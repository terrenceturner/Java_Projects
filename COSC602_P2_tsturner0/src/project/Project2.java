/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
/**
 *
 * @author terrenceturner
 */
public class Project2 {
  public static void test() {
    ArrayList<String> words=new ArrayList<String>();
    String tmp="";
    String data[]={"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
    Scanner input = new Scanner(System.in);
    String number;
    while(true){
        System.out.println("Enter a valid 7 digit phone number");
      number=input.nextLine();
      if (number.length()==7) {
      int valid=1;
        for (int i=0;i<number.length();i++  ) {
          if (number.charAt(i)<='1'||number.charAt(i)>'9') {
              valid=0;
              break;             
          }
          
        }

      if (valid==1) 
        break;

      }
    }

    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(
          "COSC602_P2_EnglishWordList.txt"));
      String line = reader.readLine();
      while (line != null) {

        if (line.length()==7){

///////////////////
          int num=1;
          int valid=1;
          char ch;
       
      for (int i=0;i<line.length() ;i++ ) {
        ch=Character.toUpperCase(line.charAt(i));

        if (ch=='A'||ch=='B'||ch=='C') 
          num=2;
        if (ch=='D'||ch=='E'||ch=='F') 
          num=3;
        if (ch=='G'||ch=='H'||ch=='I') 
          num=4;
        if (ch=='J'||ch=='K'||ch=='L') 
          num=5;
        if (ch=='M'||ch=='N'||ch=='O') 
          num=6;
        if (ch=='P'||ch=='Q'||ch=='R'||ch=='S') 
          num=7;
        if (ch=='T'||ch=='U'||ch=='V') 
          num=8;
        if (ch=='W'||ch=='X'||ch=='Y'||ch=='Z') 
          num=9;
       
        if (num!=number.charAt(i)-'0') {
          valid=0;
          break;
        }

      }

      if (valid==1) {
        System.out.println(line);        
      }

////////////////          

        }

        line = reader.readLine();

      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }



  }

  public static void main(String[] args) {
    Project2.test();
  }
}