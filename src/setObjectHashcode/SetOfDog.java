package setObjectHashcode;

import java.util.HashSet;
import java.util.Set;

public class SetOfDog {
  static  Set<Dog> dogSet = new HashSet<>();

    public void addDog() {

        Dog dog1 = new Dog("rocky", 1);
        Dog dog2 = new Dog("jack", 2);
        Dog dog3 = new Dog("panda", 5);
        Dog dog4 = new Dog("rocky", 1);

        dogSet.add(dog1);
        dogSet.add(dog2);
        dogSet.add(dog3);
        dogSet.add(dog4);
    }

    public void printDog(){
        for(Dog dogSet: dogSet){
            System.out.println(dogSet);
        }
    }
}
