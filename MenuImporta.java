import java.util.*;
import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class MenuImporta {
	Scanner entrada = new Scanner(System.in);
	TituloSecoes titulo = new TituloSecoes();
	Cores colorir = new Cores();

	public void importar(Cores colorir, ArrayList<Contato> arrayContatos) {
		String usuarioDigitado = "";
		Contato contato = new Contato();
    DeletarArquivo deletarArquivo = new DeletarArquivo();
		List<String> linhas = new ArrayList<>();
		Prefixos prefixos = new Prefixos();
		String[] listaPrefixos = prefixos.getListaVazios();
		ArrayList<String> listaPrefixosUsados = new ArrayList<String>();
		ArrayList<String> valoresAFormatar = new ArrayList<String>();
		
		String valorSite = "";
		Boolean casoEspecial = false;
		
		
		String prefixoSite = "uindsfuhjishnfujidsnfuidsnij";
		titulo.tituloPrincipal("Importacao Usuario");

		colorir.imprimirCiano("Digite o nome completo do usuario a ser importado: ");
		System.out.print("-> ");
		usuarioDigitado = entrada.nextLine();

		// FAZER VERIFICAÇÃO SE ESSE VCF JÁ EXISTE

		// 1 - ler o amigo

		try {
			linhas = Files.readAllLines(new File(usuarioDigitado + ".vcf").toPath());
			linhas.remove(0);
			linhas.remove(0);
			linhas.remove(linhas.size() - 1);
		} catch (Exception e) {
      colorir.imprimirVermelho("Arquivo não encontrado!");
		}

		// 2 - verificar se contem o prefixo dentro da array, se sim adiciona em lista,
		// se não adiciona risco (-)


		for (int i = 0; i < linhas.size(); i++) {
			String currentLinha = linhas.get(i);
			
			if(currentLinha.contains("X-SOCIALPROFILE;TYPE=")){
				String[] separacaoLinhaValores = currentLinha.split(":");
				String[] separacaoLinhaType = separacaoLinhaValores[0].split("=");
				
				if(!separacaoLinhaType[1].equals("twitter") && !separacaoLinhaType[1].equals("linkedin") && !separacaoLinhaType[1].equals("instagram") && !separacaoLinhaType[1].equals("youtube")){
					valorSite = separacaoLinhaValores[1];
					prefixoSite = separacaoLinhaType[1];
					casoEspecial = true;
					// linhas.add(prefixoSite);
				}
			}
			
			String prefixoNovo = "X-SOCIALPROFILE;TYPE=" + prefixoSite + ":";
			
			for (int p = 0; p < listaPrefixos.length; p++) {
				String currentPrefixo = listaPrefixos[p];
				
				if(casoEspecial) {
					if(currentLinha.replace(";", "").contains(prefixoNovo.replace(";", ""))){
						listaPrefixosUsados.add(prefixoNovo);
						prefixoNovo = "uindsfuhjishnfujidsnfuidsnij";
						System.out.println("Colocou palavra");
					}
				} else {
					if (currentLinha.replace(";", "").contains(currentPrefixo.replace(";", ""))) {
						listaPrefixosUsados.add(listaPrefixos[p]);
						listaPrefixos[p] = "uindsfuhjishnfujidsnfuidsnii";
						System.out.println("Colocou palavra");
          }
				} 
      }
		}
		
		// PROBLEMA
		for(int i = 0; i < listaPrefixos.length; i ++) {
			int naoTemIndice=0;
			String naoTem2 = "";
			
			for(int l = 0; l < listaPrefixosUsados.size(); l++) {
				String currentPrefixo = listaPrefixos[i].replace(";", "");
				String currentPrefixoUsado = listaPrefixosUsados.get(l).replace(";", "");
				String prefixoSiteNovo = listaPrefixos[i].split(":")[0] + prefixoSite + ":";

				String prefixoCurrentSiteNovo = listaPrefixos[i].split(":")[0] + prefixoSite + ":";
				
				if(!currentPrefixo.contains(currentPrefixoUsado)){
					if(casoEspecial){
						if(!prefixoCurrentSiteNovo.replace(";", "").contains(prefixoSiteNovo.replace(";", ""))){
							naoTemIndice = i;	
							naoTem2 = listaPrefixos[i];	
						}
					} else {
						if(!listaPrefixos[i].equals("uindsfuhjishnfujidsnfuidsnii")) {
							naoTemIndice = i;
							naoTem2 = listaPrefixos[i];
						}
					}
				}
			}

			if(naoTemIndice!=0) {
				System.out.println(naoTemIndice);	
				listaPrefixosUsados.add(naoTemIndice, "-");
			}
		}

		System.out.println("------------------------");
/*		System.out.println(listaPrefixos.length);

		for(int i = 0; i < listaPrefixosUsados.size(); i++) {
			System.out.println(listaPrefixosUsados.get(i).split(":")[0].replace(";", ""));
		}
		
		System.out.println("------------------------");
		
		for(int i = 0; i < linhas.size(); i++) {
			System.out.println(linhas.get(i).split(":")[0].replace(";", ""));
		}
		System.out.println("------------------------");*/
		
		for (int i = 0; i < listaPrefixos.length; i++) {

			String currentPrefixo = listaPrefixosUsados.get(i).split(":")[0].replace(";", "");
			String currentLinha="";
			String currentValor="";

			if(currentPrefixo.equals("-")) {
				valoresAFormatar.add("-");
			} else {
				for(int j = 0; j < linhas.size(); j++){	
					currentLinha = linhas.get(j).split(":")[0].replace(";", "");
					currentValor = linhas.get(j).split(":")[1];

					

					if(currentLinha.equals(currentPrefixo)) {
	
						valoresAFormatar.add(currentValor);
						
					}
				}
			}
		}

		if(casoEspecial){
			valoresAFormatar.add(prefixoSite);
		} else {
			valoresAFormatar.add("-");
		}

    
		for(int j = 0; j < valoresAFormatar.size(); j ++) {
			System.out.println("ValoresFinais: " + valoresAFormatar.get(j));
		}
    
    /*
		
    Formatacoes formatacoes = new Formatacoes(valoresAFormatar);
    formatacoes.setLista();
    String[] dadosFormatados = formatacoes.getLista();

    for(int k = 0; k < dadosFormatados.lenght; k++) {
      System.out.println(dadosFormatados[k]);
    }
    

    contato.setAll(dadosFormatados);
      			

            deletarArquivo.deletarArquivo("Contatos.txt");
      			
            arrayContatos.add(contato);
            
      			try {
      				FileWriter fw = new FileWriter("Contatos.txt", true);
      				BufferedWriter bw = new BufferedWriter(fw);
      	
      	      bw.write("Inicio");
      				bw.newLine();
      	      for (int i = 0; i < arrayContatos.size(); i++) {
      	  			for (int j = 0; j < arrayContatos.get(0).getAll().length; j++) {
      	  				if (arrayContatos.get(i).getAll()[j].equals("")) {
      	  					bw.write("-");	
      	  				} else {
      	  					bw.write(arrayContatos.get(i).getAll()[j]);
      	  				}
      	  				bw.newLine();
      	  			}
      	  			bw.write("Inicio");
                if(i != arrayContatos.size() - 1){
                  bw.newLine();
                }
      	      }
      				bw.close();
      				fw.close();
      			} catch (IOException e) {
      				e.printStackTrace();
      			}
      
      
      			
      		leituraTXTs.ler();

    */
    
	}

	public void menu(ArrayList<Contato> arrayContatos, BackupTXTs leituraTXTs) {

		Cores colorir = new Cores();

		Boolean continuar = true;
		int opcaoUsuario;

		while (continuar) {

			System.out.println("\n1) Importar Contato \n2) Voltar ao menu principal");
			System.out.print("-> ");
			opcaoUsuario = Integer.parseInt(entrada.nextLine());

			switch (opcaoUsuario) {
				case 1:
					importar(colorir, arrayContatos);
					break;
				case 2:
					continuar = false;
					titulo.tituloVoltar();
					break;
			}
		}
	}
}