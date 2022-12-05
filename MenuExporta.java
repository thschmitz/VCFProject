import java.io.*;
import java.util.*;
public class MenuExporta{
  
  
  Scanner entrada = new Scanner(System.in);
	TituloSecoes titulo = new TituloSecoes();
	Cores colorir = new Cores();
  Prefixos prefixos;
  Contato contato;

	  public void menu(ArrayList<Contato> arrayContatos, BackupTXTs leituraTXTs) {
  		MenuBusca menuBusca = new MenuBusca();
      
      String usuarioDigitado = "";    
      Boolean continuar = true, temArquivo=false;
		  int opcaoUsuario;
		
		while(continuar){
			System.out.println("\n1) Exportar Contato \n2) Voltar ao menu principal");
			System.out.print("-> ");
      opcaoUsuario = Integer.parseInt(entrada.nextLine());

			switch(opcaoUsuario) {
				case 1:

        	titulo.tituloPrincipal("Exportacao Usuario");
	  
	  		  colorir.imprimirCiano("Digite o nome completo do usuario a ser exportado: ");
	    		System.out.print("-> ");
	    		usuarioDigitado = entrada.nextLine();
					try{
						InputStream arquivo = new FileInputStream(usuarioDigitado + ".vcf");	
						Scanner entradaArquivo = new Scanner(arquivo);
	
						if(entradaArquivo.hasNextLine()) {
							temArquivo = true;
						}
					} catch (IOException e) {
						
					}
	
					for(int i = 0; i < arrayContatos.size(); i++) {
						if(arrayContatos.get(i).getNome().equals(usuarioDigitado)){            
							this.contato = menuBusca.buscaNomeCompleto(usuarioDigitado, arrayContatos, colorir);
							try {
								ArquivoCriacao arquivoCriacao = new ArquivoCriacao(contato);
								File file = new File(usuarioDigitado + ".vcf");
								file.createNewFile();
								FileWriter fileWriter = new FileWriter(usuarioDigitado + ".vcf");
								prefixos = new Prefixos(contato);
					
								arquivoCriacao.valoresVcf(fileWriter, prefixos);
					
								fileWriter.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							if(temArquivo) {
								colorir.imprimirVerde("VCF recriado com sucesso!");	
							}else{
								colorir.imprimirVerde("VCF criado com sucesso!");	
							}             
						}          
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