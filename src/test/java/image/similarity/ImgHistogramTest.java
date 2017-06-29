package image.similarity;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Assert;

import junit.framework.TestCase;

public class ImgHistogramTest extends TestCase {

	ImageHistogram histogram = null;

	public void setUp() {
		histogram = new ImageHistogram();
	}

	public void testImageHistogram() {
		try {
			double score = histogram.match(new File("doc/imgs/1.jpg"), new File("doc/imgs/1.jpg"));
			System.out.println("img1-->img1::::score : " + score);
			Assert.assertTrue(score >= 0.8);

			score = histogram.match(new File("doc/imgs/1.jpg"), new File("doc/imgs/2.jpg"));
			System.out.println("img1-->img2::::score : " + score);
			Assert.assertTrue(score >= 0.8);

			score = histogram.match(new File("doc/imgs/1.jpg"), new File("doc/imgs/3.jpg"));
			System.out.println("img1-->img3::::score : " + score);
			Assert.assertTrue(score >= 0.8);

			score = histogram.match(new File("doc/imgs/1.jpg"), new File("doc/imgs/4.jpg"));
			System.out.println("img1-->img4::::score : " + score);
			Assert.assertTrue(score < 0.8);

			score = histogram.match(new File("doc/imgs/5.jpg"), new File("doc/imgs/6.jpg"));
			System.out.println("img5-->img6::::score : " + score);
			Assert.assertTrue(score < 0.8); // incorrect

			score = histogram.match(new File("doc/imgs/1.jpg"), new File("doc/imgs/6.jpg"));
			System.out.println("img1-->img6::::score : " + score);
			Assert.assertTrue(score < 0.8);

			String srcUrl = "http://oarfc773f.bkt.clouddn.com/100000094nzslsdnswbb_1_1_r.jpg";
			score = histogram.match(new URL(srcUrl), new URL("https://img3.doubanio.com/lpic/s27140981.jpg"));
			System.out.println("url::::score:" + score);
			Assert.assertTrue(score < 0.8);	// incorrect

			score = histogram.match(new URL(srcUrl), new URL("https://img3.doubanio.com/lpic/s8966044.jpg"));
			System.out.println("url::::score:" + score);
			Assert.assertTrue(score < 0.8);	// incorrect

		} catch (IOException e) {
			e.printStackTrace();
			Assert.assertFalse(false);
		}

	}

}
