    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!dir.isEmpty() && !dir.equals(".") && !dir.equals("..")) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        // bug:注意res是empty的情况
        return res.isEmpty() ? "/" : res;
    }
