package adv_DS;

public class HashingQuadratic {
    private int[] hashTable;
    private int tableSize;
    private int currentSize;

    public HashingQuadratic(int size) {
        tableSize = size;
        hashTable = new int[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = -1;
        }
        currentSize = 0;
    }

    private int hashFunction(int key) {
        return key % tableSize;
    }

    public void insert(int key) {
        if (currentSize >= tableSize) {
            System.out.println("Hash Table is full");
            return;
        }
        int hashValue = hashFunction(key);
        int i = 0;
        while (hashTable[(hashValue + i * i) % tableSize] != -1) {
            i++;
        }
        hashTable[(hashValue + i * i) % tableSize] = key;
        currentSize++;
    }

    public boolean search(int key) {
        int hashValue = hashFunction(key);
        int i = 0;
        while (hashTable[(hashValue + i * i) % tableSize] != -1) {
            if (hashTable[(hashValue + i * i) % tableSize] == key) {
                return true;
            }
            i++;
            if (i == tableSize) {
                break;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < tableSize; i++) {
            if (hashTable[i] != -1) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }

    public static void main(String[] args) {
        HashingQuadratic ht = new HashingQuadratic(7);
        ht.insert(10);
        ht.insert(20);
        ht.insert(15);
        ht.insert(7);
        ht.insert(30);
        ht.display();
        System.out.println("Search 15: " + ht.search(15));
        System.out.println("Search 25: " + ht.search(25));
    }
}
