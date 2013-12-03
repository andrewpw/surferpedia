package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds Country type for Country validation and search box list.
 * @author eduardgamiao
 *
 */
public class CountryType {
  
  private static String [] countryTypes = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", 
    "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", 
    "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", 
    "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", 
    "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", 
    "Canada", "Cape Verde", "Central African Republic", "Chad", "Chile", "China", 
    "Colombia", "Comoros", "Congo", "Congo", "Costa Rica", "Croatia", 
    "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", 
    "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", 
    "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", 
    "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", 
    "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", 
    "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", 
    "Iraq", "Ireland", "Israel", "Italy", "Ivory Coast", "Jamaica", 
    "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", 
    "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", 
    "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", 
    "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", 
    "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", 
    "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", 
    "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", 
    "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", 
    "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", 
    "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", 
    "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", 
    "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", 
    "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", 
    "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", 
    "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", 
    "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", 
    "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", 
    "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", 
    "Yemen", "Zambia", "Zimbabwe"};
  
  /**
   * Return ammping of the countries of surfers.
   * @return Mapping of countries of surfers.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> countryMap = new HashMap<String, Boolean>();
    for (String type : countryTypes) {
      countryMap.put(type, false);
    }
    return countryMap;
  }
  
  /**
   * Return a mapping of the types of Surfers.
   * @param country The country of Surfer.
   * @return A mapping of Surfer countries.
   */
  public static Map<String, Boolean> getTypes(String country) {
    Map<String, Boolean> countryMap = SurferTypes.getTypes();
    if (isType(country)) {
      countryMap.put(country, true);
    }
    return countryMap;
  }
  
  /**
   * Check if a country input is a valid country.
   * @param country The country to check.
   * @return True if the country is valid, false otherwise.
   */
  public static boolean isType(String country) {
    return getTypes().containsKey(country);
  }
  
  
}
