package cs207.linear;
import java.io.PrintWriter;


/**
 * Assorted utilities for working with strings.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+

  /**
   * Determine whether the parens match in string.
   * @throws Exception 
   */
  public static boolean checkMatching(String str) throws Exception {
    Stack<Character> parens = new LinkedStack<Character>();
    
    for(int i=0;i<str.length();i++){
      char strLinked = str.charAt(i);
      if(strLinked=='('||strLinked=='['){
        parens.push(strLinked);
      }
      if(strLinked==')' ){
        if(parens.peek()=='('){
        parens.pop();
        }else{
          throw new Exception("Mismatched ");
        }
      } else{
        
      }

     if(strLinked==']'&& parens.peek()=='['){
        parens.pop();
      }else{
        throw new Exception("Mismatched ");
      }
    }
    return false;       // STUB
  } // checkMatching

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+
  /**
   * A quick set of experiments with checkMatching.
   */
  static void checkMatchingExperiments(PrintWriter pen) {
    checkMatchingExperiment(pen, "");
    checkMatchingExperiment(pen, "()");
    checkMatchingExperiment(pen, "(");
    checkMatchingExperiment(pen, ")");
    checkMatchingExperiment(pen, "[]()");
    checkMatchingExperiment(pen, "[()([])]");
    checkMatchingExperiment(pen, "[a(b]c)");
    checkMatchingExperiment(pen, "Hello (there) (world (!!))");
    checkMatchingExperiment(pen, "alphabetical");
    checkMatchingExperiment(pen, "((((((((a))))))))");
    checkMatchingExperiment(pen, "((((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a))))))])");
    checkMatchingExperiment(pen, "((((b)(((((a)(c)))(d))))))");
    // Feel free to add your own
  } // PrintWriter()

  /**
   * A single experiment with checkMatching.
   */
  static void checkMatchingExperiment(PrintWriter pen, String str) {
    pen.print("checkMatching(\"" + str + "\") = ");
    pen.flush();
    try {
      pen.println(checkMatching(str));
    } catch (Exception e) {
      pen.println("*** ERROR *** " + e.toString());
    }
  } // checkMatchingExperiment(PrintWriter, String)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run a few experiments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    checkMatchingExperiments(pen);
    pen.close();
  } // main(String[])
} // class StringUtils
