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

<p align="center">
  <img src="https://uc8c982049f705f4475fc4b5583a.previews.dropboxusercontent.com/p/thumb/AAYWX5PbFMoTvN6oSbMnbaa_AaZIAIDJQ_KG6nNEB_Zz6oIkeAbXqTlUBxtTduTkR8AP4UaD0ikmaBiyPzIgSeF_1a4neyfb9Ly0fFrALah6KSi5NBthAYKTIu0dUF2vvwhN74RZ33KxPHnwDXp8hAHxdDl1xYMazQFv8Wy9xHg0lLyiv_7ejpMX3Jn5NQ8F8M-8KYDNbKmOadDGSCOMwnMhngEtFO7r6pJlmAa-HOlypdx2_n0GYujASmpuKh-0mj5RiR8yQ4i8pMbrvB0Wlc7oLtaepWTxQ4ebPJ8JWmsf_gyTyRIYX4CblpzDXTE2ogI95GmGKVLQ-L_pMWO1_ESJDgA8WQIqv2mRO0TLHd6sCMkobw3Scfk0D-LkAlqXbRRu4-jglAjfovrEgjNpUUU1CGhMIsrlfw8HvopfDxKzUAi1fWdVuj73mgiunqxDSPHCZJyLDcN-CTkcSesVyZaG8Y5X3epYNbUk4QehgTrq76E8qs5Qn5w1u-pZrrYD4SY/p.png?size_mode=5">
</p>

    ETH - http://localhost:4502/editor.html/content/challenge/cryptocurrencies/eth.html
<p align="center">
  <img src="https://uc9ffc96c75ca0144a94d8d60039.previews.dropboxusercontent.com/p/thumb/AAaKnFK-w1hFefISVLhrDfATwnh0LVOcOQ4z15I8D_07kRuGpy2TdTIA3pUUbH0XCT34WkiWUPeYu3s-k_zTPOjGXv90uZEZospp3dpm223cAw6IRoyY_SsjbeEnUhT2ltV8KxTHXn7xBO-h-be7F5UV8fl_WasXluYcLkdh6T5G6mGtXd3lp3yCkn2Gz-3m645cGSTEu0M8aF5-Pmv60AbjAXcjB1Al1dUrK33GXUx4DakqlBmkHz6Gu32T9FG0DaNY5-LRX1o0HgJ9-tEsvT_idszNJq7Le01mS1FzDVm33x3NW2dX9d_GqJAiJWavDgUFWlmaioX8altLVAN-EK1HvjhjKFSQm3fGKb-ogMnpJ8IF4xMd4MoS9EiX4XBBFY6BM26Z7-0tqExLMHgLemNNJen2w0kmt11liwpcUuveGGbDzeWQQt5FURetKbhmo1Mhs211QoLfWX3n83zgtysFu5svu5XpfJU0wxjYTQlV0iNZ54dAeNrC1bF2qvzGKuU/p.png?size_mode=5">
</p>

    LTC - http://localhost:4502/editor.html/content/challenge/cryptocurrencies/ltc.html
<p align="center">
  <img src="https://ucf543e36d9b1857c0708c90ce48.previews.dropboxusercontent.com/p/thumb/AAZKfK55aXxwPUtcnAq9XakhXuXm56rptGvrb9Ye5cPjkujB_SlhbdI0sPoXFKfATM3CJoFk5AJUVgWGK2D7keLlPohxNNy78I0eUegrVY9W2LWiQEeAu28mWO69GjvIysvw7tlcLBppwhmqLcL3ws3Flc9NQFrEPslzNnLIbIRen_pFW7z6z2N_n5owXiJIObfctvbeY1nw13Km_FMIRMRfVJAtqawjfUKXsIYJyHir-zPkVoEFqxJQTg7RGW3vHDswl_2QR_BkMEibpXXVHoeIHXWTovyb4-fFdHjSI77n--4PeKBx9yvpSdPhDNYw9dWgbd-ba6EkSmYuJIySR-GzAl2hTQQNwQSYp87oGQKLVPd9QntroSrGSxXg7z7gMIgLB6-EKvFei5Ma11sIgNlV5TcDA5GgnLi8oMG6gt4CuSs6xytfI4mn21Bk39YdWgawvTm-JbOnHvsRWo4E6_A9cu60B6fHDolw53k5_DTPaWo3O0_lqDyuqij4V0UxkkA/p.png?size_mode=5">
</p>

## Information about the back-end

* The Sling Model reads the information form the crx repository located in the path /content/challenge/currencies
        Model: com.cab.challenge.core.models

<p align="center">
  <img src="https://uc69f50dc5a3e2bc4bb7a211e72c.previews.dropboxusercontent.com/p/thumb/AAbRNxbY2r-C7qI5IyGHu00LlucXy0YojqkemV_lmUaKt1xsAndu97qJIgAcS6uSZp6O_jY6EDcocXq1nIAzd3j6OHOiuPLnbFv0hqYwbqY0AvM6dGA797fwlloEpK058XDP1vtmeFt2UTsogvShAcFe1zwmQMR6L8h4NqGs9SlgrWZrRS8TGafLn9-JLs69xkiZWQJTlgGWseKDAxcEkxle9fQMyurIBs-PY4XQ7EZXLgbPTX2Vas0t64DkqUoW01yWZJ-be3Q2loqfOOMtR5aZ-qCQr7N_5fayGujRMfWw5IE4m1Ny9ic_uIoKJyFM6i7A_g7i7Fwlk4jLJmwi2W2L7eJ8ns1gniUgfnNm3RJaDQetj8zc_KY4FxGvAedvXtWFMUrBXpsgCJgphvfhHB4887qCAXOunlMZoyfdQZkAKgCqWOrokfVBIHFXtXdWfJcPaKmFfq20ob69BT7fY399HCmwmaS3YdgKgKd9XpUXq-sAKzx0gcMBHV3Wo_xxJdA/p.png?size_mode=5">
</p>

* It will filter the information based in the values entered in the author interface
        Currency Name - for example "BTC"
        Currency Date - for example "20180507"
        Buying price - for example "14.32" (this is a very simple author interface, it could be improved by adding a list of possible prices from the backend)

<p align="center">
  <img src="https://uceb202e7b06fff3c1c6641614db.previews.dropboxusercontent.com/p/thumb/AAZ3j4Fxe4JrJvLxVBuqLfdEtjuB4yFEX4u-jlMRpEQy_cuoVReWs9Hqanc-V7HvFrNss0KGEodr-u3E1kpxunCEuP21StSHhV5B7wZoQGVcdvkb6SF5sGFIOqkWkvXC3kSQgHh9LP-vAN932-bywJSSeq6dqdUuGMJUpBYMMNvFDfTWmYU0qZ3lmmn5dQhoWFrucOY2uYCaNzzfktE3zJbdiJG0Rk_TAGa8jOVJBSJJUsaXB9jPzpFnGKbuFjJO4fqlHrrkes6IE-5-B3H0BR3bJaPo8AiH0SVs_CYiwEZn4fhtvX0dIElL35KOR9uxANiM-atdqOEJXi1pza7iqGCHlf0uouUEfVLMDsL_cVSb2NTMMcI6FY6B7mtKUaydRZGCOsChzT0Ri-8ueatllbpdx6PGs8cbKfOehyse_i5wWJ_TK6elY_vgYvd9V7YoVs03c0i4NVO4BMXQ-PWdB3ScyrvY6eg6oFAyjHhYYOiQpJT9XhJDnri8lQNcsuKyUVM/p.png?size_mode=5">
</p>

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
