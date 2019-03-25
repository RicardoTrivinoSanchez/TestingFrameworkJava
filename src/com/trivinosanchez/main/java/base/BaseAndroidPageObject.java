package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public abstract class BaseAndroidPageObject extends BasePageObject {

    protected BaseAndroidPageObject(TestContext context) {
        super(context);
    }

    protected void submit() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
