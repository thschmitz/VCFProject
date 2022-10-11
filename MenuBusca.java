import java.util.*;

public class MenuBusca {
  Scanner entradaEspecifico = new Scanner(System.in);
	Scanner entrada = new Scanner(System.in);
	Cores colorir = new Cores();
	TituloSecoes titulo = new TituloSecoes();
	CamposMenu camposMenu = new CamposMenu();
	
  public void buscaPorLetra(ArrayList<Contato>arrayContatos, BackupTXTs leituraTXTs, Cores colorir) throws Exception{
    char letraDesejada;
    int contador = 0;

    colorir.imprimirCiano("Insira a letra desejada: ");
		System.out.print("-> ");
    letraDesejada = entrada.next().charAt(0);
    
    for(int i = 0; i < arrayContatos.size(); i++) {
      if(Character.toUpperCase(arrayContatos.get(i).getNome().charAt(0)) == Character.toUpperCase(letraDesejada)){
        colorir.imprimirVerde("- " + arrayContatos.get(i).getNome() + "\n" + arrayContatos.get(i).getNumeroCelularPessoal());
        contador++;     
      }
    }
		if(contador == 0){
      titulo.tituloSemUsuario();
    }
  }

	public Contato buscaNomeCompleto(String nomeDesejado, ArrayList<Contato>arrayContatos, Cores colorir) {
		for(int i = 0; i < arrayContatos.size(); i++) {
			if(arrayContatos.get(i).getNome().toUpperCase()
		 	.equals(nomeDesejado.toUpperCase())) {
				return arrayContatos.get(i);
			}
		}

		return null;
	}

	public void buscaPorEspecifico(ArrayList<Contato> arrayContatos, BackupTXTs leituraTXTs, Cores colorir) {
		String nomeDesejado="";
    
		colorir.imprimirCiano("Insira o nome ou sobrenome desejado:");
		System.out.print("-> ");
		nomeDesejado = entradaEspecifico.nextLine();
		System.out.println();
		Contato usuarioAchado = buscaNomeCompleto(nomeDesejado, arrayContatos, colorir);
    if(usuarioAchado == null){
      titulo.tituloSemUsuario();
    }else{
			for(int i = 0; i < usuarioAchado.getAll().length; i++){
				String campo = usuarioAchado.getAll()[i];
				if(!campo.equals("")){
					colorir.imprimirVerde(camposMenu.getCampos()[i].toUpperCase() + ": " + campo);	
				}
				
			}
    }
	}
	
	public void buscaPorAlfabeto(ArrayList<Contato>arrayContatos, BackupTXTs leituraTXTs) throws Exception{
		ArrayList<String> arrayNomesAlfabetico = new ArrayList<String>();
    ArrayList<String> arrayNumerosAlfabetico = new ArrayList<String>();
    Cores colorir = new Cores();
		for(int i = 0; i < arrayContatos.size(); i++) {
			arrayNomesAlfabetico.add(arrayContatos.get(i).getNome());
		}
    System.out.println();
    Collections.sort(arrayNomesAlfabetico, String.CASE_INSENSITIVE_ORDER);
    
    for(int i = 0; i < arrayContatos.size(); i++) {
      for(int j = 0; j < arrayContatos.size(); j++){            
        if(arrayNomesAlfabetico.get(i).equals(arrayContatos.get(j).getNome())){
          arrayNumerosAlfabetico.add(arrayContatos.get(j).getNumeroCelularPessoal());
        }
      }
    }
    
    for(int i = 0; i < arrayContatos.size(); i++) {
    	colorir.imprimirVerde(arrayNomesAlfabetico.get(i) + "\n" + arrayNumerosAlfabetico.get(i));
		}

		if(arrayContatos.size() == 0) {
			titulo.tituloSemUsuario();
		}
	}
	
  public void menu(ArrayList<Contato> arrayContatos, BackupTXTs leituraTXTs) throws Exception{

		Boolean continuar = true;
    Cores colorir = new Cores();
		int opcaoUsuario;

		while(continuar){
			titulo.tituloPrincipal("Busca de Usuario");
	
			System.out.println("Como voce deseja buscar?: " + "\n1) Por letra \n2) Especifico \n3) Em ordem Alfetica \n4) Voltar ao menu principal");
			System.out.print("-> ");
			opcaoUsuario = Integer.parseInt(entrada.next()); // Nao da para utilizar o
																				// nextInt antes do nextLine
	
			switch(opcaoUsuario){
				case 1:
					buscaPorLetra(arrayContatos, leituraTXTs, colorir);
					break;
				case 2:
					buscaPorEspecifico(arrayContatos, leituraTXTs, colorir);
					break;
				case 3:
					buscaPorAlfabeto(arrayContatos, leituraTXTs);
					break;
				case 4:
					continuar = false;
					titulo.tituloVoltar();
					break;
			}
		}
  }
}