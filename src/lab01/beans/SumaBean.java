package lab01.beans;

public class SumaBean {

	private double operadorA;
	private double operadorB;
	private double resultado;
	
	public String sumar() {
		resultado = operadorA + operadorB;
		return "listo";
	}
	
	public double getOperadorA() {
		return operadorA;
	}
	public void setOperadorA(double operadorA) {
		this.operadorA = operadorA;
	}
	public double getOperadorB() {
		return operadorB;
	}
	public void setOperadorB(double operadorB) {
		this.operadorB = operadorB;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
}
