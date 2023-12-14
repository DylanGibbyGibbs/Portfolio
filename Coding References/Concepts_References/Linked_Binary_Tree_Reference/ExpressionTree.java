import java.util.Scanner;
import net.datastructures.Position;
import net.datastructures.LinkedBinaryTree;
import net.datastructures.LinkedStack;

   public class ExpressionTree
   {
      public static void main(String[] args)
         {
            LinkedBinaryTree<String> myTree1 = buildTree( "10 19 * 18 32 + - ");       //good
            LinkedBinaryTree<String> myTree2 = buildTree( "2 5 9 + 12 * + ");          //good
            LinkedBinaryTree<String> myTree3 = buildTree( "12 8 + 7 5 - - ");          //good
         //   LinkedBinaryTree<String> myTree4 = buildTree( "- - - 8 9 7 - ");           //bad
        //    LinkedBinaryTree<String> myTree5 = buildTree( "5 4 6 7 + - 15 - 29");      //bad
         }
         
      public static LinkedBinaryTree<String> buildTree( String s )
         {
            Scanner exprScan = new Scanner( s );
            LinkedStack<LinkedBinaryTree<String>> treeStack = new LinkedStack<>();
            
            while( exprScan.hasNext() )
               {
                 if( exprScan.hasNextInt() )
                     {
                        String value = exprScan.next();
                        LinkedBinaryTree<String> rootTree = new LinkedBinaryTree<>();
                        rootTree.addRoot( value );
                        treeStack.push( rootTree );
                     }
                 else
                     {
                        String value = exprScan.next();
                        LinkedBinaryTree<String> rootTree = new LinkedBinaryTree<>();
                        rootTree.addRoot( value );
                        LinkedBinaryTree<String> left, right;
                        right = treeStack.pop();
                        left = treeStack.pop();
                        rootTree.attach( rootTree.root(), left, right ); 
                        treeStack.push( rootTree );
                     }
                }
            return treeStack.pop();
       }
   } 
      