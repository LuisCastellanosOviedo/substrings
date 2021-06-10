package com.appgate.substr;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.appgate.substr.finder.FindIndexFirstLetter.buildIndexsPivote;
import static com.appgate.substr.finder.function.catalog.SubStrFunctionCatalog.findFirstIndexCharAtStrategy;

public class FindIndexFirstLetterTest {




    @Test
    public void findZeroIndexes() throws ExecutionException, InterruptedException {
        List<Integer> indexes = buildIndexsPivote("babgbag","zzz",findFirstIndexCharAtStrategy);

        Assert.assertEquals(indexes.size(),0);
    }

    @Test
    public void findOneIndex() throws ExecutionException, InterruptedException {
        List<Integer> indexes = buildIndexsPivote("bagag","bzz",findFirstIndexCharAtStrategy);

        Assert.assertEquals(indexes.size(),1);
    }

    @Test
    public void find3IndexOfFirtLetter() throws ExecutionException, InterruptedException {
        List<Integer> indexes = buildIndexsPivote("babgbag","bag",findFirstIndexCharAtStrategy);

        Assert.assertEquals(indexes.size(),3);
        Assert.assertEquals(indexes.get(0),new Integer(0));
        Assert.assertEquals(indexes.get(1),new Integer(2));
        Assert.assertEquals(indexes.get(2),new Integer(4));
    }
}
