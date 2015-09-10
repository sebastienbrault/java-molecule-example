package yose;

/**
 * Bean pour la transformation en Gson pour le retour d'erreur de Prime Factor
 * 
 * @author XHLX8486
 *
 */
public class PrimeFactorErrorBean {
	private String number;
	private String error;

	public PrimeFactorErrorBean(String number, String error) {
		super();
		this.number = number;
		this.error = error;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
