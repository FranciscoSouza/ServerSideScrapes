package com.serversidescrape;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.serversidescrape.bo.JSONResultBO;
import com.serversidescrape.bo.ProductBO;
import com.serversidescrape.util.ScraperSite;

public class ScrapTest {

	private ScraperSite scrape = null;

	private static final String RIGHT_URL_TO_SCRAPE = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk"
			+ "/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

	private static final String WRONG_URL_TO_SCRAPE = "http://google.com";

	@Before
	public void setUp() throws Exception {
		scrape = new ScraperSite();
	}

	@After
	public void tearDown() throws Exception {
		scrape = null;
	}

	@Test
	public void testShouldReturnTheRightJSON() {

		String jsonResult = null;
		jsonResult = scrape.startScrapeSite(RIGHT_URL_TO_SCRAPE);
		assertTrue(jsonResult.contains("total") && jsonResult.contains("results"));
	}

	@Test
	public void testJSONIsEmpty() {

		String jsonResult = null;
		jsonResult = scrape.startScrapeSite(WRONG_URL_TO_SCRAPE);
		assertTrue(!jsonResult.contains("results"));

	}

	@Test
	public void testgetProducts() {
		JSONResultBO productList = null;
		ProductBO product = null;
		try {
			Document doc = Jsoup.connect(RIGHT_URL_TO_SCRAPE).get();
			productList=(JSONResultBO) new ScraperSite().getProducts(doc);
			product=(ProductBO)productList.getProductList().get(0);
			assertTrue(product.getCalorie()==33.0);
			assertTrue(product.getTitle().equals("Sainsbury's Strawberries 400g"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
