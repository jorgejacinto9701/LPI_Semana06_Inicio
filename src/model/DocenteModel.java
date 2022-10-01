package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Docente;

public class DocenteModel {

	private static Logger log = Logger.getLogger(DocenteModel.class.getName());
	
	public List<Docente> listaDocentePorFecha(Date fecIni, Date fecFin){
		List<Docente> salida = new ArrayList<Docente>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {

			log.info("SQL >> " + pstm);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		return salida;
	}
	
}


