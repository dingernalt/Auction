package codigo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) throws LeilaoFechadoException{
		ILeilao le = new Leilao(LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), new BigDecimal("500.0"),
				"Lucas Parizotto", "batata", true, true);
		le.cadastraLance("04150410070", new BigDecimal("501.25"));
		System.out.println(le.descricaoLeilao());
		System.out.println(le.getVencedor());
	}

}
