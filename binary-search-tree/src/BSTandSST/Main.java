import java.util.Vector;

/**
 * created by PATRICK
 * 2018/5/31 1:01
 *
 * 测试比较 BST 和 SST 的运行效率
 *
 **/

public class Main {

    public static void main(String[] args) {

        String filename = "binary-search-tree/src/BSTandSST/gone with the wind.txt";
        Vector<String> words = new Vector<>();
        if (BSTandSST.FileOperations.readFile(filename, words)) {
            System.out.println("There are totally " + words.size() + " words in " + filename);
            System.out.println();

            // 测试 BST
            long startTime = System.currentTimeMillis();

            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                Integer res = bst.search(word);
                if (res == null)
                    bst.insert(word, new Integer(1));
                else
                    bst.insert(word, res + 1);
            }

            if (bst.contain("god"))
                System.out.println("'god' : " + bst.search("god"));
            else
                System.out.println("No word 'god' in " + filename);

            long endTime = System.currentTimeMillis();
            System.out.println("BST , time: " + (endTime - startTime) + "ms.");

            System.out.println();


            // 测试顺序查找表 SST
            startTime = System.currentTimeMillis();

            BSTandSST.SST<String, Integer> sst = new BSTandSST.SST<String, Integer>();
            for (String word : words) {
                Integer res = sst.search(word);
                if (res == null)
                    sst.insert(word, new Integer(1));
                else
                    sst.insert(word, res + 1);
            }

            if (sst.contain("god"))
                System.out.println("'god' : " + sst.search("god"));
            else
                System.out.println("No word 'god' in " + filename);

            endTime = System.currentTimeMillis();
            System.out.println("SST , time: " + (endTime - startTime) + "ms.");
        }
    }
}
