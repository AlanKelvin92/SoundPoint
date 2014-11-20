package bc.impl;

import java.util.ArrayList;
import java.util.List;

import soporte.UsuarioTO;
import soundPoint.FactoryDAO;
import soundPoint.user.data.MongoUsuariosDAO;
import soundPoint.user.data.UsuariosDAO;
import soundPoint.user.data.UsuariosDTO;
import bc.GestionarUsuario;

public class GestorUsuarioEstatico implements GestionarUsuario {

	@Override
	public void agregar(UsuarioTO user) {
		UsuariosDAO usuariosDAO = new MongoUsuariosDAO();
		usuariosDAO.insert(mapTOtoDTO(user));
	}

	@Override
	public List<UsuarioTO> buscar() {
		UsuariosDAO usuariosDAO = new MongoUsuariosDAO();
		return mapDTOtoTO(usuariosDAO.list());
	}

	@Override
	public void modificar(UsuarioTO user) {
		UsuariosDAO usuariosDAO = new MongoUsuariosDAO();
		usuariosDAO.update(mapTOtoDTO(user));
	}

	@Override
	public void eliminar(UsuarioTO user) {
		UsuariosDAO usuariosDAO = new MongoUsuariosDAO();
		usuariosDAO.delete(mapTOtoDTO(user));
	}
	
	private List<UsuarioTO> mapDTOtoTO(List<UsuariosDTO> list){
		List<UsuarioTO> listTO = new ArrayList<UsuarioTO>();
		for (UsuariosDTO usuariosDTO : list) {
			listTO.add(mapDTOtoTO(usuariosDTO));
		}
		return listTO;
	}
	
	private UsuarioTO mapDTOtoTO(UsuariosDTO usuarioDTO){
		UsuarioTO usuarioTO = new UsuarioTO();
		usuarioTO.setId(usuarioDTO.getId());
		usuarioTO.setNombre(usuarioDTO.getNombre());
		usuarioTO.setEstaciones(usuarioDTO.getEstaciones());
		return usuarioTO;
	}
	
	private UsuariosDTO mapTOtoDTO(UsuarioTO usuarioTO){
		UsuariosDTO usuariosDTO = new UsuariosDTO();
		usuariosDTO.setId(usuarioTO.getId());
		usuariosDTO.setNombre(usuarioTO.getNombre());
		usuariosDTO.setEstaciones(usuarioTO.getEstaciones());
		return usuariosDTO;
	}
}
