import java.io.File;
import java.io.*;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("myfile.txt");
        Client client = new Client("Camilla", 22, 100000, 5000000);
        client.connectToFile(file);

        ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(file));
        ostream.writeObject(client);
        ostream.close();
        ObjectInputStream istream = new ObjectInputStream(new FileInputStream(file));
        Client client1 = (Client) istream.readObject();
        istream.close();
        System.out.println(client1);

    }
}




