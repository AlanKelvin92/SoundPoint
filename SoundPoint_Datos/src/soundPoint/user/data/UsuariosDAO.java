package soundPoint.user.data;

import java.util.List;

public interface UsuariosDAO {
	public int insert(UsuariosDTO user);
	public List<UsuariosDTO> list();
	public void delete(UsuariosDTO user);
	public UsuariosDTO update(UsuariosDTO user);
}
