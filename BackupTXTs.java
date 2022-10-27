import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class BackupTXTs {
	ArrayList<Contato> arrayContatos = new ArrayList<Contato>();
  Cores colorir = new Cores();
	
	public void ler() throws Exception {
		CamposMenu campos = new CamposMenu();
    int numeroContatos = this.arrayContatos.size();
    for(int i = numeroContatos - 1; i >= 0 ; i--) {
			this.arrayContatos.remove(i);
		}
		
		try {
			int contador = 0;
			InputStream arquivo = new FileInputStream("Contatos.txt");
			Scanner entradaArquivo = new Scanner(arquivo);
			String listaValores[];
			int qtdCampos = campos.getCampos().length;
			BufferedReader reader;
			reader = new BufferedReader(new FileReader("Contatos.txt"));

			listaValores = new String[qtdCampos];
			entradaArquivo.nextLine();
	
			String line = reader.readLine();			
			line = reader.readLine();
			while (entradaArquivo.hasNextLine() && line != null) {
				if (line.equals("Inicio")) {
					Contato contato = new Contato();
					contato.setAll(listaValores);
					this.arrayContatos.add(contato);
					listaValores = new String[qtdCampos];
					contador = 0;
				} else {
					if(line.equals("-")) {
						line = "";
					}
					listaValores[contador] = line;
					entradaArquivo.nextLine();
					contador++;
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			colorir.imprimirVermelho("Erro na leitura do arquivo!");
		}
	}

	public ArrayList<Contato> getArrayContatos() {
		return this.arrayContatos;
	}
}