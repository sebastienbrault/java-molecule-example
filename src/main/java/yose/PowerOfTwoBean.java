package yose;

/**
 * Bean pour la transformation en Gson pour le world PowerOfTwo
 * 
 * @author XHLX8486
 *
 */
public class PowerOfTwoBean {
	private Integer number;
	private Integer[] decomposition;

	public PowerOfTwoBean(Integer number, Integer[] decomposition) {
		super();
		this.number = number;
		this.decomposition = decomposition;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer[] getDecomposition() {
		return decomposition;
	}

	public void setDecomposition(Integer[] decomposition) {
		this.decomposition = decomposition;
	}

}
