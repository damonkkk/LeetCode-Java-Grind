package Review.Q7.ws4b;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// ============================================================
//  GENERAL TREES & MUTUAL RECURSION  —  EXAM PRACTICE FILE
//  Run: javac GeneralTreesExam.java && java GeneralTreesExam
// ============================================================
//
//  DATA DEFINITIONS (read these carefully before each question)
//
//  record RoseTree(ArrayList<RoseTree> children, Integer value) {}
//
//  record Person(String name, String gender, int birth, int death) {}
//      death == 0  means the person is still alive.
//
//  record Descendants(Person person, ArrayList<Descendants> children) {}
//      Represents a person together with ALL of their descendants.
//      children contains exactly the DIRECT children of person.
//
// ============================================================

public class GeneralTreesExam {

    // ----------------------------------------------------------
    // DATA DEFINITIONS
    // ----------------------------------------------------------

    record RoseTree(ArrayList<RoseTree> children, Integer value) {}

    record Person(String name, String gender, int birth, int death) {}

    record Descendants(Person person, ArrayList<Descendants> children) {}

    // ----------------------------------------------------------
    // TINY TEST HELPER  (prints PASS / FAIL)
    // ----------------------------------------------------------

    static int passed = 0;
    static int failed = 0;

    static <T> void check(T expected, T actual, String label) {
        if (expected.equals(actual)) {
            System.out.println("  PASS  " + label);
            passed++;
        } else {
            System.out.println("  FAIL  " + label
                    + "\n         expected: " + expected
                    + "\n           actual: " + actual);
            failed++;
        }
    }

// ============================================================
    // EXERCISE 1 — RoseTree sum
    // ============================================================
    //
    // SETUP
    // -----
    // A RoseTree is a general tree where every node (leaf or internal)
    // stores an Integer value and has zero or more children stored in
    // an ArrayList<RoseTree>.
    //
    //   record RoseTree(ArrayList<RoseTree> children, Integer value) {}
    //
    // A leaf node has an empty ArrayList as its children.
    //
    // QUESTION
    // --------
    // Write a method   static int roseTreeSum(RoseTree t)
    // that returns the sum of ALL Integer values stored in the tree.
    //
    // You MUST NOT use streams or higher-order list functions.
    // You MUST write a helper method:
    //
    //   static int listSum(ArrayList<RoseTree> children)
    //
    // that sums all values in the subtrees rooted at each child.
    // roseTreeSum and listSum must be MUTUALLY RECURSIVE.
    //
    // Examples
    //   roseTreeSum( leaf(7) )                    =>  7
    //   roseTreeSum( node(5, [leaf(3), leaf(2)]) ) => 10
    //
    // ------------------------------------------------------------
    // WRITE YOUR SOLUTION HERE
    // ------------------------------------------------------------

    static int roseTreeSum(RoseTree t) {
        //设置 初始返回值
        int total =0;
        // 如果当前节点是 null， 返回 total 即0
        if(t==null){
            return total;
        }
        // total 累积 当前节点的值
        total += t.value;

        // recursively call all the children to go through the process
        return  total+listSum(t.children);
    }

    static int listSum(ArrayList<RoseTree> children) {
        // null check
       if(children == null || children.isEmpty()){
           return 0;
       }

       // 初始化 total
    int res=0;
       // 对于每一个 child和child的children， 都跑一边 roseTreeSum
        for(RoseTree child: children){
             res+= roseTreeSum(child);
        }
        return res;
    }



// ============================================================
    // EXERCISE 2 — Count descendants
    // ============================================================
    //
    // SETUP
    // -----
    // A Descendants tree encodes a person and all of their biological
    // descendants:
    //
    //   record Person(String name, String gender, int birth, int death){}
    //   record Descendants(Person person, ArrayList<Descendants> children){}
    //
    // A person with no children has an empty ArrayList for children.
    // The ROOT of the tree is NOT counted as its own descendant.
    //
    // QUESTION
    // --------
    // Write a method
    //
    //   static int countDescendants(Descendants tree)
    //
    // that returns the TOTAL number of descendants of the person at
    // the root (i.e., every node in the tree EXCEPT the root itself).
    //
    // You MUST NOT use streams or higher-order list functions.
    // You MUST use a helper   static int countDescList(ArrayList<Descendants> list)
    //
    // Examples
    //   countDescendants( A with no children )          => 0
    //   countDescendants( A -> [B, C] (no grandkids) )  => 2
    //
    // ------------------------------------------------------------
    // WRITE YOUR SOLUTION HERE
    // ------------------------------------------------------------

