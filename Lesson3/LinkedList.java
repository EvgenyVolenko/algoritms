import java.util.Comparator;

/**
 * Связный список
 */
public class LinkedList<T> {

    /**
     * Указатель на первый элемент связного списка
     */
    private Node head;

    /**
     * Узел связного списка
     */
    public class Node{

        /**
         * Указатель на следующий элемент связного списка
         */
        public Node next;

        /**
         * Значение элемента (узла)
         */
        public T value;
    }

    /**
     * Добавление нового элемента в начало связного списка
     * @param value значение
     */
    public void addFirst(T value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            node.next = head;
        }
        head = node;
    }

    /**
     * Удаление первого элемента из начала связного списка
     */
    public void removeFirst(){
        if (head != null){
            head = head.next;
        }
    }

    /**
     * Поиск элемента в связном списке по значению
     * @param value значение
     * @return элемент
     */
    public Node contains(T value){
        Node node = head;
        while (node != null){
            if (node.value.equals(value))
                return node;
            node = node.next;
        }
        return null;
    }

    /**
     * Сортировка связного списка
     * @param comparator
     */
    public void sort(Comparator<T> comparator){
        Node node = head;
        while (node != null){

            Node minValueNode = node;
            Node node2 = node.next;
            while (node2 != null){
                if (comparator.compare(minValueNode.value, node2.value) > 0){
                    minValueNode = node2;
                }
                node2 = node2.next;
            }

            if (minValueNode != node){
                T buf = minValueNode.value;
                minValueNode.value = node.value;
                node.value = buf;
            }

            node = node.next;
        }
    }

    /**
     * Добавление элемента в конец связного списка
     * @param value значение
     */
    public void addLast(T value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
        }
        else {
            Node lastNode = head;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
    }

    /**
     * Удаление последнего элемента из связного списка
     */
    public void removeLast(){
        if (head == null)
            return;
        Node node = head;
        while (node.next != null) {
            if (node.next.next == null){
                node.next = null;
                return;
            }
            node = node.next;
        }
        head = null;
    }

    /**
     * Подсчет количества элементов списка
     */
    public int count() {
        int size = 1;
        Node node = head;
        if (head == null)
            return 0;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        Node node = head;
        while (node != null){
            stringBuilder.append(node.value);
            stringBuilder.append('\n');
            node = node.next;
        }
        return stringBuilder.toString();
    }
}
