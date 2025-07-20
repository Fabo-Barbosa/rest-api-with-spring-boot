package br.com.fabodev.mathaux;

public class NumberTratamentAuxiliar {
	
	public static double changeToDouble(String valor) {
		if (valor == null) return 0D;
		String number = valor.replaceAll(",", ".");
		
		//parseDouble muda o tipo de uma string numérica para double
		if (isNumber(number)) return Double.parseDouble(number);
		return 0D;
	}

	public static boolean isNumber(String valor) {
		if (valor == null) return false;
		
		// replaceAll substitui string especificadas e retorna a string resultante
		String number = valor.replaceAll(",", ".");
		
		// matches recebe uma regex e realiza uma verificação retornando um booleano
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
