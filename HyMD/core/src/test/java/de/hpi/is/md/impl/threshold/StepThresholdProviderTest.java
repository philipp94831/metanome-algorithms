package de.hpi.is.md.impl.threshold;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Sets;
import de.hpi.is.md.ThresholdFilter;
import it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

public class StepThresholdProviderTest {

	@Test
	public void testEmpty() {
		ThresholdFilter thresholdFilter = new StepThresholdFilter(Collections.emptyList());
		Iterable<Double> thresholds = thresholdFilter.filter(new DoubleOpenHashSet());
		assertThat(thresholds).isEmpty();
	}

	@Test
	public void testGetNext() {
		ThresholdFilter thresholdFilter = new StepThresholdFilter(
			Arrays.asList(0.9, 0.8, 0.4, 0.7));
		Iterable<Double> thresholds = thresholdFilter
			.filter(new DoubleOpenHashSet(Sets.newHashSet(0.7, 0.6)));
		assertThat(thresholds).hasSize(4);
		assertThat(thresholds).contains(0.9, 0.8, 0.4, 0.7);
	}

}