package libreplan;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAffichagePlanning {
	
WebDriver wd;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.firefox.bin", "C://Program Files (x86)//Mozilla Firefox//firefox.exe");
		wd = new FirefoxDriver();
		wd.navigate().to("http://localhost:8080/libreplan");
	}
	
	@Test
	public void testAjouterTaches() throws Exception{
		
		//PDT1 : Se connecter � l'application
		LoginPage page = new LoginPage(wd);
		MenuPage accueil = page.connexion("admin", "admin");
		Thread.sleep(1000);
		
		//PDT2 : Acc�der � la liste des projets
		accueil.projectsList();
		MenuPage page2 = new MenuPage(wd);
		AccueilProjetPage2 accueilProjetPage2 = page2.accueilProjetPage2();
		
		//PDT3 : Acc�der � la page d'�dition du projet
		accueilProjetPage2.projetDetail();
		Thread.sleep(1000);
		accueilProjetPage2.affichageOngletProjet();
		AccueilProjetPage2 page3 = new AccueilProjetPage2(wd);
		
		//PDT4 : Acc�der � la page de plannification du projet
		PlanningPage planningPage = page3.planningPage();
		
		//PDT5-6-7 : Zoom ann�e - trimestre - mois
		planningPage.verifierPlanningPage();
		planningPage.parcoursTableauAnnee("H1");
		planningPage.parcoursTableauAnnee("H2");
		planningPage.verifierPlanningPageQuarter();
		planningPage.parcoursTableauQuarter("Q1");
		planningPage.parcoursTableauQuarter("Q2");
		planningPage.parcoursTableauQuarter("Q3");
		planningPage.parcoursTableauQuarter("Q4");
		planningPage.verifierPlanningPageMonth();
		planningPage.parcoursTableauMonthYear("2017,H1");
		planningPage.parcoursTableauMonthYear("2017,H2");
		planningPage.parcoursTableauMonth("Jan");
		planningPage.parcoursTableauMonth("Feb");
		planningPage.parcoursTableauMonth("Mar");
		planningPage.parcoursTableauMonth("Apr");
		planningPage.parcoursTableauMonth("May");
		planningPage.parcoursTableauMonth("Jun");
		planningPage.parcoursTableauMonth("Jul");
		planningPage.parcoursTableauMonth("Aug");
		planningPage.parcoursTableauMonth("Sep");
		planningPage.parcoursTableauMonth("Oct");
		planningPage.parcoursTableauMonth("Nov");
		planningPage.parcoursTableauMonth("Dec");
	}
}
