import java.util.*;

public class MenuImporta{
	Scanner entrada = new Scanner(System.in);
	TituloSecoes titulo = new TituloSecoes();
	Cores colorir = new Cores();

	public void importar(Cores colorir, ArrayList<Contato> arrayContatos) {
		String usuarioDigitado="";
		titulo.tituloPrincipal("Importacao Usuario");
		
		colorir.imprimirCiano("Digite o nome completo do usuario a ser importado: ");
		System.out.print("-> ");
		usuarioDigitado = entrada.nextLine();
	}
	
  public void menu(ArrayList<Contato>arrayContatos, BackupTXTs leituraTXTs){

		Cores colorir = new Cores();

		Boolean continuar = true;
		int opcaoUsuario;
		
		while(continuar){
			
			System.out.println("\n1) Importar Contato \n2) Voltar ao menu principal");
			System.out.print("-> ");
      opcaoUsuario = Integer.parseInt(entrada.nextLine());

			switch(opcaoUsuario) {
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