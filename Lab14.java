package lab14;

public class Lab14 {
    public static void main(String[] args) {
        HashTableExample.main(args); // Call the main method of HashTableExample
    }
}

class HashTableExample {
    static final int SIZE = 20;

    static class DataItem {
        int data;
        int key;

        DataItem(int data, int key) {
            this.data = data;
            this.key = key;
        }
    }

    static DataItem[] hashArray = new DataItem[SIZE];
    static DataItem dummyItem = new DataItem(-1, -1);

    static int hashCode(int key) {
        return key % SIZE;
    }

    static void insert(int key, int data) {
        DataItem item = new DataItem(data, key);
        int hashIndex = hashCode(key);

        // Linear probing for collision resolution
        while (hashArray[hashIndex] != null && hashArray[hashIndex].key != -1) {
            hashIndex = (hashIndex + 1) % SIZE;
        }
        hashArray[hashIndex] = item;
    }

    static DataItem search(int key) {
        int hashIndex = hashCode(key);

        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == key) {
                return hashArray[hashIndex];
            }
            hashIndex = (hashIndex + 1) % SIZE;
        }
        return null;
    }

    static DataItem deleteItem(int key) {
        int hashIndex = hashCode(key);

        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == key) {
                DataItem temp = hashArray[hashIndex];
                hashArray[hashIndex] = dummyItem;
                return temp;
            }
            hashIndex = (hashIndex + 1) % SIZE;
        }
        return null;
    }

    static void display() {
        for (int i = 0; i < SIZE; i++) {
            if (hashArray[i] != null && hashArray[i].key != -1) {
                System.out.print(" (" + hashArray[i].key + "," + hashArray[i].data + ")");
            } else {
                System.out.print(" ~~ ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Insert some data
        insert(1, 20);
        insert(2, 70);
        insert(42, 80);
        insert(4, 25);
        insert(12, 44);
        insert(14, 32);
        insert(17, 11);
        insert(13, 78);
        insert(37, 97);

        System.out.println("Contents of Hash Table:");
        display();

        // Search for a key
        int keyToSearch = 37;
        System.out.println("Searching for key: " + keyToSearch);
        DataItem item = search(keyToSearch);
        if (item != null) {
            System.out.println("Element found: " + item.key + " -> " + item.data);
        } else {
            System.out.println("Element not found.");
        }

        // Delete an item
        System.out.println("Deleting key: " + keyToSearch);
        deleteItem(keyToSearch);

        System.out.println("Contents of Hash Table after deletion:");
        display();
    }
}
