package io.contentstack.webapp;

import com.contentstack.sdk.*;
import com.contentstack.sdk.Error;
import io.contentstack.webapp.models.NewsModel;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Utils.
 */
public class Utils {


    /**
     * Gets news headlines.
     *
     * @param stack the stack
     * @return the news headlines
     */
    public static ArrayList<NewsModel> getNewsHeadlines(Stack stack) {
        try {
            ArrayList<NewsModel> newsHeadlines = new ArrayList<>();
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


    /**
     * Gets all products.
     *
     * @param stack the stack
     * @return the all products
     */
    public static ArrayList<NewsModel> getAllProducts(Stack stack) {

        try {
            ArrayList<NewsModel> allProducts = new ArrayList<>();
            Query query = stack.contentType("products").query();
            query.includeContentType();
            query.find(new QueryResultsCallBack() {

                @Override
                public void onCompletion(ResponseType responseType, QueryResult queryresult, com.contentstack.sdk.Error error) {
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


    /**
     * Gets about us.
     *
     * @param stack the stack
     * @return the about us
     */
    public static String getAboutUs(Stack stack) {

        try {
            final String[] ABOUT_US = {""};
            Query query = stack.contentType("about").query();
            query.includeContentType();
            query.find(new QueryResultsCallBack() {

                @Override
                public void onCompletion(ResponseType responseType, QueryResult queryresult, com.contentstack.sdk.Error error) {
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


    /**
     * Gets contact us.
     *
     * @param stack the stack
     * @return the contact us
     */
    public static String getContactUs(Stack stack) {

        try {
            final String[] contact = {""};
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
