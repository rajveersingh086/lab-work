package adv_DS;

public class DoubleHashingProbling {
        private int[] hashTable;
        private int tableSize;
        private int currentSize;
        public DoubleHashingProbling(int size) {
            tableSize = size;
            hashTable = new int[tableSize];
            for (int i = 0; i < tableSize; i++) {
                hashTable[i] = -1;
            }
            currentSize = 0;
        }
        private int hashFunction1(int key) {
            return key % tableSize;
        }
        private int hashFunction2(int key) {
            return 7 - (key % 7);
        }
        public void insert(int key) {
            if (currentSize >= tableSize) {
                System.out.println("Hash Table is full");
                return;
            }
            int hashValue = hashFunction1(key);
            int i = 0;
            while (hashTable[(hashValue + i * hashFunction2(key)) % tableSize] != -1) { 
                i++;
            }
            hashTable[(hashValue + i * hashFunction2(key)) % tableSize] = key; 
            currentSize++;
        }
        public boolean search(int key) {
            int hashValue = hashFunction1(key);
            int i = 0;
            while (hashTable[(hashValue + i * hashFunction2(key)) % tableSize] != -1) { 
                if (hashTable[(hashValue + i * hashFunction2(key)) % tableSize] == key) { 
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
            DoubleHashingProbling ht = new DoubleHashingProbling(7);
            ht.insert(79);
            ht.insert(69);
            ht.insert(98);
            ht.insert(72);
            ht.insert(14);
            ht.insert(50);
            ht.display();
            System.out.println("Search 15: " + ht.search(15));  // Output: true
            System.out.println("Search 25: " + ht.search(25));  // Output: false
    }
}
