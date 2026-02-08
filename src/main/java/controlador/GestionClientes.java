package controlador;

import java.util.ArrayList;
import modelo.Clientes;
import modelo.persona;

public interface GestionClientes {
    void agregar_Clientes(persona p);

    void actualizar_Clientes(Clientes cl,int id);

    void eliminar_Clientes();

    ArrayList<Clientes> visualizar_Clientes();

    Clientes buscar(int id);

}
