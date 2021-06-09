package com.appgate.substr;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.appgate.substr.finder.FindIndexFirstLetter.buildIndexsPivote;

public class FindIndexFirstLetterTest {




    @Test
    public void findZeroIndexes() {
        List<Integer> indexes = buildIndexsPivote("babgbag","zzz");

        Assert.assertEquals(indexes.size(),0);
    }

    @Test
    public void findOneIndex() {
        List<Integer> indexes = buildIndexsPivote("bagag","bzz");

        Assert.assertEquals(indexes.size(),1);
    }

    @Test
    public void find3IndexOfFirtLetter() {
        List<Integer> indexes = buildIndexsPivote("babgbag","bag");

        Assert.assertEquals(indexes.size(),3);
        Assert.assertEquals(indexes.get(0),new Integer(0));
        Assert.assertEquals(indexes.get(1),new Integer(2));
        Assert.assertEquals(indexes.get(2),new Integer(4));
    }
}
