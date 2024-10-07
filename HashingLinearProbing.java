package adv_DS;
class HashingLinearProbing {
    class Hashing {
        private int[] hashtable;
        private int tableSize;
        private int currentSize;

        public Hashing(int size) {
            tableSize = size;
            hashtable = new int[tableSize];
            for (int i = 0; i < tableSize; i++) {
                hashtable[i] = -1;
            }
            currentSize = 0;
        }

        private int hashFunction(int key) {
            return key % tableSize;
        }

        public void insert(int key) {
            if (currentSize >= tableSize) {
                System.out.println("Hash table is full");
                return;
            }

            int hashValue = hashFunction(key);

            while (hashtable[hashValue] != -1) {
                hashValue = (hashValue + 1) % tableSize;
            }

            hashtable[hashValue] = key;
            currentSize++;
        }

        public boolean search(int key) {
            int hashValue = hashFunction(key);
            int initialHash = hashValue;

            while (hashtable[hashValue] != -1) {
                if (hashtable[hashValue] == key) {
                    return true;
                }

                hashValue = (hashValue + 1) % tableSize;

                if (hashValue == initialHash) {
                    break;  // If we circle back to the starting point, stop searching
                }
            }
            return false;
        }

        public void display() {
            for (int i = 0; i < tableSize; i++) {
                if (hashtable[i] != -1) {
                    System.out.println("Index " + i + ": " + hashtable[i]);
                } else {
                    System.out.println("Index " + i + ": Empty");
                }
            }
        }
    }

    public static void main(String[] args) {
        HashingLinearProbing.Hashing ht = new HashingLinearProbing().new Hashing(7);

        ht.insert(56);
        ht.insert(79);
        ht.insert(41);
        ht.insert(44);
        ht.insert(21);
        ht.insert(43);
        ht.insert(11);
        ht.insert(29);

        ht.display();

        System.out.println("Search 15: " + ht.search(15));  // Output: true
        System.out.println("Search 25: " + ht.search(25));  // Output: false
    }
}
