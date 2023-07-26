import java.util.Iterator;

public class HashMap<K, V> implements Iterable<K> {

    private static final int INIT_BUCKET_COUNT = 16;

    private Bucket[] buckets;

    class Entity {
        K key;
        V value;

        @Override
        public String toString() {
            return String.format("Телефон № %s - Контакт %s", key, value);
        }
    }

    class Bucket<K, V> {

        Node head;

        class Node {
            Node next;
            Entity value;
        }

        public V add(Entity entity) {
            Node node = new Node();
            node.value = entity;

            if (head == null) {
                head = node;
                return null;
            }

            Node currentNode = head;
            while (true) {
                if (currentNode.value.key.equals(entity.key)) {
                    V buf = (V) currentNode.value.value;
                    currentNode.value.value = entity.value;
                    return buf;
                }
                if (currentNode.next != null)
                    currentNode = currentNode.next;
                else {
                    currentNode.next = node;
                    return null;
                }
            }
        }

        public V get(K key) {
            Node node = head;
            while (node != null) {
                if (node.value.key.equals(key))
                    return (V) node.value.value;
                node = node.next;
            }
            return null;
        }

        public V remove(K key) {
            if (head == null)
                return null;
            if (head.value.key.equals(key)) {
                V buf = (V) head.value.value;
                head = head.next;
                return buf;
            } else {
                Node node = head;
                while (node.next != null) {
                    if (node.next.value.key.equals(key)) {
                        V buf = (V) node.next.value.value;
                        node.next = node.next.next;
                        return buf;
                    }
                    node = node.next;
                }
                return null;
            }
        }

        /**
         * @return Получаем количество элементов списка из Entity
         */
        public int size() {
            int count = 0;
            Node node = head;
            while (node != null) {
                count++;
                node = node.next;
            }
            return count;
        }

        public K getKeyByIndex(int cell) {
            Node node = head;
            if (head == null) {
                return null;
            }
            for (int index = 0; index < cell; index++) {
                node = node.next;
            }
            return (K) node.value.key;
        }

        /**
         * @return Получаем строковый массив значений ключей в списке bucket
         */
        public String[] getKeys() {
            String[] keys = new String[size()];
            Node node = head;

            for (int i = 0; i < size(); i++) {
                keys[i] = (String) node.value.key;
                node = node.next;
            }
            return keys;
        }

        /**
         * Обходим список из Entity и выводим в терминал
         */
        public void printEntitys() {
            Node node = head;

            if (head == null) {
                System.out.println("Список из Entity существует, но пустой");
            } else {
                while (node != null) {
                    System.out.println(node.value.toString());
                    node = node.next;
                }
            }
        }

    }

    private int calculateBucketIndex(K key) {
        int index = key.hashCode() % buckets.length;
        index = Math.abs(index);
        return index;
    }

    /**
     * Добавить новую пару ключ + значение
     * 
     * @param key   ключ
     * @param value значение
     * @return предыдущее значение (при совпадении ключа), иначе null
     */
    public V put(K key, V value) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null) {
            bucket = new Bucket();
            buckets[index] = bucket;
        }

        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        return (V) bucket.add(entity);
    }

    public V get(K key) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        return (V) bucket.get(key);
    }

    public K getKeyByCoord(int column, int cell) {
        Bucket bucket = buckets[column];
        if (bucket == null) {
            return null;
        }
        return (K) bucket.getKeyByIndex(cell);
    }

    public V remove(K key) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        return (V) bucket.remove(key);
    }

    public HashMap() {
        // buckets = new Bucket[INIT_BUCKET_COUNT];
        this(INIT_BUCKET_COUNT);
    }

    public HashMap(int initCount) {
        buckets = new Bucket[initCount];
    }

    /**
     * Выводим в терминал все, что есть в HashMap
     */
    public void printALL() {

        for (int index = 0; index < buckets.length; index++) {
            if (buckets[index] == null) {
                System.out.printf("bucket № %d содержит:\nНе содержит списка из Entity\n", index);
            } else {
                System.out.printf("bucket № %d содержит:\n", index);
                buckets[index].printEntitys();
            }
        }
    }

    public void printALLForeach() {
        for (Bucket bucket : buckets) {
            if (bucket == null)
                ;
            else {
                HashMap.Bucket.Node node = bucket.head;
                if (node != null) {
                    for (int i = 0; i < bucket.size(); i++) {
                        System.out.printf("Телефон № %s - Контакт %s\n", bucket.getKeyByIndex(i),
                                bucket.get(bucket.getKeyByIndex(i)));
                        node = node.next;
                    }
                }
            }
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            HashMap.Bucket.Node node = null;
            K key = null;
            int bucketN = 0;
            int counter = 0;

            @Override
            public boolean hasNext() {
                if (bucketN < buckets.length) {
                    return true;
                }
                return false;
            }

            @Override
            public K next() {

                if (counter >= buckets[bucketN].size() || buckets[bucketN] == null || buckets[bucketN].head == null) {
                    bucketN++;
                    counter = 0;
                }

                if (counter < buckets[bucketN].size()) {
                    return (K) getKeyByCoord(bucketN, counter++);
                } else {
                    return (K) getKeyByCoord(bucketN++, counter);
                }

            }
        };
    }
}
