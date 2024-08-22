import java.util.ArrayList;

public class Grupo {
    ArrayList<Usuario> integrantes;
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
        return this.integrantes.get(index)
    }
    public Usuario getUser(Usuario usuario) {
        return this.integrantes.get(this.integrantes.indexOf(usuario));
    }
}
