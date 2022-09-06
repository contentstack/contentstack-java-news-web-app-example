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

    private static void getCredentials() throws Exception {
        stack = Contentstack.stack("apiKey", "deliveryToken", "environment");
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        getCredentials();
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
            model.addAttribute(Utils.aboutKey, "Could not fetch about page..");
        } else {
            model.addAttribute(Utils.aboutKey, about);
        }
        return Utils.aboutKey;
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
            model.addAttribute(Utils.contactKey, "Could not fetch contactUs..");
        } else {
            model.addAttribute(Utils.contactKey, contactUs);
        }
        return Utils.contactKey;
    }

    /**
     * Home string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/")
    public String home(Model model) {
        return loadHeadline(model);
    }

    /**
     * Headline string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/headline")
    public String headline(Model model) {
        return loadHeadline(model);
    }

    private String loadHeadline(Model model) {
        ArrayList<NewsModel> listOfHeadlines = (ArrayList<NewsModel>) Utils.getNewsHeadlines(stack);
        if (listOfHeadlines == null || listOfHeadlines.isEmpty()) {
            model.addAttribute(Utils.headlinesKey, "Could not fetch Headlines..");
        } else {
            model.addAttribute(Utils.headlinesKey, listOfHeadlines);
        }
        return Utils.headlinesKey;
    }

    /**
     * All products string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/products")
    public String allProducts(Model model) {
        ArrayList<NewsModel> listOfProducts = (ArrayList<NewsModel>) Utils.getAllProducts(stack);
        if (listOfProducts == null || listOfProducts.isEmpty()) {
            model.addAttribute(Utils.productsKey, "Could not fetch Products..");
        } else {
            model.addAttribute(Utils.productsKey, listOfProducts);
        }
        return Utils.productsKey;
    }

}