    static int countDescendants(Descendants tree) {
        if(tree== null) {
            return 0;
        }
            return countDescList(tree.children);
    }

    static int countDescList(ArrayList<Descendants> list) {
       if(list==null || list.isEmpty()){
           return 0;
       }
       int total = 0;
       for(Descendants child: list){
           //这一步 把这个child自己算上， 因为它自己肯定是descendant的一部分
           total++;
           //再把loop through child的descendant的recursive结果加上
           total+= countDescendants(child);
       }
       return total;
    }

    // ============================================================
    // EXERCISE 3 — Count descendants by name
    // ============================================================
    //
    // SETUP
    // -----
    // Same data definitions as Exercise 2.
    // You may assume all names in the tree are UNIQUE.
    //
    // QUESTION
    // --------
    // Write a method
    //
    //   static int countDescendantsByPersonName(Descendants tree, String name)
    //
    // that finds the person called `name` anywhere in the tree and
    // returns the number of their descendants.
    // If no person with that name exists in the tree, return 0.
    //
    // You MUST NOT use streams or higher-order list functions.
    //
    // Examples
    //   "A" is root with 7 total descendants  => 7
    //   "B1" is a leaf                         => 0
    //   "Z" does not appear in tree            => 0
    //
    // ------------------------------------------------------------
    // WRITE YOUR SOLUTION HERE
    // ------------------------------------------------------------

    static int countDescendantsByPersonName(Descendants tree, String name) {
        // null check
        if(tree==null){
            return 0;
        }
        // initialise
        int total = 0;
        //如果name match， 用之前的method 计算以这个点起始的node有多少个sub-nodes
        if(tree.person.name.equals(name)){
            return countDescendants(tree);
            // 如果名字不match，对于 每一个child，loop recursively the method itself to check every child's name target name
            // then return the total descendants
        } else {
            for(var child: tree.children){
                total+= countDescendantsByPersonName(child,name);
            }
        }


        return total;
    }

// ============================================================
    // EXERCISE 4 — Count people satisfying a predicate
    // ============================================================
    //
    // SETUP
    // -----
    // Same data definitions as Exercise 2.
    // java.util.function.Predicate<T> has one method:
    //   boolean test(T t)
    //
    // QUESTION
    // --------
    // Write a method
    //
    //   static int countPeopleByPredicate(Descendants tree,
    //                                     Predicate<Descendants> pred)
    //
    // that returns the number of people in the tree (including the root)
    // for which pred.test(node) is TRUE.
    //
    // You MUST NOT use streams or higher-order list functions.
    //
    // Examples
    //   pred = x -> true    (all nodes)   => total size of tree
    //   pred = x -> false   (no nodes)    => 0
    //   pred = x -> x.person().name().equals("B")  => 1  (if B is in tree)
    //
    // ------------------------------------------------------------
    // WRITE YOUR SOLUTION HERE
    // ------------------------------------------------------------

