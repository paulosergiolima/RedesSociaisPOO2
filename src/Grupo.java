import java.util.ArrayList;

public class Grupo {
    ArrayList<Usuario> members;
    ArrayList<Message> messages;
    //Usuario vai ser a classe criada
    public void putUser(Usuario novo_integrante) {
        integrantes.add(novo_integrante);
    }
    public void removeUser(Usuario integrante) {
        integrantes.remove(integrante);
    }
    public ArrayList<Usuario> getUsers() {
        return this.integrantes;
    }
    public Usuario getUser(int index) {
        return this.integrantes.get(index);
    }
    public Usuario getUser(Usuario usuario) {
        return this.integrantes.get(this.integrantes.indexOf(usuario));
    }
    public void sendMessage(Usuario user,String message) {
        Message msg = new Message(message, user);
        messages.add(msg);
    }
    public ArrayList<Message> getMessages() {
        return this.messages;
    }
}
