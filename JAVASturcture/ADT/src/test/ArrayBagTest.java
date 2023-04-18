package test;

import function.bag.entities.ArrayBag;
import function.inter.BagInterface;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Collection;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/15 20:49
 * @Version 1.0.0.0
 */
public class ArrayBagTest {

    @Test
    public void testAdd(){
        BagInterface<String> bag = new ArrayBag<>();
        String[] content = {"A","A","B","A","C","A"};
        System.out.println(bag.add(bag,content));
        bag.loop();
        bag = new ArrayBag<>(7);
        String[] content2 = {"A","B","A","C","B","C","D","another String"};
        System.out.println(bag.add(bag,content2));
        bag.loop();
        Collection<Object> coll = new ArrayList<>();
    }

}
