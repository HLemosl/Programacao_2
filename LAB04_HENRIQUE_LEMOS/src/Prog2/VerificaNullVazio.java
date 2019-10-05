package Prog2;

public class VerificaNullVazio {
	
	public VerificaNullVazio() {
		
	}
	
	public void verificador(String verificado) {
		if (verificado == null || "".equals(verificado.trim()) ) {
			throw new IllegalArgumentException("ENTRADA VAZIA/NULA INVÁLIDA!");
		}
	}
}
