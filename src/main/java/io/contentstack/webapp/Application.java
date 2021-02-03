package io.contentstack.webapp;

import com.contentstack.sdk.Error;
import com.contentstack.sdk.*;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@GetMapping("/about")
	public String about(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {

		String aboutUs = getAboutUs();
		if (aboutUs == null) {
			model.addAttribute("about", "Could not fetch AboutUs..");
		} else {
			model.addAttribute("about", aboutUs);
		}
		return "about";
	}



	@GetMapping("/contact")
	public String contact(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {

		String contactUs = getContactUs();
		if (contactUs == null) {
			model.addAttribute("contact", "Could not fetch contactUs..");
		} else {
			model.addAttribute("contact", contactUs);
		}
		return "contact";
	}



	@GetMapping("/")
	public String home(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {

		ArrayList<NewsModel> listOfHeadlines = getNewsHeadlines();
		if (listOfHeadlines == null || listOfHeadlines.size() == 0) {
			model.addAttribute("headlines", "Could not fetch Headlines..");
		} else {
			model.addAttribute("headlines", listOfHeadlines);
		}
		return "headline";
	}


	@GetMapping("/headline")
	public String headline(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {

		ArrayList<NewsModel> listOfHeadlines = getNewsHeadlines();
		if (listOfHeadlines == null || listOfHeadlines.size() == 0) {
			model.addAttribute("headlines", "Could not fetch Headlines..");
		} else {
			model.addAttribute("headlines", listOfHeadlines);
		}
		return "headline";
	}




	@GetMapping("/products")
	public String allProducts(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {

		ArrayList<NewsModel> listOfProducts = getAllProducts();
		if (listOfProducts == null || listOfProducts.size() == 0) {
			model.addAttribute("products", "Could not fetch Products..");
		} else {
			model.addAttribute("products", listOfProducts);
		}
		System.out.println("products: "+listOfProducts);
		return "products";
	}


	private ArrayList<NewsModel> getNewsHeadlines() {

		try {
			ArrayList<NewsModel> newsHeadlines = new ArrayList<>();
			final Stack stack = Contentstack.stack("blt7979d15c28261b93", "cs17465ae5683299db9d259cb6", "production");
			ContentType contentType = stack.contentType("news");
			Query query = contentType.query();
			query.find(new QueryResultsCallBack() {
				@Override
				public void onCompletion(ResponseType responseType, QueryResult queryresult, com.contentstack.sdk.Error error) {
					if (error == null) {
						List<Entry> result = queryresult.getResultObjects();
						for (Entry entry : result) {
							JSONObject response = entry.toJSON();
							JSONObject url = response.optJSONObject("thumbnail");
							String imageUrl = url.optString("url");
							newsHeadlines.add(new NewsModel(response.optString("title"),
									response.optString("body"), imageUrl));
						}
					}
				}
			});
			return newsHeadlines;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}


	private ArrayList<NewsModel> getAllProducts() {

		try {
			ArrayList<NewsModel> allProducts = new ArrayList<>();
			Stack stack = Contentstack.stack("blt7979d15c28261b93", "cs17465ae5683299db9d259cb6", "production");
			Query query = stack.contentType("products").query();
			query.includeContentType();
			query.find(new QueryResultsCallBack() {

				@Override
				public void onCompletion(ResponseType responseType, QueryResult queryresult, Error error) {
					if (error == null) {
						List<Entry> entryList = queryresult.getResultObjects();
						if (queryresult.getResultObjects().size() > 0) {
							for (Entry entry : entryList) {
								JSONObject response = entry.toJSON();
								JSONObject url = response.optJSONObject("image");
								String imageUrl = url.optString("url");
								allProducts.add(new NewsModel(response.optString("title"),
										response.optString("description"),
										imageUrl));
							}
						}
					}
				}
			});
			return allProducts;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}


	private String getAboutUs() {

		try {
			final String[] ABOUT_US = {""};
			Stack stack = Contentstack.stack("blt7979d15c28261b93", "cs17465ae5683299db9d259cb6", "production");
			Query query = stack.contentType("about").query();
			query.includeContentType();
			query.find(new QueryResultsCallBack() {

				@Override
				public void onCompletion(ResponseType responseType, QueryResult queryresult, Error error) {
					if (error == null) {
						ABOUT_US[0] = queryresult.getResultObjects().get(0).toJSON().optString("about");
					}
				}
			});
			return ABOUT_US[0];
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}



	private String getContactUs() {

		try {
			final String[] contact = {""};
			Stack stack = Contentstack.stack("blt7979d15c28261b93", "cs17465ae5683299db9d259cb6", "production");
			Query query = stack.contentType("contactus").query();
			query.includeContentType();
			query.find(new QueryResultsCallBack() {

				@Override
				public void onCompletion(ResponseType responseType, QueryResult queryresult, Error error) {
					if (error == null) {
						contact[0] = queryresult.getResultObjects().get(0).toJSON().optString("contactus");
					}
				}
			});
			return contact[0];
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
