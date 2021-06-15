package tupyo.domain;

public class Hubo {
	private int kiho;
	private String name;
	
	public Hubo() {
		
	}
	
	public Hubo(int kiho, String name) {
		super();
		this.kiho = kiho;
		this.name = name;
	}
	public int getKiho() {
		return kiho;
	}
	public void setKiho(int kiho) {
		this.kiho = kiho;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Hubo [kiho=" + kiho + ", name=" + name + "]";
	}
	
	
	

}