    static int countPeopleByPredicate(Descendants tree,
                                      Predicate<Descendants> pred) {

        if(tree== null){
            return 0;
        }
        int total = 0;
        if(pred.test(tree)){
            total++;
        }

        for(Descendants child:tree.children){
            total+=countPeopleByPredicate(child,pred);
        }

        return total;
    }

// ============================================================
    // EXERCISE 5 — Youngest parent
    // ============================================================
    //
    // SETUP
    // -----
    // Same data definitions as Exercise 2.
    // A "parent" is any person in the tree who has at least one child.
    // The "age at which someone became a parent" is:
    //   (birth year of the YOUNGEST child) - (birth year of the parent)
    // Use the birth year of the YOUNGEST child in the list
    // (i.e., the child with the SMALLEST birth year means born earliest,
    //  but we want the child born LATEST to find the YOUNGEST age at
    //  which the parent first had a child —
    //  actually, use the child with the SMALLEST birth year to compute
    //  the EARLIEST/youngest parental age).
    //
    // To be precise: parentAge = (minChildBirth) - (parentBirth)
    // where minChildBirth is the minimum birth year among direct children.
    //
    // Assume the root of the tree has at least one child.
    // If multiple people tie for youngest parent age, return any one.
    // Assume current year is 2025 (not needed for the calculation above).
    //
    // QUESTION
    // --------
    // Write a method
    //
    //   static Person youngestParent(Descendants tree)
    //
    // that returns the Person in the tree who became a parent at the
    // youngest age (as defined above).
    //
    // You MUST NOT use streams or higher-order list functions.
    //
    // Examples
    //   Alice born 1970, child born 1990  => parentAge 20
    //   Bob   born 1954, child born 1972  => parentAge 18  (winner)
    //
    // ------------------------------------------------------------
    // WRITE YOUR SOLUTION HERE
    // ------------------------------------------------------------






    // helper 1: compute how old this person was when they became a parent
// = earliest child's birth year - parent's birth year
    private static int parentAge(Descendants node) {
     int min = Integer.MAX_VALUE;
     for(var c:node.children){
        if(c.person.birth<min){
            min = c.person.birth;
        }
     }
     return min - node.person.birth;
    }

    // helper 2: searches whole subtree, returns youngest parent found
// returns null if no parent exists in this subtree (i.e. all leaves)
    private static Descendants youngestParentHelper(Descendants tree) {
        if(tree == null){
            return null;
        }
        Descendants best = tree;

        for(var c:tree.children){
            Descendants childBest = youngestParentHelper(c);
            if(childBest!= null && parentAge(childBest)< parentAge(best)){
                best = childBest;
            }
        }
       return best;
    }

    // main function — just unwrap the Person from the result
    static Person youngestParent(Descendants tree) {
        return youngestParentHelper(tree).person;
    }








// ============================================================
    // EXERCISE 6 — Prune by predicate
    // ============================================================
    //
    // SETUP
    // -----
    // Same data definitions as Exercise 2.
    //
    // QUESTION
    // --------
    // Write a method
    //
    //   static Descendants pruneByPredicate(Descendants tree,
    //                                       Predicate<Person> pred)
    //
    // that returns a NEW Descendants tree where every non-root person
    // p for which pred.test(p.person()) is TRUE is REMOVED together
    // with ALL of their descendants.
    //
    // Special rule: if the ROOT satisfies the predicate it is NEVER
    // removed (only its descendants may be affected recursively).
    //
    // You MAY use streams / higher-order list methods if helpful.
    //
    // Examples
    //   pred = p -> false            => unchanged tree
    //   pred = p -> true             => root only (all children removed)
    //   pred = p -> name equals "B"  => B and all of B's subtree removed
    //
    // ------------------------------------------------------------
    // WRITE YOUR SOLUTION HERE
    // ------------------------------------------------------------

    static Descendants pruneByPredicate(Descendants tree,
                                        Predicate<Person> pred) {

        // null check
        if(tree== null ){
            return null;
        }
        // 新 instance of descendant，只包含tree，和empty list of children， 之后如果有没通过test的我们就不remove
        // 我们就可以加上它
        Descendants result = new Descendants(tree.person(),new ArrayList<>());

        // 对于tree的children
        for(var c:tree.children){
            // 如果没通过测试，就不需要remove， 就可以添加进最后的返回列表
            if(!pred.test(c.person)){
                // recursively call all children of children etc  etc etc
                result.children.add(pruneByPredicate(c, pred));
            }
        }

return result;
    }










