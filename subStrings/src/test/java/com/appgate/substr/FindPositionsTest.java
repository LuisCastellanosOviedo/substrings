package com.appgate.substr;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.appgate.substr.finder.FindPositions.findPositions;

public class FindPositionsTest {

    @Test
    public void shouldReturnPositionsForFirstExample() {
        List<List<Integer>> res = findPositions(0, "babgbag", "bag");
        Assert.assertEquals(res.size(),3);
        Assert.assertEquals(res.get(0).get(0),new Integer(0));

        Assert.assertEquals(res.get(1).get(0),new Integer(1));
        Assert.assertEquals(res.get(1).get(1),new Integer(5));

        Assert.assertEquals(res.get(2).get(0),new Integer(3));
        Assert.assertEquals(res.get(2).get(1),new Integer(6));
    }

    @Test
    public void shouldReturnPositionsForSecondExample() {
        List<List<Integer>> res = findPositions(2, "babgbag", "bag");
        Assert.assertEquals(res.size(),3);
        Assert.assertEquals(res.get(0).get(0),new Integer(2));
        Assert.assertEquals(res.get(1).get(0),new Integer(5));
        Assert.assertEquals(res.get(2).get(0),new Integer(3));
        Assert.assertEquals(res.get(2).get(1),new Integer(6));

    }
}
