package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SymmetricTreeTest {
    private static SymmetricTree s = new SymmetricTree();
    private TreeNode n;
    private boolean ret;

    @Parameterized.Parameters
    public static Collection data() {

        TreeNode l11 = new TreeNode(1);
        TreeNode l12 = new TreeNode(2);
        TreeNode l13 = new TreeNode(2);
        TreeNode l14 = new TreeNode(3);
        TreeNode l15 = new TreeNode(4);
        TreeNode l16 = new TreeNode(4);
        TreeNode l17 = new TreeNode(3);
        l11.left = l12;
        l11.right = l13;
        l12.left = l14;
        l12.right = l15;
        l13.left = l16;
        l13.right = l17;

        TreeNode l21 = new TreeNode(1);
        TreeNode l22 = new TreeNode(2);
        TreeNode l23 = new TreeNode(2);
        TreeNode l25 = new TreeNode(3);
        TreeNode l27 = new TreeNode(3);
        l21.left = l22;
        l21.right = l23;
        l22.right = l25;
        l23.right = l27;


        return Arrays.asList(new Object[][]{
                {l11, true},
                {l21, false}
        });
    }

    public SymmetricTreeTest(TreeNode n, boolean ret){
        this.n = n;
        this.ret = ret;
    }

    @Test
    public void isSymmetricTest(){
        assertEquals(ret, s.isSymmetric(n));
    }
}
