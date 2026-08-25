public class person {
    String name;
    int age;
    String city;

        person(String name, int age, String city){
            this.name = name;
            this.age = age;
            this.city = city;
        }

    public static void main(String[] args) {
        person per = new person("Anna Mikaela Gavieres", 22, "Makati City");

        System.out.println(per.name + " " + per.age + " " + per.city);
    }

}
