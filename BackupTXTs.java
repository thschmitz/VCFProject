import java.io.*;
import java.util.*;

public class BackupTXTs {
	ArrayList<Contato> arrayContatos = new ArrayList<Contato>();
	
	public void ler() throws Exception {
    int numeroContatos = this.arrayContatos.size();
    for(int i = numeroContatos - 1; i >= 0 ; i--) {
			this.arrayContatos.remove(i);
		}
		
		try {
			int contador = 0;
			InputStream arquivo = new FileInputStream("Contatos.txt");
			Scanner entradaArquivo = new Scanner(arquivo);
			String listaValores[];

			listaValores = new String[26];
			entradaArquivo.nextLine();
			
			while (entradaArquivo.hasNextLine()) {
				String valorLido = entradaArquivo.next();
				if (valorLido.equals("Inicio")) {
					Contato contato = new Contato();
					contato.setAll(listaValores);
					this.arrayContatos.add(contato);
					listaValores = new String[26];
					contador = 0;
					if (entradaArquivo.hasNextLine()) {
						entradaArquivo.nextLine();
						valorLido = entradaArquivo.next();
					} else {
						break;
					}
				}

				if(valorLido.equals("-")) {
					valorLido = "";
				}
				
				listaValores[contador] = valorLido;
				entradaArquivo.nextLine();
				contador++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Contato> getArrayContatos() {
		return this.arrayContatos;
	}
}