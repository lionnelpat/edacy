package domaine;

public class Classe {
	
	private String id_classe;
	private String libelle;
	
	
	
	
	public Classe() {
		super();
	}


	public Classe(String id_classe, String libelle) {
		super();
		this.id_classe = id_classe;
		this.libelle = libelle;
	}
	
	
	public String getId_classe() {
		return id_classe;
	}
	public void setId_classe(String id_classe) {
		this.id_classe = id_classe;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	

}
