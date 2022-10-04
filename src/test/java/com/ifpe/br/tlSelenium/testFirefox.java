package com.ifpe.br.tlSelenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class testFirefox {
	
	static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/home/paulo/Downloads/geckodriver-v0.27.0-linux64/geckodriver");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://www.calculadoraonline.com.br/basica");

	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();

	}
	
	/*
	 * Primeiro Teste, o intuito desse teste é testar valores padões para ver se existe algum erro 
	 * teste padrão.
	 */
	@Test
	void test() {
		
		
		driver.findElement(By.id("b31")).click();
		
		driver.findElement(By.id("cx31_0")).sendKeys("8");
		
		driver.findElement(By.id("cx31_1")).sendKeys("2");
		
		driver.findElement(By.cssSelector("button.uk-button.uk-button-default")).click();
		
		String valor = driver.findElement(By.id("TIExp")).getAttribute("value");
		
		assertEquals("64", valor);
	
		
	}
	
	/*Testamos se o sistema por sua vez aceita letra como parâmetro, 
	 * E se o retorno é NaN sigla que do inglês é Not a Number, mas esse foi um erro encontrado
	 * pois o sistema retorna um caractere "-"
	 */
	
	@Test
	void test2() {
		
		
		driver.findElement(By.id("b31")).click();
		
		driver.findElement(By.id("cx31_0")).sendKeys("8");
		
		driver.findElement(By.id("cx31_1")).sendKeys("s");
		
		driver.findElement(By.cssSelector("button.uk-button.uk-button-default")).click();
		
		String valor = driver.findElement(By.id("TIExp")).getAttribute("value");
		
		assertEquals("NaN", valor);
	
		
	}
	
	/*
	 * O intuito desse teste é ver se a calculadora aceita valor negativo no expoente e se o 
	 * resultado condiz com a realidade.
	 * 
	 */
	@Test
	void test3() {
		
		
		driver.findElement(By.id("b31")).click();
		
		driver.findElement(By.id("cx31_0")).sendKeys("5");
		
		driver.findElement(By.id("cx31_1")).sendKeys("-4");
		
		driver.findElement(By.cssSelector("button.uk-button.uk-button-default")).click();
		
		String valor = driver.findElement(By.id("TIExp")).getAttribute("value");
		
		assertEquals("0,0016", valor);
	
		
	}
	/*
	 * A intenção do Teste é testar o valor 0 como expoente e se o resultado é coerente com a realidade, 
	 * pois qualuqer numero elevadoa 0 é 1.
	 */
	
	@Test
	void test4() {
		
		
		driver.findElement(By.id("b31")).click();
		
		driver.findElement(By.id("cx31_0")).sendKeys("5");
		
		driver.findElement(By.id("cx31_1")).sendKeys("0");
		
		driver.findElement(By.cssSelector("button.uk-button.uk-button-default")).click();
		
		String valor = driver.findElement(By.id("TIExp")).getAttribute("value");
		
		assertEquals("1", valor);
	
		
	}
	/*
	 * 
	 */
	
	@Test
	void test5() {
		
		
		driver.findElement(By.id("b31")).click();
		
		driver.findElement(By.id("cx31_0")).sendKeys("0");
		
		driver.findElement(By.id("cx31_1")).sendKeys("5");
		
		driver.findElement(By.cssSelector("button.uk-button.uk-button-default")).click();
		
		String valor = driver.findElement(By.id("TIExp")).getAttribute("value");
		
		assertEquals("0", valor);
	
		
	}
	
	@Test
	void test6() {
		
		
		driver.findElement(By.id("b31")).click();
		
		driver.findElement(By.id("cx31_0")).sendKeys("5");
		
		driver.findElement(By.id("cx31_1")).sendKeys("1");
		
		driver.findElement(By.cssSelector("button.uk-button.uk-button-default")).click();
		
		String valor = driver.findElement(By.id("TIExp")).getAttribute("value");
		
		assertEquals("5", valor);
	
		
	}
	
	@Test
	void test7() {
		
		
		driver.findElement(By.id("b31")).click();
		
		driver.findElement(By.id("cx31_0")).sendKeys("5");
		
		driver.findElement(By.id("cx31_1")).sendKeys("$");
		
		driver.findElement(By.cssSelector("button.uk-button.uk-button-default")).click();
		
		String valor = driver.findElement(By.id("TIExp")).getAttribute("value");
		
		assertEquals("NaN", valor);
	
		
	}
	
	@Test
	void test8() {
		
		
		driver.findElement(By.id("b31")).click();
		
		driver.findElement(By.id("cx31_0")).sendKeys("-5");
		
		driver.findElement(By.id("cx31_1")).sendKeys("3");
		
		driver.findElement(By.cssSelector("button.uk-button.uk-button-default")).click();
		
		String valor = driver.findElement(By.id("TIExp")).getAttribute("value");
		
		assertEquals("-125", valor);
	
		
	}
	
	
	


	

}
