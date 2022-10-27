import java.util.*;
import java.text.DateFormat;

public class Contato {

	DateFormat formataData = DateFormat.getDateInstance();

	private String primeiroNome;
	private String nomeMeio;
	private String ultimoNome;
	private String numeroCelularPessoal;
	private String numeroCelularFixo;
	private Calendar dataNascimento;
	private char genero;
	private String email;
	private String tipoResidencia;
	private String etiquetaComercial;
	private String enderecoComercial;
	private String endereco;
	private String cidade;
	private String estado;
	private String pais;
	private String cep;
	private String emprego;
	private String siteEmpresarial;
	private String twitter;
	private String linkedin;
	private String instagram;
	private String youtube;
  private String nomeSitePessoal;
	private String sitePessoal;
	
	Contato() {
	}

	Contato(String primeiroNome, String ultimoNome, String numeroCelular, String email) {
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.numeroCelularPessoal = numeroCelular;
		this.email = email;
	}

	public String[] getAll() {
		String[] info = {this.primeiroNome, this.ultimoNome, this.numeroCelularPessoal, this.email, this.numeroCelularFixo, this.getDiaNascimento(), this.getMesNascimento(),  this.getAnoNascimento(), this.getGenero(), this.nomeMeio, this.tipoResidencia, this.etiquetaComercial, this.enderecoComercial, this.endereco, this.cidade, this.estado, this.pais, this.cep, this.emprego, this.siteEmpresarial, this.twitter, this.linkedin, this.instagram, this.youtube, this.nomeSitePessoal, this.sitePessoal};
		return info;
	}

	public String getNome() {
		if(this.nomeMeio.equals("")){
			return this.primeiroNome + " " + this.ultimoNome;
		} else if(!this.nomeMeio.equals("-")){
			return this.primeiroNome + " " + this.nomeMeio + " " + this.ultimoNome;	
		}

		return this.primeiroNome + " " + this.ultimoNome;
		
	}

	public String getPrimeiroNome() {
		return this.primeiroNome;
	}

	public String getNomeMeio() {
		return this.nomeMeio;
	}

	public String getUltimoNome() {
		return this.ultimoNome;
	}

	public String getNumeroCelularPessoal() {
		return this.numeroCelularPessoal;
	}

	public String getNumeroCelularFixo() {
		return this.numeroCelularFixo;
	}

	public String getNascimento() {
		return formataData.format(this.dataNascimento.getTime());
	}

  public String getAnoNascimento(){
    return String.valueOf(this.dataNascimento.get(Calendar.YEAR));
  }

  public String getMesNascimento(){
    if(this.dataNascimento.get(Calendar.MONTH) + 1 < 10){
      return "0" + String.valueOf(this.dataNascimento.get(Calendar.MONTH) + 1);
    }
    return String.valueOf(this.dataNascimento.get(Calendar.MONTH) + 1);
  }

  public String getDiaNascimento(){
    if(this.dataNascimento.get(Calendar.DAY_OF_MONTH) < 10){
      return "0" + String.valueOf(this.dataNascimento.get(Calendar.DAY_OF_MONTH));
    }
		
    return String.valueOf(this.dataNascimento.get(Calendar.DAY_OF_MONTH));
  }

	public String getGenero() {
		return String.valueOf(this.genero);
	}

	public String getEmail() {
		return this.email;
	}

	public String getTipoResidencia() {
		return this.tipoResidencia;
	}

	public String getEtiquetaComercial() {
		return this.etiquetaComercial;
	}

	public String getEnderecoComercial() {
		return this.enderecoComercial;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public String getCidade() {
		return this.cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public String getPais() {
		return this.pais;
	}

	public String getCep() {
		return this.cep;
	}

	public String getEmprego() {
		return this.emprego;
	}

	public String getSiteEmpresarial() {
		return this.siteEmpresarial;
	}

	public String getTwitter() {
		return this.twitter;
	}

	public String getLinkedin() {
		return this.linkedin;
	}

	public String getInstagram() {
		return this.instagram;
	}

	public String getYoutube() {
		return this.youtube;
	}

  public String getNomeSitePessoal(){
    return this.nomeSitePessoal;
  }

	public String getSitePessoal() {
		return this.sitePessoal;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public void setNomeMeio(String nomeMeio) {
		this.nomeMeio = nomeMeio;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public void setNumeroCelularPessoal(String numeroCelularPessoal) {
		this.numeroCelularPessoal = numeroCelularPessoal;
	}

	public void setNumeroCelularFixo(String numeroCelularFixo) {
		this.numeroCelularFixo = numeroCelularFixo;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTipoResidencia(String tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		if (estado.equals("casado") || estado.equals("solteiro")) {
			System.out.println("Tu é burro cara? kkkkkkkkk");
		} else {
			this.estado = estado;
		}
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setEmprego(String emprego) {
		this.emprego = emprego;
	}

	public void setSiteEmpresarial(String siteEmpresarial) {
		this.siteEmpresarial = siteEmpresarial;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

  public void setNomeSitePessoal(String nomeSitePessoal) {
    this.nomeSitePessoal = nomeSitePessoal;
  }

	public void setSitePessoal(String sitePessoal) {
		this.sitePessoal = sitePessoal;
	}

	public void setAll(String[] valores) {
		int dia, mes, ano;
		this.primeiroNome = valores[0].toString();
		this.ultimoNome = valores[1].toString();
		this.numeroCelularPessoal = valores[2].toString();
		this.email = valores[3].toString();
		this.numeroCelularFixo = valores[4].toString();
		if (valores[5].equals("")) {
			dia = 1;
		} else {
			dia = Integer.parseInt(valores[5]);
		}
		if (valores[6].equals("")) {
			mes = 0;
		} else {
			mes = (Integer.parseInt(valores[6]) - 1);
		}
		if (valores[7].equals("")) {
			ano = 1000;
		} else {
			ano = Integer.parseInt(valores[7]);
		}
		Calendar c = Calendar.getInstance();
		c.set(ano, mes, dia);
		this.dataNascimento = c;

		
		if(valores[8] != ""){
			this.genero = valores[8].charAt(0); // TALVEZ AQUI TENHA PROBLEMA
		} else {
			this.genero = 'o';
		}
		
		this.nomeMeio = valores[9].toString();
		this.tipoResidencia = valores[10].toString();
		this.etiquetaComercial = valores[11].toString();
		this.enderecoComercial = valores[12].toString();
		this.endereco = valores[13].toString();
		this.cidade = valores[14].toString();
		this.estado = valores[15].toString();
		this.pais = valores[16].toString();
		this.cep = valores[17].toString();
		this.emprego = valores[18].toString();
		this.siteEmpresarial = valores[19].toString();
		this.twitter = valores[20].toString();
		this.linkedin = valores[21].toString();
		this.instagram = valores[22].toString();
		this.youtube = valores[23].toString();
    this.nomeSitePessoal = valores[24].toString();
		this.sitePessoal = valores[25].toString();
	}
}