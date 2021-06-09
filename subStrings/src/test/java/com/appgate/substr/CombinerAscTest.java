package com.appgate.substr;

import com.appgate.substr.combiner.CombinerAsc;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinerAscTest {

    @Test
    public void shouldMix1ElementVs2() {
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(5);
        List<Integer> node0 = new ArrayList<>();
        node0.add(0);
        a.add(node0);

        List<List<Integer>> res = CombinerAsc.combine(a, b);

        Assert.assertEquals(res.get(0).get(0),new Integer(0));
        Assert.assertEquals(res.get(0).get(1),new Integer(1));

        Assert.assertEquals(res.get(1).get(0),new Integer(0));
        Assert.assertEquals(res.get(1).get(1),new Integer(5));

        Assert.assertEquals(res.size(),2);

    }

    @Test
    public void shouldMix1ElementVs1() {
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        b.add(1);
        List<Integer> node0 = new ArrayList<>();
        node0.add(0);
        a.add(node0);

        List<List<Integer>> res =CombinerAsc.combine(a,b);

        Assert.assertEquals(res.get(0).get(0),new Integer(0));
        Assert.assertEquals(res.get(0).get(1),new Integer(1));

        Assert.assertEquals(res.size(),1);

    }

    @Test
    public void shouldMix2ElementVs1() {
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(6);
        List<Integer> node0 = new ArrayList<>();
        node0.add(0);
        node0.add(1);
        a.add(node0);

        node0 = new ArrayList<>();
        node0.add(0);
        node0.add(5);
        a.add(node0);

        List<List<Integer>> res =CombinerAsc.combine(a,b);

        Assert.assertEquals(res.get(0).get(0),new Integer(0));
        Assert.assertEquals(res.get(0).get(1),new Integer(1));
        Assert.assertEquals(res.get(0).get(2),new Integer(3));


        Assert.assertEquals(res.get(1).get(0),new Integer(0));
        Assert.assertEquals(res.get(1).get(1),new Integer(1));
        Assert.assertEquals(res.get(1).get(2),new Integer(6));

        Assert.assertEquals(res.get(2).get(0),new Integer(0));
        Assert.assertEquals(res.get(2).get(1),new Integer(5));
        Assert.assertEquals(res.get(2).get(2),new Integer(6));

        Assert.assertEquals(res.size(),3);

    }


}
