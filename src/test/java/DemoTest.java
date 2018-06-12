
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.testbench.elements.VerticalLayoutElement;;


public class DemoTest extends TestBenchTestCase {

	@Before
	public void setUp() throws Exception {
		setDriver(new ChromeDriver());
		getDriver().get("http://localhost:8080/vaadin-testbench-fitnesse");

	}

	@Test
	public void testSize() {

		assertTrue($(VerticalLayoutElement.class).exists());

		VerticalLayoutElement layout = $(VerticalLayoutElement.class).first();
		List<LabelElement> labels = layout.$(LabelElement.class).all();
		assertEquals(labels.size(), 0);
		
	}
	
	@Test
	public void testClick() {

		assertTrue($(VerticalLayoutElement.class).exists());

		VerticalLayoutElement layout = $(VerticalLayoutElement.class).first();
		
		layout.$(ButtonElement.class).first().click();
		layout.$(ButtonElement.class).first().click();

		List<LabelElement> labels = layout.$(LabelElement.class).all();
		assertEquals(labels.size(), 2);
	}
	
	@Test
	public void testSetValue() {

		VerticalLayoutElement layout = $(VerticalLayoutElement.class).first();
		List<LabelElement> labels = layout.$(LabelElement.class).all();

		layout.$(TextFieldElement.class).first().setValue("Lars");
		layout.$(ButtonElement.class).first().click();
		
		labels = layout.$(LabelElement.class).all();
		assertEquals("Thanks Lars, it works!", labels.get(0).getText());
	}

	@After
	public void tearDown() throws Exception {
		getDriver().quit();
	}
}
