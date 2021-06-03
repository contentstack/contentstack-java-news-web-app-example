package io.contentstack.webapp;

import com.contentstack.sdk.Contentstack;
import com.contentstack.sdk.Stack;
import io.contentstack.webapp.models.NewsModel;
import io.github.cdimascio.dotenv.Dotenv;
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

    // load credentials from from .env
    private static void loadEnvVar() throws Exception {
        Dotenv dotenv = Dotenv.load();
        String deliverToken = dotenv.get("_EVV_DELIVERY_TOKEN");
        String _API_KEY = dotenv.get("_ENV_API_KEY");
        String _ENV = dotenv.get("_ENV");
        assert _API_KEY != null;
        assert deliverToken != null;
        assert _ENV != null;
        stack = Contentstack.stack(_API_KEY, deliverToken, _ENV);
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
            model.addAttribute("about", "Could not fetch about page..");
        } else {
            model.addAttribute("about", about);
        }
        return "about";
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
            model.addAttribute("contact", "Could not fetch contactUs..");
        } else {
            model.addAttribute("contact", contactUs);
        }
        return "contact";
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
        if (listOfHeadlines == null || listOfHeadlines.size() == 0) {
            model.addAttribute("headlines", "Could not fetch Headlines..");
        } else {
            model.addAttribute("headlines", listOfHeadlines);
        }
        return "headline";
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
        if (listOfHeadlines == null || listOfHeadlines.size() == 0) {
            model.addAttribute("headlines", "Could not fetch Headlines..");
        } else {
            model.addAttribute("headlines", listOfHeadlines);
        }
        return "headline";
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
        if (listOfProducts == null || listOfProducts.size() == 0) {
            model.addAttribute("products", "Could not fetch Products..");
        } else {
            model.addAttribute("products", listOfProducts);
        }
        System.out.println("products: " + listOfProducts);
        return "products";
    }



}
