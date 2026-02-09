package controlador;

import java.util.ArrayList;
import modelo.sistema_operativo;

public interface GestionSistemaOperativos {
    
    void agregar_SistemaOperativo(sistema_operativo sio);

    void actualizar_SistemaOperativo(sistema_operativo sio,int id);

    void eliminar_SistemaOperativo(int id);

    ArrayList<sistema_operativo> visualizar_SistemaOperativo();
    
    sistema_operativo buscar(int id);

}