    // ============================================================
    // MAIN — runs all tests
    // ============================================================

    public static void main(String[] args) {

        System.out.println("=== Exercise 1: roseTreeSum ===");
        testEx1();

        System.out.println("\n=== Exercise 2: countDescendants ===");
        testEx2();

        System.out.println("\n=== Exercise 3: countDescendantsByPersonName ===");
        testEx3();

        System.out.println("\n=== Exercise 4: countPeopleByPredicate ===");
        testEx4();

        System.out.println("\n=== Exercise 5: youngestParent ===");
        testEx5();

        System.out.println("\n=== Exercise 6: pruneByPredicate ===");
        testEx6();

        System.out.println("\n-----------------------------");
        System.out.println("  PASSED: " + passed);
        System.out.println("  FAILED: " + failed);
        System.out.println("-----------------------------");
    }

    // ----------------------------------------------------------
    // TEST BLOCKS
    // ----------------------------------------------------------

    static void testEx1() {
        // Tree0: single leaf
        //   7
        RoseTree tree0 = new RoseTree(new ArrayList<>(), 7);
        check(7, roseTreeSum(tree0), "single leaf = 7");

        // Tree1:
        //    5
        //   / \
        //  3   2
        ArrayList<RoseTree> t1kids = new ArrayList<>();
        t1kids.add(new RoseTree(new ArrayList<>(), 3));
        t1kids.add(new RoseTree(new ArrayList<>(), 2));
        RoseTree tree1 = new RoseTree(t1kids, 5);
        check(10, roseTreeSum(tree1), "root=5, children=3,2 => 10");

        // Tree2:
        //       1
        //      / \
        //     3   7
        //    / \   \
        //   4   6   8
        ArrayList<RoseTree> left2kids = new ArrayList<>();
        left2kids.add(new RoseTree(new ArrayList<>(), 4));
        left2kids.add(new RoseTree(new ArrayList<>(), 6));
        RoseTree left2 = new RoseTree(left2kids, 3);

        ArrayList<RoseTree> right2kids = new ArrayList<>();
        right2kids.add(new RoseTree(new ArrayList<>(), 8));
        RoseTree right2 = new RoseTree(right2kids, 7);

        ArrayList<RoseTree> t2kids = new ArrayList<>();
        t2kids.add(left2);
        t2kids.add(right2);
        RoseTree tree2 = new RoseTree(t2kids, 1);
        check(29, roseTreeSum(tree2), "3-level tree => 29");

        // Tree3: chain  1 -> 2 -> 3 -> 4 -> 5
        ArrayList<RoseTree> k5 = new ArrayList<>();
        RoseTree n5 = new RoseTree(k5, 5);
        ArrayList<RoseTree> k4 = new ArrayList<>(); k4.add(n5);
        RoseTree n4 = new RoseTree(k4, 4);
        ArrayList<RoseTree> k3 = new ArrayList<>(); k3.add(n4);
        RoseTree n3 = new RoseTree(k3, 3);
        ArrayList<RoseTree> k2 = new ArrayList<>(); k2.add(n3);
        RoseTree n2 = new RoseTree(k2, 2);
        ArrayList<RoseTree> k1 = new ArrayList<>(); k1.add(n2);
        RoseTree chain = new RoseTree(k1, 1);
        check(15, roseTreeSum(chain), "chain 1-2-3-4-5 => 15");

        // Tree4: root=10, five children 1..5
        ArrayList<RoseTree> wide = new ArrayList<>();
        for (int i = 1; i <= 5; i++) wide.add(new RoseTree(new ArrayList<>(), i));
        RoseTree tree4 = new RoseTree(wide, 10);
        check(25, roseTreeSum(tree4), "root=10, children=1..5 => 25");
    }

