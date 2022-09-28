package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Docente;
import util.MySqlDBConexion;

public class DocenteModel {

	private static Logger log = Logger.getLogger(DocenteModel.class.getName());
	
	public List<Docente> listaPorFecha(Date fecDesde, Date fecHasta){
		List<Docente> lista = new ArrayList<Docente>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select * from docente where fechaNacimiento between ? and ?";
			pstm = conn.prepareStatement(sql);
			pstm.setDate(1, fecDesde);
			pstm.setDate(2, fecHasta);
			log.info(">>> " + pstm);
			rs = pstm.executeQuery();
			Docente objDocente = null;
			while (rs.next()) {
				objDocente = new Docente();
				objDocente.setIdDocente(rs.getInt(1));
				objDocente.setNombre(rs.getString(2));
				objDocente.setDni(rs.getString(3));
				objDocente.setFechaNacimiento(rs.getDate(4));
				lista.add(objDocente);
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


