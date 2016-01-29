package myapp;

import java.io.*;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.*;
import com.google.appengine.api.utils.SystemProperty;

/**
 * Servlet for returning the countries and Elo rankings.
 */
public class RankServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
      resp.setContentType("application/json");
      resp.getWriter().print("{ \"updated\": " + getTimestamp() + ", \"countries\" : [");
      List<Map.Entry<String, Integer>> list = new LinkedList(getRankings().entrySet());
      Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
               return ((Comparable) ((Map.Entry) (o2)).getValue())
              .compareTo(((Map.Entry) (o1)).getValue());
            }
       });

      for (Map.Entry<String, Integer> entry : list) {
        resp.getWriter().print("[\"" + entry.getKey() + "\", " + entry.getValue() + "]");
        if (entry != list.get(list.size() - 1)) {
          resp.getWriter().print(", ");
        }
      }
      resp.getWriter().println("]}");
    }

    /**
     * Get the updated ranks. For now manually. Later from redis.
     */
    public Map<String, Integer> getRankings() {
      Map<String, Integer> ranks = new HashMap<String, Integer>();
      ranks.put("USA (United States of America)", 1776);
      ranks.put("UK (United Kingdom)", 1116);
      ranks.put("Australia", 1101);
      ranks.put("Austria", 1085);
      ranks.put("Jamaica", 1071);
      ranks.put("Italy", 1069);
      ranks.put("Ireland", 1066);
      ranks.put("Canada", 1059);
      ranks.put("France", 1056);
      ranks.put("Sweden", 1053);
      ranks.put("Brazil", 1053);
      ranks.put("Germany", 1048);
      ranks.put("Costa Rica", 1047);
      ranks.put("New Zealand", 1044);
      ranks.put("Belgium", 1042);
      ranks.put("Malta", 1036);
      ranks.put("Iceland", 1035);
      ranks.put("Trinidad and Tobago", 1035);
      ranks.put("Slovenia", 1034);
      ranks.put("Netherlands", 1034);
      ranks.put("Philippines", 1032);
      ranks.put("Argentina", 1032);
      ranks.put("Luxembourg", 1031);
      ranks.put("Monaco", 1030);
      ranks.put("Czech Republic", 1028);
      ranks.put("St. Lucia", 1027);
      ranks.put("Lithuania", 1027);
      ranks.put("South Africa", 1025);
      ranks.put("Liechtenstein", 1024);
      ranks.put("Greece", 1024);
      ranks.put("Nicaragua", 1023);
      ranks.put("Mexico", 1023);
      ranks.put("Norway", 1023);
      ranks.put("Belarus", 1022);
      ranks.put("Bahamas", 1022);
      ranks.put("Uruguay", 1020);
      ranks.put("El Salvador", 1018);
      ranks.put("Fiji", 1017);
      ranks.put("Colombia", 1017);
      ranks.put("Chile", 1016);
      ranks.put("Samoa", 1016);
      ranks.put("Vanuatu", 1016);
      ranks.put("Japan", 1016);
      ranks.put("Dominican Republic", 1014);
      ranks.put("India", 1014);
      ranks.put("Spain", 1014);
      ranks.put("Brunei", 1012);
      ranks.put("China", 1012);
      ranks.put("Guatemala", 1011);
      ranks.put("Turkey", 1010);
      ranks.put("Finland", 1010);
      ranks.put("Poland", 1009);
      ranks.put("St. Vincent and The Grenadines", 1008);
      ranks.put("Ecuador", 1007);
      ranks.put("Switzerland", 1007);
      ranks.put("United Arab Emirates", 1006);
      ranks.put("Zimbabwe", 1005);
      ranks.put("Bosnia and Herzegovina", 1004);
      ranks.put("Barbados", 1003);
      ranks.put("Romania", 1001);
      ranks.put("Denmark", 999);
      ranks.put("Solomon Islands", 999);
      ranks.put("Portugal", 999);
      ranks.put("Bolivia", 996);
      ranks.put("Albania", 996);
      ranks.put("St. Kitts and Nevis", 995);
      ranks.put("Hungary", 994);
      ranks.put("Honduras", 993);
      ranks.put("Latvia", 991);
      ranks.put("Nigeria", 990);
      ranks.put("Singapore", 990);
      ranks.put("Taiwan", 989);
      ranks.put("Georgia", 989);
      ranks.put("Nauru", 989);
      ranks.put("Croatia", 988);
      ranks.put("Serbia", 987);
      ranks.put("Kosovo", 986);
      ranks.put("Dominica", 985);
      ranks.put("Ukraine", 984);
      ranks.put("Armenia", 984);
      ranks.put("Vatican City (Holy See)", 983);
      ranks.put("Israel", 983);
      ranks.put("Estonia", 982);
      ranks.put("Kenya", 982);
      ranks.put("Qatar", 981);
      ranks.put("Panama", 980);
      ranks.put("South Korea", 980);
      ranks.put("Tajikistan", 980);
      ranks.put("Grenada", 979);
      ranks.put("Montenegro", 978);
      ranks.put("Congo, Democratic Republic of the", 977);
      ranks.put("Jordan", 977);
      ranks.put("Myanmar (Burma)", 976);
      ranks.put("Palau", 976);
      ranks.put("Russia", 975);
      ranks.put("Kuwait", 975);
      ranks.put("Macedonia", 975);
      ranks.put("Antigua and Barbuda", 974);
      ranks.put("Cyprus", 973);
      ranks.put("Liberia", 973);
      ranks.put("Egypt", 972);
      ranks.put("Cote d'Ivoire", 972);
      ranks.put("Vietnam", 972);
      ranks.put("Cabo Verde", 970);
      ranks.put("San Marino", 969);
      ranks.put("Andorra", 968);
      ranks.put("Bulgaria", 967);
      ranks.put("Peru", 966);
      ranks.put("Paraguay", 965);
      ranks.put("Mongolia", 964);
      ranks.put("Tanzania", 964);
      ranks.put("Marshall Islands", 963);
      ranks.put("Morocco", 962);
      ranks.put("Libya", 962);
      ranks.put("Mozambique", 961);
      ranks.put("Somalia", 961);
      ranks.put("Chad", 960);
      ranks.put("Saudi Arabia", 959);
      ranks.put("Turkmenistan", 958);
      ranks.put("Yemen", 958);
      ranks.put("Haiti", 957);
      ranks.put("Madagascar", 957);
      ranks.put("Swaziland", 957);
      ranks.put("Central African Republic", 956);
      ranks.put("Papua New Guinea", 956);
      ranks.put("Cameroon", 956);
      ranks.put("Mauritania", 956);
      ranks.put("Equatorial Guinea", 955);
      ranks.put("Pakistan", 953);
      ranks.put("Gambia", 952);
      ranks.put("Congo, Republic of the", 952);
      ranks.put("Malaysia", 952);
      ranks.put("Sierra Leone", 951);
      ranks.put("Namibia", 951);
      ranks.put("Timor-Leste", 949);
      ranks.put("Ghana", 949);
      ranks.put("Seychelles", 949);
      ranks.put("Venezuela", 949);
      ranks.put("Iraq", 947);
      ranks.put("Kiribati", 945);
      ranks.put("Indonesia", 945);
      ranks.put("Niger", 945);
      ranks.put("Guinea-Bissau", 944);
      ranks.put("Botswana", 944);
      ranks.put("Uzbekistan", 943);
      ranks.put("Mali", 943);
      ranks.put("Slovakia", 942);
      ranks.put("Maldives", 941);
      ranks.put("Belize", 941);
      ranks.put("Micronesia", 940);
      ranks.put("Cuba", 940);
      ranks.put("Laos", 939);
      ranks.put("Tuvalu", 939);
      ranks.put("Djibouti", 938);
      ranks.put("Tunisia", 938);
      ranks.put("Uganda", 934);
      ranks.put("Zambia", 934);
      ranks.put("Guinea", 932);
      ranks.put("Bhutan", 932);
      ranks.put("Mauritius", 929);
      ranks.put("Benin", 928);
      ranks.put("Kazakhstan", 928);
      ranks.put("Thailand", 927);
      ranks.put("Kyrgyzstan", 926);
      ranks.put("Ethiopia", 926);
      ranks.put("Moldova", 924);
      ranks.put("Rwanda", 924);
      ranks.put("Comoros", 922);
      ranks.put("Bahrain", 919);
      ranks.put("Senegal", 919);
      ranks.put("Lebanon", 918);
      ranks.put("Malawi", 918);
      ranks.put("Iran", 917);
      ranks.put("Sudan", 917);
      ranks.put("Suriname", 917);
      ranks.put("Angola", 916);
      ranks.put("Oman", 916);
      ranks.put("Sao Tome and Principe", 914);
      ranks.put("Eritrea", 914);
      ranks.put("Tonga", 913);
      ranks.put("Algeria", 911);
      ranks.put("Sri Lanka", 911);
      ranks.put("Burundi", 910);
      ranks.put("Lesotho", 910);
      ranks.put("Palestine", 904);
      ranks.put("Afghanistan", 903);
      ranks.put("Nepal", 900);
      ranks.put("Bangladesh", 896);
      ranks.put("North Korea", 891);
      ranks.put("Syria", 888);
      ranks.put("Guyana", 887);
      ranks.put("South Sudan", 882);
      ranks.put("Cambodia", 880);
      ranks.put("Azerbaijan", 879);
      ranks.put("Togo", 876);
      ranks.put("Gabon", 874);
      ranks.put("Burkina Faso", 870);
      return ranks;
    }

    public long getTimestamp() {
      return 1453745238788L;
    }

}
