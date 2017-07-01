package codigo;
//oi
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import deprecated.Bid;

public class Auction implements ILeilao{
	//private final LeilaoStrategy tipoLeilao;
	private final LocalDateTime startTtime;
	private final LocalDateTime endTime;
	private final BigDecimal reserve;
	private final String seller;
	private final String goods;	
	private final Openess check;
	private final BidType type;
	private ArrayList<Bid> bids;
	private boolean closed;
	
	public static enum BidType {
		Supply, Demand;
	}
	
	public static enum Openess {
		Open, Closed;
	}
	
	private class Bidding implements Bid {
		private final String id;
		private final BigDecimal value;
		private final LocalDateTime time;
		
		public Bidding(String id, BigDecimal value, LocalDateTime time) {
			super();
			this.id = id;
			this.value = value;
			this.time = time;
		}

		@Override
		public String id() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal value() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public LocalDateTime time() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public Auction(LocalDateTime horaInicio, LocalDateTime horaFinal, BigDecimal valorBase, String criador, String bens, BidType type, Openess check) {
		this.startTtime = horaInicio;
		this.endTime = horaFinal;
		this.reserve = valorBase;
		this.seller = criador;
		this.goods = bens;
		tipoLeilao = LeilaoFactory.criaLeilao(type);
		if(type.equals(BidType.Supply)) tipoLeilao = 
		this.check = check;
		bids = new ArrayList<Bid>();
	}	
	
	/*
	 * if (horaInicio.compareTo(LocalDateTime.now()) < 0 || horaFinal.compareTo(LocalDateTime.now()) > 0){
			
		}
	 * */
	
	public void cadastraLance(String cpf, BigDecimal valor) {
		tipoLeilao.cadastraLance(lances, cpf, valor, reserve);
		
	}
	
	public List<Bid> getLances(){
		return Collections.unmodifiableList(lances);
	}

	public String getVencedor() throws LeilaoFechadoException {
		if (check.equals(Openess.Closed)) throw new LeilaoFechadoException("Leilão Fechado");
		Bid vencedor = tipoLeilao.getVencedor(bids);
		if(vencedor == null) return "Não houve vencedor";
		return vencedor.getCpf()+" - Lance: "+vencedor.getValor();
	}
	
//	public String toString(){
//		String s = seller+"\n";
//		s = s + "Item(s) vendido(s): "+ goods+"\n";
//		s = s + "Tipo Leilão: "+tipoLeilao.tipoLeilao()+(aberto? " Aberto\n" : " Fechado\n");
//		s = s + tipoLeilao.valorBase()+": "+reserve+"\n";
//		s = s + "Data Inicio: "+horaInicio.toString()+"  -  Data Termino: "+horaFinal.toString();
//		return s;			
//	}

	@Override
	public void regBid(String cpf, BigDecimal valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bid> getBids() {
		return Collections.unmodifiableList(bids);
	}

	@Override
	public String reservePrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bid winner() throws ClosedAuctionExecption{
		if (bids.size() == 0) return null;
		Bid aux = null;
		switch(type) {
			
			case Demand: 
				aux = bids.get(0);
				for(int i = 1; i < bids.size(); i++) {
					if(bids.get(i).value().compareTo(aux.value()) >  0) {
						aux = bids.get(i);
					}
				}
				break;				
			case Supply: 
				aux = bids.get(0);
				for(int i = 1; i < bids.size(); i++) {
					if(bids.get(i).value().compareTo(aux.value()) <  0) {
						aux = bids.get(i);
					}
				}
				break;
			default:
				break; 
		}
		return aux;
	}
	
}
