package com.serversidescrape;

import com.serversidescrape.util.ScraperSite;

/**
 * Hello world!
 *
 */
public class App {
	private static final String URL_TO_SCRAPE = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk"
			+ "/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";
	
	static ScraperSite scraperUtil;

	public static void main(String[] args) {
		scraperUtil = new ScraperSite();
		System.out.println(scraperUtil.startScrapeSite(URL_TO_SCRAPE));

	}
}
