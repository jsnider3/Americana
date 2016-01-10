package myapp;

import java.io.IOException;
import javax.servlet.http.*;

public class MainServlet extends HttpServlet {

    final static int NUM_COUNTRIES = 197;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String countryStr = req.getParameter("countryID");
        if (countryStr != null) {
          try {
            int countryID = Integer.parseInt(countryStr);
            if (countryID < 0 || countryID >= NUM_COUNTRIES) {
              errorMessage(resp, "countryID not a valid ID.");
            } else {
              resp.setContentType("text/plain");
              resp.getWriter().println("{ \"name\": \"" +
                getCountryName(countryID) + "\", \"image\": \"" +
                getCountryImage(countryID) + "\" }");
            }
          } catch (NumberFormatException ex) {
            errorMessage(resp, "countryID not a number.");
          }
        } else {
          errorMessage(resp, "countryID not provided.");
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
      errorMessage(resp, "Not implemented yet.");
    }

    /**
     * Write an error message to a servlet response.
     */
    private void errorMessage(HttpServletResponse resp, String msg)
          throws IOException {
      resp.setStatus(400);
      resp.setContentType("text/plain");
      resp.getWriter().println("{ \"message\": \"" + msg + "\" }");
    }

    /**
     * Get a picture of a country given it's unique ID.
     */
    private String getCountryImage(int id) {
      String url = "";
      switch (id) {
        case 0: //Afghanistan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Afghanistan_%28orthographic_projection%29.svg/250px-Afghanistan_%28orthographic_projection%29.svg.png";
          break;
        case 1: //Albania
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Europe-Albania.svg/250px-Europe-Albania.svg.png";
          break;
        case 2: //Algeria
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Algeria_%28orthographic_projection%29.svg/250px-Algeria_%28orthographic_projection%29.svg.png";
          break;
        case 3: //Andorra
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Location_Andorra_Europe.png/250px-Location_Andorra_Europe.png";
          break;
        case 4: //Angola
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Location_Angola_AU_Africa.svg/250px-Location_Angola_AU_Africa.svg.png";
          break;
        case 5: //Antigua and Barbuda
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/ATG_orthographic.svg/250px-ATG_orthographic.svg.png";
          break;
        case 6: //Argentina
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Argentina_orthographic.svg/220px-Argentina_orthographic.svg.png";
          break;
        case 7: //Armenia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Armenia_%28orthographic_projection%29.svg/250px-Armenia_%28orthographic_projection%29.svg.png";
          break;
        case 8: //Australia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Australia_with_AAT_%28orthographic_projection%29.svg/220px-Australia_with_AAT_%28orthographic_projection%29.svg.png";
          break;
        case 9: //Austria
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/EU-Austria.svg/250px-EU-Austria.svg.png";
          break;
        case 10: //Azerbaijan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Azerbaijan_%28orthographic_projection%29.svg/250px-Azerbaijan_%28orthographic_projection%29.svg.png";
          break;
        case 11: //Bahamas
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/LocationBahamas.svg/250px-LocationBahamas.svg.png";
          break;
        case 12: //Bahrain
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Bahrain_on_the_globe_%28Afro-Eurasia_centered%29.svg/250px-Bahrain_on_the_globe_%28Afro-Eurasia_centered%29.svg.png";
          break;
        case 13: //Bangladesh
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Bangladesh_%28orthographic_projection%29.svg/250px-Bangladesh_%28orthographic_projection%29.svg.png";
          break;
        case 14: //Barbados
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/BRB_orthographic.svg/250px-BRB_orthographic.svg.png";
          break;
        case 15: //Belarus
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Europe-Belarus.svg/250px-Europe-Belarus.svg.png";
          break;
        case 16: //Belgium
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/EU-Belgium.svg/250px-EU-Belgium.svg.png";
          break;
        case 17: //Belize
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/BLZ_orthographic.svg/250px-BLZ_orthographic.svg.png";
          break;
        case 18: //Benin
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Location_Benin_AU_Africa.svg/250px-Location_Benin_AU_Africa.svg.png";
          break;
        case 19: //Bhutan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Bhutan_%28orthographic_projection%29.svg/250px-Bhutan_%28orthographic_projection%29.svg.png";
          break;
        case 20: //Bolivia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Bolivia_%28orthographic_projection%29.svg/220px-Bolivia_%28orthographic_projection%29.svg.png";
          break;
        case 21: //Bosnia and Herzegovina
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Europe-Bosnia_and_Herzegovina.svg/250px-Europe-Bosnia_and_Herzegovina.svg.png";
          break;
        case 22: //Botswana
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Location_Botswana_AU_Africa.svg/250px-Location_Botswana_AU_Africa.svg.png";
          break;
        case 23: //Brazil
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Brazil_%28orthographic_projection%29.svg/250px-Brazil_%28orthographic_projection%29.svg.png";
          break;
        case 24: //Brunei
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Location_Brunei_ASEAN.svg/250px-Location_Brunei_ASEAN.svg.png";
          break;
        case 25: //Bulgaria
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/EU-Bulgaria.svg/250px-EU-Bulgaria.svg.png";
          break;
        case 26: //Burkina Faso
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Location_Burkina_Faso_AU_Africa.svg/250px-Location_Burkina_Faso_AU_Africa.svg.png";
          break;
        case 27: //Burundi
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Location_Burundi_AU_Africa.svg/250px-Location_Burundi_AU_Africa.svg.png";
          break;
        case 28: //Cabo Verde
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/Location_Cape_Verde_AU_Africa.svg/250px-Location_Cape_Verde_AU_Africa.svg.png";
          break;
        case 29: //Cambodia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Location_Cambodia_ASEAN.svg/250px-Location_Cambodia_ASEAN.svg.png";
          break;
        case 30: //Cameroon
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Location_Cameroon_AU_Africa.svg/250px-Location_Cameroon_AU_Africa.svg.png";
          break;
        case 31: //Canada
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/Canada_%28orthographic_projection%29.svg/220px-Canada_%28orthographic_projection%29.svg.png";
          break;
        case 32: //Central African Republic
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Location_Central_African_Republic_AU_Africa.svg/250px-Location_Central_African_Republic_AU_Africa.svg.png";
          break;
        case 33: //Chad
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Chad_%28orthographic_projection%29.svg/250px-Chad_%28orthographic_projection%29.svg.png";
          break;
        case 34: //Chile
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Chile_%28orthographic_projection%29.svg/220px-Chile_%28orthographic_projection%29.svg.png";
          break;
        case 35: //China
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/People%27s_Republic_of_China_%28orthographic_projection%29.svg/220px-People%27s_Republic_of_China_%28orthographic_projection%29.svg.png";
          break;
        case 36: //Colombia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/COL_orthographic_%28San_Andr%C3%A9s_and_Providencia_special%29.svg/250px-COL_orthographic_%28San_Andr%C3%A9s_and_Providencia_special%29.svg.png";
          break;
        case 37: //Comoros
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Location_Comoros_AU_Africa.svg/250px-Location_Comoros_AU_Africa.svg.png";
          break;
        case 38: //Congo, Republic of the
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Location_Republic_of_the_Congo_AU_Africa.svg/250px-Location_Republic_of_the_Congo_AU_Africa.svg.png";
          break;
        case 39: //Congo, Democratic Republic of the
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Democratic_Republic_of_the_Congo_%28orthographic_projection%29.svg/250px-Democratic_Republic_of_the_Congo_%28orthographic_projection%29.svg.png";
          break;
        case 40: //Costa Rica
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Costa_Rica_%28orthographic_projection%29.svg/250px-Costa_Rica_%28orthographic_projection%29.svg.png";
          break;
        case 41: //Cote d'Ivoire
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Location_C%C3%B4te_d%27Ivoire_AU_Africa.svg/250px-Location_C%C3%B4te_d%27Ivoire_AU_Africa.svg.png";
          break;
        case 42: //Croatia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/EU-Croatia.svg/250px-EU-Croatia.svg.png";
          break;
        case 43: //Cuba
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Cuba_%28orthographic_projection%29.svg/250px-Cuba_%28orthographic_projection%29.svg.png";
          break;
        case 44: //Cyprus
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/EU-Cyprus.svg/250px-EU-Cyprus.svg.png";
          break;
        case 45: //Czech Republic
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/EU-Czech_Republic.svg/250px-EU-Czech_Republic.svg.png";
          break;
        case 46: //Denmark
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/EU-Denmark.svg/250px-EU-Denmark.svg.png";
          break;
        case 47: //Djibouti
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/Djibouti_%28orthographic_projection%29.svg/250px-Djibouti_%28orthographic_projection%29.svg.png";
          break;
        case 48: //Dominica
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Dominica_on_the_globe_%28Americas_centered%29.svg/250px-Dominica_on_the_globe_%28Americas_centered%29.svg.png";
          break;
        case 49: //Dominican Republic
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Dominican_Republic_%28orthographic_projection%29.svg/250px-Dominican_Republic_%28orthographic_projection%29.svg.png";
          break;
        case 50: //Ecuador
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Ecuador_%28orthographic_projection%29.svg/250px-Ecuador_%28orthographic_projection%29.svg.png";
          break;
        case 51: //Egypt
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Egypt_%28orthographic_projection%29_highlighted.svg/250px-Egypt_%28orthographic_projection%29_highlighted.svg.png";
          break;
        case 52: //El Salvador
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/LocationElSalvador.svg/250px-LocationElSalvador.svg.png";
          break;
        case 53: //Equatorial Guinea
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Location_Equatorial_Guinea_AU_Africa.svg/250px-Location_Equatorial_Guinea_AU_Africa.svg.png";
          break;
        case 54: //Eritrea
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Eritrea_%28Africa_orthographic_projection%29.svg/250px-Eritrea_%28Africa_orthographic_projection%29.svg.png";
          break;
        case 55: //Estonia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/EU-Estonia.svg/250px-EU-Estonia.svg.png";
          break;
        case 56: //Ethiopia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Ethiopia_%28Africa_orthographic_projection%29.svg/250px-Ethiopia_%28Africa_orthographic_projection%29.svg.png";
          break;
        case 57: //Fiji
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Fiji_on_the_globe_%28small_islands_magnified%29_%28Polynesia_centered%29.svg/250px-Fiji_on_the_globe_%28small_islands_magnified%29_%28Polynesia_centered%29.svg.png";
          break;
        case 58: //Finland
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/EU-Finland.svg/250px-EU-Finland.svg.png";
          break;
        case 59: //France
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/EU-France.svg/250px-EU-France.svg.png";
          break;
        case 60: //Gabon
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Location_Gabon_AU_Africa.svg/250px-Location_Gabon_AU_Africa.svg.png";
          break;
        case 61: //Gambia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Location_Gambia_AU_Africa.svg/250px-Location_Gambia_AU_Africa.svg.png";
          break;
        case 62: //Georgia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Georgia_%28orthographic_projection_with_inset%29.svg/250px-Georgia_%28orthographic_projection_with_inset%29.svg.png";
          break;
        case 63: //Germany
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/EU-Germany.svg/250px-EU-Germany.svg.png";
          break;
        case 64: //Ghana
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Ghana_%28orthographic_projection%29.svg/250px-Ghana_%28orthographic_projection%29.svg.png";
          break;
        case 65: //Greece
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/EU-Greece.svg/250px-EU-Greece.svg.png";
          break;
        case 66: //Grenada
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Grenada_in_its_region.svg/250px-Grenada_in_its_region.svg.png";
          break;
        case 67: //Guatemala
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Guatemala_%28orthographic_projection%29.svg/250px-Guatemala_%28orthographic_projection%29.svg.png";
          break;
        case 68: //Guinea
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Location_Guinea_AU_Africa.svg/250px-Location_Guinea_AU_Africa.svg.png";
          break;
        case 69: //Guinea-Bissau
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Location_Guinea_Bissau_AU_Africa.svg/250px-Location_Guinea_Bissau_AU_Africa.svg.png";
          break;
        case 70: //Guyana
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Guyana_%28orthographic_projection%29.svg/250px-Guyana_%28orthographic_projection%29.svg.png";
          break;
        case 71: //Haiti
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Haiti_%28orthographic_projection%29.svg/250px-Haiti_%28orthographic_projection%29.svg.png";
          break;
        case 72: //Honduras
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Honduras_%28orthographic_projection%29.svg/250px-Honduras_%28orthographic_projection%29.svg.png";
          break;
        case 73: //Hungary
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/EU-Hungary.svg/250px-EU-Hungary.svg.png";
          break;
        case 74: //Iceland
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/Iceland_%28orthographic_projection%29.svg/220px-Iceland_%28orthographic_projection%29.svg.png";
          break;
        case 75: //India
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/India_%28orthographic_projection%29.svg/250px-India_%28orthographic_projection%29.svg.png";
          break;
        case 76: //Indonesia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/Location_Indonesia_ASEAN.svg/250px-Location_Indonesia_ASEAN.svg.png";
          break;
        case 77: //Iran
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Iran_%28orthographic_projection%29.svg/250px-Iran_%28orthographic_projection%29.svg.png";
          break;
        case 78: //Iraq
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Iraq_%28orthographic_projection%29.svg/250px-Iraq_%28orthographic_projection%29.svg.png";
          break;
        case 79: //Ireland
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Map_of_Ireland_in_Europe.svg/255px-Map_of_Ireland_in_Europe.svg.png";
          break;
        case 80: //Israel
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/ISR_orthographic.svg/250px-ISR_orthographic.svg.png";
          break;
        case 81: //Italy
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/EU-Italy.svg/250px-EU-Italy.svg.png";
          break;
        case 82: //Jamaica
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Jamaica_%28orthographic_projection%29.svg/250px-Jamaica_%28orthographic_projection%29.svg.png";
          break;
        case 83: //Japan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Japan_%28orthographic_projection%29.svg/220px-Japan_%28orthographic_projection%29.svg.png";
          break;
        case 84: //Jordan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Jordan_%28orthographic_projection%29.svg/250px-Jordan_%28orthographic_projection%29.svg.png";
          break;
        case 85: //Kazakhstan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Kazakhstan_%28orthographic_projection%29.svg/250px-Kazakhstan_%28orthographic_projection%29.svg.png";
          break;
        case 86: //Kenya
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Location_Kenya_AU_Africa.svg/250px-Location_Kenya_AU_Africa.svg.png";
          break;
        case 87: //Kiribati
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Kiribati_on_the_globe_%28Polynesia_centered%29.svg/250px-Kiribati_on_the_globe_%28Polynesia_centered%29.svg.png";
          break;
        case 88: //Kosovo
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Europe-Republic_of_Kosovo.svg/250px-Europe-Republic_of_Kosovo.svg.png";
          break;
        case 89: //Kuwait
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Kuwait_on_the_globe_%28Afro-Eurasia_centered%29.svg/250px-Kuwait_on_the_globe_%28Afro-Eurasia_centered%29.svg.png";
          break;
        case 90: //Kyrgyzstan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/Kyrgyzstan_%28orthographic_projection%29.svg/250px-Kyrgyzstan_%28orthographic_projection%29.svg.png";
          break;
        case 91: //Laos
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/Location_Laos_ASEAN.svg/250px-Location_Laos_ASEAN.svg.png";
          break;
        case 92: //Latvia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/EU-Latvia.svg/250px-EU-Latvia.svg.png";
          break;
        case 93: //Lebanon
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Lebanon_%28orthographic_projection%29.svg/250px-Lebanon_%28orthographic_projection%29.svg.png";
          break;
        case 94: //Lesotho
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Location_Lesotho_AU_Africa.svg/250px-Location_Lesotho_AU_Africa.svg.png";
          break;
        case 95: //Liberia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Location_Liberia_AU_Africa.svg/250px-Location_Liberia_AU_Africa.svg.png";
          break;
        case 96: //Libya
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Libya_%28Libya_centered%3B_orthographic_projection%29.svg/220px-Libya_%28Libya_centered%3B_orthographic_projection%29.svg.png";
          break;
        case 97: //Liechtenstein
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Location_Liechtenstein_Europe.png/250px-Location_Liechtenstein_Europe.png";
          break;
        case 98: //Lithuania
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/EU-Lithuania.svg/250px-EU-Lithuania.svg.png";
          break;
        case 99: //Luxembourg
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/EU-Luxembourg.svg/250px-EU-Luxembourg.svg.png";
          break;
        case 100: //Macedonia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Europe-Macedonia.svg/250px-Europe-Macedonia.svg.png";
          break;
        case 101: //Madagascar
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Location_Madagascar_AU_Africa.svg/250px-Location_Madagascar_AU_Africa.svg.png";
          break;
        case 102: //Malawi
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Location_Malawi_AU_Africa.svg/250px-Location_Malawi_AU_Africa.svg.png";
          break;
        case 103: //Malaysia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Location_Malaysia_ASEAN.svg/250px-Location_Malaysia_ASEAN.svg.png";
          break;
        case 104: //Maldives
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Maldives_%28orthographic_projection%29.svg/250px-Maldives_%28orthographic_projection%29.svg.png";
          break;
        case 105: //Mali
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Mali_%28orthographic_projection%29.svg/250px-Mali_%28orthographic_projection%29.svg.png";
          break;
        case 106: //Malta
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/EU-Malta.svg/250px-EU-Malta.svg.png";
          break;
        case 107: //Marshall Islands
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Marshall_Islands_on_the_globe_%28small_islands_magnified%29_%28Polynesia_centered%29.svg/250px-Marshall_Islands_on_the_globe_%28small_islands_magnified%29_%28Polynesia_centered%29.svg.png";
          break;
        case 108: //Mauritania
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/Mauritania_%28orthographic_projection%29.svg/250px-Mauritania_%28orthographic_projection%29.svg.png";
          break;
        case 109: //Mauritius
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Mauritius_%28orthographic_projection_with_inset%29.svg/250px-Mauritius_%28orthographic_projection_with_inset%29.svg.png";
          break;
        case 110: //Mexico
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/MEX_orthographic.svg/220px-MEX_orthographic.svg.png";
          break;
        case 111: //Micronesia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/Micronesia_on_the_globe_%28small_islands_magnified%29_%28Polynesia_centered%29.svg/250px-Micronesia_on_the_globe_%28small_islands_magnified%29_%28Polynesia_centered%29.svg.png";
          break;
        case 112: //Moldova
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Location_Moldova_Europe.png/250px-Location_Moldova_Europe.png";
          break;
        case 113: //Monaco
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Location_Monaco_Europe.png/250px-Location_Monaco_Europe.png";
          break;
        case 114: //Mongolia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Mongolia_%28orthographic_projection%29.svg/250px-Mongolia_%28orthographic_projection%29.svg.png";
          break;
        case 115: //Montenegro
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Europe-Montenegro.svg/250px-Europe-Montenegro.svg.png";
          break;
        case 116: //Morocco
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Morocco_%28orthographic_projection%29.svg/250px-Morocco_%28orthographic_projection%29.svg.png";
          break;
        case 117: //Mozambique
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Location_Mozambique_AU_Africa.svg/250px-Location_Mozambique_AU_Africa.svg.png";
          break;
        case 118: //Myanmar (Burma)
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Location_Burma_%28Myanmar%29_ASEAN.svg/250px-Location_Burma_%28Myanmar%29_ASEAN.svg.png";
          break;
        case 119: //Namibia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Location_Namibia_AU_Africa.svg/250px-Location_Namibia_AU_Africa.svg.png";
          break;
        case 120: //Nauru
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Nauru_on_the_globe_%28Polynesia_centered%29.svg/250px-Nauru_on_the_globe_%28Polynesia_centered%29.svg.png";
          break;
        case 121: //Nepal
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Nepal_%28orthographic_projection%29.svg/250px-Nepal_%28orthographic_projection%29.svg.png";
          break;
        case 122: //Netherlands
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Kingdom_of_the_Netherlands_%28orthographic_projection%29.svg/220px-Kingdom_of_the_Netherlands_%28orthographic_projection%29.svg.png";
          break;
        case 123: //New Zealand
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/NZL_orthographic_NaturalEarth.svg/250px-NZL_orthographic_NaturalEarth.svg.png";
          break;
        case 124: //Nicaragua
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Nicaragua_%28orthographic_projection%29.svg/250px-Nicaragua_%28orthographic_projection%29.svg.png";
          break;
        case 125: //Niger
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Niger_%28orthographic_projection%29.svg/250px-Niger_%28orthographic_projection%29.svg.png";
          break;
        case 126: //Nigeria
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Nigeria_%28orthographic_projection%29.svg/250px-Nigeria_%28orthographic_projection%29.svg.png";
          break;
        case 127: //North Korea
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/North_Korea_%28orthographic_projection%29.svg/250px-North_Korea_%28orthographic_projection%29.svg.png";
          break;
        case 128: //Norway
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Europe-Norway.svg/250px-Europe-Norway.svg.png";
          break;
        case 129: //Oman
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Oman_%28better%29_%28orthographic_projection%29.svg/250px-Oman_%28better%29_%28orthographic_projection%29.svg.png";
          break;
        case 130: //Pakistan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Pakistan_%28orthographic_projection%29.svg/220px-Pakistan_%28orthographic_projection%29.svg.png";
          break;
        case 131: //Palau
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Palau_on_the_globe_%28Southeast_Asia_centered%29_%28small_islands_magnified%29.svg/250px-Palau_on_the_globe_%28Southeast_Asia_centered%29_%28small_islands_magnified%29.svg.png";
          break;
        case 132: //Palestine
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/State_of_Palestine_%28orthographic_projection%29.svg/220px-State_of_Palestine_%28orthographic_projection%29.svg.png";
          break;
        case 133: //Panama
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Panama_%28orthographic_projection%29.svg/250px-Panama_%28orthographic_projection%29.svg.png";
          break;
        case 134: //Papua New Guinea
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Papua_New_Guinea_%28orthographic_projection%29.svg/250px-Papua_New_Guinea_%28orthographic_projection%29.svg.png";
          break;
        case 135: //Paraguay
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/80/Paraguay_%28orthographic_projection%29.svg/250px-Paraguay_%28orthographic_projection%29.svg.png";
          break;
        case 136: //Peru
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Peru_%28orthographic_projection%29.svg/250px-Peru_%28orthographic_projection%29.svg.png";
          break;
        case 137: //Philippines
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Location_Philippines_ASEAN.svg/250px-Location_Philippines_ASEAN.svg.png";
          break;
        case 138: //Poland
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9b/EU-Poland.svg/250px-EU-Poland.svg.png";
          break;
        case 139: //Portugal
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/EU-Portugal_with_islands_circled.svg/250px-EU-Portugal_with_islands_circled.svg.png";
          break;
        case 140: //Qatar
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/QAT_orthographic.svg/250px-QAT_orthographic.svg.png";
          break;
        case 141: //Romania
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/EU-Romania.svg/250px-EU-Romania.svg.png";
          break;
        case 142: //Russia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Russian_Federation_%28orthographic_projection%29_-_Crimea_disputed.svg/220px-Russian_Federation_%28orthographic_projection%29_-_Crimea_disputed.svg.png";
          break;
        case 143: //Rwanda
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/Location_Rwanda_AU_Africa.svg/250px-Location_Rwanda_AU_Africa.svg.png";
          break;
        case 144: //St. Kitts and Nevis
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/KNA_orthographic.svg/250px-KNA_orthographic.svg.png";
          break;
        case 145: //St. Lucia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/Saint_Lucia_on_the_globe_%28Americas_centered%29.svg/250px-Saint_Lucia_on_the_globe_%28Americas_centered%29.svg.png";
          break;
        case 146: //St. Vincent and The Grenadines
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/VCT_orthographic.svg/250px-VCT_orthographic.svg.png";
          break;
        case 147: //Samoa
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Samoa_on_the_globe_%28Polynesia_centered%29.svg/250px-Samoa_on_the_globe_%28Polynesia_centered%29.svg.png";
          break;
        case 148: //San Marino
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Location_San_Marino_Europe.png/250px-Location_San_Marino_Europe.png";
          break;
        case 149: //Sao Tome and Principe
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Location_S%C3%A3o_Tom%C3%A9_and_Pr%C3%ADncipe_AU_Africa.svg/250px-Location_S%C3%A3o_Tom%C3%A9_and_Pr%C3%ADncipe_AU_Africa.svg.png";
          break;
        case 150: //Saudi Arabia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/Saudi_Arabia_%28orthographic_projection%29.svg/250px-Saudi_Arabia_%28orthographic_projection%29.svg.png";
          break;
        case 151: //Senegal
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Location_Senegal_AU_Africa.svg/250px-Location_Senegal_AU_Africa.svg.png";
          break;
        case 152: //Serbia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Location_Serbia_Europe.png/250px-Location_Serbia_Europe.png";
          break;
        case 153: //Seychelles
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Location_Seychelles_AU_Africa.svg/250px-Location_Seychelles_AU_Africa.svg.png";
          break;
        case 154: //Sierra Leone
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Location_Sierra_Leone_AU_Africa.svg/250px-Location_Sierra_Leone_AU_Africa.svg.png";
          break;
        case 155: //Singapore
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Location_Singapore_ASEAN.svg/250px-Location_Singapore_ASEAN.svg.png";
          break;
        case 156: //Slovakia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/EU-Slovakia.svg/250px-EU-Slovakia.svg.png";
          break;
        case 157: //Slovenia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/EU-Slovenia.svg/250px-EU-Slovenia.svg.png";
          break;
        case 158: //Solomon Islands
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Solomon_Islands_on_the_globe_%28Oceania_centered%29.svg/250px-Solomon_Islands_on_the_globe_%28Oceania_centered%29.svg.png";
          break;
        case 159: //Somalia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Somalia_%28orthographic_projection%29.svg/250px-Somalia_%28orthographic_projection%29.svg.png";
          break;
        case 160: //South Africa
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Location_South_Africa_AU_Africa.svg/250px-Location_South_Africa_AU_Africa.svg.png";
          break;
        case 161: //South Korea
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/South_Korea_%28orthographic_projection%29.svg/220px-South_Korea_%28orthographic_projection%29.svg.png";
          break;
        case 162: //South Sudan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/South_Sudan_%28orthographic_projection%29.svg/250px-South_Sudan_%28orthographic_projection%29.svg.png";
          break;
        case 163: //Spain
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/EU-Spain.svg/250px-EU-Spain.svg.png";
          break;
        case 164: //Sri Lanka
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Sri_Lanka_%28orthographic_projection%29.svg/250px-Sri_Lanka_%28orthographic_projection%29.svg.png";
          break;
        case 165: //Sudan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Sudan_%28orthographic_projection%29_highlighted.svg/250px-Sudan_%28orthographic_projection%29_highlighted.svg.png";
          break;
        case 166: //Suriname
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Suriname_%28orthographic_projection%29.svg/250px-Suriname_%28orthographic_projection%29.svg.png";
          break;
        case 167: //Swaziland
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Location_Swaziland_AU_Africa.svg/250px-Location_Swaziland_AU_Africa.svg.png";
          break;
        case 168: //Sweden
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/EU-Sweden.svg/250px-EU-Sweden.svg.png";
          break;
        case 169: //Switzerland
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Europe-Switzerland.svg/250px-Europe-Switzerland.svg.png";
          break;
        case 170: //Syria
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/Syria_%28orthographic_projection%29.svg/250px-Syria_%28orthographic_projection%29.svg.png";
          break;
        case 171: //Taiwan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Taiwan_on_the_globe_%28Southeast_Asia_centered%29.svg/250px-Taiwan_on_the_globe_%28Southeast_Asia_centered%29.svg.png";
          break;
        case 172: //Tajikistan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Tajikistan_%28orthographic_projection%29.svg/250px-Tajikistan_%28orthographic_projection%29.svg.png";
          break;
        case 173: //Tanzania
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Location_Tanzania_AU_Africa.svg/250px-Location_Tanzania_AU_Africa.svg.png";
          break;
        case 174: //Thailand
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Location_Thailand_ASEAN.svg/250px-Location_Thailand_ASEAN.svg.png";
          break;
        case 175: //Timor-Leste
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/LocationEastTimor.svg/250px-LocationEastTimor.svg.png";
          break;
        case 176: //Togo
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Location_Togo_AU_Africa.svg/250px-Location_Togo_AU_Africa.svg.png";
          break;
        case 177: //Tonga
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Tonga_on_the_globe_%28Polynesia_centered%29.svg/250px-Tonga_on_the_globe_%28Polynesia_centered%29.svg.png";
          break;
        case 178: //Trinidad and Tobago
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Trinidad_and_Tobago_%28orthographic_projection%29.svg/250px-Trinidad_and_Tobago_%28orthographic_projection%29.svg.png";
          break;
        case 179: //Tunisia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Tunisia_%28orthographic_projection%29.svg/250px-Tunisia_%28orthographic_projection%29.svg.png";
          break;
        case 180: //Turkey
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Turkey_%28orthographic_projection%29.svg/250px-Turkey_%28orthographic_projection%29.svg.png";
          break;
        case 181: //Turkmenistan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Turkmenistan_on_the_globe_%28Eurasia_centered%29.svg/250px-Turkmenistan_on_the_globe_%28Eurasia_centered%29.svg.png";
          break;
        case 182: //Tuvalu
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Tuvalu_on_the_globe_%28Polynesia_centered%29.svg/250px-Tuvalu_on_the_globe_%28Polynesia_centered%29.svg.png";
          break;
        case 183: //Uganda
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Uganda_%28orthographic_projection%29.svg/250px-Uganda_%28orthographic_projection%29.svg.png";
          break;
        case 184: //Ukraine
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Europe-Ukraine_%28disputed_territory%29.svg/250px-Europe-Ukraine_%28disputed_territory%29.svg.png";
          break;
        case 185: //United Arab Emirates
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/United_Arab_Emirates_%28orthographic_projection%29.svg/250px-United_Arab_Emirates_%28orthographic_projection%29.svg.png";
          break;
        case 186: //UK (United Kingdom)
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/EU-United_Kingdom.svg/250px-EU-United_Kingdom.svg.png";
          break;
        case 187: //USA (United States of America)
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/USA_orthographic.svg/220px-USA_orthographic.svg.png";
          break;
        case 188: //Uruguay
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Uruguay_%28orthographic_projection%29.svg/220px-Uruguay_%28orthographic_projection%29.svg.png";
          break;
        case 189: //Uzbekistan
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/%D0%A3%D0%B7%D0%B1%D0%B5%D0%BA%D0%B8%D1%81%D1%82%D0%B0%D0%BD_%D0%BD%D0%B0_%D0%B3%D0%BB%D0%BE%D0%B1%D1%83%D1%81%D0%B5.svg/250px-%D0%A3%D0%B7%D0%B1%D0%B5%D0%BA%D0%B8%D1%81%D1%82%D0%B0%D0%BD_%D0%BD%D0%B0_%D0%B3%D0%BB%D0%BE%D0%B1%D1%83%D1%81%D0%B5.svg.png";
          break;
        case 190: //Vanuatu
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Vanuatu_on_the_globe_%28Polynesia_centered%29.svg/250px-Vanuatu_on_the_globe_%28Polynesia_centered%29.svg.png";
          break;
        case 191: //Vatican City (Holy See)
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Location_of_the_Vatican_City_in_Europe.svg/250px-Location_of_the_Vatican_City_in_Europe.svg.png";
          break;
        case 192: //Venezuela
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Venezuela_%28orthographic_projection%29.svg/250px-Venezuela_%28orthographic_projection%29.svg.png";
          break;
        case 193: //Vietnam
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Location_Vietnam_ASEAN.svg/250px-Location_Vietnam_ASEAN.svg.png";
          break;
        case 194: //Yemen
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Yemen_on_the_globe_%28Afro-Eurasia_centered%29.svg/250px-Yemen_on_the_globe_%28Afro-Eurasia_centered%29.svg.png";
          break;
        case 195: //Zambia
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Location_Zambia_AU_Africa.svg/250px-Location_Zambia_AU_Africa.svg.png";
          break;
        case 196: //Zimbabwe
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Location_Zimbabwe_AU_Africa.svg/250px-Location_Zimbabwe_AU_Africa.svg.png";
          break;
        default:
          url = "";
          break;
      }
      return url;
    }

    /**
     * Get the name of a country given it's unique ID.
     */
    private String getCountryName(int id) {
      String country = "";
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
