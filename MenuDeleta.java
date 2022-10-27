import java.util.*;
import java.io.*;

public class MenuDeleta{
	TituloSecoes titulo = new TituloSecoes();

	public void apaga(Cores colorir, String nomeDesejado, ArrayList<Contato>arrayContatos){
		DeletarArquivo deletarArquivo = new DeletarArquivo();


		//1- apagar de dentro do arrayContatos
		
		for(int i = 0; i < arrayContatos.size(); i++) {
			if(arrayContatos.get(i).getNome().equals(nomeDesejado)){
				arrayContatos.remove(i);
			}
		}
		
		//2- apagar o vcf e o txt

		deletarArquivo.deletarArquivo(nomeDesejado+".vcf");
		deletarArquivo.deletarArquivo("Contatos.txt");

		//3- reescrever txt com base no arrayContatos e ser feliz

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
	}
	
	public void deletar(Cores colorir, String nomeDesejado, ArrayList<Contato>arrayContatos, Boolean continuar) {
		Scanner entrada = new Scanner(System.in);
		MenuBusca busca = new MenuBusca();
		char escolha;
		
		titulo.tituloPrincipal("Deleta Usuario");
		
		colorir.imprimirCiano("Digite o nome do contato a ser deletado: ");
		System.out.print("-> ");
		nomeDesejado = entrada.nextLine();
		
		if(busca.buscaNomeCompleto(nomeDesejado, arrayContatos, colorir) != null){

			colorir.imprimirAmarelo("Tem certeza que deseja deletar o contato " + nomeDesejado + "? (s ou n)");
			System.out.print("-> ");
			escolha = entrada.next().charAt(0);

			switch(escolha) {
				case 's':
					apaga(colorir, nomeDesejado, arrayContatos);
					break;
				case 'n':
          continuar = false;
					titulo.tituloVoltar();
					break;
			}
			
			
		} else {
			colorir.imprimirVermelho("Não há contatos com esse nome."); 
		}
	}
	
	public void menu(ArrayList<Contato> arrayContatos) {
		Cores colorir = new Cores();
		String nomeDesejado="";
		Scanner entrada = new Scanner(System.in);

		Boolean continuar = true;
		int opcaoUsuario;
		
		while(continuar){
			System.out.println("\n1) Deletar Contato \n2) Voltar ao menu principal");
			System.out.print("-> ");
      opcaoUsuario = Integer.parseInt(entrada.nextLine());

			switch(opcaoUsuario) {
				case 1:
					deletar(colorir, nomeDesejado, arrayContatos, continuar);
					break;
				case 2:
					continuar = false;
					titulo.tituloVoltar();
					break;
			}
		}
	}
}