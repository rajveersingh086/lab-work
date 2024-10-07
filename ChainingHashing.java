package adv_DS;
import java.util.LinkedList;

public class ChainingHashing {
    private LinkedList<Integer>[] hashTable;
    private int tableSize;

    public ChainingHashing(int size) {
        tableSize = size;
        hashTable = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return key % tableSize;
    }

    public void insert(int key) {
        int hashValue = hashFunction(key);
        hashTable[hashValue].add(key);
    }

    public boolean search(int key) {
        int hashValue = hashFunction(key);
        return hashTable[hashValue].contains(key);
    }

    public void delete(int key) {
        int hashValue = hashFunction(key);
        if (hashTable[hashValue].contains(key)) {
            hashTable[hashValue].remove((Integer) key);
        }
    }

    public void display() {
        for (int i = 0; i < tableSize; i++) {
            for (int key : hashTable[i]) {
                System.out.print(key + "->");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        ChainingHashing ht = new ChainingHashing(7);
        ht.insert(25);
        ht.insert(97);
        ht.insert(80);
        ht.insert(65);
        ht.insert(40);
        ht.insert(59);
        ht.insert(78);
        ht.insert(17);
        ht.insert(99);
        ht.insert(35);
        ht.insert(23);
        ht.display();
        System.out.println(ht.search(15));
        System.out.println(ht.search(25));
        ht.delete(15);
        ht.display();
    }
}
