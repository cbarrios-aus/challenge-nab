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

    ETH - http://localhost:4502/editor.html/content/challenge/cryptocurrencies/eth.html

    LTC - http://localhost:4502/editor.html/content/challenge/cryptocurrencies/ltc.html


## Information about the back-end


* The Sling Model reads the information form the crx repository located in the path /content/challenge/currencies
        Model: com.cab.challenge.core.models
* It will filter the information based in the values entered in the author interface
        Currency Name - for example "BTC"
        Currency Date - for example "20180507"
        Buying price - for example "14.32" (this is a very simple author interface, it could be improved by adding a list of possible prices from the backend)
* The AEM Component will show the list of time-price for that currency in the entered date and calculate the "best profit"

## Maven settings

The project comes with the auto-public repository configured. To setup the repository in your Maven settings, refer to:

    http://helpx.adobe.com/experience-manager/kb/SetUpTheAdobeMavenRepository.html
