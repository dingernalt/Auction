package codigo;

public class LeilaoFactory {
	public static LeilaoStrategy criaLeilao(boolean oferta){
		if (oferta) return new LeilaoOferta();
		return new LeilaoDemanda();
	}
}
