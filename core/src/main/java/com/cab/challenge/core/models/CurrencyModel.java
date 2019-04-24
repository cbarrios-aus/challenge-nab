/*

 */
package com.cab.challenge.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jcr.*;

import com.cab.challenge.core.models.beans.Currency;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Model(adaptables=Resource.class, defaultInjectionStrategy= DefaultInjectionStrategy.OPTIONAL)
public class CurrencyModel {

    @Inject
    private SlingSettingsService settings;

    @Inject @Named("sling:resourceType") @Default(values="No resourceType")
    protected String resourceType;

    @Inject
    private ResourceResolverFactory resolverFactory;

    @Inject @Default(values="")
    private String currencyName;

    @Inject @Default(values="")
    private String currencyDate;

    @Inject @Default(values="")
    private String currencyPrice;

    private List<Currency> listOfDetails = new ArrayList<>();

    private Currency profit;

    private Currency bestProfit;

    public CurrencyModel() {
    }


    @PostConstruct
    protected void init() throws RepositoryException, LoginException {

        HashMap<String, Object> param = new HashMap<>();

        //OSGi "Service User Mapper" config -> challenge.core:challengeServiceUser=challengeServiceUser
        param.put(ResourceResolverFactory.SUBSERVICE, "challengeServiceUser");

        ResourceResolver resourceResolver = resolverFactory.getServiceResourceResolver(param);

        Resource currencyResource = resourceResolver.getResource("/content/challenge/currencies/");
        Node rootNode = currencyResource.adaptTo(Node.class);
        //resp.getWriter().write(" - " + node.getPath());

        NodeIterator currencies = rootNode.getNodes();
        System.out.println("init--------- " + currencyName + " - " + currencyDate);

        //for each currency name
        while(currencies.hasNext()) {
            Node currency = currencies.nextNode();
            System.out.println("currency: " + currency.getName());

            if(currency.getName().toLowerCase().equals(currencyName.toLowerCase())) {
                NodeIterator details = currency.getNodes();

                while(details.hasNext()) {
                    Node detail = details.nextNode();
                    System.out.println("    date: " + detail.getName());
                    if(detail.getName().equals(currencyDate)) {

                        PropertyIterator propertyIterator = detail.getProperties();
                        while (propertyIterator.hasNext()) {
                            Property property = propertyIterator.nextProperty();
                            if(property.getName() != "jcr:primaryType") {
                                System.out.println("        prop: " + property.getValue() + " " + property.getName());
                                listOfDetails.add(new Currency(property.getName(),  property.getDouble()));
                            }

                        }
                    }
                }
            }

        }

        // max profigit
        //Profit profit = new Profit();

        if(listOfDetails.size() > 0) {
            Currency min = listOfDetails.get(0);
            Currency max = listOfDetails.get(0);

            System.out.println("$$$$$$$$$$$$$$$$ " + listOfDetails.size());
            for (Currency curr : listOfDetails) {
                System.out.println(curr.toString());
                if (curr.getValue() < min.getValue()) {
                    min = curr;
                }

                if (curr.getValue() > max.getValue())
                    max = curr;

            }

            System.out.println("min: " + min.toString());
            System.out.println("max: " + max.toString());

            System.out.println("max profit: " + (max.getValue() - Double.parseDouble(currencyPrice)));

            BigDecimal profitValue = new BigDecimal(max.getValue() - Double.parseDouble(currencyPrice));
            profitValue = profitValue.setScale(2, BigDecimal.ROUND_HALF_EVEN);

            System.out.println("best profit " + profitValue);

            profit = new Currency(max.getTime(), profitValue.doubleValue());

        }


    }


    public String getCurrencyName(){
        return currencyName;
    }

    public String getCurrencyDate(){
        return currencyDate;
    }

    private String getCurrencyPrice() {
        return currencyPrice;
    }

    public List<Currency> getListOfDetails() {
        return listOfDetails;
    }

    public Currency getProfit() {
        return profit;
    }

    public Currency getBestProfit() {
        return bestProfit;
    }
}
