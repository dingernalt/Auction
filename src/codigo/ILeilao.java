package codigo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import deprecated.Bid;

public interface ILeilao {
	public void regBid(String cpf, BigDecimal valor);
	public String winner() throws ClosedAuctionExecption;
	public List<String> getBids();
	public String toString();
	public String reservePrice();
	public Bid winner(ArrayList<Bid> lances);	
}
