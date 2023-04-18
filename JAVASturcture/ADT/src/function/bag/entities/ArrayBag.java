package function.bag.entities;

import function.inter.BagInterface;


/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/14 11:33
 * @Version 1.0.0.0
 */
public class ArrayBag<T> implements BagInterface<T> {
    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    //为了属于的安全需要考虑初始化包时容量超过最大容量该怎么办
    //此时增加两个数据域来进行判断和处理
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;


    //每次创建对象时，执行构造方法，初始化bag的容量
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int desireCapacity) {
        //判断创建bag包时给出的容量是否大于最大容量，大于则抛出异常，提醒错误
        if (desireCapacity <= MAX_CAPACITY) {
            T[] tempBag = (T[]) new Object[desireCapacity];
            bag = tempBag;
            numberOfEntries = 0;
            initialized = true;
        } else {
            throw new IllegalStateException("需要创建的包容量超出最大容量！！！创建失败");
        }

    }

    //检查创建包是否成功,这里的方法不能暴露，所以使用private
    private void checkInitialization() {
        if (!initialized)
            throw new SecurityException("创建的包没有合理的初始化；");
    }

    @Override
    public int getCurrentSize() {

        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {


        return numberOfEntries <= 0;
    }

    @Override
    public boolean add(T newEntry) {
        checkInitialization();
        boolean result = true;
        if (isArrayFull()) {
            result = false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            result = true;
        }
        return result;
    }


    //添加一整个数组
    @Override
    public boolean add(BagInterface<T> bag, T[] contentBag) {

        for (int i = 0; i < contentBag.length; i++) {
            bag.add(contentBag[i]);
        }

        return true;
    }

    private boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    }

    @Override
    public T remove() {

        checkInitialization();
        T result = null;
        if (numberOfEntries > 0) {
            result = bag[numberOfEntries-1];
            bag[numberOfEntries-1] = null;
            numberOfEntries--;
        }
        return result;
    }



    @Override
    public boolean remove(T anEntry) {

        return false;
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            remove();
        }

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        return 0;

    }

    @Override
    public int findIndex(T anEntry) {
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T[] toArray() {
        //返回一个复制bag包元素的新数组，而不是直接返回bag原数组，这样可以防止暴露bag的私有数据而破坏包的完整性
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[numberOfEntries];
        }
        return result;
    }

    @Override
    public void loop() {
        checkInitialization();
        for (int i = 0; i < numberOfEntries; i++) {
            System.out.print(bag[i] + " ");
        }
        System.out.println("\n");
    }

}
