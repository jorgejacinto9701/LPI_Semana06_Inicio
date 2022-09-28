package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Campeonato;
import util.MySqlDBConexion;

public class CampeonatoModel {

	private static Logger log = Logger.getLogger(CampeonatoModel.class.getName());

	public int insertaCampeonato(Campeonato obj) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// 1 Se crea la conexión
			conn = MySqlDBConexion.getConexion();

			// 2 Se prepara el SQL
			String sql = "insert into campeonato value(null,?,?,curtime(),?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setInt(2, obj.getAnnio());
			pstm.setInt(3, obj.getEstado());

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

	public List<Campeonato> listaPorNombre(String filtro) {
		List<Campeonato> lista = new ArrayList<Campeonato>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select * from campeonato where nombre like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro + "%");
			log.info(">>> " + pstm);
			rs = pstm.executeQuery();
			Campeonato objCampeonato = null;
			while (rs.next()) {
				objCampeonato = new Campeonato();
				objCampeonato.setIdCampeonato(rs.getInt(1));
				objCampeonato.setNombre(rs.getString(2));
				objCampeonato.setAnnio(rs.getInt(3));
				objCampeonato.setFechaRegistro(rs.getDate(4));
				objCampeonato.setEstado(rs.getInt(5));
				lista.add(objCampeonato);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)		rs.close();
				if (pstm != null)	pstm.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
			}
		}
		return lista;
	}

}
