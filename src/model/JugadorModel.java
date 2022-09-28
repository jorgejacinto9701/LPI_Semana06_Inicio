package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import entidad.Jugador;
import util.MySqlDBConexion;

public class JugadorModel {

	private static Logger log = Logger.getLogger(JugadorModel.class.getName());

	public int insertaJugador(Jugador obj) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// 1 Se crea la conexión
			conn = MySqlDBConexion.getConexion();

			// 2 Se prepara el SQL
			String sql = "insert into jugador value(null,?,?,?,curtime(),?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setDate(3, obj.getFechaNacimiento());
			pstm.setInt(4, obj.getEstado());
			
			log.info(">>> " + pstm);

			// 3 Ejecutamos a la base de datos
			// Retorna la cantidad de registrados en salida
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

}
