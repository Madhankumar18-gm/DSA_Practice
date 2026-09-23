import java.util.Stack;

/**
 * Problem 17: Simplify Path
 * 
 * Given an absolute path for a Unix-style file system, transform it to the simplified canonical path.
 * 
 * Time Complexity: O(N) scanning path characters.
 * Space Complexity: O(N) stack storage for directory tokens.
 */
public class SimplifyPath {

    /**
     * Canonicalizes Unix path using Stack.
     * Time: O(N), Space: O(N)
     */
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
        System.out.println("=== SimplifyPath Execution Suite ===");
        System.out.println("Path: \"/home/\"               -> " + simplifyPath("/home/"));
        System.out.println("Path: \"/../\"                -> " + simplifyPath("/../"));
        System.out.println("Path: \"/home//foo/\"           -> " + simplifyPath("/home//foo/"));
        System.out.println("Path: \"/a/./b/../../c/\"     -> " + simplifyPath("/a/./b/../../c/"));
        System.out.println("Path: \"/a/../../b/../c//.//\" -> " + simplifyPath("/a/../../b/../c//.//"));
        System.out.println("=== All Tests Completed Successfully ===");
    }
}
