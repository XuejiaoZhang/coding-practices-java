package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SameTreeTest {
    private static SameTree s = new SameTree();
    private TreeNode n;
    private TreeNode m;
    private boolean ret;

    @Parameterized.Parameters
    public static Collection data() {

        TreeNode l11 = new TreeNode(1);
        TreeNode l12 = new TreeNode(2);
        TreeNode l13 = new TreeNode(3);
        l11.left = l12;
        l12.right = l13;

        TreeNode l21 = new TreeNode(1);
        TreeNode l22 = new TreeNode(2);
        TreeNode l23 = new TreeNode(3);
        l21.left = l22;
        l22.right = l23;

        TreeNode m11 = new TreeNode(1);
        TreeNode m12 = new TreeNode(2);
        m11.left = m12;

        TreeNode m21 = new TreeNode(1);
        TreeNode m22 = new TreeNode(2);
        m21.right = m22;

        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(2);
        r1.left = r3;
        r1.right = r2;

        TreeNode r11 = new TreeNode(1);
        TreeNode r21 = new TreeNode(1);
        TreeNode r31 = new TreeNode(2);
        r11.left = r21;
        r11.right = r31;

        return Arrays.asList(new Object[][]{
                {l11, l21, true},
                {m11, m21, false},
                {r1, r11, false}
        });
    }

    public SameTreeTest(TreeNode n, TreeNode m, boolean ret){
        this.n = n;
        this.m = m;
        this.ret = ret;
    }

    @Test
    public void isSameTreeTest(){
        assertEquals(ret, s.isSameTree(m, n));
    }
}