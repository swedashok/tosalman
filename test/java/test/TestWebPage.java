package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.AddList;
import Pages.MainPage;
import Pages.ValidationPage;
import util.BrowserFactory;


public class TestWebPage {

WebDriver driver;

@Test
	public void toggleOnCheckBox() throws InterruptedException {

		driver = BrowserFactory.init();
				
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.ToggleCheckBoxAllChecked();
		//MainPage.toggleAll();
				if(MainPage.checkIfitIsClicked() == true)
				{
				System.out.print("All items are checked");
				}
		{
			
		Thread.sleep(2000);
		// adding items
		Thread.sleep(2000);
		AddList addList = PageFactory.initElements(driver, AddList.class);
		addList.enterData("Ashok");
		addList.clickAddButton();
		addList.enterData("sharma");
		addList.clickAddButton();
		addList.enterData("adhikari");
		addList.clickAddButton();

    // selecting one item and deleting it

	ValidationPage validationPage = PageFactory.initElements(driver, ValidationPage.class);	
	validationPage.selectinOneItem();
		
	validationPage.buttonDelete();

	// selecting toggle all and clicking delete
//	MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
//	mainPage.ToggleCheckBoxAllChecked();
//	//MainPage.toggleAll();
//			if(MainPage.checkIfitIsClicked() == true)
//			{
//			System.out.print("All items are checked");
//			}
			
	validationPage.verifyCheckBox();
	validationPage.buttonDelete();


	//BrowserFactory.tearDown();
	}
}
}