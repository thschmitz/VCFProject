public class Prefixos{
	private String[] listaVazios = {"FN;CHARSET=UTF-8:", "N;CHARSET=UTF-8:;;;;", "GENDER:", "BDAY:", "EMAIL;CHARSET=UTF-8;type=HOME,INTERNET:", "TEL;TYPE=CELL:", "TEL;TYPE=HOME,VOICE:", "LABEL;CHARSET=UTF-8;TYPE=HOME:", "ADR;CHARSET=UTF-8;TYPE=WORK:;;", "ORG;CHARSET=UTF-8:", "ADR;CHARSET=UTF-8;TYPE=HOME:;;;;;;", "ROLE;CHARSET=UTF-8:", "URL;type=WORK;CHARSET=UTF-8:", "X-SOCIALPROFILE;TYPE=twitter:", "X-SOCIALPROFILE;TYPE=linkedin:", "X-SOCIALPROFILE;TYPE=instagram:", "X-SOCIALPROFILE;TYPE=youtube:", "X-SOCIALPROFILE;TYPE="+":" };
  private Contato contato;
  
  Prefixos(Contato contato){
    this.contato = contato;
  }

	public String[] getListaVazios() {
		return this.listaVazios;
	}

	public String prefixarInicioArquivo() {
		return "BEGIN:VCARD";
	}

	public String prefixarVersaoArquivo() {
		return "VERSION:3.0";
	}
	
  public String prefixarNomeCompleto(){
    return "FN;CHARSET=UTF-8:" + contato.getNome();
  }

  public String prefixarNome() {
		return "N;CHARSET=UTF-8:" + contato.getUltimoNome() + ";" + contato.getPrimeiroNome() + ";" + contato.getNomeMeio()+ ";;";
	}

  public String prefixarGenero() {
    return "GENDER:" + contato.getGenero();
  }

  public String prefixarDataNascimento() {
    return "BDAY:" + contato.getAnoNascimento() + contato.getMesNascimento() + contato.getDiaNascimento();
  }

  public String prefixarEmail() {
    return "EMAIL;CHARSET=UTF-8;type=HOME,INTERNET:" + contato.getEmail();
  }

  public String prefixarCelularPessoal() {
    return "TEL;TYPE=CELL:" + contato.getNumeroCelularPessoal();
  }

  public String prefixarTelefoneFixo() {
    return "TEL;TYPE=HOME,VOICE:" + contato.getNumeroCelularFixo();
  }

  public String prefixarTipoResidencial(){
    return "LABEL;CHARSET=UTF-8;TYPE=HOME:" + contato.getTipoResidencia();
  }

	public String prefixarEnderecoComercial() {
    return "ADR;CHARSET=UTF-8;TYPE=WORK:;;" + contato.getEnderecoComercial();
  }
	
	public String prefixarEtiquetaComercial() {
		return "ORG;CHARSET=UTF-8:" + contato.getEtiquetaComercial();
	}

	// Revisar sequencia de informacoes
	public String prefixarTipoEndereco(){
		return "ADR;CHARSET=UTF-8;TYPE=HOME:;;" + contato.getEndereco() + ";" + contato.getCidade() + ";" + contato.getEstado() + ";" + contato.getCep() + ";" + contato.getPais();
	}

  public String prefixarEmprego(){
    return "ROLE;CHARSET=UTF-8:" + contato.getEmprego();
  }

  public String prefixarSiteEmpresarial(){
    return "URL;type=WORK;CHARSET=UTF-8:" + contato.getSiteEmpresarial();
  }

	public String prefixarTwitter(){
    return "X-SOCIALPROFILE;TYPE=twitter:" + contato.getTwitter();
  }

  public String prefixarLinkedin(){
    return "X-SOCIALPROFILE;TYPE=linkedin:" + contato.getLinkedin();
  }

  public String prefixarInstagram(){
    return "X-SOCIALPROFILE;TYPE=instagram:" + contato.getInstagram();
  }

  public String prefixarYoutube(){
    return "X-SOCIALPROFILE;TYPE=youtube:" + contato.getYoutube();
  }

  public String prefixarSitePessoal(){
    return "X-SOCIALPROFILE;TYPE=" + contato.getNomeSitePessoal() + ":" + contato.getSitePessoal();
  }

  public String prefixarFinalArquivo(){
    return "END:VCARD";
  }

	public String[] prefixarAll() {
		String[] valoresVcf = {this.prefixarInicioArquivo(), this.prefixarVersaoArquivo(), this.prefixarNomeCompleto(), this.prefixarNome(), this.prefixarGenero(), this.prefixarDataNascimento(), this.prefixarEmail(), this.prefixarCelularPessoal(), this.prefixarTelefoneFixo(), this.prefixarTipoResidencial(), this.prefixarTipoEndereco(), this.prefixarEtiquetaComercial(), this.prefixarEnderecoComercial(), this.prefixarEmprego(), this.prefixarSiteEmpresarial(), this.prefixarTwitter(), this.prefixarLinkedin(), this.prefixarInstagram(), this.prefixarYoutube(), this.prefixarSitePessoal(), this.prefixarFinalArquivo()};
		return valoresVcf;
	}
}