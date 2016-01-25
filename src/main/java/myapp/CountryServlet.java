package myapp;

import java.io.IOException;
import javax.servlet.http.*;

/**
 * Provides information on countries.
 */
public class CountryServlet extends HttpServlet {

    static final int AMERICA = 187;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String countryStr = req.getParameter("countryID");
        if (countryStr != null) {
          try {
            int countryID = Integer.parseInt(countryStr);
            if (countryID < 0 || countryID >= Common.NUM_COUNTRIES) {
              Common.errorMessage(resp, "countryID not a valid ID.");
            } else {
              resp.setContentType("aplication/json");
              resp.getWriter().println("{ \"name\": \"" +
                getCountryName(countryID) + "\", \"image\": \"" +
                getCountryImage(countryID) + "\" }");
            }
          } catch (NumberFormatException ex) {
            Common.errorMessage(resp, "countryID not a number.");
          }
        } else {
          Common.errorMessage(resp, "countryID not provided.");
        }
    }

    /**
     * Get a picture of a country given it's unique ID.
     */
    public String getCountryImage(int id) {
      String url = "";
      if (id >= 0 && id < Common.NUM_COUNTRIES) {
        url = "pictures/country_" + id + ".png";
      }
      return url;
    }

    /**
     * Get the name of a country given it's unique ID.
     */
    public String getCountryName(int id) {
      String country = "Invalid country";
      switch (id) {
        case 0:
          country = "Afghanistan";
          break;
        case 1:
          country = "Albania";
          break;
        case 2:
          country = "Algeria";
          break;
        case 3:
          country = "Andorra";
          break;
        case 4:
          country = "Angola";
          break;
        case 5:
          country = "Antigua and Barbuda";
          break;
        case 6:
          country = "Argentina";
          break;
        case 7:
          country = "Armenia";
          break;
        case 8:
          country = "Australia";
          break;
        case 9:
          country = "Austria";
          break;
        case 10:
          country = "Azerbaijan";
          break;
        case 11:
          country = "Bahamas";
          break;
        case 12:
          country = "Bahrain";
          break;
        case 13:
          country = "Bangladesh";
          break;
        case 14:
          country = "Barbados";
          break;
        case 15:
          country = "Belarus";
          break;
        case 16:
          country = "Belgium";
          break;
        case 17:
          country = "Belize";
          break;
        case 18:
          country = "Benin";
          break;
        case 19:
          country = "Bhutan";
          break;
        case 20:
          country = "Bolivia";
          break;
        case 21:
          country = "Bosnia and Herzegovina";
          break;
        case 22:
          country = "Botswana";
          break;
        case 23:
          country = "Brazil";
          break;
        case 24:
          country = "Brunei";
          break;
        case 25:
          country = "Bulgaria";
          break;
        case 26:
          country = "Burkina Faso";
          break;
        case 27:
          country = "Burundi";
          break;
        case 28:
          country = "Cabo Verde";
          break;
        case 29:
          country = "Cambodia";
          break;
        case 30:
          country = "Cameroon";
          break;
        case 31:
          country = "Canada";
          break;
        case 32:
          country = "Central African Republic";
          break;
        case 33:
          country = "Chad";
          break;
        case 34:
          country = "Chile";
          break;
        case 35:
          country = "China";
          break;
        case 36:
          country = "Colombia";
          break;
        case 37:
          country = "Comoros";
          break;
        case 38:
          country = "Congo, Republic of the";
          break;
        case 39:
          country = "Congo, Democratic Republic of the";
          break;
        case 40:
          country = "Costa Rica";
          break;
        case 41:
          country = "Cote d'Ivoire";
          break;
        case 42:
          country = "Croatia";
          break;
        case 43:
          country = "Cuba";
          break;
        case 44:
          country = "Cyprus";
          break;
        case 45:
          country = "Czech Republic";
          break;
        case 46:
          country = "Denmark";
          break;
        case 47:
          country = "Djibouti";
          break;
        case 48:
          country = "Dominica";
          break;
        case 49:
          country = "Dominican Republic";
          break;
        case 50:
          country = "Ecuador";
          break;
        case 51:
          country = "Egypt";
          break;
        case 52:
          country = "El Salvador";
          break;
        case 53:
          country = "Equatorial Guinea";
          break;
        case 54:
          country = "Eritrea";
          break;
        case 55:
          country = "Estonia";
          break;
        case 56:
          country = "Ethiopia";
          break;
        case 57:
          country = "Fiji";
          break;
        case 58:
          country = "Finland";
          break;
        case 59:
          country = "France";
          break;
        case 60:
          country = "Gabon";
          break;
        case 61:
          country = "Gambia";
          break;
        case 62:
          country = "Georgia";
          break;
        case 63:
          country = "Germany";
          break;
        case 64:
          country = "Ghana";
          break;
        case 65:
          country = "Greece";
          break;
        case 66:
          country = "Grenada";
          break;
        case 67:
          country = "Guatemala";
          break;
        case 68:
          country = "Guinea";
          break;
        case 69:
          country = "Guinea-Bissau";
          break;
        case 70:
          country = "Guyana";
          break;
        case 71:
          country = "Haiti";
          break;
        case 72:
          country = "Honduras";
          break;
        case 73:
          country = "Hungary";
          break;
        case 74:
          country = "Iceland";
          break;
        case 75:
          country = "India";
          break;
        case 76:
          country = "Indonesia";
          break;
        case 77:
          country = "Iran";
          break;
        case 78:
          country = "Iraq";
          break;
        case 79:
          country = "Ireland";
          break;
        case 80:
          country = "Israel";
          break;
        case 81:
          country = "Italy";
          break;
        case 82:
          country = "Jamaica";
          break;
        case 83:
          country = "Japan";
          break;
        case 84:
          country = "Jordan";
          break;
        case 85:
          country = "Kazakhstan";
          break;
        case 86:
          country = "Kenya";
          break;
        case 87:
          country = "Kiribati";
          break;
        case 88:
          country = "Kosovo";
          break;
        case 89:
          country = "Kuwait";
          break;
        case 90:
          country = "Kyrgyzstan";
          break;
        case 91:
          country = "Laos";
          break;
        case 92:
          country = "Latvia";
          break;
        case 93:
          country = "Lebanon";
          break;
        case 94:
          country = "Lesotho";
          break;
        case 95:
          country = "Liberia";
          break;
        case 96:
          country = "Libya";
          break;
        case 97:
          country = "Liechtenstein";
          break;
        case 98:
          country = "Lithuania";
          break;
        case 99:
          country = "Luxembourg";
          break;
        case 100:
          country = "Macedonia";
          break;
        case 101:
          country = "Madagascar";
          break;
        case 102:
          country = "Malawi";
          break;
        case 103:
          country = "Malaysia";
          break;
        case 104:
          country = "Maldives";
          break;
        case 105:
          country = "Mali";
          break;
        case 106:
          country = "Malta";
          break;
        case 107:
          country = "Marshall Islands";
          break;
        case 108:
          country = "Mauritania";
          break;
        case 109:
          country = "Mauritius";
          break;
        case 110:
          country = "Mexico";
          break;
        case 111:
          country = "Micronesia";
          break;
        case 112:
          country = "Moldova";
          break;
        case 113:
          country = "Monaco";
          break;
        case 114:
          country = "Mongolia";
          break;
        case 115:
          country = "Montenegro";
          break;
        case 116:
          country = "Morocco";
          break;
        case 117:
          country = "Mozambique";
          break;
        case 118:
          country = "Myanmar (Burma)";
          break;
        case 119:
          country = "Namibia";
          break;
        case 120:
          country = "Nauru";
          break;
        case 121:
          country = "Nepal";
          break;
        case 122:
          country = "Netherlands";
          break;
        case 123:
          country = "New Zealand";
          break;
        case 124:
          country = "Nicaragua";
          break;
        case 125:
          country = "Niger";
          break;
        case 126:
          country = "Nigeria";
          break;
        case 127:
          country = "North Korea";
          break;
        case 128:
          country = "Norway";
          break;
        case 129:
          country = "Oman";
          break;
        case 130:
          country = "Pakistan";
          break;
        case 131:
          country = "Palau";
          break;
        case 132:
          country = "Palestine";
          break;
        case 133:
          country = "Panama";
          break;
        case 134:
          country = "Papua New Guinea";
          break;
        case 135:
          country = "Paraguay";
          break;
        case 136:
          country = "Peru";
          break;
        case 137:
          country = "Philippines";
          break;
        case 138:
          country = "Poland";
          break;
        case 139:
          country = "Portugal";
          break;
        case 140:
          country = "Qatar";
          break;
        case 141:
          country = "Romania";
          break;
        case 142:
          country = "Russia";
          break;
        case 143:
          country = "Rwanda";
          break;
        case 144:
          country = "St. Kitts and Nevis";
          break;
        case 145:
          country = "St. Lucia";
          break;
        case 146:
          country = "St. Vincent and The Grenadines";
          break;
        case 147:
          country = "Samoa";
          break;
        case 148:
          country = "San Marino";
          break;
        case 149:
          country = "Sao Tome and Principe";
          break;
        case 150:
          country = "Saudi Arabia";
          break;
        case 151:
          country = "Senegal";
          break;
        case 152:
          country = "Serbia";
          break;
        case 153:
          country = "Seychelles";
          break;
        case 154:
          country = "Sierra Leone";
          break;
        case 155:
          country = "Singapore";
          break;
        case 156:
          country = "Slovakia";
          break;
        case 157:
          country = "Slovenia";
          break;
        case 158:
          country = "Solomon Islands";
          break;
        case 159:
          country = "Somalia";
          break;
        case 160:
          country = "South Africa";
          break;
        case 161:
          country = "South Korea";
          break;
        case 162:
          country = "South Sudan";
          break;
        case 163:
          country = "Spain";
          break;
        case 164:
          country = "Sri Lanka";
          break;
        case 165:
          country = "Sudan";
          break;
        case 166:
          country = "Suriname";
          break;
        case 167:
          country = "Swaziland";
          break;
        case 168:
          country = "Sweden";
          break;
        case 169:
          country = "Switzerland";
          break;
        case 170:
          country = "Syria";
          break;
        case 171:
          country = "Taiwan";
          break;
        case 172:
          country = "Tajikistan";
          break;
        case 173:
          country = "Tanzania";
          break;
        case 174:
          country = "Thailand";
          break;
        case 175:
          country = "Timor-Leste";
          break;
        case 176:
          country = "Togo";
          break;
        case 177:
          country = "Tonga";
          break;
        case 178:
          country = "Trinidad and Tobago";
          break;
        case 179:
          country = "Tunisia";
          break;
        case 180:
          country = "Turkey";
          break;
        case 181:
          country = "Turkmenistan";
          break;
        case 182:
          country = "Tuvalu";
          break;
        case 183:
          country = "Uganda";
          break;
        case 184:
          country = "Ukraine";
          break;
        case 185:
          country = "United Arab Emirates";
          break;
        case 186:
          country = "UK (United Kingdom)";
          break;
        case 187:
          country = "USA (United States of America)";
          break;
        case 188:
          country = "Uruguay";
          break;
        case 189:
          country = "Uzbekistan";
          break;
        case 190:
          country = "Vanuatu";
          break;
        case 191:
          country = "Vatican City (Holy See)";
          break;
        case 192:
          country = "Venezuela";
          break;
        case 193:
          country = "Vietnam";
          break;
        case 194:
          country = "Yemen";
          break;
        case 195:
          country = "Zambia";
          break;
        case 196:
          country = "Zimbabwe";
          break;
        default:
          country = "Invalid country";
          break;
      }
      return country;
    }

}
