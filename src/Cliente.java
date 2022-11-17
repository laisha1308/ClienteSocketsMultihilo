import java.util.ArrayList;

public class Cliente {
    //static final int MAX_HILOS = 10;
    //public static final String HOST = "localhost";

    public static void main(String[] args)  {
        ArrayList<Thread> cliente = new ArrayList<>();
        for(int i = 0; i < 1; i++) {
            cliente.add(new HiloClienteParlante(i));
        }
        for (Thread thread : cliente) {
            thread.start();
        }
    }
}