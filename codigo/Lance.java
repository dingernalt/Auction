package codigo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Lance {
	private LocalDateTime horaLance;
	private String cpf;
	BigDecimal valor;
	
	public Lance(String cpf, BigDecimal valor){
		this.cpf = cpf;
		this.valor = valor;
		horaLance = LocalDateTime.now();
	}
	
	public LocalDateTime getHoraLance() {
		return horaLance;
	}

	public String getCpf() {
		return cpf;
	}

	public BigDecimal getValor() {
		return valor;
	}
}
