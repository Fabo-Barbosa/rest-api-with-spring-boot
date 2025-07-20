package br.com.fabodev.mathaux;

import br.com.fabodev.exceptions.UnsupportedMathOperationException;

public class OperationResult {
	
	public double getSum(String strV1, String strV2) {
		if (!NumberTratamentAuxiliar.isNumber(strV1) || !NumberTratamentAuxiliar.isNumber(strV2))
			throw new UnsupportedMathOperationException("Please, set only numbers...");
		
		return NumberTratamentAuxiliar.changeToDouble(strV1) + NumberTratamentAuxiliar.changeToDouble(strV2);
	}
	
	public double getSub(String strV1, String strV2) {
		if (!NumberTratamentAuxiliar.isNumber(strV1) || !NumberTratamentAuxiliar.isNumber(strV2))
			throw new UnsupportedMathOperationException("Please, set only numbers...");
		
		return NumberTratamentAuxiliar.changeToDouble(strV1) - NumberTratamentAuxiliar.changeToDouble(strV2);
	}
	
	public double getDiv(String strV1, String strV2) {
		if (!NumberTratamentAuxiliar.isNumber(strV1) || !NumberTratamentAuxiliar.isNumber(strV2))
			throw new UnsupportedMathOperationException("Please, set only numbers...");
		
		return NumberTratamentAuxiliar.changeToDouble(strV1) / NumberTratamentAuxiliar.changeToDouble(strV2);
	}
	public double getMult(String strV1, String strV2) {
		if (!NumberTratamentAuxiliar.isNumber(strV1) || !NumberTratamentAuxiliar.isNumber(strV2))
			throw new UnsupportedMathOperationException("Please, set only numbers...");
		
		return NumberTratamentAuxiliar.changeToDouble(strV1) * NumberTratamentAuxiliar.changeToDouble(strV2);
	}
	
	public double getMedia(String strV1, String strV2) {
		if (!NumberTratamentAuxiliar.isNumber(strV1) || !NumberTratamentAuxiliar.isNumber(strV2))
			throw new UnsupportedMathOperationException("Please, set only numbers...");
		
		
		return (NumberTratamentAuxiliar.changeToDouble(strV1) + 
				NumberTratamentAuxiliar.changeToDouble(strV2) / 2);
	}
	
	public double getSqrt(String strV) {
		if (!NumberTratamentAuxiliar.isNumber(strV))
			throw new UnsupportedMathOperationException("Please, set only numbers...");
		
		return Math.sqrt(NumberTratamentAuxiliar.changeToDouble(strV));
	}

}
