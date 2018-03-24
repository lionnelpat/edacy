package sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import domaine.Classe;
import domaine.Eleve;

public class DbHandler {

	public static String URL = "jdbc:mysql://localhost:3306/smsdb";
	public static String LOGIN = "root";
	public static String PASSWD = "";

	public static void createEleve(Eleve eleve) {

		Connection cn = null;
		PreparedStatement pr = null;

		try {
			// 1 - Chargement du drive
			Class.forName("com.mysql.jdbc.Driver");

			// 2- r�cup�raion de la connexion
			cn = DriverManager.getConnection(URL, LOGIN, PASSWD);

			// 3- Cr�ation d'un statement

			String sqlParametre = "INSERT INTO eleve (matri,fname,lname,age,sex,phone,classe_id_class) VALUES(?, ?, ?, ?, ?, ?, ?);";

			pr = cn.prepareStatement(sqlParametre);
			pr.setString(1, eleve.getMatri());
			pr.setString(2, eleve.getFname());
			pr.setString(3, eleve.getLname());
			pr.setString(4, eleve.getAge());
			pr.setString(5, eleve.getSex());
			pr.setString(6, eleve.getPhone());
			pr.setString(7, eleve.getClasse());

			pr.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} finally {

			try {
				// 5 - Lib�ration des ressources de la m�moires

				cn.close();
				pr.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public static void createClasse(Classe classe) {

		Connection cn = null;
		Statement st = null;

		try {
			// 1 - Chargement du drive
			Class.forName("com.mysql.jdbc.Driver");

			// 2- r�cup�raion de la connexion
			cn = DriverManager.getConnection(URL, LOGIN, PASSWD);

			// 3- Cr�ation d'un statement
			st = cn.createStatement();

			String sql = "INSERT INTO classe (matri,anneeUniversitaire,hospitalDeStage,categorie,indamniteStage) VALUES ('"
					+ classe.getId_classe() + "','" + classe.getLibelle() + "')";

			// 4- Ex�cution requ�te
			st.executeUpdate(sql);

		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println(" ");
			System.out.println("        Probl�me de matri");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// 5 - Lib�ration des ressources de la m�moires
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void afficherEleve() {

		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// 1 - Chargement du drive
			Class.forName("com.mysql.jdbc.Driver");

			// 2 - R�cup�ration de la conexion
			cn = DriverManager.getConnection(URL, LOGIN, PASSWD);

			// 3- Cr�ation d'un statement
			st = cn.createStatement();

			// requete jointure interne entre personne et contact

			String sql = "SELECT eleve.matri matri,fname,lname,age,sex,phone,libelle FROM eleve INNER JOIN classe ON eleve.classe_id_class=classe.id_class";

			// 4- Ex�cution de la requ�te

			rs = st.executeQuery(sql);
			// rs0 = st0.executeQuery(sql0);

			// 5 - parcours
			while (rs.next()) {

				System.out.println("        matri   : " + rs.getString("matri"));
				System.out.println("        Prenoms     : " + rs.getString("fname"));
				System.out.println("        Nom         : " + rs.getString("lname"));
				System.out.println("        Age         : " + rs.getString("age") + " ans");
				System.out.println("        Sexe        : " + rs.getString("sex"));
				System.out.println("        Adresse     : " + rs.getString("adresse"));
				System.out.println("        Telephone   : " + rs.getString("phone"));
				System.out.println("        Libelle       : " + rs.getString("libelle"));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// 6- Lib�ration des ressources

				// st0.close();
				// cn0.close();
				cn.close();
				st.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete(String matri, String id_classe) {

		Connection cn = null;
		PreparedStatement pr = null, pr1 = null;

		try {
			// 1 - Chargement du drive
			Class.forName("com.mysql.jdbc.Driver");

			// 2- r�cup�raion de la connexion
			cn = DriverManager.getConnection(URL, LOGIN, PASSWD);

			// 3- Cr�ation d'un statement

			String sqlParametre = "DELETE FROM smsdb.eleve WHERE eleve.matri=?";
			String sqlParametre1 = "DELETE FROM smsdb.classe WHERE classe.id_classe=?";

			pr = cn.prepareStatement(sqlParametre);
			pr1 = cn.prepareStatement(sqlParametre1);

			pr.setString(1, matri);
			pr1.setString(1, id_classe);

			pr.executeUpdate();
			pr1.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} finally {

			try {
				// 5 - Lib�ration des ressources de la m�moires

				cn.close();
				pr.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
	public void update(Eleve eleve,Classe classe) {

		Connection cn = null;
		Statement st = null;
		int rs = 0;

		try {
			// 1 - Chargement du drive
			Class.forName("com.mysql.jdbc.Driver");

			// 2- r�cup�raion de la connexion
			cn = DriverManager.getConnection(URL, LOGIN, PASSWD);
		
		// 1. Modification du Nom
		if (eleve.getLname() != null) {

			// a.syntaxe sql
			String sql = "UPDATE smsdb.eleve SET nom = '" + eleve.getLname()
					+ "' WHERE eleve.matri='" + eleve.getMatri() + "'";

			// b.execution de la syntaxe sql

				rs = st.executeUpdate(sql);
		}
		// 2. Modification du Prenoms
		if (eleve.getFname() != null) {

			// a.syntaxe sql
			String sql = "UPDATE smsdb.eleve SET prenoms = '" + eleve.getFname()
					+ "' WHERE eleve.matri='" + eleve.getMatri() + "'";

			// b.execution de la syntaxe sql
			rs = st.executeUpdate(sql);
		}
		// 3. Modification de l'Age
		if (eleve.getAge() != "") {

			// a.syntaxe sql
			String sql = "UPDATE smsdb.eleve SET age = '" + eleve.getAge()
					+ "' WHERE eleve.matri='" + eleve.getMatri() + "'";

			// b.execution de la syntaxe sql
			rs = st.executeUpdate(sql);
		}
		// 4. Modification du Sexe
		if (eleve.getSex() != null) {

			// a.syntaxe sql
			String sql = "UPDATE smsdb.eleve SET sex = '" + eleve.getSex()
					+ "' WHERE eleve.matri='" + eleve.getMatri() + "'";

			// b.execution de la syntaxe sql
			rs = st.executeUpdate(sql);
		}
		// 5. Modification du Telephone
		if (eleve.getPhone() != null) {

			// a.syntaxe sql
			String sql = "UPDATE smsdb.eleve SET telephone = '" + eleve.getPhone()
					+ "' WHERE eleve.matri='" + eleve.getMatri() + "'";

			// b.execution de la syntaxe sql
			rs = st.executeUpdate(sql);
		}
		// 6. Modification de l'Adresse
		if (classe.getLibelle() != null) {

			// a.syntaxe sql
			String sql = "UPDATE smsdb.classe SET adresse = '" + classe.getLibelle()
					+ "' WHERE eleve.id_classe='" + classe.getId_classe() + "'";

			// b.execution de la syntaxe sql
			rs = st.executeUpdate(sql);
		}
		
		// 8 .fermeture de la conexion
		cn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
