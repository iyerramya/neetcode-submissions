class TimeMap {

    class TimePair {
        String value;
        int ts;

        public TimePair(String value, int ts) {
            this.value = value;
            this.ts = ts; 
        }
    }

    private final Map<String, List<TimePair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new TimePair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        List<TimePair> list =map.get(key);
        if(list == null) {
            return res;
        }
        int l = 0;
        int r = list.size()-1;
        while(l <=r ) {
            int m = (l+r)/2;
            if(list.get(m).ts <= timestamp) {
                res = list.get(m).value;
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return res;
    }
}
