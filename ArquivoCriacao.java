import java.io.*;
import java.util.ArrayList;

public class ArquivoCriacao {
	Contato contato;
	Prefixos prefixos;
	CamposMenu menu = new CamposMenu();

	ArquivoCriacao(Contato contato) {
		this.contato = contato;
	}

	public void valoresVcf(FileWriter fileWriter, Prefixos prefixos) {
		String[] valores = prefixos.prefixarAll();
		String[] prefixosVazios = prefixos.getListaVazios();
		ArrayList<String> testePrefixosVazios = new ArrayList<String>();

		for (int i = 0; i < prefixosVazios.length; i++) {
			testePrefixosVazios.add(prefixosVazios[i]);
		}

		for (int i = 0; i < valores.length; i++) {
			if (!testePrefixosVazios.contains(valores[i])) {
				try {
          if(!valores[i].equals("-")){
						fileWriter.write(valores[i]);
						fileWriter.write(System.lineSeparator());
          }
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void criar() {
		criarArquivoTxt();
  }

	public void criarArquivoTxt() {

		try {
			FileWriter fw = new FileWriter("Contatos.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.newLine();
			for (int i = 0; i < contato.getAll().length; i++) {
				if (contato.getAll()[i].equals("")) {
					bw.write("-");	
				} else {
					bw.write(contato.getAll()[i]);
				}
				bw.newLine();
			}
			bw.write("Inicio");

			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}