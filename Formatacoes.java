import java.util.*;


public class Formatacoes{

	List<String> listaValores = new ArrayList<String>();

  List<String> listaFormatados = new ArrayList<String>();
	
	Formatacoes(List<String> lista) {
		this.listaValores = lista;
	}

	
	public void imprimirListaValores(){
		for(int i = 0; i < this.listaValores.size(); i++) {
			System.out.println(this.listaValores.get(i));	
		}
  }

  public void formatarPrimeiroNome(){
		System.out.println(listaValores.get(1));
    String[] partes = listaValores.get(1).split(";");
    listaFormatados.add(partes[1]);
    
  }

  public void formatarNomeMeio(){
		
		System.out.println("Algo: " + listaValores.get(1).split(";", -1)[2]);
	  String[] partes = listaValores.get(1).split(";", -1);	
		
    listaFormatados.add(partes[2]);
		
    
  }

  public void formatarUltimoNome(){
    String[] partes = listaValores.get(1).split(";");
    listaFormatados.add(partes[0]);
    
  }
  
  public void formatarGenero(){
    listaFormatados.add(listaValores.get(2));
    
  }
  
  public void formatarAno(){

    if(listaValores.get(3).equals("-")){
      listaFormatados.add("-");
    }else{
      listaFormatados.add(String.valueOf(listaValores.get(3).charAt(0)) + String.valueOf(listaValores.get(3).charAt(1)) + String.valueOf(listaValores.get(3).charAt(2)) + String.valueOf(listaValores.get(3).charAt(3)));
    }
  }

  public void formatarMes(){
    if(listaValores.get(3).equals("-")){
      listaFormatados.add("-");
    }else{
      listaFormatados.add(String.valueOf(listaValores.get(3).charAt(4)) + String.valueOf(listaValores.get(3).charAt(5)));
    }
  }

  public void formatarDia(){
    if(listaValores.get(3).equals("-")){
      listaFormatados.add("-");
    }else{
      listaFormatados.add(String.valueOf(listaValores.get(3).charAt(6)) + String.valueOf(listaValores.get(3).charAt(7)));
    }
    
  }

  public void formatarEmail(){
    listaFormatados.add(listaValores.get(4)) ;
    
  }

  public void formatarTelefonePessoal(){
    listaFormatados.add(listaValores.get(5)) ;   
    
  }

  public void formatarTelefoneFixo(){
    listaFormatados.add(listaValores.get(6)) ;   
    
  }

  public void formatarTipoResidencia(){
    listaFormatados.add(listaValores.get(7)) ;  
    
  }

  public void formatarEndereco(){
    if (listaValores.get(9).equals("-")){
      listaFormatados.add("-");
    }else{
      String[] partes = listaValores.get(9).split(";", -1);
      listaFormatados.add(partes[2]) ;  
    }
  }

  public void formatarCidade(){
    if (listaValores.get(9).equals("-")){
      listaFormatados.add("-");
    }else{
      String[] partes = listaValores.get(9).split(";", -1);
      listaFormatados.add(partes[3]);
    }
  }

  public void formatarEstado(){
    if (listaValores.get(9).equals("-")){
      listaFormatados.add("-");
    }else{
      String[] partes = listaValores.get(9).split(";", -1);
      listaFormatados.add(partes[4]);
    }
  }

  public void formatarPais(){
    if (listaValores.get(9).equals("-")){
      listaFormatados.add("-");
    }else{
      String[] partes = listaValores.get(9).split(";", -1);
      listaFormatados.add(partes[6]);
    }
  }

  public void formatarCEP(){
    if (listaValores.get(9).equals("-")){
      listaFormatados.add("-");
    }else{
      String[] partes = listaValores.get(9).split(";", -1);
      listaFormatados.add(partes[5]);
    }
  }

  public void formatarEtiquetaComercial(){
    listaFormatados.add(listaValores.get(10)) ;    
    
  }

  public void formatarEnderecoComercial(){
    if(listaValores.get(8).equals("-")){
      listaFormatados.add(listaValores.get(8));
    } else {
    	String[] partes = listaValores.get(8).split(";", -1);
    	listaFormatados.add(partes[2]);  
		}
  }

  public void formatarEmprego(){
    listaFormatados.add(listaValores.get(11));
    
  }

  public void formatarSiteEmpresarial(){
    listaFormatados.add(listaValores.get(12));  
    
  }

  public void formatarTwitter(){
    listaFormatados.add(listaValores.get(13));   
    
  }

  public void formatarLinkedin(){
    listaFormatados.add(listaValores.get(14));  
    
  }

  public void formatarInstagram(){
    listaFormatados.add(listaValores.get(15));   
    
  }

  public void formatarYoutube(){
    listaFormatados.add(listaValores.get(16));    
    
  }

  public void formatarNomeSitePessoal(){
    listaFormatados.add(listaValores.get(18));
    
  }
  
  public void formatarEnderecoSitePessoal(){
    listaFormatados.add(listaValores.get(17));
    
  }

  public String[] getLista(){		
    String[] listaFormatadosFinal = new String[listaFormatados.size()];
    for(int i = 0; i < listaFormatados.size(); i++){
      listaFormatadosFinal[i] = listaFormatados.get(i);
    }
      return listaFormatadosFinal;
  }

	public void setLista() {
		formatarPrimeiroNome(); 
    formatarUltimoNome(); 
    formatarTelefonePessoal();
    formatarEmail();
    formatarTelefoneFixo();
    formatarDia();
    formatarMes();
    formatarAno();
    formatarGenero();
    formatarNomeMeio();
    formatarTipoResidencia();
    formatarEtiquetaComercial();
    formatarEnderecoComercial(); 
    formatarEndereco();
    formatarCidade();
    formatarEstado();
    formatarPais();
    formatarCEP();
    formatarEmprego();
    formatarSiteEmpresarial();
    formatarTwitter();
    formatarLinkedin();
    formatarInstagram();
    formatarYoutube();    
    formatarNomeSitePessoal();
    formatarEnderecoSitePessoal();
	}
}