    // ---- shared tree for Ex2, Ex3, Ex4 ----
    //
    //         A
    //        /|\
    //       B  C  D1
    //      / \     \
    //     B1 B2    D11
    //               \
    //               D111
    //
    static Descendants buildTree2() {
        Descendants B1  = new Descendants(new Person("B1",  "x", 0, 0), new ArrayList<>());
        Descendants B2  = new Descendants(new Person("B2",  "x", 0, 0), new ArrayList<>());
        ArrayList<Descendants> bKids = new ArrayList<>();
        bKids.add(B1); bKids.add(B2);
        Descendants B   = new Descendants(new Person("B",   "x", 0, 0), bKids);

        Descendants C   = new Descendants(new Person("C",   "x", 0, 0), new ArrayList<>());

        Descendants D111 = new Descendants(new Person("D111","x", 0, 0), new ArrayList<>());
        ArrayList<Descendants> d11Kids = new ArrayList<>(); d11Kids.add(D111);
        Descendants D11  = new Descendants(new Person("D11", "x", 0, 0), d11Kids);
        ArrayList<Descendants> d1Kids  = new ArrayList<>(); d1Kids.add(D11);
        Descendants D1   = new Descendants(new Person("D1",  "x", 0, 0), d1Kids);

        ArrayList<Descendants> aKids = new ArrayList<>();
        aKids.add(B); aKids.add(C); aKids.add(D1);
        return new Descendants(new Person("A", "x", 0, 0), aKids);
    }

    static void testEx2() {
        // Single node
        Descendants solo = new Descendants(new Person("A","x",0,0), new ArrayList<>());
        check(0, countDescendants(solo), "single node => 0");

        // A -> [B, C, D]  (no grandkids)
        ArrayList<Descendants> t1kids = new ArrayList<>();
        t1kids.add(new Descendants(new Person("B","x",0,0), new ArrayList<>()));
        t1kids.add(new Descendants(new Person("C","x",0,0), new ArrayList<>()));
        t1kids.add(new Descendants(new Person("D","x",0,0), new ArrayList<>()));
        Descendants tree1 = new Descendants(new Person("A","x",0,0), t1kids);
        check(3, countDescendants(tree1), "A with 3 children => 3");

        // Complex tree with 7 descendants
        check(7, countDescendants(buildTree2()), "complex tree => 7");
    }

    static void testEx3() {
        Descendants tree = buildTree2();
        check(7, countDescendantsByPersonName(tree, "A"),    "A => 7");
        check(2, countDescendantsByPersonName(tree, "B"),    "B => 2");
        check(0, countDescendantsByPersonName(tree, "B1"),   "B1 => 0");
        check(0, countDescendantsByPersonName(tree, "B2"),   "B2 => 0");
        check(0, countDescendantsByPersonName(tree, "C"),    "C => 0");
        check(2, countDescendantsByPersonName(tree, "D1"),   "D1 => 2");
        check(1, countDescendantsByPersonName(tree, "D11"),  "D11 => 1");
        check(0, countDescendantsByPersonName(tree, "D111"), "D111 => 0");
        check(0, countDescendantsByPersonName(tree, "Z"),    "Z not found => 0");
    }

