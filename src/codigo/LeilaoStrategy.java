package codigo;

import java.math.BigDecimal;
import java.util.ArrayList;

import deprecated.Bid;

public interface LeilaoStrategy {
	public Bid getVencedor(ArrayList<Bid> lances);
	public void cadastraLance(ArrayList<Bid> lances, String cpf, BigDecimal valor, BigDecimal valorBase);
	public String valorBase();
	public String tipoLeilao();
}
