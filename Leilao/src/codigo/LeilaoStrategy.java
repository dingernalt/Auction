package codigo;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface LeilaoStrategy {
	public Lance getVencedor(ArrayList<Lance> lances);
	public void cadastraLance(ArrayList<Lance> lances, String cpf, BigDecimal valor, BigDecimal valorBase);
	public String valorBase();
	public String tipoLeilao();
}
