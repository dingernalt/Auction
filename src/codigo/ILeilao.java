package codigo;

import java.math.BigDecimal;
import java.util.List;

public interface ILeilao {
	public void regBid(String cpf, BigDecimal valor);
	public List<Bid> getBids();
	public String toString();
	public String reservePrice();
	public Bid winner() throws ClosedAuctionExecption;
}
