/**
 * @author cbarrios
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CurrencyModel {

    @Inject
    private SlingSettingsService settings;

    @Inject
    @Named("sling:resourceType")
    @Default(values = "No resourceType")
    protected String resourceType;

    @Inject
    private ResourceResolverFactory resolverFactory;

    /**
     * Currency name from the author dialog
     */
    @Inject
    @Default(values = "")
    private String currencyName;

    /**
     * Currency date from the author dialog
     */
    @Inject
    @Default(values = "")
    private String currencyDate;

    /**
     * Currency buying price from the author dialog
     */
    @Inject
    @Default(values = "")
    private String currencyPrice;

    private List<Currency> listOfDetails = new ArrayList<>();

    private Currency profit;

    /**
     * Logger
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public CurrencyModel() {
    }


    @PostConstruct
    protected void init() throws RepositoryException, LoginException {

        HashMap<String, Object> param = new HashMap<>();

        //OSGi "Service User Mapper" config -> challenge.core:challengeServiceUser=challengeServiceUser
        param.put(ResourceResolverFactory.SUBSERVICE, Constants.SERVICE_USER);
        ResourceResolver resourceResolver = resolverFactory.getServiceResourceResolver(param);

        //path in the crx repository with the information for the currencies
        Resource currencyResource = resourceResolver.getResource(Constants.ROOT_PATH);
        Node rootNode = currencyResource.adaptTo(Node.class);

        NodeIterator currencies = rootNode.getNodes();

        //for each currency name
        while (currencies.hasNext()) {
            Node currency = currencies.nextNode();
            //the currency from the dialog matches the node
            if (currency.getName().toLowerCase().equals(currencyName.toLowerCase())) {
                NodeIterator details = currency.getNodes();
                while (details.hasNext()) {
                    Node detail = details.nextNode();
                    //the date from the dialog matches the node
                    if (detail.getName().equals(currencyDate)) {
                        PropertyIterator propertyIterator = detail.getProperties();
                        while (propertyIterator.hasNext()) {
                            Property property = propertyIterator.nextProperty();
                            //ignore the "jcr:primaryType" property
                            if (property.getName() != Constants.JCR_PRIMARY_TYPE) {
                                listOfDetails.add(new Currency(property.getName(), property.getDouble()));
                            }

                        }
                    }
                }
            }
        }

        //there is information about currencies
        if (listOfDetails.size() > 0) {
            Currency max = listOfDetails.get(0);
            for (Currency curr : listOfDetails) {
                System.out.println(curr.toString());
                //highest price
                if (curr.getValue() > max.getValue())
                    max = curr;
            }

            //profit -> max - input from the author dialog
            BigDecimal profitValue = new BigDecimal(max.getValue() - Double.parseDouble(currencyPrice));
            profitValue = profitValue.setScale(2, BigDecimal.ROUND_HALF_EVEN);

            //pojo with the information about the best profit
            profit = new Currency(max.getTime(), profitValue.doubleValue());
            logger.info("Max profit is [" + profitValue + "] for a buying price of[" + currencyPrice + "]");

        }


    }


    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencyDate() {
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

}
