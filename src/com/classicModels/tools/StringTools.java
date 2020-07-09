package com.classicModels.tools;




public class StringTools {
	
	/**
	 * Retourne le nom complet de la classe
	 * @param classe
	 */
	public static String getTotalNameFromClass(Object classe) {
		return classe.getClass().getName();
	}
	
	/**
	 * retourne le nom de la classe sans son extention Bean
	 * @param classe
	 */
	public static String getNameFromClass(Object classe) {
		String s = classe.getClass().getSimpleName();
		s = s.substring(0, s.indexOf("DTO")).toLowerCase();
		
		return s;
	}
	
	
}
