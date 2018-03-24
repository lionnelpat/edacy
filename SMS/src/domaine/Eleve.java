package domaine;

public class Eleve {
	
	private String matri;
	private String fname;
	private String lname;
	private String age;
	private String sex;
	private String phone;
	private String classe_id_class;
	
	public Eleve() {
		super();
	}

    public Eleve(String matri, String fname, String lname, String age, String sex, String phone, String classe_id_class) {
        this.matri = matri;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.classe_id_class = classe_id_class;
    }

    public String getMatri() {
        return matri;
    }

    public void setMatri(String matri) {
        this.matri = matri;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClasse() {
        return classe_id_class;
    }

    public void setClasse(String classe_id_class) {
        this.classe_id_class = classe_id_class;
    }
        
     

	
	
	

}
