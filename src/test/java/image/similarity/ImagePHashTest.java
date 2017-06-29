package image.similarity;

import java.io.File;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ImagePHashTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public ImagePHashTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ImagePHashTest.class);
	}

	ImagePHash p = null;

	@Before
	public void setUp() {
		p = new ImagePHash();
	}

	public void testImgPHash() {
		try {
			int dis = p.distance(new File("doc/imgs/1.jpg"), new File("doc/imgs/1.jpg"));
			System.out.println("img1-->img1::::distance:" + dis);
			Assert.assertTrue(dis < 10);

			dis = p.distance(new File("doc/imgs/1.jpg"), new File("doc/imgs/2.jpg"));
			System.out.println("img1-->img2::::distance:" + dis);
			Assert.assertTrue(dis > 10); // incorrect

			dis = p.distance(new File("doc/imgs/1.jpg"), new File("doc/imgs/3.jpg"));
			System.out.println("img1-->img3::::distance:" + dis);
			Assert.assertTrue(dis > 10); // incorrect

			dis = p.distance(new File("doc/imgs/2.jpg"), new File("doc/imgs/3.jpg"));
			System.out.println("img2-->img3::::distance:" + dis);
			Assert.assertTrue(dis < 10);

			dis = p.distance(new File("doc/imgs/2.jpg"), new File("doc/imgs/4.jpg"));
			System.out.println("img2-->img4::::distance:" + dis);
			Assert.assertTrue(dis > 10);

			dis = p.distance(new File("doc/imgs/1.jpg"), new File("doc/imgs/4.jpg"));
			System.out.println("img2-->img3::::distance:" + dis);
			Assert.assertTrue(dis > 10);

			String srcUrl = "http://oarfc773f.bkt.clouddn.com/100000094nzslsdnswbb_1_1_r.jpg";
			dis = p.distance(new URL("https://img3.doubanio.com/lpic/s27140981.jpg"), new URL(srcUrl));
			System.out.println("url::::distance:" + dis);
			Assert.assertTrue(dis < 10);

			dis = p.distance(new URL("https://img3.doubanio.com/lpic/s8966044.jpg"), new URL(srcUrl));
			System.out.println("url::::distance:" + dis);
			Assert.assertTrue(dis < 10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
