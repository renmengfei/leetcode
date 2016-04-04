    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length())
            return res;

        int n = s.length(), m = words.length, wl = words[0].length();

        Map<String, Integer> map = new HashMap<>(), curmap = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word))
                map.put(word, 0);
            map.put(word, map.get(word) + 1);
        }

        String tmp = null;
        for (int i = 0; i < wl; i++) {
            int count = 0; // remark: reset count
            for (int l = i, r = i; r + wl <= n; r += wl) {
                String str = s.substring(r, r + wl);
                if (map.containsKey(str)) {
                    if (!curmap.containsKey(str))
                        curmap.put(str, 0);
                    curmap.put(str, curmap.get(str) + 1);

                    if (curmap.get(str) <= map.get(str))
                        count++;
                    while (curmap.get(str) > map.get(str)) {
                        tmp = s.substring(l, l + wl);
                        curmap.put(tmp, curmap.get(tmp) - 1);
                        l += wl;
                        if (curmap.get(tmp) < map.get(tmp))
                            count--;
                    }
                    if (count == m) {
                        res.add(l);
                        tmp = s.substring(l, l + wl);
                        curmap.put(tmp, curmap.get(tmp) - 1);
                        l += wl;
                        count--;
                    }
                } else {
                    curmap.clear();
                    count = 0;
                    l = r + wl;
                }
            }
            curmap.clear();
        }
        return res;
    }
