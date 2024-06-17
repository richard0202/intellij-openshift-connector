package org.jboss.tools.intellij.openshift.test.ui;
import org.jboss.tools.intellij.openshift.test.ui.tests_public.*;
import org.jboss.tools.intellij.openshift.test.ui.utils.KubeConfigUtility;
import org.jboss.tools.intellij.openshift.test.ui.views.GettingStartedView;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        GettingStartedTest.class,
        AboutPublicTest.class,
        ClusterLoginDialogPublicTest.class,
        OpenshiftExtensionTest.class
})
@IncludeClassNamePatterns({"^.*Test$"})
public class PublicTestsSuite extends AbstractBaseTest {
    private static boolean isLoggedOut = false;

    @BeforeAll
    public static void setUp() {
        GettingStartedView view = robot.find(GettingStartedView.class);
        view.closeView();
        if (!isLoggedOut) {
            backUpAndLogOut();
        }
    }

    @AfterAll
    public static void tearDown() {
        if (isLoggedOut) {
            KubeConfigUtility.restoreKubeConfig();
        }
    }

    private static void backUpAndLogOut() {
        KubeConfigUtility.backupKubeConfig();
        logOut();
        isLoggedOut = true;
    }

}
