package utilities;

import base.TestContext;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PageBuilderUtil extends PageFactory {

    private PageBuilderUtil() {
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

