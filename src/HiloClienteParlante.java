import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloClienteParlante extends Thread {
    protected Socket socket;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private int id;

    public HiloClienteParlante(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            System.out.println("Laisha envía un saludo");
            dos.writeUTF("hola");
            String respuesta = "";
            respuesta = dis.readUTF();
            System.out.println("Laisha el servidor te devuelve el saludo: " + respuesta);
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            Logger.getLogger(HiloClienteParlante.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
