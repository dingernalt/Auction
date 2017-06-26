package codigo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class LeilaoOferta implements LeilaoStrategy {

	@Override
	public Lance getVencedor(ArrayList<Lance> lances) {
		if (lances.size() == 0) return null;
		Lance menorLance = lances.get(0);
		for(int i = 1; i<lances.size();i++){
			if (lances.get(i).getValor().compareTo(menorLance.getValor()) < 0)
				menorLance = lances.get(i);
		}
		return menorLance;
	}
	
	public String valorBase(){
		return "Valor Máximo";
	}
	
	public String tipoLeilao(){
		return "Leilão Oferta";
	}
	
	@Override
	public void cadastraLance(ArrayList<Lance> lances, String cpf, BigDecimal valor, BigDecimal valorBase) {
		if(valor.compareTo(valorBase) <= 0) lances.add(new Lance(cpf, valor));
	}

}
