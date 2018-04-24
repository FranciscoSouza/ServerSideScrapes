package com.serversidescrape.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.serversidescrape.bo.JSONResultBO;
import com.serversidescrape.bo.ProductBO;

public class ScraperSite {

	/**
	 * Method to scrape the URL. This will fetch the product page, access the link
	 * each product, grab details information with JSON output
	 * 
	 * @param url
	 * @return JSON format String
	 */
	public String startScrapeSite(String url) {
		Document doc = null;
		String outputJSON = "";
		try {
			// The loading phase comprises the fetching and parsing of the HTML into a
			// Document
			doc = Jsoup.connect(url).get();

		} catch (HttpStatusException e) {
			// to detect abnormal status codes (e.g. 404)
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Selecting
		outputJSON = generateJSON(getProducts(doc));
		// just for print propose 
		System.out.println(outputJSON);
		return outputJSON;
	}

	/**
	 * Get the products List
	 * 
	 * @param doc
	 */
	public JSONResultBO getProducts(Document doc) {

		List<ProductBO> productList = null;
		ProductBO product = null;
		Float sumPrice = null;

		Element el = doc.select("ul.productLister").first();
		if (el != null) {
			productList = new ArrayList<ProductBO>();
			sumPrice = new Float(0);
			Elements elements = el.getElementsByClass("gridItem");
			for (Iterator<Element> iterator = elements.iterator(); iterator.hasNext();) {
				product = new ProductBO();
				Element element = (Element) iterator.next();

				// get the element title
				Element elTitle = element.getElementsByTag("h3").first();
				product.setTitle(elTitle.text());

				// get the price
				Element pinfoel = element.select("p.pricePerUnit").first();
				String price = pinfoel.text();
				price = price.replace("/unit", "");
				price = price.replace("£", "");
				float ppunit = Float.parseFloat(price);
				product.setPrice(ppunit);

				// get the calorie & description
				Element linkel = element.getElementsByTag("a").first();
				String infoUrl = linkel.attr("abs:href");
				getProductDetails(product, infoUrl);

				// sum the products price of the page
				sumPrice = sumPrice + ppunit;

				productList.add(product);
			}
		}

		return new JSONResultBO(productList, sumPrice);
	}

	/**
	 * Get details about the product
	 * 
	 * @param product
	 *            ProductBO to be populated by details
	 * @param infoUrl
	 *            URL of the product
	 */
	private void getProductDetails(ProductBO product, String infoUrl) {
		Document doc;
		try {
			// get Information about the product
			doc = Jsoup.connect(infoUrl).get();
			Element el = doc.getElementById("information");
			Element titleElement = el.getElementsByClass("productText").first();
			product.setDescription(titleElement.text());

			// get calories
			Element calorieElements = el.getElementsByClass("tableRow0").first();
			if (calorieElements != null) {
				Element calor = calorieElements.getElementsByTag("td").first();

				if (calor != null) {
					String strCalorie = calor.text();
					strCalorie = strCalorie.replace("kcal", "");

					float floatCalorie = Float.parseFloat(strCalorie);
					product.setCalorie(floatCalorie);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Generate the JSON based on java Object
	 * 
	 * @param jsonResult
	 * @return String JSON format
	 */
	private String generateJSON(JSONResultBO obj) {
		return new Gson().toJson(obj);
	}
}
