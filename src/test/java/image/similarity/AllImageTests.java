package image.similarity;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ImagePHashTest.class, ImgHistogramTest.class })
public class AllImageTests {
}
