import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.text.html.parser.Entity;

public class HashMap<K, V> {

    private static final int INIT_BUCKET_COUNT = 16;

    private Bucket[] buckets;

    class Entity {
        K key;
        V value;
    }

    class Bucket<K, V> implements Iterator<Entity>{

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

        public int size() {
            int count = 0;
            Node node = head;
            while (node != null) {
                count++;
                node = node.next;
            }
            return count;
        }

        public String[] getKeys() {
            String[] keys = new String[size()];
            Node node = head;

            for (int i = 0; i < size(); i++) {
                keys[i] = (String) node.value.key;
                node = node.next;
            }
            return keys;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Entity next() {
            // TODO Auto-generated method stub
            return null;
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

    public void printALL() {
        int count = 1;
        for (Bucket bucket : buckets) {
            if (bucket == null) {
                System.out.printf("bucket № %d пустой\n", count);
            } else {
                String[] keys = bucket.getKeys();
                System.out.printf("bucket № %d содержит %s элементов!\n", count, keys.length);
                
                for (int index = 0; index < keys.length; index++) {
                    System.out.printf("Телефон № %s - Контакт %s\n", keys[index], bucket.get(keys[index]));
               }
            }
            count++;
        }
    }
}
