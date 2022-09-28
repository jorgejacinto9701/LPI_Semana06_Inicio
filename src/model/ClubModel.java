package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import entidad.Club;
import util.MySqlDBConexion;

public class ClubModel {

	private static Logger log = Logger.getLogger(ClubModel.class.getName());
	
	public int insertaClub(Club obj) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			//1 Se crea la conexión
			conn = MySqlDBConexion.getConexion();
			
			//2 Se prepara el SQL
			String sql = "insert into club value(null,?,?,curtime(),?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setDate(2, obj.getFechaCreacion());
			pstm.setInt(3, obj.getEstado());
			pstm.setInt(4, obj.getPais().getIdPais());
			log.info(">>> " + pstm);
			
			//3 Ejecutamos a la base de datos
			//Retorna la cantidad de registrados en salida
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return salida;
	}
}
