package bc;

import java.util.List;

import soporte.UsuarioTO;
import soundPoint.user.data.UsuariosDTO;

public interface GestionarUsuario {
	public void agregar(UsuarioTO user);
	public void modificar(UsuarioTO user);
	public List<UsuarioTO> buscar();
	public void eliminar(UsuarioTO user);
}	
