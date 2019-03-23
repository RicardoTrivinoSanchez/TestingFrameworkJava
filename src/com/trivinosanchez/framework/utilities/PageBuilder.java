package com.trivinosanchez.framework.utilities;

import com.trivinosanchez.framework.base.TestContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PageBuilder extends org.openqa.selenium.support.PageFactory {

    private PageBuilder() {
    }

    public static <T> T initElements(TestContext context, Class<T> pageClassToProxy) {
        T page = instantiatePage(context, pageClassToProxy);
        initElements(context.getDriver(), page);
        return page;
    }

    private static <T> T instantiatePage(TestContext context, Class<T> pageClassToProxy) {
        try {
            Constructor<T> constructor = pageClassToProxy.getConstructor(TestContext.class);
            return constructor.newInstance(context);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException var4) {
            throw new RuntimeException(var4);
        }
    }
}

