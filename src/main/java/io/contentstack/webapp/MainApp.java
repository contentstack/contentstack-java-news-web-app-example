package io.contentstack.webapp;

import com.contentstack.sdk.Contentstack;
import com.contentstack.sdk.Stack;
import io.contentstack.webapp.models.NewsModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

/**
 * The type Main app.
 */
@SpringBootApplication
@Controller
public class MainApp {

    private static Stack stack;
    private static final String aboutKey = "about";
    private static final String contactKey = "contact";
    private static final String headlinesKey = "headlines";
    private static final String productsKey = "products";

    // load credentials from from .env
    private static void loadEnvVar() throws Exception {
        stack = Contentstack.stack("_API_KEY", "deliverToken", "_ENV");
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        loadEnvVar();
        SpringApplication.run(MainApp.class, args);
    }

    /**
     * About string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/about")
    public String about(Model model) {
        String about = Utils.getAboutUs(stack);
        if (about == null) {
            model.addAttribute(aboutKey, "Could not fetch about page..");
        } else {
            model.addAttribute(aboutKey, about);
        }
        return aboutKey;
    }

    /**
     * Contact string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/contact")
    public String contact(Model model) {
        String contactUs = Utils.getContactUs(stack);
        if (contactUs == null) {
            model.addAttribute(contactKey, "Could not fetch contactUs..");
        } else {
            model.addAttribute(contactKey, contactUs);
        }
        return contactKey;
    }

    /**
     * Home string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/")
    public String home(Model model) {
        ArrayList<NewsModel> listOfHeadlines = Utils.getNewsHeadlines(stack);
        if (listOfHeadlines == null || listOfHeadlines.isEmpty()) {
            model.addAttribute(headlinesKey, "Could not fetch Headlines..");
        } else {
            model.addAttribute(headlinesKey, listOfHeadlines);
        }
        return headlinesKey;
    }

    /**
     * Headline string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/headline")
    public String headline(Model model) {
        ArrayList<NewsModel> listOfHeadlines = Utils.getNewsHeadlines(stack);
        if (listOfHeadlines == null || listOfHeadlines.isEmpty()) {
            model.addAttribute(headlinesKey, "Could not fetch Headlines..");
        } else {
            model.addAttribute(headlinesKey, listOfHeadlines);
        }
        return headlinesKey;
    }

    /**
     * All products string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/products")
    public String allProducts(Model model) {
        ArrayList<NewsModel> listOfProducts = Utils.getAllProducts(stack);
        if (listOfProducts == null || listOfProducts.isEmpty()) {
            model.addAttribute(productsKey, "Could not fetch Products..");
        } else {
            model.addAttribute(productsKey, listOfProducts);
        }
        return productsKey;
    }

}
