public class Program {

    public static void main(String[] args) {

        Object[] array = new Object[10];
        array[0] = 1;
        array[1] = "Hello!";
        array[2] = new Person();
        // Object o = new Person();

        // Employee employee2 = new Employee("DDDD", 32);

        Employee employee1 = new Employee("AAAAAA", 34);
        LinkedList<Employee> linkedList1 = new LinkedList<>();
        linkedList1.addFirst(new Employee("AAAAAA", 43));
        linkedList1.addFirst(new Employee("CCCC", 22));
        linkedList1.addFirst(employee1);
        linkedList1.addFirst(new Employee("EEEEE", 55));
        linkedList1.addFirst(new Employee("AAAAAA", 67));
        linkedList1.addFirst(new Employee("DDDD", 32));
        linkedList1.addFirst(new Employee("AAAAAA", 21));

        System.out.println(linkedList1);

        linkedList1.sort(new EmployeeComparator(SortType.Ascending));

        // System.out.println();
        // System.out.println(linkedList1);

        // linkedList1.sort(new EmployeeComparator(SortType.Descending));

        // System.out.println();
        // System.out.println(linkedList1);

        // LinkedList<Employee>.Node node = linkedList1.contains(employee2);
        // if (node != null){
        //     System.out.println("Элемент найден!");
        //     System.out.println("Значение элемента: " + node.value);
        // }
        // else {
        //     System.out.println("Элемент не найден.");
        // }

        int count = linkedList1.count();
        System.out.printf("Количество элементов в списке - %d\n", count);
        
        linkedList1.revers();

        // linkedList1.removeFirst();
        // linkedList1.removeLast();
        System.out.println();
        System.out.println(linkedList1);

        linkedList1.reversRec();

        System.out.println(linkedList1);
    }
}

class Person{

}
