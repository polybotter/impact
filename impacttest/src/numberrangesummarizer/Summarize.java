package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Summarize implements NumberRangeSummarizer{
	
	public String runSummarize(String input) {
		input = input.replaceAll("[^0-9,]", "");
		Collection<Integer> numbers = collect(input.trim());
		return summarizeCollection(numbers);
	}
	
	@Override
	public Collection<Integer> collect(String input) {
        String[] collection = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < collection.length; i++){
        	numbers.add(Integer.parseInt(collection[i]));
        }
        return numbers;
	}

	@Override
	public String summarizeCollection(Collection<Integer> input) {
		StringBuilder data = new StringBuilder();
		int size = input.size();
		int[] numbers = new int[size];
		Integer[] temp = input.toArray(new Integer[size]);
		for (int i = 0; i < size; i++) {
			numbers[i] = temp[i];
		}
		for(int j = 0; j < numbers.length - 1; j++) {
			data.append(numbers[j]);
			if(numbers[j] + 1 == numbers[j+1]) {
				data.append("-");
			} else {
				data.append(", ");
			}
		}
		data.append(numbers[numbers.length -1]);
		String result = data.toString();
		result = result.replaceAll("-([^,]*)-", "-");
		System.out.println(result);
		return result;
	}
}
