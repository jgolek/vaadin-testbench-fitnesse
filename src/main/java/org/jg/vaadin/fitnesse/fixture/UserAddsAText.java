package org.jg.vaadin.fitnesse.fixture;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.testbench.elements.VerticalLayoutElement;

public class UserAddsAText extends TestBenchTestCase{
	
	String text;
	String[] welcomeText;
	
	public UserAddsAText() {}
	
	public void execute() {
		
		VerticalLayoutElement layout = $(VerticalLayoutElement.class).first();
		List<LabelElement> labels = layout.$(LabelElement.class).all();

		layout.$(TextFieldElement.class).first().setValue(this.text);
		layout.$(ButtonElement.class).first().click();
		
		labels = layout.$(LabelElement.class).all();
		
		welcomeText = new String[labels.size()];
		for (int i = 0; i < labels.size(); i++) {
			welcomeText[i] = labels.get(i).getText();
			
		}
	}
	
	public void beginTable() {
		setDriver(new ChromeDriver());
		getDriver().get("http://localhost:8080/vaadin-testbench-fitnesse");
	}
	
	public void endTable() {
		getDriver().quit();
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String[] welcomeText() {
		return this.welcomeText;
	}
}
