import br.com.entitys.Pessoa;
import br.com.impl.DataNormalization;

public class Main {

	public static void main(String[] args) {
		
		Pessoa pessoa = DataNormalization.of(new Pessoa("rodrigo mendes"), Pessoa.class).apply().value();
		System.out.println(pessoa.getNome());

	}

}
