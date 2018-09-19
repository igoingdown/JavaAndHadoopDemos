package interview.Airbnb.Job.Online;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] actions = new String[n];
        for (int i = 0; i < n; i++) {
            actions[i] = in.nextLine();
        }
        for (String res : solve(actions)) System.out.println(res);
    }

    private static List<String> solve(String[] actions) {
        HashMap<String, String> armyPlace = new HashMap<>(), supportMap = new HashMap<>();
        HashMap<String, Set<String>> supportedBy = new HashMap<>(), placeArmy = new HashMap<>();
        for (String action : actions) {
            String[] items = action.split(" ");
            String armyName = items[0], originalPlace = items[1], actionName = items[2], actionParam = null;
            if (items.length > 3) actionParam = items[3];
            if (actionName.equals("Hold")) {
                armyPlace.put(armyName, originalPlace);
                placeArmy.putIfAbsent(originalPlace, new TreeSet<>());
                placeArmy.get(originalPlace).add(armyName);
            } else if (actionName.equals("Move")) {
                armyPlace.put(armyName, actionParam);
                placeArmy.putIfAbsent(actionParam, new TreeSet<>());
                placeArmy.get(actionParam).add(armyName);
            } else {
                armyPlace.put(armyName, originalPlace);
                placeArmy.putIfAbsent(originalPlace, new TreeSet<>());
                placeArmy.get(originalPlace).add(armyName);
                supportMap.put(armyName, actionParam);
                supportedBy.putIfAbsent(actionParam, new TreeSet<>());
                supportedBy.get(actionParam).add(armyName);
            }
        }
        TreeMap<String, String> ans = new TreeMap<>();
        for (String placeName : placeArmy.keySet()) {
            if (placeArmy.get(placeName).size() > 1) {
                for (String armyName : placeArmy.get(placeName)) {
                    ans.put(armyName, "[dead]");
                    if (supportMap.containsKey(armyName)) {
                        supportedBy.get(supportMap.get(armyName)).remove(armyName);
                        if (supportedBy.get(supportMap.get(armyName)).size() == 0) supportedBy.remove(supportMap.get(armyName));
                        supportMap.remove(armyName);
                    }
                }
            } else {
                for (String armyName : placeArmy.get(placeName)) ans.put(armyName, armyPlace.get(armyName));
            }
        }
        for (String placeName : placeArmy.keySet()) {
            int maxSupportNum = 0;
            String maxSupportedArmy = null;
            for (String armyName : placeArmy.get(placeName)) {
                if (supportedBy.containsKey(armyName) && supportedBy.get(armyName).size() > maxSupportNum) {
                    maxSupportedArmy = armyName;
                    maxSupportNum = supportedBy.get(armyName).size();
                } else if (supportedBy.containsKey(armyName) && supportedBy.get(armyName).size() == maxSupportNum) {
                    maxSupportedArmy = null;
                }
            }
            if (maxSupportedArmy != null) ans.put(maxSupportedArmy, placeName);
        }
        List<String> res = new ArrayList<>();
        for (String armyName : ans.keySet()) {
            res.add(armyName + " " + ans.get(armyName));
        }
        return res;
    }
}
