package codigo;
//oi
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao implements ILeilao{
	private final LeilaoStrategy tipoLeilao;
	private final LocalDateTime horaInicio;
	private final LocalDateTime horaFinal;
	private final BigDecimal valorBase;
	private final String criador;
	private final String bens;
	private ArrayList<Lance> lances;
	private boolean aberto;
	
	public Leilao(LocalDateTime horaInicio, LocalDateTime horaFinal, BigDecimal valorBase, String criador,
			String bens, boolean oferta, boolean aberto) {
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.valorBase = valorBase;
		this.criador = criador;
		this.bens = bens;
		tipoLeilao = LeilaoFactory.criaLeilao(oferta);
		this.aberto = aberto;
		lances = new ArrayList<>();
	}
	/*
	 * if (horaInicio.compareTo(LocalDateTime.now()) < 0 || horaFinal.compareTo(LocalDateTime.now()) > 0){
			
		}
	 * */
	
	public void cadastraLance(String cpf, BigDecimal valor) {
		tipoLeilao.cadastraLance(lances, cpf, valor, valorBase);
		
	}
	
	public List<Lance> getLances(){
		return Collections.unmodifiableList(lances);
	}

	public String getVencedor() throws LeilaoFechadoException {
		if (!aberto) throw new LeilaoFechadoException("Leilão Fechado");
		Lance vencedor = tipoLeilao.getVencedor(lances);
		if(vencedor == null) return "Não houve vencedor";
		return vencedor.getCpf()+" - Lance: "+vencedor.getValor();
	}
	
	public String descricaoLeilao(){
		String s = criador+"\n";
		s = s + "Item(s) vendido(s): "+ bens+"\n";
		s = s + "Tipo Leilão: "+tipoLeilao.tipoLeilao()+(aberto? " Aberto\n" : " Fechado\n");
		s = s + tipoLeilao.valorBase()+": "+valorBase+"\n";
		s = s + "Data Inicio: "+horaInicio.toString()+"  -  Data Termino: "+horaFinal.toString();
		return s;			
	}
	
}
