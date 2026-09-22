/**
 * Problem 17: Simplify Path
 * 
 * Given an absolute path for a Unix-style file system, transform it to the simplified canonical path.
 */
public class SimplifyPath {

    public static String simplifyPathBasic(String path) {
        if (path == null || path.isEmpty()) return "/";
        return path.replaceAll("/+", "/");
    }

    public static String simplifyPath(String path) {
        return simplifyPathBasic(path);
    }

    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println("Result: " + simplifyPath(path));
    }
}
