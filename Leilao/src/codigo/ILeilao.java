package codigo;

import java.math.BigDecimal;
import java.util.List;

public interface ILeilao {
	public void cadastraLance(String cpf, BigDecimal valor);
	public String getVencedor() throws LeilaoFechadoException;
	public List<Lance> getLances();
	public String descricaoLeilao();
}
