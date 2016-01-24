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
      ranks.put("UK (United Kingdom)", 1238);
      ranks.put("Australia", 1188);
      ranks.put("Jamaica", 1184);
      ranks.put("Austria", 1182);
      ranks.put("Ireland", 1149);
      ranks.put("Mexico", 1145);
      ranks.put("New Zealand", 1131);
      ranks.put("Luxembourg", 1131);
      ranks.put("Germany", 1125);
      ranks.put("Canada", 1117);
      ranks.put("Italy", 1115);
      ranks.put("France", 1109);
      ranks.put("Belgium", 1105);
      ranks.put("South Africa", 1101);
      ranks.put("Hungary", 1101);
      ranks.put("Sweden", 1096);
      ranks.put("Netherlands", 1085);
      ranks.put("Switzerland", 1084);
      ranks.put("Philippines", 1084);
      ranks.put("South Korea", 1079);
      ranks.put("Singapore", 1079);
      ranks.put("Costa Rica", 1077);
      ranks.put("Dominican Republic", 1076);
      ranks.put("Bahamas", 1073);
      ranks.put("Panama", 1069);
      ranks.put("Malta", 1069);
      ranks.put("Spain", 1066);
      ranks.put("Nicaragua", 1064);
      ranks.put("Slovenia", 1062);
      ranks.put("Brazil", 1062);
      ranks.put("Czech Republic", 1059);
      ranks.put("Colombia", 1058);
      ranks.put("St. Vincent and The Grenadines", 1057);
      ranks.put("Portugal", 1057);
      ranks.put("Finland", 1057);
      ranks.put("Argentina", 1057);
      ranks.put("Norway", 1051);
      ranks.put("Greece", 1046);
      ranks.put("Denmark", 1046);
      ranks.put("Liechtenstein", 1045);
      ranks.put("Ecuador", 1045);
      ranks.put("St. Kitts and Nevis", 1040);
      ranks.put("Japan", 1039);
      ranks.put("Guatemala", 1038);
      ranks.put("Monaco", 1035);
      ranks.put("Iceland", 1035);
      ranks.put("Chile", 1034);
      ranks.put("Taiwan", 1033);
      ranks.put("Latvia", 1033);
      ranks.put("Israel", 1032);
      ranks.put("Honduras", 1032);
      ranks.put("Brunei", 1029);
      ranks.put("Venezuela", 1028);
      ranks.put("Poland", 1028);
      ranks.put("India", 1027);
      ranks.put("Marshall Islands", 1025);
      ranks.put("Romania", 1021);
      ranks.put("Macedonia", 1019);
      ranks.put("Bolivia", 1018);
      ranks.put("St. Lucia", 1017);
      ranks.put("Antigua and Barbuda", 1016);
      ranks.put("Uruguay", 1013);
      ranks.put("Samoa", 1013);
      ranks.put("Kenya", 1012);
      ranks.put("Vatican City (Holy See)", 1009);
      ranks.put("United Arab Emirates", 1009);
      ranks.put("San Marino", 1008);
      ranks.put("Fiji", 1008);
      ranks.put("Nigeria", 1006);
      ranks.put("Montenegro", 1006);
      ranks.put("Trinidad and Tobago", 1005);
      ranks.put("El Salvador", 1003);
      ranks.put("Serbia", 1000);
      ranks.put("Liberia", 999);
      ranks.put("Grenada", 999);
      ranks.put("Albania", 995);
      ranks.put("Dominica", 994);
      ranks.put("China", 994);
      ranks.put("Georgia", 992);
      ranks.put("Peru", 989);
      ranks.put("Morocco", 987);
      ranks.put("Lithuania", 987);
      ranks.put("Croatia", 985);
      ranks.put("Estonia", 983);
      ranks.put("Cyprus", 983);
      ranks.put("Barbados", 983);
      ranks.put("Equatorial Guinea", 982);
      ranks.put("Kosovo", 979);
      ranks.put("Belize", 979);
      ranks.put("Turkey", 978);
      ranks.put("Slovakia", 975);
      ranks.put("Bosnia and Herzegovina", 975);
      ranks.put("Haiti", 972);
      ranks.put("Vanuatu", 969);
      ranks.put("Palau", 969);
      ranks.put("Malaysia", 969);
      ranks.put("Ukraine", 967);
      ranks.put("Andorra", 967);
      ranks.put("Suriname", 966);
      ranks.put("Solomon Islands", 965);
      ranks.put("Egypt", 962);
      ranks.put("Cabo Verde", 961);
      ranks.put("Jordan", 960);
      ranks.put("Kuwait", 957);
      ranks.put("Tuvalu", 955);
      ranks.put("Micronesia", 952);
      ranks.put("Moldova", 951);
      ranks.put("Bulgaria", 951);
      ranks.put("Belarus", 950);
      ranks.put("Nauru", 948);
      ranks.put("Central African Republic", 947);
      ranks.put("Vietnam", 944);
      ranks.put("Thailand", 944);
      ranks.put("Qatar", 944);
      ranks.put("Uzbekistan", 943);
      ranks.put("Armenia", 940);
      ranks.put("Tajikistan", 939);
      ranks.put("Ghana", 939);
      ranks.put("Congo, Democratic Republic of the", 936);
      ranks.put("Cuba", 934);
      ranks.put("Saudi Arabia", 933);
      ranks.put("Myanmar (Burma)", 933);
      ranks.put("Paraguay", 932);
      ranks.put("Yemen", 931);
      ranks.put("Guyana", 931);
      ranks.put("Tonga", 930);
      ranks.put("Iraq", 928);
      ranks.put("Kiribati", 927);
      ranks.put("Mauritius", 924);
      ranks.put("Bangladesh", 921);
      ranks.put("Mongolia", 920);
      ranks.put("Mozambique", 918);
      ranks.put("Pakistan", 917);
      ranks.put("Mauritania", 916);
      ranks.put("Indonesia", 916);
      ranks.put("Djibouti", 916);
      ranks.put("Russia", 912);
      ranks.put("Lebanon", 912);
      ranks.put("Seychelles", 911);
      ranks.put("Kyrgyzstan", 908);
      ranks.put("Palestine", 906);
      ranks.put("Iran", 906);
      ranks.put("Tunisia", 905);
      ranks.put("Benin", 905);
      ranks.put("Libya", 904);
      ranks.put("Bahrain", 904);
      ranks.put("Kazakhstan", 903);
      ranks.put("Timor-Leste", 902);
      ranks.put("Cote d'Ivoire", 902);
      ranks.put("Zimbabwe", 900);
      ranks.put("Tanzania", 899);
      ranks.put("Oman", 899);
      ranks.put("Burundi", 899);
      ranks.put("Swaziland", 898);
      ranks.put("Comoros", 897);
      ranks.put("Zambia", 896);
      ranks.put("Papua New Guinea", 895);
      ranks.put("Sao Tome and Principe", 894);
      ranks.put("Madagascar", 894);
      ranks.put("Nepal", 892);
      ranks.put("Congo, Republic of the", 892);
      ranks.put("Gambia", 890);
      ranks.put("Botswana", 890);
      ranks.put("Cambodia", 889);
      ranks.put("Maldives", 886);
      ranks.put("Sri Lanka", 883);
      ranks.put("Algeria", 883);
      ranks.put("Malawi", 882);
      ranks.put("Cameroon", 882);
      ranks.put("Namibia", 880);
      ranks.put("Turkmenistan", 875);
      ranks.put("Guinea-Bissau", 875);
      ranks.put("Uganda", 874);
      ranks.put("Senegal", 874);
      ranks.put("Mali", 873);
      ranks.put("Sierra Leone", 872);
      ranks.put("Chad", 872);
      ranks.put("Rwanda", 870);
      ranks.put("Niger", 870);
      ranks.put("Syria", 868);
      ranks.put("Guinea", 865);
      ranks.put("Togo", 860);
      ranks.put("Laos", 860);
      ranks.put("Azerbaijan", 853);
      ranks.put("Afghanistan", 848);
      ranks.put("Angola", 847);
      ranks.put("Sudan", 845);
      ranks.put("Somalia", 845);
      ranks.put("Bhutan", 845);
      ranks.put("Ethiopia", 838);
      ranks.put("Gabon", 834);
      ranks.put("Eritrea", 829);
      ranks.put("North Korea", 827);
      ranks.put("South Sudan", 812);
      ranks.put("Burkina Faso", 809);
      ranks.put("Lesotho", 802);
      return ranks;
    }

    public long getTimestamp() {
      return 1453525864169L;
    }

}
