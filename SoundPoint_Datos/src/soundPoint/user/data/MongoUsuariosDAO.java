package soundPoint.user.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import soundPoint.FactoryDAO;

public class MongoUsuariosDAO implements UsuariosDAO{
	
	Connection connection = null;
	
	@Override
	public int insert(UsuariosDTO user) {
		try {
			connection = DriverManager.getConnection(FactoryDAO.getMongoDriver());
			PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES(?,?)");
			ps.setString(1, user.getNombre());
			ps.setInt(2, user.getId());
			ps.setArray(3, user.getEstaciones());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<UsuariosDTO> list() {
		try {
			connection = DriverManager.getConnection(FactoryDAO.getMongoDriver());
			ArrayList<UsuariosDTO> users = new ArrayList<UsuariosDTO>() ;
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				UsuariosDTO user = new UsuariosDTO();
				user.setNombre(rs.getString(1));
				user.setId(rs.getInt(2));
				user.setEstaciones(rs.getArray(3));
			}
			rs.close();
			ps.close();
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void delete(UsuariosDTO user){
		try{
			connection = DriverManager.getConnection(FactoryDAO.getMongoDriver());
			PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE id = ?");
			ps.setInt(1, user.getId());
			ps.execute();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public UsuariosDTO update(UsuariosDTO user){
		try{
			connection = DriverManager.getConnection(FactoryDAO.getMongoDriver());
			PreparedStatement ps = connection.prepareStatement("UPDATE users SET nombre = ?, estaciones = ? WHERE id = " + user.getId());
			ps.setString(1, user.getNombre());
			ps.setArray(3, user.getEstaciones());
			
			ResultSet rs = ps.executeQuery();
			if(rs.rowUpdated()){
				user.setNombre(rs.getString(1));
				user.setEstaciones(rs.getArray(2));
			}
			rs.close();
			ps.close();
			return user;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
}
