import java.util.*;
import java.io.*;

public class MenuEdita{
  public void menu(ArrayList<Contato>arrayContatos, BackupTXTs leituraTXTs) throws Exception{
		CamposMenu menu = new CamposMenu();
    DeletarArquivo deletarArquivo = new DeletarArquivo();
		MenuBusca menuBusca = new MenuBusca();
		String [] campos = menu.getCampos();
		String[] valores = new String[campos.length];
		Scanner entrada = new Scanner(System.in);
    String valorDigitado;
		String nomeDesejado = "";
		Cores colorir = new Cores();
		TituloSecoes titulo = new TituloSecoes();

		Boolean continuar = true;
		int opcaoUsuario;
		
		while(continuar){
			System.out.println("\n1) Editar Contato \n2) Voltar ao menu principal");
			System.out.print("-> ");
      opcaoUsuario = Integer.parseInt(entrada.nextLine());

			switch(opcaoUsuario) {
				case 1:
					titulo.tituloPrincipal("Edicao de Usuario");

		      System.out.println("Digite o usuario a ser editado: ");
      		nomeDesejado = entrada.nextLine();
      
      		Contato contato = menuBusca.buscaNomeCompleto(nomeDesejado, arrayContatos, colorir);
      
      		System.out.println();
      		colorir.imprimirAmarelo("Digite '-' caso queira eliminar o valor do campo");
      		colorir.imprimirAmarelo("Deixe em branco caso queira manter o valor do campo");
      		if(contato != null){
      			for (int i = 0; i < campos.length; i++) {
      				System.out.println("\n" + (i + 1) + ") Editar " + campos[i] + "(" +           
  contato.getAll()[i] + ")" + ": ");
      				valorDigitado = entrada.nextLine();
      
      				if(valorDigitado == "") {
      					valores[i] = contato.getAll()[i];
      				} else if(valorDigitado == "-") {
      					valores[i] = "";
      				} else {
      					valores[i] = valorDigitado;
      				}
      			}
      
            for(int i = 0; i < arrayContatos.size(); i++) {
      				if(arrayContatos.get(i).getNome().equals(nomeDesejado)){
                arrayContatos.remove(i);
      				}
      			}


      			contato.setAll(valores);
						String nomeAtualEditado = contato.getNome();
      			if(menuBusca.buscaNomeCompleto(nomeAtualEditado, arrayContatos, colorir) != null) {
							colorir.imprimirVermelho("Ja existe um contato com esse nome!");
							colorir.imprimirVermelho("Contato nao adicionado no sistema!");
						} else {
							deletarArquivo.deletarArquivo(nomeDesejado+".vcf");
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
						}
					} else {
						colorir.imprimirVermelho("Nenhum usuario encontrado!");
					}
					break;
				case 2:
					continuar = false;
					titulo.tituloVoltar();
					break;
			}
		}		
	}
}
	