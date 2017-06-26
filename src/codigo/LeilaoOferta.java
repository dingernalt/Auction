package codigo;

import java.math.BigDecimal;
import java.util.ArrayList;

import deprecated.Bid;

public class LeilaoOferta implements LeilaoStrategy {

	@Override
	public Bid getVencedor(ArrayList<Bid> lances) {
		if (lances.size() == 0) return null;
		Bid menorLance = lances.get(0);
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
	public void cadastraLance(ArrayList<Bid> lances, String cpf, BigDecimal valor, BigDecimal valorBase) {
		if(valor.compareTo(valorBase) <= 0) lances.add(new Bid(cpf, valor));
	}

}
