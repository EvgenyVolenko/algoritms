public class Program {

    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>(4);

        hashMap.put("+79001112233", "Андрей");
        hashMap.put("+79001112231", "Андрей");
        // hashMap.put("+79001112231", "Сергей");
        hashMap.put("+79001112234", "Сергей");
        hashMap.put("+79001112235", "Валерий");
        // hashMap.put("+79001112236", "Вася");

        String searchValue = hashMap.get("+79001112233");

        // hashMap.remove("+79001112233");
        hashMap.remove("+79001112233");

        // searchValue = hashMap.get("+79001112233");

        // Human human1 = new Human();
        // human1.name = "User";
        // human1.age = 34;

        // Human human2 = new Human();
        // human2.name = "User";
        // human2.age = 34;

        // System.out.println(human1.equals(human2));
        hashMap.printALL();

    }

}

class Human {
    String name;
    int age;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Human) {
            Human human = (Human) obj;
            if (name.equals(human.name) && age == human.age)
                return true;
        }
        return false;
    }
}
