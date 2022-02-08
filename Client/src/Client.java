import java.io.*;

public class Client implements Serializable {
    private String name;
    private int age;
    private int salary ;
    private int propertyValue;
    private transient File file;

    public Client (String name, int age, int salary, int propertyValue){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.propertyValue = propertyValue;
    }

    public static Client loadFromFile(File file) throws IOException, ClassNotFoundException {
        Client client = null;

        try (ObjectInputStream istream = new ObjectInputStream(new FileInputStream(file))) {

            client = (Client) istream.readObject();
            client.file = file;
        }
        return client;
    }

    public void connectToFile(File file){
        this.file = file;
    }

     public void save () throws IOException{

         try(ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(file))){
             ostream.writeObject(new Client(name,age, salary,propertyValue));
         }
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(int propertyValue) {
        this.propertyValue = propertyValue;
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", propertyValue=" + propertyValue +
                '}';
    }

}
