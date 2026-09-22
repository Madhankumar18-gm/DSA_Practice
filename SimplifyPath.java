import java.util.Stack;

/**
 * Problem 17: Simplify Path
 * 
 * Given an absolute path for a Unix-style file system, transform it to the simplified canonical path.
 */
public class SimplifyPath {

    public static String simplifyPathStack(String path) {
        if (path == null || path.isEmpty()) return "/";

        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String comp : components) {
            if (comp.equals("") || comp.equals(".")) {
                continue;
            } else if (comp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(comp);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    public static String simplifyPath(String path) {
        return simplifyPathStack(path);
    }

    public static void main(String[] args) {
        System.out.println("Null Path Guard:  " + simplifyPath(null));
        System.out.println("Empty Path Guard: " + simplifyPath(""));
    }
}
