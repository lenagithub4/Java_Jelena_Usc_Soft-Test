package lessonsJava;

import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {

        String[] langs = {"Java", "C#", "Python", "PHP"};

        //for (int i=0; i<langs.length; i++) {
         //   System.out.println("I want learn " + langs[i]);

        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");
       // languages.add("Java");
       // languages.add("C#");
        //languages.add("PHP");

           // for (String l : languages) {
           //     System.out.println("I want learn " + l);

        for (String l :  languages) {
            System.out.println("I want learn " + l);
            }
        }


    }

