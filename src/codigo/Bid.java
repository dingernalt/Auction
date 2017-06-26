package codigo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Bid {
	public String id();
	public BigDecimal value();
	public LocalDateTime time();
}
