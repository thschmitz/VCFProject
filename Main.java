import java.util.*;


class Main {
	public static void main(String[] args) throws Exception {
		Scanner entrada = new Scanner(System.in);
		Boolean menuPrincipalContador = true;
		int opcaoUsuario;
		MenuCriacao menuCriacao = new MenuCriacao();
		MenuBusca menuBusca = new MenuBusca();
		MenuDeleta menuDeleta = new MenuDeleta();
		MenuEdita menuEdita = new MenuEdita();
		MenuImporta menuImporta = new MenuImporta();
    MenuExporta menuExporta = new MenuExporta();
		BackupTXTs leituraTXTs = new BackupTXTs();
		TituloSecoes titulo = new TituloSecoes();
		leituraTXTs.ler();
		
		ArrayList<Contato> arrayContatos = leituraTXTs.getArrayContatos();


		while (menuPrincipalContador) {
			titulo.tituloPrincipal("Opcoes");
			System.out.println("O que voce deseja fazer?: " + "\n1) Cadastrar Usuario \n2) Visualizar Usuario \n3) Deletar Usuario \n4) Editar Usuario \n5) Importar Usuario \n6) Exportar Usuario \n7) Desconectar");
			System.out.print("-> ");
			opcaoUsuario = entrada.nextInt();

			switch (opcaoUsuario) {
				case 1:
					menuCriacao.menu(arrayContatos, leituraTXTs);
					break;
				case 2:
					menuBusca.menu(arrayContatos, leituraTXTs);
					break;
				case 3:
					menuDeleta.menu(arrayContatos);
					break;
				case 4:
					menuEdita.menu(arrayContatos, leituraTXTs);
					break;
				case 5:
					menuImporta.menu(arrayContatos, leituraTXTs);
					break;
        case 6:
          menuExporta.menu(arrayContatos, leituraTXTs);
          break;
				case 7:
					menuPrincipalContador = false;
					System.out.println("Obrigado por usar o sistema");
					break;
				default:
					System.out.println("Digite um valor valido");
			}
		}
	}
}