    static void testEx4() {
        // Single-node tree
        Descendants solo = new Descendants(new Person("A","x",0,0), new ArrayList<>());
        check(1, countPeopleByPredicate(solo, x -> true),  "solo, all => 1");
        check(0, countPeopleByPredicate(solo, x -> false), "solo, none => 0");
        check(1, countPeopleByPredicate(solo,
                x -> x.person().name().equals("A")), "solo, name=A => 1");

        // A -> [B, C, D]
        ArrayList<Descendants> t1kids = new ArrayList<>();
        t1kids.add(new Descendants(new Person("B","x",0,0), new ArrayList<>()));
        t1kids.add(new Descendants(new Person("C","x",0,0), new ArrayList<>()));
        t1kids.add(new Descendants(new Person("D","x",0,0), new ArrayList<>()));
        Descendants tree1 = new Descendants(new Person("A","x",0,0), t1kids);
        check(4, countPeopleByPredicate(tree1, x -> true),  "tree1, all => 4");
        check(0, countPeopleByPredicate(tree1, x -> false), "tree1, none => 0");
        check(1, countPeopleByPredicate(tree1,
                x -> x.person().name().equals("B")), "tree1, name=B => 1");

        // Complex tree (8 nodes total)
        Descendants tree2 = buildTree2();
        check(8, countPeopleByPredicate(tree2, x -> true),  "tree2, all => 8");
        check(0, countPeopleByPredicate(tree2, x -> false), "tree2, none => 0");
        // names of length 2: B1, B2, D1  => 3
        check(3, countPeopleByPredicate(tree2,
                x -> x.person().name().length() == 2), "tree2, namelen=2 => 3");
        // "A" or "D11" => 2
        check(2, countPeopleByPredicate(tree2,
                        x -> x.person().name().equals("A") ||
                                x.person().name().equals("D11")),
                "tree2, A or D11 => 2");
    }

    static void testEx5() {
        // Tree1:  A(1970) -> [B(1994), C(1995), D(1993)]
        //  A's youngest parental age = 1993 - 1970 = 23
        //  (no other parents in tree)
        Person pA1 = new Person("A","x",1970,0);
        ArrayList<Descendants> t1kids = new ArrayList<>();
        t1kids.add(new Descendants(new Person("B","x",1994,0), new ArrayList<>()));
        t1kids.add(new Descendants(new Person("C","x",1995,0), new ArrayList<>()));
        t1kids.add(new Descendants(new Person("D","x",1993,0), new ArrayList<>()));
        Descendants tree1 = new Descendants(pA1, t1kids);
        check(pA1, youngestParent(tree1), "only A is parent");

        // Tree2:
        //         A(1930) -> [B(1950), C(1952), D1(1954)]
        //  B(1950) -> [B1(1975), B2(1977)]   parentAge = 1975-1950 = 25
        //  D1(1954) -> [D11(1972)]            parentAge = 1972-1954 = 18  ← winner
        //  D11(1972) -> [D111(1991)]          parentAge = 1991-1972 = 19
        //  A(1930) -> min(1950,1952,1954)=1950  parentAge = 20
        Person personD1 = new Person("D1","x",1954,0);

        Descendants B1d  = new Descendants(new Person("B1", "x",1975,0), new ArrayList<>());
        Descendants B2d  = new Descendants(new Person("B2", "x",1977,0), new ArrayList<>());
        ArrayList<Descendants> bKids2 = new ArrayList<>(); bKids2.add(B1d); bKids2.add(B2d);
        Descendants Bd   = new Descendants(new Person("B",  "x",1950,0), bKids2);

        Descendants Cd   = new Descendants(new Person("C",  "x",1952,0), new ArrayList<>());

        Descendants D111d = new Descendants(new Person("D111","x",1991,0), new ArrayList<>());
        ArrayList<Descendants> d11Kids2 = new ArrayList<>(); d11Kids2.add(D111d);
        Descendants D11d  = new Descendants(new Person("D11", "x",1972,0), d11Kids2);
        ArrayList<Descendants> d1Kids2  = new ArrayList<>(); d1Kids2.add(D11d);
        Descendants D1d   = new Descendants(personD1, d1Kids2);

        ArrayList<Descendants> aKids2 = new ArrayList<>();
        aKids2.add(Bd); aKids2.add(Cd); aKids2.add(D1d);
        Descendants tree2 = new Descendants(new Person("A","x",1930,0), aKids2);
        check(personD1, youngestParent(tree2), "D1 is youngest parent (age 18)");
    }

