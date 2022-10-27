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
    BackupTXTs leituraTXTs = new BackupTXTs();
		ArrayList<String> listaPrefixosUsados = new ArrayList<String>();
		ArrayList<String> valoresAFormatar = new ArrayList<String>();
		MenuBusca busca = new MenuBusca();
		
		String valorSite = "";
		Boolean casoEspecial = false;
		
		
		String prefixoSite = "uindsfuhjishnfujidsnfuidsnij";
		titulo.tituloPrincipal("Importacao Usuario");

		colorir.imprimirCiano("Digite o nome completo do usuario a ser importado: ");
		System.out.print("-> ");
		usuarioDigitado = entrada.nextLine();

		if(busca.buscaNomeCompleto(usuarioDigitado, arrayContatos, colorir)!=null){
			colorir.imprimirVermelho("Usuario ja esta cadastrado no sistema!");
		} else {

			try {
				linhas = Files.readAllLines(new File(usuarioDigitado + ".vcf").toPath());
				linhas.remove(0);
				linhas.remove(0);
				linhas.remove(linhas.size() - 1);


				for (int i = 0; i < linhas.size(); i++) {
					String currentLinha = linhas.get(i);
					
					if(currentLinha.contains("X-SOCIALPROFILE;TYPE=")){
						String[] separacaoLinhaValores = {currentLinha.substring(0, currentLinha.indexOf(":")), currentLinha.substring(currentLinha.indexOf(":") + 1) };
						String[] separacaoLinhaType = separacaoLinhaValores[0].split("=");
						
						if(!separacaoLinhaType[1].equals("twitter") && !separacaoLinhaType[1].equals("linkedin") && !separacaoLinhaType[1].equals("instagram") && !separacaoLinhaType[1].equals("youtube")){
							valorSite = separacaoLinhaValores[1];
							prefixoSite = separacaoLinhaType[1];
							casoEspecial = true;
						}
					}
					
					String prefixoNovo = "X-SOCIALPROFILE;TYPE=" + prefixoSite + ":";
					
					for (int p = 0; p < listaPrefixos.length; p++) {
						String currentPrefixo = listaPrefixos[p];
						
						if(casoEspecial) {
							if(currentLinha.replace(";", "").contains(prefixoNovo.replace(";", ""))){
								listaPrefixosUsados.add(prefixoNovo);
								prefixoNovo = "uindsfuhjishnfujidsnfuidsnij";
								
							}
						} else {
							if (currentLinha.replace(";", "").contains(currentPrefixo.replace(";", ""))) {
								listaPrefixosUsados.add(listaPrefixos[p]);
								listaPrefixos[p] = "uindsfuhjishnfujidsnfuidsnii";
								
		          }
						} 
		      }
				}
		
				String[] novaListaPrefixosVazios = {"FN;CHARSET=UTF-8:", "N;CHARSET=UTF-8:;;;;", "GENDER:", "BDAY:", "EMAIL;CHARSET=UTF-8;type=HOME,INTERNET:", "TEL;TYPE=CELL:", "TEL;TYPE=HOME,VOICE:", "LABEL;CHARSET=UTF-8;TYPE=HOME:", "ADR;CHARSET=UTF-8;TYPE=WORK:;;", "ADR;CHARSET=UTF-8;TYPE=HOME:;;;;;;", "ORG;CHARSET=UTF-8:", "ROLE;CHARSET=UTF-8:", "URL;type=WORK;CHARSET=UTF-8:", "X-SOCIALPROFILE;TYPE=twitter:", "X-SOCIALPROFILE;TYPE=linkedin:", "X-SOCIALPROFILE;TYPE=instagram:", "X-SOCIALPROFILE;TYPE=youtube:", "X-SOCIALPROFILE;TYPE="+":" };
		
				for(int i = 0; i < novaListaPrefixosVazios.length; i ++) {					int TemIndice=0;
					
					for(int l = 0; l < listaPrefixosUsados.size(); l++) {
						String currentPrefixo = novaListaPrefixosVazios[i].replace(";", "");
						String currentPrefixoUsado = listaPrefixosUsados.get(l).replace(";", "");
						String prefixoSiteNovo = novaListaPrefixosVazios[i].split(":")[0] + prefixoSite + ":";
			
						if(casoEspecial && prefixoSiteNovo.equals("X-SOCIALPROFILE;TYPE="+prefixoSite+":")){
							currentPrefixo = currentPrefixo.replace(":", prefixoSite) + ":";
						}
		
						if(currentPrefixoUsado.equals(currentPrefixo)) {
							TemIndice = i;
						}
					}
					if(TemIndice!=i) {
						listaPrefixosUsados.add(i, "-");
					}
				}
				
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
				
		    Formatacoes formatacoes = new Formatacoes(valoresAFormatar);
		    formatacoes.setLista();
		    String[] dadosFormatados = formatacoes.getLista();
			
		    for(int i = 0; i < dadosFormatados.length; i ++) {
					if(dadosFormatados[i].equals("-")) {
						dadosFormatados[i] = "";
					}
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
					colorir.imprimirVermelho("Erro na leitura do arquivo!");
				}
	
	
				try{
					leituraTXTs.ler();
				}catch (Exception e) {
					colorir.imprimirVermelho("Erro na leitura do arquivo!");
				}
			} catch (Exception e) {
	      colorir.imprimirVermelho("Arquivo não encontrado!");
			}
		}
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