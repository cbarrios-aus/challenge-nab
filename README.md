# AEM Challenge NAB

This project is based in the Archetype 13 for AEM 6.4

You need to have an AEM 6.4 instance in order to test the functionality

## How to build

To build and install, simple execute:

    mvn clean install -PautoInstallPackage

## Testing Content pages

After installing the project, log in to the instance

    http://localhost:4502/

Open the test pages:

    BTC - http://localhost:4502/editor.html/content/challenge/cryptocurrencies/btc.html
    <img src="https://www.dropbox.com/s/9xtgg08xvb0wfro/1-dialog-btc.png" alt="btc image"/>

    ETH - http://localhost:4502/editor.html/content/challenge/cryptocurrencies/eth.html
    <img src="https://www.dropbox.com/s/5nspjjuujcvosh2/2-dialog-eth.png" alt="eth image"/>

    LTC - http://localhost:4502/editor.html/content/challenge/cryptocurrencies/ltc.html
    <img src="https://www.dropbox.com/s/uw7xbod7aesbjxd/3-dialog-etc.png" alt="ltc image"/>


## Information about the back-end

* The Sling Model reads the information form the crx repository located in the path /content/challenge/currencies
        Model: com.cab.challenge.core.models

        <img src="https://www.dropbox.com/s/09k3zuli6bilypx/0-crx.png" alt="crx image"/>

* It will filter the information based in the values entered in the author interface
        Currency Name - for example "BTC"
        Currency Date - for example "20180507"
        Buying price - for example "14.32" (this is a very simple author interface, it could be improved by adding a list of possible prices from the backend)

        <img src="https://www.dropbox.com/s/0cvbif84ax9914r/0-dialog.png" alt="dialog image"/>

* The AEM Component will show the list of time-price for that currency in the entered date and calculate the "best profit"

## Notes

* In order to get access to the jcr repository will need to add a service user "challengeServiceUser" and give it the read permissions.

        https://helpx.adobe.com/au/experience-manager/6-4/sites/administering/using/security-service-users.html#Creatinganewserviceuser

* The classes used for backend code are:
        CurrencyModel.java
        Currency.java

* The AEM test component "Currencies Component" is located in "ui.apps/src/main/content/jcr_root/apps/challenge/components/content/currencies/currencies.html"


## Maven settings

The project comes with the auto-public repository configured. To setup the repository in your Maven settings, refer to:

    http://helpx.adobe.com/experience-manager/kb/SetUpTheAdobeMavenRepository.html
