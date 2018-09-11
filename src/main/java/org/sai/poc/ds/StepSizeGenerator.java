package com.apple.ist.poc.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates steps for the specified size and # of variables 0.25 0 0.75
 * 
 *
 */
public class StepSizeGenerator {
	private static final double STEP_SIZE = 0.25;
	private static final int PARAMETER_COUNT = 4;

	public static void main(String[] args) {
		List<List<Double>> generatedSteps = new ArrayList<>();
		List<Double> currentStepList = new ArrayList<>();
		generateVariableStepsEx(STEP_SIZE, PARAMETER_COUNT, 1, generatedSteps, currentStepList);
		for (List<Double> stepList : generatedSteps) {
			for (Double val : stepList) {
				System.out.print(val);
				System.out.print(",");
			}
			System.out.println();
		}
	}

	private static void generateSteps(double stepSize) {
		for (double x = 0; x <= 1; x = x + stepSize) {
			for (double y = 0; x + y <= 1; y = y + stepSize) {
				double z = 1 - (x + y);
				if (z < 0) {
					z = 0;
				}
				String output = x + "," + y + "," + z;
				System.out.println(output);
			}
		}
	}

	private static void generateVariableSteps(double stepSize, int totalStepCount, int currentStep,
			List<List<Double>> generatedSteps) {
		for (double i = 0; i <= 1; i = i + stepSize) {
			if (currentStep == 1) {
				List<Double> stepList = new ArrayList<>();
				stepList.add(i);
				generatedSteps.add(stepList);
			} else if (currentStep == totalStepCount) {
				for (List<Double> stepList : generatedSteps) {
					double lSum = listSum(stepList);
					if (lSum < 1) {
						stepList.add(1 - lSum);
					}
				}
			} else {
				for (List<Double> stepList : generatedSteps) {
					if (listSum(stepList) < 1) {
						stepList.add(i);
					} else {
						stepList.add(0.0);
					}
				}
			}
			if (currentStep < totalStepCount) {
				generateVariableSteps(stepSize, totalStepCount, currentStep + 1, generatedSteps);
			}
		}
	}

	private static void generateVariableStepsEx(double stepSize, int totalStepCount, int currentStep,
			List<List<Double>> generatedSteps, List<Double> currentStepList) {
		for (double i = 0; i <= 1; i = i + stepSize) {
			if (listSum(currentStepList) < 1) {
				currentStepList.add(i);
			} else {
				currentStepList.add(0.0);
			}
			if (currentStep < totalStepCount) {
				generateVariableStepsEx(stepSize, totalStepCount, currentStep + 1, generatedSteps, currentStepList);
			}
		}
		if (currentStep == totalStepCount) {
			generatedSteps.add(currentStepList);
			currentStepList = new ArrayList<Double>();
		}
	}

	private static Double listSum(List<Double> stepList) {
		Double sum = 0.0;
		for (Double val : stepList) {
			sum = sum + val;
		}
		return sum;
	}

	// private static void generateVariableStep(int stepCount, double stepSize, )
}
