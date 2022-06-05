package Classes;

public class MainApp {

	public static void main(String[] args) {

		
		
		Etudiant stud = new Etudiant(1, "taleb", "mehdi", "mehdi@gmail.com", "password", 1);
		
		I_EtudiantRepository etudRep = new EtudiantRepository();
		
		I_UniversiteRepository univRep = new UniversiteRepository();
		
		EtudiantService etud_Service = new EtudiantService(etudRep, univRep);
		
		
		try {
			
			etud_Service.inscription(stud);   //Inscription de l'�tudiant stud

			stud.AjouterBonus(univRep);       //Ajouter bonus � l'�tudiant
			
			etud_Service.AjouterBonusTous();  //Ajouter bonus � tous les �tudiants avec 'Standard' et 'Premium'
			
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
