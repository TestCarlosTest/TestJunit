package org.example;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest3
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

        // Ordenado por longitud, utiliza un treemap por defecto, de no ser así, se crearía un nuevo treemap desde el calculado
        Map<Integer, List<String>> sortedByKeyMap = sentenceList.stream().collect(Collectors.groupingBy(value -> value.length()));

        // Se invierte cada lista
        sortedByKeyMap.keySet().stream().forEach(
                length -> Collections.reverse(sortedByKeyMap.get(length)));

        // Se calcula la lista desde el conjunto de list ordenados en cada value del map
        List<String> finalSentenceList =
                sortedByKeyMap.keySet()
                        .stream()
                        .map(length -> sortedByKeyMap.get(length))
                        //.filter(wordsByLenght -> wordsByLenght.size() > 1)
                        .flatMap(wordsByLength -> wordsByLength.stream())
                        .collect(Collectors.toList());

        // Se convierte la lista de palabras ordenadas en una cadena, se ponen todas las letras en minúsculas,
        // la primera letra en mayúscula y se añade el punto final
        String finalSentence = finalSentenceList.stream().collect(Collectors.joining(" ")).toLowerCase();
        return finalSentence.substring(0, 1).toUpperCase() + finalSentence.substring(1) + ".";
    }
}
