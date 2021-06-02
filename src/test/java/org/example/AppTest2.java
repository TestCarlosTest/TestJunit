package org.example;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest2
{


    @Test
    public void test1()
    {
        String s1 = "The lines are printed in reverse order.";
        String s2 = "In are the order lines reverse printed.";
        String s3 = arrange(s1);
        System.out.println(s3);
        assertEquals( s2, s3  );
    }

    // Complete the arrange function below.
    String arrange(String sentence) {


        // Se convierte la frase en una lista de palabras separadas por espacios
        List<String> sentenceList =
                Arrays.asList(
                    // Eliminamos el punto final
                    sentence.substring(0, sentence.length()-1)
                    // se divide por espacios
                    .split(" ")
                );

        // Se ordena por longitud
        Collections.sort(sentenceList, Comparator.comparing(String::length));

        // Se procesa la frase ordenada de principio a fin. Cada bloque de palabras de la misma longitud se invierte
        // Seguramente haya una forma mejor de hacerlo con java 8
        int oldLength = 0;
        int newLength;
        List<String> finalSentenceList = new ArrayList<>();
        List<String> temporalSentenceList = new ArrayList<>();

        for (int i = 0; i< sentenceList.size(); i++){
            newLength = sentenceList.get(i).length();
            if (newLength != oldLength ){
                Collections.reverse(temporalSentenceList);
                finalSentenceList.addAll(temporalSentenceList);
                oldLength = newLength;
                temporalSentenceList = new ArrayList<>();
            }
            temporalSentenceList.add(sentenceList.get(i));
        }

        Collections.reverse(temporalSentenceList);
        finalSentenceList.addAll(temporalSentenceList);

        // Se convierte la lista de palabras ordenadas en una cadena, se ponen todas las letras en minúsculas,
        // la primera letra en mayúscula y se añade el punto final
        String finalSentence = finalSentenceList.stream().collect(Collectors.joining(" ")).toLowerCase();
        return finalSentence.substring(0, 1).toUpperCase() + finalSentence.substring(1) + ".";
    }
}
