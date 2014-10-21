import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by ivonhoe on 14-10-15.
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        int index = 0;
        while (index < path.length()) {
            while (index < path.length() && path.charAt(index) == '/') {
                index++;
            }

            if (index >= path.length()) {
                break;
            }
            int start = index;
            while (index < path.length() && path.charAt(index) != '/') {
                index++;
            }
            int end = index;
            String element = path.substring(start, end);
            if (element.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (element.equals(".")) {

            } else {
                stack.push(element);
            }
        }

        if (stack.size() == 0) {
            return "/";
        }
        String simply = "";
        for (int i = 0; i < stack.size(); i++) {
            simply = simply + "/" + stack.elementAt(i);
        }
        return simply;
    }

    public static void main(String[] args) {
        String path = "/.";
        System.out.println("simplifyPath(path)=" + simplifyPath(path));
    }
}
