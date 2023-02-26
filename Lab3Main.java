import java.util.Arrays;

public class Lab3Main
{
    public static void main(String[] args)
    {
        //Variables 
        int firstValue = 0;

        //#region - If Checks -

        if(args.length == 0)
        {
            System.out.println("No arguments were provided to the program. Exiting");

            System.exit(0);
        }

        else if (args.length > 1)
        {
            System.out.println("More than one argument was provided to the program. No processing will occur for any item other than the first argument.\n");
        }

        try {
            
            firstValue = Integer.parseInt(args[0]);

        } catch (NumberFormatException e) {
            System.out.println(" An invalid integer argument value was provided to the program. Exiting");
            System.exit(0);
        }

        if(firstValue <= 0)
        {
            System.out.println("The input argument must be an integer greater than zero. Exiting.");
            System.exit(0);
        }

        else
        {
            System.out.println(firstValue + " was specified as the array size.");
        }

        //#endregion

        double[] numArray = new double[firstValue];

        System.out.println("Array Created");

        for(int i = 0; i < firstValue; i++)
        {
            numArray[i]  = Math.random();
        }

        //System.out.println(Arrays.toString(numArray));

		int comparisons = (int) numArray[numArray.length - 1];

		numArray = Arrays.copyOf(numArray, numArray.length - 1);
		
		System.out.println("Array sorted");
        
        int incrementCounter = 0;

        System.out.println("Elements of the sorted array: ");
		for(int i = 0; i < numArray.length; i++)
        {
            if(incrementCounter % 10 == 0)
            {
                System.out.printf("%d ", incrementCounter);
            }

            System.out.print(" " + numArray[i]);
            incrementCounter++;

            if (incrementCounter % 10 == 0) {
                System.out.println();
            }
        }

        numArray = Sort(numArray);

    }

    static double[] Sort(double[] numArray) {

		double counter = 0;
        

		for (int o = 0; o < numArray.length - 1; o++) {

			int smallest = o;
			
			for (int j = o + 1; j < numArray.length; j++) {
				
                counter = counter + 1;

				if (numArray[smallest] > numArray[j]) {

					smallest = j;
				}
				
			}

			if (smallest != o) {

				double temp = numArray[smallest];

				numArray[smallest] = numArray[o];

				numArray[o] = temp;

			}

		}

		numArray = Arrays.copyOf(numArray, numArray.length + 1);

		numArray[numArray.length - 1] = counter;

        int iterationCounter = (int) counter; 
        
        System.out.println("\n" + iterationCounter + " comparisons were performed during the brute force sort operation.");
        System.out.println("\n" + "Processing completed. Exiting.");

        boolean sortedBool = true;

        for (int i = 0; i < numArray.length - 1; i++) 
        {
            if (numArray[i] > numArray[i + 1]) 
            {
                System.out.println("Array is not sorted.");
                sortedBool = false;
                return null;
            }
        }

        if (sortedBool)
        {
            System.out.println("\n" + "Array sort confirmed." + "\n");
        }

		return numArray;

	}


}