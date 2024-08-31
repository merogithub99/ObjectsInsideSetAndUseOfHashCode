package MapOfListValue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SubjectsAndMarksInEachTerm {
    public static void main(String[] args) {

        List<Integer> numbersInEnglish=List.of(100,30,40,99);
        List<Integer> numbersInMath=List.of(100,75,56,42);
        List<Integer> numbersInJava=List.of(100,75,56,42);
        List<Integer> numbersInDotNet=List.of(100,75,56,42);
        List<Integer> numbersInSAD=List.of(100,30,40,99);


        Map<String ,List<Integer>> map= new HashMap<>();
        map.put("English",numbersInEnglish);
        map.put("java",numbersInJava);
        map.put("math",numbersInMath);
        map.put("dotnet",numbersInDotNet);
        map.put("sad",numbersInSAD);

        //using lambda expression
        map.forEach((a,b)->{
            System.out.println("subjects:"+a+"  "+"marks:"+b);
        });

        System.out.println("---------------------------");
        System.out.println("using enhanced for loop and iterator");
        for (Map.Entry<String, List<Integer>> stringListEntry : map.entrySet()) {
            System.out.println(stringListEntry);
        }

        System.out.println("---------------------------");
        System.out.println("using while and iterator");
        Iterator<Map.Entry<String,List<Integer>>> iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