    static void testEx6() {
        // Tree0: single node A
        Descendants tree0 = new Descendants(new Person("A","x",0,0), new ArrayList<>());
        check(tree0, pruneByPredicate(tree0, p -> false), "tree0: pred=false unchanged");
        check(tree0, pruneByPredicate(tree0, p -> true),  "tree0: pred=true root stays");

        // Tree1: A -> [B, C, D]
        Descendants Bt = new Descendants(new Person("B","x",0,0), new ArrayList<>());
        Descendants Ct = new Descendants(new Person("C","x",0,0), new ArrayList<>());
        Descendants Dt = new Descendants(new Person("D","x",0,0), new ArrayList<>());
        ArrayList<Descendants> t1k = new ArrayList<>();
        t1k.add(Bt); t1k.add(Ct); t1k.add(Dt);
        Descendants tree1 = new Descendants(new Person("A","x",0,0), t1k);

        check(tree1, pruneByPredicate(tree1, p -> false), "tree1: pred=false unchanged");

        // pred=true removes all children; root stays
        Descendants tree1Gone = new Descendants(new Person("A","x",0,0), new ArrayList<>());
        check(tree1Gone, pruneByPredicate(tree1, p -> true), "tree1: pred=true => root only");

        // pred matches only "B" => B removed, C and D remain
        ArrayList<Descendants> t1noB = new ArrayList<>(); t1noB.add(Ct); t1noB.add(Dt);
        Descendants tree1NoB = new Descendants(new Person("A","x",0,0), t1noB);
        check(tree1NoB,
                pruneByPredicate(tree1, p -> p.name().equals("B")),
                "tree1: prune B => C,D remain");

        // Complex tree
        Descendants tree2 = buildTree2();

        // pred=false => unchanged
        check(tree2, pruneByPredicate(tree2, p -> false), "tree2: pred=false unchanged");

        // pred=true => root only
        Descendants tree2Gone = new Descendants(new Person("A","x",0,0), new ArrayList<>());
        check(tree2Gone, pruneByPredicate(tree2, p -> true), "tree2: pred=true => root only");

        // pred: namelen==2 prunes B1, B2, D1 (and D1's subtree); B keeps no kids; C stays
        //   Result:  A -> [B(no kids), C]
        Descendants Bbare = new Descendants(new Person("B","x",0,0), new ArrayList<>());
        Descendants Cbare = new Descendants(new Person("C","x",0,0), new ArrayList<>());
        ArrayList<Descendants> len2kids = new ArrayList<>(); len2kids.add(Bbare); len2kids.add(Cbare);
        Descendants tree2Len2 = new Descendants(new Person("A","x",0,0), len2kids);
        check(tree2Len2,
                pruneByPredicate(tree2, p -> p.name().length() == 2),
                "tree2: prune namelen=2 => A->[B,C]");

        // pred: "A" or "D11" — root A kept, D11 pruned so D1 has no kids
        //   Result:  A -> [B(B1,B2), C, D1(no kids)]
        Descendants B1d = new Descendants(new Person("B1","x",0,0), new ArrayList<>());
        Descendants B2d = new Descendants(new Person("B2","x",0,0), new ArrayList<>());
        ArrayList<Descendants> bWithKids = new ArrayList<>(); bWithKids.add(B1d); bWithKids.add(B2d);
        Descendants Bfull = new Descendants(new Person("B","x",0,0), bWithKids);
        Descendants Cfull = new Descendants(new Person("C","x",0,0), new ArrayList<>());
        Descendants D1bare = new Descendants(new Person("D1","x",0,0), new ArrayList<>());
        ArrayList<Descendants> pruneD11kids = new ArrayList<>();
        pruneD11kids.add(Bfull); pruneD11kids.add(Cfull); pruneD11kids.add(D1bare);
        Descendants tree2PruneD11 = new Descendants(new Person("A","x",0,0), pruneD11kids);
        check(tree2PruneD11,
                pruneByPredicate(tree2,
                        p -> p.name().equals("A") || p.name().equals("D11")),
                "tree2: prune D11 (root A kept) => D1 loses kids");
    }



}