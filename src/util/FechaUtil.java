package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FechaUtil {

	public static String getFechaActualYYYYMMdd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaActal = new Date();
		return sdf.format(fechaActal);
	}
	
	public static String getFechaActualddMMyyyy() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaActal = new Date();
		return sdf.format(fechaActal);
	}
	
	public static String getFechaPrimeroEneroYYYYMMdd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//El calendar permite operar con fechas
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);  //1 en el mes
		calendar.set(Calendar.MONTH, Calendar.JANUARY); //El mes de Enero
		Date fecha = calendar.getTime();
		
		//Le damos el formato
		return sdf.format(fecha);
	}
	
	public static String getFechaUltimoDiciembreYYYYMMdd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//El calendar permite operar con fechas
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 31);  //31 en el mes
		calendar.set(Calendar.MONTH, Calendar.DECEMBER); //El mes de Diciembre
		Date fecha = calendar.getTime();
		
		//Le damos el formato
		return sdf.format(fecha);
	}
	
	public static boolean isNotSuperiorFechaYYYYMMdd(String fecUno, String fecDos) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateUno = sdf.parse(fecUno);
			Date dateDos = sdf.parse(fecDos);
			return dateDos.before(dateUno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean isNotSuperiorSeisMesesFechaYYYYMMdd(String fecUno, String fecDos) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateUno = sdf.parse(fecUno);
			Date dateDos = sdf.parse(fecDos);
			
			//Aumentar la fecha 1 en seis meses (180 días)
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateUno);
			int diasAnio = calendar.get(Calendar.DAY_OF_YEAR);
			calendar.set(Calendar.DAY_OF_YEAR, diasAnio + 180);
			Date  dateAumentado = calendar.getTime();
			
			System.out.println(sdf.format(dateAumentado));
			return dateAumentado.before(dateDos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
