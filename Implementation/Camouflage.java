import java.util.HashMap;
import java.util.Map;

public class Camouflage {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesTypeMap = getClothesTypeMap(clothes);

        int caseCount = clothesTypeMap.values().stream().reduce(1, (o1, o2) -> o1 * (o2 + 1)) - 1;

        return caseCount;
    }

    private Map<String, Integer> getClothesTypeMap(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];
            if (map.containsKey(type)) {
                map.put(type, map.get(type) + 1);
            } else {
                map.put(type, 1);
            }
        }
        return map;
    }
}
