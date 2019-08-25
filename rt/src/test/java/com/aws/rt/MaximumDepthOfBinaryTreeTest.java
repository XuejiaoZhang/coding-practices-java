package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaximumDepthOfBinaryTreeTest {
    private static MaximumDepthOfBinaryTree s = new MaximumDepthOfBinaryTree();
    private TreeNode n;
    private int a;

    @Parameterized.Parameters
    public static Collection data() {

        TreeNode l11 = new TreeNode(3);
        TreeNode l12 = new TreeNode(9);
        TreeNode l13 = new TreeNode(20);
        TreeNode l22 = new TreeNode(15);
        TreeNode l23 = new TreeNode(7);
        l11.left = l12;
        l11.right = l13;
        l13.left = l22;
        l13.right = l23;

        return Arrays.asList(new Object[][]{
                {l11, 3},
        });
    }

    public MaximumDepthOfBinaryTreeTest(TreeNode n, int a){
        this.n = n;
        this.a = a;
    }

    @Test
    public void maxDepthTest(){
        assertEquals(a, s.maxDepth(n));
    }
}