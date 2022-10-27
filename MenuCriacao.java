import java.util.*;
import java.io.*;

// Fazer uma classe mae dessa daqui.
// Extender ela e por fim chamar a variavel "campos" pelo super.
// Mudar o nome deste arquivo para MenuCriacao.
// Achar um nome melhor para CriacaoArquivo.java

public class MenuCriacao{
	public void menu(ArrayList<Contato>arrayContatos, BackupTXTs leituraTXTs) throws Exception{
		CamposMenu menu = new CamposMenu();
		TituloSecoes titulo = new TituloSecoes();
		String [] campos = menu.getCampos();
		String[] valores = new String[campos.length];
		Scanner entrada = new Scanner(System.in);
		String valorDigitado = "";
		MenuBusca menuBusca = new MenuBusca();
		Cores colorir = new Cores();
		
		titulo.tituloPrincipal("Cria Usuario");

		for (int i = 0; i < campos.length; i++) {
			if (i == 0 || i == 1 || i == 2 || i == 3) {
        
				  System.out.println("\n" + (i + 1) + ") *Adicionar " + campos[i] + ": ");
          valorDigitado = entrada.nextLine();
        
			} else {
				System.out.println("\n" + (i + 1) + ") Adicionar " + campos[i] + ": ");
        valorDigitado = entrada.nextLine();
			}
			valores[i] = valorDigitado;
		}

		
		
		Contato contato = new Contato(valores[0], valores[1], valores[2], valores[3]);
		ArquivoCriacao criarArquivo = new ArquivoCriacao(contato);
		contato.setAll(valores);

		String nomeContatoAtual = contato.getNome();

		if(menuBusca.buscaNomeCompleto(nomeContatoAtual, arrayContatos, colorir) != null) {
			colorir.imprimirVermelho("Ja existe um contato com esse nome!");
			colorir.imprimirVermelho("Contato nao adicionado no sistema!");
		} else {
			criarArquivo.criar();

			System.out.println();
			System.out.println("Arquivo criado com sucesso!");
			System.out.println();
	    
			leituraTXTs.ler();
		}
		

	}
}